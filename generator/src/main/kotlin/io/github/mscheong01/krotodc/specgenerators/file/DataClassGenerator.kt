// Copyright 2023 Minsoo Cheong
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package io.github.mscheong01.krotodc.specgenerators.file

import com.google.protobuf.Descriptors
import com.google.protobuf.Descriptors.Descriptor
import com.google.protobuf.Descriptors.FileDescriptor
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.BOOLEAN
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.DOUBLE
import com.squareup.kotlinpoet.FLOAT
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.INT
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LIST
import com.squareup.kotlinpoet.LONG
import com.squareup.kotlinpoet.MAP
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.STRING
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import io.github.mscheong01.krotodc.KrotoDC
import io.github.mscheong01.krotodc.import.CodeWithImports
import io.github.mscheong01.krotodc.import.Import
import io.github.mscheong01.krotodc.import.TypeSpecsWithImports
import io.github.mscheong01.krotodc.predefinedtypes.HandledPreDefinedType
import io.github.mscheong01.krotodc.specgenerators.FileSpecGenerator
import io.github.mscheong01.krotodc.util.MAP_ENTRY_KEY_FIELD_NUMBER
import io.github.mscheong01.krotodc.util.MAP_ENTRY_VALUE_FIELD_NUMBER
import io.github.mscheong01.krotodc.util.addAllImports
import io.github.mscheong01.krotodc.util.capitalize
import io.github.mscheong01.krotodc.util.fieldNameToJsonName
import io.github.mscheong01.krotodc.util.isHandledPreDefinedType
import io.github.mscheong01.krotodc.util.isKrotoDCOptional
import io.github.mscheong01.krotodc.util.isPredefinedType
import io.github.mscheong01.krotodc.util.krotoDCPackage
import io.github.mscheong01.krotodc.util.krotoDCTypeName
import io.github.mscheong01.krotodc.util.protobufJavaTypeName
import io.github.mscheong01.krotodc.util.simpleNames

class DataClassGenerator : FileSpecGenerator {

    override fun generate(fileDescriptor: FileDescriptor): List<FileSpec> {
        val fileSpecs = mutableMapOf<String, FileSpec>()
        for (messageType in fileDescriptor.messageTypes) {
            val fileSpecBuilder = FileSpec.builder(fileDescriptor.krotoDCPackage, messageType.name + ".kt")
            val specsWithImports = generateTypeSpecForMessageDescriptor(messageType)
            specsWithImports.typeSpecs.forEach { fileSpecBuilder.addType(it) }
            fileSpecBuilder.addAllImports(specsWithImports.imports)
            if (fileSpecBuilder.members.isNotEmpty()) {
                fileSpecs[messageType.fullName] = fileSpecBuilder.build()
            }
        }
        return fileSpecs.values.toList()
    }

