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
package io.github.mscheong01.krotodc.util

import com.google.protobuf.Descriptors
import com.google.protobuf.Descriptors.Descriptor
import com.google.protobuf.Descriptors.EnumDescriptor
import com.google.protobuf.Descriptors.FieldDescriptor
import com.google.protobuf.Descriptors.FileDescriptor
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import io.github.mscheong01.krotodc.import.Import
import io.github.mscheong01.krotodc.predefinedtypes.HandledPreDefinedType

val FileDescriptor.javaPackage: String
    get() = when (val javaPackage = this.options.javaPackage) {
        "" -> this.`package`
        else -> javaPackage
    }

val FileDescriptor.krotoDCPackage: String
    get() = this.javaPackage + ".krotodc"

val FileDescriptor.simpleName: String
    get() = this.name.split('/').last().split('.').first()

val Descriptor.protobufJavaTypeName: ClassName
    get() {
        var simpleNames = this.fullName
            .replace(this.file.`package` + ".", "")
            .split('.')
        if (!this.file.options.javaMultipleFiles) {
            simpleNames = listOf(
                if (this.file.options.hasJavaOuterClassname()) {
                    this.file.options.javaOuterClassname
                } else {
                    fieldNameToJsonName(this.file.simpleName).capitalize()
                }
            ) + simpleNames
        }
        return ClassName(this.file.javaPackage, simpleNames)
    }

val Descriptor.krotoDCTypeName: ClassName
    get() {
        return ClassName(this.file.krotoDCPackage, simpleNames)
    }

val Descriptor.simpleNames: List<String>
    get() = this.fullName
        .replace(this.file.`package` + ".", "")
        .split('.')

fun Descriptor.isPredefinedType(): Boolean {
    return this.file.name.startsWith("google/")
}

fun Descriptor.isWellKnownWrapperType(): Boolean {
    return when (this.fullName) {
        in listOf(
            HandledPreDefinedType.DOUBLE_VALUE.descriptor.fullName,
            HandledPreDefinedType.FLOAT_VALUE.descriptor.fullName,
            HandledPreDefinedType.INT32_VALUE.descriptor.fullName,
            HandledPreDefinedType.INT64_VALUE.descriptor.fullName,
            HandledPreDefinedType.UINT32_VALUE.descriptor.fullName,
            HandledPreDefinedType.UINT64_VALUE.descriptor.fullName,
            HandledPreDefinedType.BOOL_VALUE.descriptor.fullName,
            HandledPreDefinedType.STRING_VALUE.descriptor.fullName,
            HandledPreDefinedType.BYTES_VALUE.descriptor.fullName
        ) -> true
        else -> false
    }
}

fun Descriptor.isHandledPreDefinedType(): Boolean {
    return HandledPreDefinedType.values().any {
        it.descriptor.fullName == this.fullName
    }
}

val EnumDescriptor.protobufJavaTypeName: ClassName
    get() {
        var simpleNames = this.fullName
            .replace(this.file.`package` + ".", "")
            .split('.')
        if (!this.file.options.javaMultipleFiles) {
            simpleNames = listOf(
                if (this.file.options.hasJavaOuterClassname()) {
                    this.file.options.javaOuterClassname
                } else {
                    fieldNameToJsonName(this.file.simpleName).capitalize()
                }
            ) + simpleNames
        }
        return ClassName(this.file.javaPackage, simpleNames)
    }

val EnumDescriptor.krotoDCTypeName: ClassName
    get() {
        val simpleNames = this.fullName
            .replace(this.file.`package` + ".", "")
            .split('.')
        return ClassName(this.file.krotoDCPackage, simpleNames)
    }

val FieldDescriptor.isKrotoDCOptional: Boolean
    get() {
        if (this.hasOptionalKeyword()) {
            return true
        }
        if (this.isRepeated || isMapField) {
            return false
        }
        if (this.type != FieldDescriptor.Type.MESSAGE) {
            return false
        }
        return this.messageType.isWellKnownWrapperType()
    }

val Descriptors.ServiceDescriptor.krotoServiceImplBaseName: ClassName
    get() {
        return ClassName(this.file.krotoDCPackage, "${this.name}CoroutineImplBase")
    }

val Descriptors.ServiceDescriptor.krotoClientStubName: ClassName
    get() {
        return ClassName(this.file.krotoDCPackage, "${this.name}CoroutineStub")
    }

val Descriptors.ServiceDescriptor.grpcClass: ClassName
    get() =
        ClassName(this.file.javaPackage, this.name + GRPC_JAVA_CLASS_NAME_SUFFIX)

val Descriptors.MethodDescriptor.descriptorCode: CodeBlock
    get() = CodeBlock.of(
        "%T.%L()",
        service.grpcClass,
        "get" + this.name.capitalize() + "Method"
    )

val Descriptor.converterImports: Set<Import>
    get() {
        if (
            this.isPredefinedType() || this.options.mapEntry
        ) {
            return setOf()
        }
        return setOf(
            this.toProtoImport,
            this.toDataClassImport
        )
    }

val Descriptor.toProtoImport: Import
    get() {
        return Import(
            this.file.krotoDCPackage + '.' + this.simpleNames.first().lowercase(),
            listOf("toProto")
        )
    }
val Descriptor.toDataClassImport: Import
    get() {
        return Import(
            this.file.krotoDCPackage + '.' + this.simpleNames.first().lowercase(),
            listOf("toDataClass")
        )
    }

/**
 * beware: does not escape Kotlin keywords
 */
val FieldDescriptor.javaFieldName: String
    get() {
        val jsonName = this.jsonName
        /**
         * protobuf-java escapes special fields in order to avoid name clashes with Java/Protobuf keywords
         * @see https://github.com/protocolbuffers/protobuf/blob/2cf94fafe39eeab44d3ab83898aabf03ff930d7a/java/core/src/main/java/com/google/protobuf/DescriptorMessageInfoFactory.java#L629C1-L648
         */
        return if (PROTOBUF_JAVA_SPECIAL_FIELD_NAMES.contains(jsonName.capitalize())) {
            jsonName + "_"
        } else {
            jsonName
        }
    }

/**
 * @see https://github.com/protocolbuffers/protobuf/blob/2cf94fafe39eeab44d3ab83898aabf03ff930d7a/java/core/src/main/java/com/google/protobuf/DescriptorMessageInfoFactory.java#L72
 */
val PROTOBUF_JAVA_SPECIAL_FIELD_NAMES = setOf(
    // java.lang.Object:
    "Class",
    // com.google.protobuf.MessageLiteOrBuilder:
    "DefaultInstanceForType",
    // com.google.protobuf.MessageLite:
    "ParserForType",
    "SerializedSize",
    // com.google.protobuf.MessageOrBuilder:
    "AllFields",
    "DescriptorForType",
    "InitializationErrorString",
    "UnknownFields",
    // obsolete. kept for backwards compatibility of generated code
    "CachedSize"
)
