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
package io.github.mscheong01.krotodc.predefinedtypes

import com.google.protobuf.Descriptors.Descriptor
import com.squareup.kotlinpoet.BOOLEAN
import com.squareup.kotlinpoet.DOUBLE
import com.squareup.kotlinpoet.FLOAT
import com.squareup.kotlinpoet.INT
import com.squareup.kotlinpoet.LONG
import com.squareup.kotlinpoet.STRING
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asTypeName
import io.github.mscheong01.krotodc.import.CodeWithImports
import io.github.mscheong01.krotodc.import.Import
import io.github.mscheong01.krotodc.template.TransformTemplateWithImports
import java.time.LocalDateTime

enum class HandledPreDefinedType(
    val descriptor: Descriptor,
    val kotlinType: TypeName,
    val defaultValue: CodeWithImports,
    val toDataClassTemplate: TransformTemplateWithImports = TransformTemplateWithImports.of("%L"),
    val toProtoTransformTemplate: TransformTemplateWithImports = TransformTemplateWithImports.of("%L")
) {
    EMPTY(
        com.google.protobuf.Empty.getDescriptor(),
        Unit::class.asTypeName(),
        CodeWithImports.of("Unit"),
        TransformTemplateWithImports.of("Unit"),
        TransformTemplateWithImports.of(
            "Empty.getDefaultInstance()",
            setOf(Import("com.google.protobuf", listOf("Empty")))
        )
    ),

    // time types
    TIMESTAMP(
        com.google.protobuf.Timestamp.getDescriptor(),
        LocalDateTime::class.asTypeName(),
        CodeWithImports.of(
            "Timestamp.getDefaultInstance().toLocalDateTime()",
            setOf(
                Import("com.google.protobuf", listOf("Timestamp")),
                Import("io.github.mscheong01.krotodc", listOf("toLocalDateTime"))
            )
        ),
        TransformTemplateWithImports.of(
            "%L.toLocalDateTime()",
            setOf(Import("io.github.mscheong01.krotodc", listOf("toLocalDateTime")))
        ),
        TransformTemplateWithImports.of(
            "%L.toProtoTimestamp()",
            setOf(Import("io.github.mscheong01.krotodc", listOf("toProtoTimestamp")))
        )
    ),
    DURATION(
        com.google.protobuf.Duration.getDescriptor(),
        java.time.Duration::class.asTypeName(),
        CodeWithImports.of("java.time.Duration.ZERO"),
        TransformTemplateWithImports.of(
            "%L.toDuration()",
            setOf(Import("io.github.mscheong01.krotodc", listOf("toDuration")))
        ),
        TransformTemplateWithImports.of(
            "%L.toProtoDuration()",
            setOf(Import("io.github.mscheong01.krotodc", listOf("toProtoDuration")))
        )
    ),

    // well known wrapper types
    DOUBLE_VALUE(
        com.google.protobuf.DoubleValue.getDescriptor(),
        DOUBLE.copy(nullable = true),
        CodeWithImports.of("null"),
        TransformTemplateWithImports.of("%L.value"),
        TransformTemplateWithImports.of(
            "%L.toDoubleValue()",
            setOf(Import("io.github.mscheong01.krotodc", listOf("toDoubleValue")))
        )
    ),
    FLOAT_VALUE(
        com.google.protobuf.FloatValue.getDescriptor(),
        FLOAT.copy(nullable = true),
        CodeWithImports.of("null"),
        TransformTemplateWithImports.of("%L.value"),
        TransformTemplateWithImports.of(
            "%L.toFloatValue()",
            setOf(Import("io.github.mscheong01.krotodc", listOf("toFloatValue")))
        )
    ),
    INT64_VALUE(
        com.google.protobuf.Int64Value.getDescriptor(),
        LONG.copy(nullable = true),
        CodeWithImports.of("null"),
        TransformTemplateWithImports.of("%L.value"),
        TransformTemplateWithImports.of(
            "%L.toInt64Value()",
            setOf(Import("io.github.mscheong01.krotodc", listOf("toInt64Value")))
        )
    ),
    UINT64_VALUE(
        com.google.protobuf.UInt64Value.getDescriptor(),
        LONG.copy(nullable = true),
        CodeWithImports.of("null"),
        TransformTemplateWithImports.of("%L.value"),
        TransformTemplateWithImports.of(
            "%L.toUInt64Value()",
            setOf(Import("io.github.mscheong01.krotodc", listOf("toUInt64Value")))
        )
    ),
    INT32_VALUE(
        com.google.protobuf.Int32Value.getDescriptor(),
        INT.copy(nullable = true),
        CodeWithImports.of("null"),
        TransformTemplateWithImports.of("%L.value"),
        TransformTemplateWithImports.of(
            "%L.toInt32Value()",
            setOf(Import("io.github.mscheong01.krotodc", listOf("toInt32Value")))
        )
    ),
    UINT32_VALUE(
        com.google.protobuf.UInt32Value.getDescriptor(),
        INT.copy(nullable = true),
        CodeWithImports.of("null"),
        TransformTemplateWithImports.of("%L.value"),
        TransformTemplateWithImports.of(
            "%L.toUInt32Value()",
            setOf(Import("io.github.mscheong01.krotodc", listOf("toUInt32Value")))
        )
    ),
    BOOL_VALUE(
        com.google.protobuf.BoolValue.getDescriptor(),
        BOOLEAN.copy(nullable = true),
        CodeWithImports.of("null"),
        TransformTemplateWithImports.of("%L.value"),
        TransformTemplateWithImports.of(
            "%L.toBoolValue()",
            setOf(Import("io.github.mscheong01.krotodc", listOf("toBoolValue")))
        )
    ),
    STRING_VALUE(
        com.google.protobuf.StringValue.getDescriptor(),
        STRING.copy(nullable = true),
        CodeWithImports.of("null"),
        TransformTemplateWithImports.of("%L.value"),
        TransformTemplateWithImports.of(
            "%L.toStringValue()",
            setOf(Import("io.github.mscheong01.krotodc", listOf("toStringValue")))
        )
    ),
    BYTES_VALUE(
        com.google.protobuf.BytesValue.getDescriptor(),
        com.google.protobuf.ByteString::class.asTypeName().copy(nullable = true),
        CodeWithImports.of("null"),
        TransformTemplateWithImports.of("%L.value"),
        TransformTemplateWithImports.of(
            "%L.toBytesValue()",
            setOf(Import("io.github.mscheong01.krotodc", listOf("toBytesValue")))
        )
    )
    ;

    companion object {
        fun valueOfByDescriptor(descriptor: Descriptor): HandledPreDefinedType {
            return values().first { it.descriptor.fullName == descriptor.fullName }
        }
    }
}
