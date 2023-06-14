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
import io.github.mscheong01.krotodc.util.endControlFlowWithComma
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
import io.github.mscheong01.krotodc.util.toDataClassImport

class MessageToDataClassFunctionGenerator : FunSpecGenerator<Descriptor> {
    override fun generate(descriptor: Descriptor): FunSpecsWithImports {
        val imports = mutableSetOf<Import>()
        val generatedType = descriptor.krotoDCTypeName
        val protoType = descriptor.protobufJavaTypeName
        val functionBuilder = FunSpec.builder("toDataClass")
            .receiver(protoType)
            .returns(generatedType)

        functionBuilder.addCode("return %T(", generatedType)

        for (oneOf in descriptor.realOneofs) {
            val oneOfJsonName = fieldNameToJsonName(oneOf.name)
            functionBuilder.beginControlFlow(
                "%L = when (%LCase)",
                oneOfJsonName.escapeIfNecessary(),
                oneOfJsonName
            )
            for (field in oneOf.fields) {
                val dataClassFieldName = field.jsonName
                val protoFieldName = field.javaFieldName
                val (template, downStreamImports) = transformCodeTemplate(field)
                val oneOfDataClassName = ClassName(
                    oneOf.file.krotoDCPackage,
                    *descriptor.simpleNames.toMutableList().apply {
                        add(oneOfJsonName.capitalize())
                        add(field.jsonName.capitalize())
                    }.toTypedArray()
                )
                functionBuilder.addStatement(
                    "%L.%LCase.%L -> %L( %L = %L )".trimIndent(),
                    protoType,
                    oneOfJsonName.capitalize(),
                    field.name.uppercase(),
                    oneOfDataClassName.canonicalName,
                    dataClassFieldName.escapeIfNecessary(),
                    template.safeCall(protoFieldName.escapeIfNecessary())
                )
                imports.addAll(downStreamImports)
            }
            functionBuilder.addStatement("%L.%LCase.%L -> null", protoType, oneOfJsonName.capitalize(), "${oneOf.name.replace("_", "").uppercase()}_NOT_SET".uppercase())
            functionBuilder.addStatement("null -> null")
            functionBuilder.endControlFlowWithComma()
        }

        for (field in descriptor.fields) {
            if (field.name in descriptor.realOneofs.map { it.fields }.flatten().map { it.name }.toSet()) {
                continue
            }

            val dataClassFieldName = field.jsonName
            val protoFieldName = field.javaFieldName
            val optional = field.isKrotoDCOptional
            functionBuilder.addCode("%L = ", dataClassFieldName.escapeIfNecessary())
            if (optional) {
                functionBuilder.beginControlFlow("if (has${protoFieldName.capitalize()}())")
            }

            val codeWithImports = if (field.isMapField) {
                val valueField = field.messageType.findFieldByNumber(MAP_ENTRY_VALUE_FIELD_NUMBER)
                val (template, downStreamImports) = transformCodeTemplate(valueField)
                val mapCodeBlock = if (template.value == "%L") {
                    CodeBlock.of("%LMap", protoFieldName)
                } else {
                    CodeBlock.of(
                        "%LMap.mapValues { %L }",
                        protoFieldName,
                        template.safeCall("it.value")
                    )
                }
                CodeWithImports.of(mapCodeBlock, downStreamImports)
            } else if (field.isRepeated) {
                val (template, downStreamImports) = transformCodeTemplate(field)
                val repeatedCodeBlock = if (template.value == "%L") {
                    CodeBlock.of("%LList", protoFieldName)
                } else {
                    CodeBlock.of("%LList.map { %L }", protoFieldName, template.safeCall("it"))
                }
                CodeWithImports.of(repeatedCodeBlock, downStreamImports)
            } else {
                val (template, downStreamImports) = transformCodeTemplate(field)
                CodeWithImports.of(
                    template.safeCall(protoFieldName.escapeIfNecessary()),
                    downStreamImports
                )
            }

            imports.addAll(codeWithImports.imports)
            functionBuilder.addStatement("%L", codeWithImports.code)
            if (optional) {
                functionBuilder.nextControlFlow("else")
                functionBuilder.addStatement("null")
                functionBuilder.endControlFlowWithComma()
            } else {
                functionBuilder.addCode(", ")
            }
        }
        functionBuilder.addCode(")")
        functionBuilder.addKdoc(
            "Converts [%T] to [%T]",
            protoType,
            generatedType
        )
        functionBuilder.addAnnotation(
            AnnotationSpec.builder(KrotoDCConverter::class)
                .addMember("from = %T::class", protoType)
                .addMember("to = %T::class", generatedType)
                .build()
        )

        return FunSpecsWithImports(
            listOf(functionBuilder.build()),
            imports
        )
    }

    // code template that could be used like CodeBlock.of(transformCodeTemplate, fieldName)
    fun transformCodeTemplate(field: FieldDescriptor): TransformTemplateWithImports {
        return when (field.type) {
            FieldDescriptor.Type.MESSAGE -> {
                messageTypeTransformCodeTemplate(field.messageType)
            }
            else -> {
                TransformTemplateWithImports.of("%L")
            }
        }
    }

    companion object {
        fun messageTypeTransformCodeTemplate(descriptor: Descriptor): TransformTemplateWithImports {
            return when {
                descriptor.isPredefinedType() -> {
                    preDefinedTypeTransformCodeTemplate(descriptor)
                }
                else -> TransformTemplateWithImports.of("%L.toDataClass()", setOf(descriptor.toDataClassImport))
            }
        }

        private fun preDefinedTypeTransformCodeTemplate(
            descriptor: Descriptor
        ): TransformTemplateWithImports {
            return if (descriptor.isHandledPreDefinedType()) {
                HandledPreDefinedType.valueOfByDescriptor(descriptor).toDataClassTemplate
            } else {
                TransformTemplateWithImports.of("%L")
            }
        }
    }
}