    fun generateTypeSpecForMessageDescriptor(
        messageDescriptor: Descriptor
    ): TypeSpecsWithImports {
        if (
            messageDescriptor.isPredefinedType() ||
            messageDescriptor.options.mapEntry
        ) {
            return TypeSpecsWithImports.EMPTY
        }
        val imports = mutableSetOf<Import>()
        val className = messageDescriptor.krotoDCTypeName
        val dataClassBuilder = TypeSpec.classBuilder(className)
            .apply {
                if (messageDescriptor.fields.isNotEmpty()) {
                    addModifiers(KModifier.DATA)
                }
            }
        val constructorBuilder = FunSpec.constructorBuilder()

        for (nestedType in messageDescriptor.nestedTypes) {
            generateTypeSpecForMessageDescriptor(nestedType).let {
                imports.addAll(it.imports)
                it.typeSpecs.forEach { dataClassBuilder.addType(it) }
            }
        }
        for (nestedEnum in messageDescriptor.enumTypes) {
            val enumJavaTypeName = nestedEnum.protobufJavaTypeName
            imports.add(Import(enumJavaTypeName.packageName, enumJavaTypeName.simpleNames))
        }

        messageDescriptor.realOneofs.forEach { oneOf ->
            val oneOfJsonName = fieldNameToJsonName(oneOf.name)
            val interfaceClassName = ClassName(
                oneOf.file.krotoDCPackage,
                *messageDescriptor.simpleNames.toMutableList().apply {
                    add(oneOfJsonName.capitalize())
                }.toTypedArray()
            )
            val builder = TypeSpec.interfaceBuilder(interfaceClassName)
                .addModifiers(KModifier.SEALED)

            oneOf.fields.forEach {
                val (type, default) = mapProtoTypeToKotlinTypeAndDefaultValue(it)
                imports.addAll(default.imports)
                builder.addType(
                    TypeSpec.classBuilder(it.jsonName.capitalize())
                        .addModifiers(KModifier.DATA)
                        .primaryConstructor(
                            FunSpec.constructorBuilder()
                                .addParameter(
                                    ParameterSpec.builder(
                                        it.jsonName,
                                        type
                                    )
                                        .defaultValue(default.code)
                                        .build()
                                )
                                .build()
                        )
                        .addProperty(
                            PropertySpec.builder(
                                it.jsonName,
                                type
                            ).initializer(it.jsonName).build()
                        )
                        .apply {
                            if (it.options.deprecated) {
                                addAnnotation(
                                    AnnotationSpec.builder(Deprecated::class)
                                        .addMember("%S", "The underlying field is marked deprecated.")
                                        .build()
                                )
                            }
                        }
                        .addSuperinterface(interfaceClassName)
                        .build()
                )
            }

            constructorBuilder.addParameter(
                ParameterSpec.builder(
                    oneOfJsonName,
                    interfaceClassName.copy(nullable = true)
                ).defaultValue("null").build()
            )
            dataClassBuilder.addProperty(
                PropertySpec.builder(
                    oneOfJsonName,
                    interfaceClassName.copy(nullable = true)
                ).initializer(oneOfJsonName).build()
            )
            dataClassBuilder.addType(builder.build())
        }

        for (field in messageDescriptor.fields) {
            if (
                field.name in messageDescriptor.realOneofs.map { it.fields }.flatten().map { it.name }.toSet() ||
                field.isExtension
            ) {
                continue
            }
            val fieldName = field.jsonName
            val (fieldType, default) = mapProtoTypeToKotlinTypeAndDefaultValue(field)
            imports.addAll(default.imports)
            constructorBuilder
                .addParameter(
                    ParameterSpec
                        .builder(
                            fieldName,
                            fieldType
                        )
                        .apply {
                            if (field.options.deprecated) {
                                addAnnotation(
                                    AnnotationSpec.builder(Deprecated::class)
                                        .addMember("%S", "The underlying message field is marked deprecated.")
                                        .build()
                                )
                            }
                        }
                        .defaultValue(default.code).build()
                )
            dataClassBuilder.addProperty(
                PropertySpec.builder(
                    fieldName,
                    fieldType
                ).initializer(fieldName).build()
            )
        }

        dataClassBuilder.primaryConstructor(constructorBuilder.build())
        dataClassBuilder.addAnnotation(
            AnnotationSpec.builder(KrotoDC::class)
                .addMember("forProto = %L::class", messageDescriptor.protobufJavaTypeName)
                .build()
        )
        return TypeSpecsWithImports(
            listOf(dataClassBuilder.build()),
            imports
        )
    }

