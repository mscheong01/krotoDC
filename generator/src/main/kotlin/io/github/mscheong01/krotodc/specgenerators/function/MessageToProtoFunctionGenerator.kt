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
package io.github.mscheong01.krotodc.specgenerators.function

import com.google.protobuf.Descriptors.Descriptor
import com.google.protobuf.Descriptors.FieldDescriptor
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FunSpec
import io.github.mscheong01.krotodc.KrotoDCConverter
import io.github.mscheong01.krotodc.import.CodeWithImports
import io.github.mscheong01.krotodc.import.FunSpecsWithImports
import io.github.mscheong01.krotodc.import.Import
import io.github.mscheong01.krotodc.predefinedtypes.HandledPreDefinedType
import io.github.mscheong01.krotodc.specgenerators.FunSpecGenerator
import io.github.mscheong01.krotodc.template.TransformTemplateWithImports
import io.github.mscheong01.krotodc.util.MAP_ENTRY_VALUE_FIELD_NUMBER
import io.github.mscheong01.krotodc.util.capitalize
import io.github.mscheong01.krotodc.util.escapeIfNecessary
import io.github.mscheong01.krotodc.util.fieldNameToJsonName
import io.github.mscheong01.krotodc.util.isHandledPreDefinedType
import io.github.mscheong01.krotodc.util.isKrotoDCOptional
import io.github.mscheong01.krotodc.util.isPredefinedType
import io.github.mscheong01.krotodc.util.javaFieldName
import io.github.mscheong01.krotodc.util.krotoDCPackage
import io.github.mscheong01.krotodc.util.krotoDCTypeName
import io.github.mscheong01.krotodc.util.protobufJavaTypeName
import io.github.mscheong01.krotodc.util.simpleNames
import io.github.mscheong01.krotodc.util.toProtoImport

class MessageToProtoFunctionGenerator : FunSpecGenerator<Descriptor> {
    override fun generate(descriptor: Descriptor): FunSpecsWithImports {
        val imports = mutableSetOf<Import>()
        val generatedType = descriptor.krotoDCTypeName
        val protoType = descriptor.protobufJavaTypeName
        val functionBuilder = FunSpec.builder("toProto")
            .receiver(generatedType)
            .returns(protoType)

        functionBuilder.addCode("return %T.newBuilder()\n", protoType)

        functionBuilder.beginControlFlow(".apply")

        for (oneOf in descriptor.realOneofs) {
            val oneOfJsonName = fieldNameToJsonName(oneOf.name)
            functionBuilder.beginControlFlow("when (%L)", oneOfJsonName.escapeIfNecessary())
            for (field in oneOf.fields) {
                val oneOfFieldDataClassName = ClassName(
                    oneOf.file.krotoDCPackage,
                    *descriptor.simpleNames.toMutableList().apply {
                        add(oneOfJsonName.capitalize())
                        add(field.jsonName.capitalize())
                    }.toTypedArray()
                )
                functionBuilder.beginControlFlow("is %L ->", oneOfFieldDataClassName)
                val (template, downStreamImports) = transformCodeTemplate(field)
                functionBuilder.addStatement(
                    "set${field.javaFieldName.capitalize()}(%L)",
                    CodeBlock.of(
                        "%L",
                        template.safeCall(
                            CodeBlock.of(
                                "%L.%L",
                                oneOfJsonName.escapeIfNecessary(),
                                field.jsonName.escapeIfNecessary()
                            )
                        )
                    )
                )

                functionBuilder.endControlFlow()
                imports.addAll(downStreamImports)
            }
            functionBuilder.addStatement("null -> {}")
            functionBuilder.endControlFlow()
        }

        for (field in descriptor.fields) {
            if (field.name in descriptor.realOneofs.map { it.fields }.flatten().map { it.name }.toSet()) {
                continue
            }
            val fieldName = "this@toProto.${field.jsonName.escapeIfNecessary()}"
            val optional = field.isKrotoDCOptional
            if (optional) {
                functionBuilder.beginControlFlow("if ($fieldName != null)")
            }

            val codeWithImports = if (field.isMapField) {
                val valueField = field.messageType.findFieldByNumber(MAP_ENTRY_VALUE_FIELD_NUMBER)
                val (template, downStreamImports) = transformCodeTemplate(valueField)
                val mapCodeBlock = if (template.value == "%L") {
                    CodeBlock.of("%L", fieldName)
                } else {
                    CodeBlock.of("%L.mapValues { %L }", fieldName, template.safeCall("it.value"))
                }
                CodeWithImports.of(mapCodeBlock, downStreamImports)
            } else if (field.isRepeated) {
                val (template, downStreamImports) = transformCodeTemplate(field)
                val repeatedCodeBlock = if (template.value == "%L") {
                    CodeBlock.of("%L", fieldName)
                } else {
                    CodeBlock.of("%L.map { %L }", fieldName, template.safeCall("it"))
                }
                CodeWithImports.of(repeatedCodeBlock, downStreamImports)
            } else {
                val (template, downStreamImports) = transformCodeTemplate(field)
                CodeWithImports.of(
                    template.safeCall(fieldName),
                    downStreamImports
                )
            }
            val accessorMethodName = when {
                field.isMapField -> "putAll${field.javaFieldName.capitalize()}"
                field.isRepeated -> "addAll${field.javaFieldName.capitalize()}"
                else -> "set${field.javaFieldName.capitalize()}"
            }
            imports.addAll(codeWithImports.imports)
            functionBuilder.addCode(
                CodeBlock.of(
                    "$accessorMethodName(%L)\n",
                    codeWithImports.code
                )
            )
            if (optional) {
                functionBuilder.endControlFlow()
            }
        }
        functionBuilder.endControlFlow()

        functionBuilder.addCode(".build()")
        functionBuilder.addKdoc(
            "Converts [%T] to [%T]",
            generatedType,
            protoType
        )
        functionBuilder.addAnnotation(
            AnnotationSpec.Companion.builder(KrotoDCConverter::class)
                .addMember("from = %T::class", generatedType)
                .addMember("to = %T::class", protoType)
                .build()
        )

        return FunSpecsWithImports(
            listOf(functionBuilder.build()),
            imports
        )
    }

    fun transformCodeTemplate(field: FieldDescriptor): TransformTemplateWithImports {
        return when (field.type) {
            FieldDescriptor.Type.MESSAGE -> {
                messageTypeTransformCodeTemplate(field.messageType)
            }
            else -> TransformTemplateWithImports.of("%L")
        }
    }

    companion object {
        fun messageTypeTransformCodeTemplate(
            descriptor: Descriptor
        ): TransformTemplateWithImports {
            return if (descriptor.isPredefinedType()) {
                preDefinedTypeTransformCodeTemplate(descriptor)
            } else {
                TransformTemplateWithImports.of("%L.toProto()", setOf(descriptor.toProtoImport))
            }
        }

        private fun preDefinedTypeTransformCodeTemplate(
            descriptor: Descriptor
        ): TransformTemplateWithImports {
            return if (descriptor.isHandledPreDefinedType()) {
                HandledPreDefinedType.valueOfByDescriptor(descriptor).toProtoTransformTemplate
            } else {
                TransformTemplateWithImports.of("%L")
            }
        }
    }
}
