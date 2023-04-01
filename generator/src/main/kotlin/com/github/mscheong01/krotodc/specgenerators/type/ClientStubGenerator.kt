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
package com.github.mscheong01.krotodc.specgenerators.type

import com.github.mscheong01.krotodc.import.FunSpecsWithImports
import com.github.mscheong01.krotodc.import.Import
import com.github.mscheong01.krotodc.import.TypeSpecsWithImports
import com.github.mscheong01.krotodc.specgenerators.TypeSpecGenerator
import com.github.mscheong01.krotodc.specgenerators.file.DataClassGenerator
import com.github.mscheong01.krotodc.specgenerators.function.MessageToDataClassFunctionGenerator
import com.github.mscheong01.krotodc.specgenerators.function.MessageToProtoFunctionGenerator
import com.github.mscheong01.krotodc.util.descriptorCode
import com.google.protobuf.Descriptors.MethodDescriptor
import com.google.protobuf.Descriptors.ServiceDescriptor
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.MemberName.Companion.member
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asClassName
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls
import kotlinx.coroutines.flow.Flow

class ClientStubGenerator : TypeSpecGenerator<ServiceDescriptor> {
    override fun generate(descriptor: ServiceDescriptor): TypeSpecsWithImports {
        val imports = mutableSetOf<Import>()
        val ioIdentifier = "Coroutine"
        val className = "${descriptor.name}${ioIdentifier}Stub"
        val superClassType =
            AbstractCoroutineStub::class.asClassName().parameterizedBy(TypeVariableName(className))
        val typeBuilder = TypeSpec.classBuilder(className)
            .superclass(superClassType)
            .primaryConstructor(
                FunSpec.constructorBuilder()
                    .addParameter("channel", io.grpc.Channel::class)
                    .addParameter(
                        ParameterSpec.builder("callOptions", io.grpc.CallOptions::class)
                            .defaultValue("%M", io.grpc.CallOptions::class.member("DEFAULT"))
                            .build()
                    )
                    .build()
            )
            .addSuperclassConstructorParameter("channel")
            .addSuperclassConstructorParameter("callOptions")

        val clientMethodStubs = descriptor.methods.map { clientMethodStub(it) }
        clientMethodStubs.forEach {
            it.funSpecs.forEach { function -> typeBuilder.addFunction(function) }
            imports.addAll(it.imports)
        }
        typeBuilder.addFunction(
            FunSpec.builder("build")
                .addModifiers(KModifier.OVERRIDE)
                .addParameter("channel", io.grpc.Channel::class)
                .addParameter("callOptions", io.grpc.CallOptions::class)
                .returns(TypeVariableName(className))
                .addStatement("return %T(channel, callOptions)", TypeVariableName(className))
                .build()
        )

        return TypeSpecsWithImports(
            listOf(typeBuilder.build()),
            imports
        )
    }

    fun clientMethodStub(method: MethodDescriptor): FunSpecsWithImports {
        val imports = mutableSetOf<Import>()

        val inputType = DataClassGenerator
            .getTypeNameAndDefaultValue(method.inputType).first.copy(nullable = false)
        val outputType = DataClassGenerator
            .getTypeNameAndDefaultValue(method.outputType).first.copy(nullable = false)

        val requestParam = if (method.isClientStreaming) {
            ParameterSpec.builder("requests", Flow::class.asClassName().parameterizedBy(inputType)).build()
        } else {
            ParameterSpec.builder("request", inputType).build()
        }
        val responseType = if (method.isServerStreaming) {
            Flow::class.asClassName().parameterizedBy(outputType)
        } else {
            outputType
        }

        val clientFactoryMethod = if (method.isServerStreaming) {
            if (method.isClientStreaming) BIDI_STREAMING_CMD else SERVER_STREAMING_CMD
        } else {
            if (method.isClientStreaming) CLIENT_STREAMING_CMD else UNARY_CMD
        }

        val (toDataClassTemplate, toDataClassImports) = MessageToDataClassFunctionGenerator
            .messageTypeTransformCodeTemplate(method.outputType)
        val (toProtoTemplate, toProtoImports) = MessageToProtoFunctionGenerator
            .messageTypeTransformCodeTemplate(method.inputType)
        imports.addAll(toDataClassImports)
        imports.addAll(toProtoImports)
        val requestCode = if (method.isClientStreaming) {
            CodeBlock.of(
                "requests.map { %L }",
                toProtoTemplate.safeCall("it")
            )
        } else {
            CodeBlock.of(
                "%L",
                toProtoTemplate.safeCall("request")
            )
        }
        val implementationCode = if (method.isServerStreaming) {
            CodeBlock.of(
                """
                    return %M(
                        channel,
                        %L,
                        %L,
                        callOptions,
                        metadata,
                    ).map { %L }
                """.trimIndent(),
                clientFactoryMethod,
                method.descriptorCode,
                requestCode,
                toDataClassTemplate.safeCall("it")
            )
        } else {
            CodeBlock.of(
                """
                    return %M(
                        channel,
                        %L,
                        %L,
                        callOptions,
                        metadata,
                    ).let { %L }
                """.trimIndent(),
                clientFactoryMethod,
                method.descriptorCode,
                requestCode,
                toDataClassTemplate.safeCall("it")
            )
        }
        val methodBuilder = FunSpec.builder(method.name.decapitalize())
            .addParameter(requestParam)
            .returns(responseType)
            .addParameter(
                ParameterSpec.builder("metadata", io.grpc.Metadata::class)
                    .defaultValue("%L", "Metadata()")
                    .build()
            )
            .addStatement(
                "%L",
                implementationCode
            )
            .apply {
                if (!method.isServerStreaming) {
                    addModifiers(KModifier.SUSPEND)
                }
            }

        if (method.options.deprecated) {
            methodBuilder.addAnnotation(
                AnnotationSpec.builder(Deprecated::class)
                    .addMember("%S", "The underlying service method is marked deprecated.")
                    .build()
            )
        }

        return FunSpecsWithImports(
            listOf(methodBuilder.build()),
            imports
        )
    }

    companion object {
        private val UNARY_CMD: MemberName = ClientCalls::class.member("unaryRpc")
        private val CLIENT_STREAMING_CMD: MemberName =
            ClientCalls::class.member("clientStreamingRpc")
        private val SERVER_STREAMING_CMD: MemberName =
            ClientCalls::class.member("serverStreamingRpc")
        private val BIDI_STREAMING_CMD: MemberName =
            ClientCalls::class.member("bidiStreamingRpc")
    }
}