    private fun mapProtoTypeToKotlinTypeAndDefaultValue(field: Descriptors.FieldDescriptor): Pair<TypeName, CodeWithImports> {
        var (poetType, defaultValue) = when (
            field.javaType ?: throw IllegalStateException("Field $field does not have a java type")
        ) {
            Descriptors.FieldDescriptor.JavaType.INT -> Pair(INT, CodeWithImports.of("0"))
            Descriptors.FieldDescriptor.JavaType.LONG -> Pair(LONG, CodeWithImports.of("0L"))
            Descriptors.FieldDescriptor.JavaType.FLOAT -> Pair(FLOAT, CodeWithImports.of("0.0f"))
            Descriptors.FieldDescriptor.JavaType.DOUBLE -> Pair(DOUBLE, CodeWithImports.of("0.0"))
            Descriptors.FieldDescriptor.JavaType.BOOLEAN -> Pair(BOOLEAN, CodeWithImports.of("false"))
            Descriptors.FieldDescriptor.JavaType.STRING -> Pair(STRING, CodeWithImports.of("\"\""))
            Descriptors.FieldDescriptor.JavaType.BYTE_STRING -> Pair(
                ClassName("com.google.protobuf", "ByteString"),
                CodeWithImports.of("com.google.protobuf.ByteString.EMPTY")
            )
            Descriptors.FieldDescriptor.JavaType.ENUM -> {
                val enumType = field.enumType
                    ?: throw IllegalStateException("Enum field $field does not have an enum type")
                Pair(
                    enumType.protobufJavaTypeName,
                    CodeWithImports.of("${enumType.protobufJavaTypeName.canonicalName}.values()[0]")
                )
            }
            Descriptors.FieldDescriptor.JavaType.MESSAGE -> {
                if (field.isMapField) {
                    val keyType = field.messageType.findFieldByNumber(MAP_ENTRY_KEY_FIELD_NUMBER)
                        ?.let { this.mapProtoTypeToKotlinTypeAndDefaultValue(it).first }
                        ?: throw IllegalStateException("Map field $field does not have a key field")
                    val valueType = field.messageType.findFieldByNumber(MAP_ENTRY_VALUE_FIELD_NUMBER)
                        ?.let { this.mapProtoTypeToKotlinTypeAndDefaultValue(it).first }
                        ?: throw IllegalStateException("Map field $field does not have a value field")
                    val type = MAP.parameterizedBy(
                        keyType.copy(nullable = false),
                        valueType.copy(nullable = false)
                    )
                    Pair(type, CodeWithImports.of("mapOf()"))
                } else {
                    getTypeNameAndDefaultValue(field.messageType)
                }
            }
        }
        if (field.isRepeated && !field.isMapField) {
            poetType = LIST.parameterizedBy(poetType.copy(nullable = false))
            defaultValue = CodeWithImports.of("listOf()")
        }
        return if (field.isKrotoDCOptional) {
            Pair(poetType.copy(nullable = true), CodeWithImports.of("null"))
        } else {
            Pair(poetType.copy(nullable = false), defaultValue)
        }
    }

    companion object {
        /**
         * Returns the Kotlin type name and default value for the given descriptor.
         * This method should not be called on Map field messageTypes
         */
        fun getTypeNameAndDefaultValue(
            descriptor: Descriptor
        ): Pair<TypeName, CodeWithImports> {
            val generatedTypeName = descriptor.krotoDCTypeName
            if (descriptor.isPredefinedType()) {
                return getTypeNameAndDefaultValueForPreDefinedTypes(descriptor)
            }
            return Pair(generatedTypeName, CodeWithImports.of("${generatedTypeName.canonicalName}()"))
        }

        private fun getTypeNameAndDefaultValueForPreDefinedTypes(
            descriptor: Descriptor
        ): Pair<TypeName, CodeWithImports> {
            return if (descriptor.isHandledPreDefinedType()) {
                HandledPreDefinedType.valueOfByDescriptor(descriptor).let {
                    it.kotlinType to it.defaultValue
                }
            } else {
                Pair(
                    descriptor.protobufJavaTypeName,
                    CodeWithImports.of("${descriptor.protobufJavaTypeName.canonicalName}.getDefaultInstance()")
                )
            }
        }
    }
}
