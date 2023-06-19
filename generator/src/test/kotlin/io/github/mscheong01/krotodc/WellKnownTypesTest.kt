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
package io.github.mscheong01.krotodc

import com.google.protobuf.BoolValue
import com.google.protobuf.ByteString
import com.google.protobuf.BytesValue
import com.google.protobuf.DoubleValue
import com.google.protobuf.Empty
import com.google.protobuf.FloatValue
import com.google.protobuf.Int32Value
import com.google.protobuf.Int64Value
import com.google.protobuf.StringValue
import com.google.protobuf.UInt32Value
import com.google.protobuf.UInt64Value
import io.github.mscheong01.test.Person
import io.github.mscheong01.wellknowntypes.MapEmptyMessage
import io.github.mscheong01.wellknowntypes.MapStructAnyMessage
import io.github.mscheong01.wellknowntypes.MapTimeMessage
import io.github.mscheong01.wellknowntypes.MapWrapperMessage
import io.github.mscheong01.wellknowntypes.MessageWithEmpty
import io.github.mscheong01.wellknowntypes.RepeatedEmptyMessage
import io.github.mscheong01.wellknowntypes.RepeatedStructAnyMessage
import io.github.mscheong01.wellknowntypes.RepeatedTimeMessage
import io.github.mscheong01.wellknowntypes.RepeatedWrapperMessage
import io.github.mscheong01.wellknowntypes.StructAnyMessage
import io.github.mscheong01.wellknowntypes.TimeMessage
import io.github.mscheong01.wellknowntypes.WrapperMessage
import io.github.mscheong01.wellknowntypes.krotodc.mapemptymessage.toDataClass
import io.github.mscheong01.wellknowntypes.krotodc.mapemptymessage.toProto
import io.github.mscheong01.wellknowntypes.krotodc.mapstructanymessage.toDataClass
import io.github.mscheong01.wellknowntypes.krotodc.mapstructanymessage.toProto
import io.github.mscheong01.wellknowntypes.krotodc.maptimemessage.toDataClass
import io.github.mscheong01.wellknowntypes.krotodc.maptimemessage.toProto
import io.github.mscheong01.wellknowntypes.krotodc.mapwrappermessage.toDataClass
import io.github.mscheong01.wellknowntypes.krotodc.mapwrappermessage.toProto
import io.github.mscheong01.wellknowntypes.krotodc.messagewithempty.toDataClass
import io.github.mscheong01.wellknowntypes.krotodc.messagewithempty.toProto
import io.github.mscheong01.wellknowntypes.krotodc.repeatedemptymessage.toDataClass
import io.github.mscheong01.wellknowntypes.krotodc.repeatedemptymessage.toProto
import io.github.mscheong01.wellknowntypes.krotodc.repeatedstructanymessage.toDataClass
import io.github.mscheong01.wellknowntypes.krotodc.repeatedstructanymessage.toProto
import io.github.mscheong01.wellknowntypes.krotodc.repeatedtimemessage.toDataClass
import io.github.mscheong01.wellknowntypes.krotodc.repeatedtimemessage.toProto
import io.github.mscheong01.wellknowntypes.krotodc.repeatedwrappermessage.toDataClass
import io.github.mscheong01.wellknowntypes.krotodc.repeatedwrappermessage.toProto
import io.github.mscheong01.wellknowntypes.krotodc.structanymessage.toDataClass
import io.github.mscheong01.wellknowntypes.krotodc.structanymessage.toProto
import io.github.mscheong01.wellknowntypes.krotodc.timemessage.toDataClass
import io.github.mscheong01.wellknowntypes.krotodc.timemessage.toProto
import io.github.mscheong01.wellknowntypes.krotodc.wrappermessage.toDataClass
import io.github.mscheong01.wellknowntypes.krotodc.wrappermessage.toProto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class WellKnownTypesTest {
    @Test
    fun `test mesasge with Empty`() {
        val proto = MessageWithEmpty.newBuilder().setEmpty(Empty.newBuilder().build()).build()
        val kroto = proto.toDataClass()
        Assertions.assertThat(kroto).isEqualTo(io.github.mscheong01.wellknowntypes.krotodc.MessageWithEmpty(Unit))
        val proto2 = kroto.toProto()
        Assertions.assertThat(proto2).isEqualTo(proto)
    }

    @Disabled
    @Test
    fun `test message with time types`() {
        val kroto = io.github.mscheong01.wellknowntypes.krotodc.TimeMessage(
            LocalDateTime.of(2023, 3, 30, 22, 21, 1, 2),
            java.time.Duration.ofSeconds(3, 4)
        )
        val proto = kroto.toProto()
        Assertions.assertThat(proto).isEqualTo(
            TimeMessage.newBuilder()
                .setTimestamp(
                    com.google.protobuf.Timestamp.newBuilder()
                        .setSeconds(1680182461)
                        .setNanos(2)
                        .build()
                )
                .setDuration(
                    com.google.protobuf.Duration.newBuilder()
                        .setSeconds(3)
                        .setNanos(4)
                        .build()
                )
                .build()
        )

        val kroto2 = proto.toDataClass()
        Assertions.assertThat(kroto).isEqualTo(kroto2)
    }

    @Test
    fun `test message with well known wrapper fields`() {
        val proto = WrapperMessage.newBuilder()
            .setDoubleValue(DoubleValue.newBuilder().setValue(1.0).build())
            .setFloatValue(FloatValue.newBuilder().setValue(2.0f).build())
            .setInt64Value(Int64Value.newBuilder().setValue(3).build())
            .setUint64Value(UInt64Value.newBuilder().setValue(4).build())
            .setInt32Value(Int32Value.newBuilder().setValue(5).build())
            .setUint32Value(UInt32Value.newBuilder().setValue(6).build())
            .setBoolValue(BoolValue.newBuilder().setValue(true).build())
            .setStringValue(StringValue.newBuilder().setValue("7").build())
            .setBytesValue(
                BytesValue.newBuilder().setValue(
                    com.google.protobuf.ByteString.copyFromUtf8("8")
                ).build()
            ).build()
        val kroto = proto.toDataClass()
        Assertions.assertThat(kroto).isEqualTo(
            io.github.mscheong01.wellknowntypes.krotodc.WrapperMessage(
                1.0,
                2.0f,
                3,
                4,
                5,
                6,
                true,
                "7",
                ByteString.copyFromUtf8("8")
            )
        )
        val proto2 = kroto.toProto()
        Assertions.assertThat(proto2).isEqualTo(proto)
    }

    @Test
    fun `test message with struct and any`() {
        val proto = StructAnyMessage.newBuilder()
            .setAny(
                com.google.protobuf.Any.pack(
                    Person.newBuilder()
                        .setName("name")
                        .build()
                )
            )
            .setStruct(
                com.google.protobuf.Struct.newBuilder()
                    .putFields("key", com.google.protobuf.Value.newBuilder().setStringValue("value").build())
                    .build()
            )
            .build()
        val kroto = proto.toDataClass()
        Assertions.assertThat(kroto.any).isEqualTo(
            com.google.protobuf.Any.pack(
                Person.newBuilder()
                    .setName("name")
                    .build()
            )
        )
        Assertions.assertThat(kroto.struct).isEqualTo(
            com.google.protobuf.Struct.newBuilder()
                .putFields("key", com.google.protobuf.Value.newBuilder().setStringValue("value").build())
                .build()
        )
        val proto2 = kroto.toProto()
        Assertions.assertThat(proto2).isEqualTo(proto)
    }

    @Test
    fun `test message with repeated empty message`() {
        val proto = RepeatedEmptyMessage.newBuilder()
            .addAllEmpty(listOf(Empty.newBuilder().build(), Empty.newBuilder().build()))
            .build()
        val kroto = proto.toDataClass()
        Assertions.assertThat(kroto.empty).isEqualTo(listOf(Unit, Unit))
        val proto2 = kroto.toProto()
        Assertions.assertThat(proto2).isEqualTo(proto)
    }

    @Disabled
    @Test
    fun `test message with repeated time types`() {
        val proto = RepeatedTimeMessage.newBuilder()
            .addAllTimestamp(
                listOf(
                    com.google.protobuf.Timestamp.newBuilder()
                        .setSeconds(1680182461)
                        .setNanos(2)
                        .build(),
                    com.google.protobuf.Timestamp.newBuilder()
                        .setSeconds(1680182461)
                        .setNanos(2)
                        .build()
                )
            )
            .addAllDuration(
                listOf(
                    com.google.protobuf.Duration.newBuilder()
                        .setSeconds(3)
                        .setNanos(4)
                        .build(),
                    com.google.protobuf.Duration.newBuilder()
                        .setSeconds(3)
                        .setNanos(4)
                        .build()
                )
            )
            .build()
        val kroto = proto.toDataClass()
        Assertions.assertThat(kroto.timestamp).isEqualTo(
            listOf(
                LocalDateTime.of(2023, 3, 30, 22, 21, 1, 2),
                LocalDateTime.of(2023, 3, 30, 22, 21, 1, 2)
            )
        )
        Assertions.assertThat(kroto.duration).isEqualTo(
            listOf(
                java.time.Duration.ofSeconds(3, 4),
                java.time.Duration.ofSeconds(3, 4)
            )
        )
        val proto2 = kroto.toProto()
        Assertions.assertThat(proto2).isEqualTo(proto)
    }

    @Test
    fun `test message with repeated well known wrapper fields`() {
        val proto = RepeatedWrapperMessage.newBuilder()
            .addAllDoubleValue(
                listOf(
                    DoubleValue.newBuilder().setValue(1.0).build(),
                    DoubleValue.newBuilder().setValue(1.0).build()
                )
            )
            .addAllFloatValue(
                listOf(
                    FloatValue.newBuilder().setValue(2.0f).build(),
                    FloatValue.newBuilder().setValue(2.0f).build()
                )
            )
            .addAllInt64Value(
                listOf(
                    Int64Value.newBuilder().setValue(3).build(),
                    Int64Value.newBuilder().setValue(3).build()
                )
            )
            .addAllUint64Value(
                listOf(
                    UInt64Value.newBuilder().setValue(4).build(),
                    UInt64Value.newBuilder().setValue(4).build()
                )
            )
            .addAllInt32Value(
                listOf(
                    Int32Value.newBuilder().setValue(5).build(),
                    Int32Value.newBuilder().setValue(5).build()
                )
            )
            .addAllUint32Value(
                listOf(
                    UInt32Value.newBuilder().setValue(6).build(),
                    UInt32Value.newBuilder().setValue(6).build()
                )
            )
            .addAllBoolValue(
                listOf(
                    BoolValue.newBuilder().setValue(true).build(),
                    BoolValue.newBuilder().setValue(true).build()
                )
            )
            .addAllStringValue(
                listOf(
                    StringValue.newBuilder().setValue("7").build(),
                    StringValue.newBuilder().setValue("7").build()
                )
            )
            .addAllBytesValue(
                listOf(
                    BytesValue.newBuilder().setValue(
                        com.google.protobuf.ByteString.copyFromUtf8("8")
                    ).build(),
                    BytesValue.newBuilder().setValue(
                        com.google.protobuf.ByteString.copyFromUtf8("8")
                    ).build()
                )
            )
            .build()
        val kroto = proto.toDataClass()
        Assertions.assertThat(kroto.doubleValue).isEqualTo(listOf(1.0, 1.0))
        Assertions.assertThat(kroto.floatValue).isEqualTo(listOf(2.0f, 2.0f))
        Assertions.assertThat(kroto.int64Value).isEqualTo(listOf(3L, 3L))
        Assertions.assertThat(kroto.uint64Value).isEqualTo(listOf(4L, 4L))
        Assertions.assertThat(kroto.int32Value).isEqualTo(listOf(5, 5))
        Assertions.assertThat(kroto.uint32Value).isEqualTo(listOf(6, 6))
        Assertions.assertThat(kroto.boolValue).isEqualTo(listOf(true, true))
        Assertions.assertThat(kroto.stringValue).isEqualTo(listOf("7", "7"))
        Assertions.assertThat(kroto.bytesValue).isEqualTo(
            listOf(
                ByteString.copyFromUtf8("8"),
                ByteString.copyFromUtf8("8")
            )
        )
        val proto2 = kroto.toProto()
        Assertions.assertThat(proto2).isEqualTo(proto)
    }

    @Test
    fun `test message with repeated struct and any fields`() {
        val proto = RepeatedStructAnyMessage.newBuilder()
            .addAllAny(
                listOf(
                    com.google.protobuf.Any.pack(
                        Person.newBuilder()
                            .setName("name")
                            .build()
                    ),
                    com.google.protobuf.Any.pack(
                        Person.newBuilder()
                            .setName("name")
                            .build()
                    )
                )
            )
            .addAllStruct(
                listOf(
                    com.google.protobuf.Struct.newBuilder()
                        .putFields("key", com.google.protobuf.Value.newBuilder().setStringValue("value").build())
                        .build(),
                    com.google.protobuf.Struct.newBuilder()
                        .putFields("key", com.google.protobuf.Value.newBuilder().setStringValue("value").build())
                        .build()
                )
            )
            .build()
        val kroto = proto.toDataClass()
        Assertions.assertThat(kroto.any).isEqualTo(
            proto.anyList
        )
        Assertions.assertThat(kroto.struct).isEqualTo(
            proto.structList
        )
        val proto2 = kroto.toProto()
        Assertions.assertThat(proto2).isEqualTo(proto)
    }

    @Test
    fun `test message with map empty field`() {
        val proto = MapEmptyMessage.newBuilder()
            .putAllEmpty(mapOf("key" to Empty.getDefaultInstance()))
            .build()
        val kroto = proto.toDataClass()
        Assertions.assertThat(kroto.empty).isEqualTo(
            mapOf("key" to Unit)
        )
        val proto2 = kroto.toProto()
        Assertions.assertThat(proto2).isEqualTo(proto)
    }

    @Disabled
    @Test
    fun `test message wit map time fields`() {
        val proto = MapTimeMessage.newBuilder()
            .putAllTimestamp(
                mapOf(
                    "key" to com.google.protobuf.Timestamp.newBuilder()
                        .setSeconds(1680182461)
                        .setNanos(2)
                        .build()
                )
            )
            .putAllDuration(
                mapOf("key" to com.google.protobuf.Duration.newBuilder().setSeconds(3).setNanos(4).build())
            )
            .build()
        val kroto = proto.toDataClass()
        Assertions.assertThat(kroto.timestamp).isEqualTo(
            mapOf("key" to LocalDateTime.of(2023, 3, 30, 22, 21, 1, 2))
        )
        Assertions.assertThat(kroto.duration).isEqualTo(
            mapOf("key" to java.time.Duration.ofSeconds(3, 4))
        )
        val proto2 = kroto.toProto()
        Assertions.assertThat(proto2).isEqualTo(proto)
    }

    @Test
    fun `test message with map well knwon wrapper type fields`() {
        val proto = MapWrapperMessage.newBuilder()
            .putAllDoubleValue(mapOf("key" to DoubleValue.newBuilder().setValue(1.0).build()))
            .putAllFloatValue(mapOf("key" to FloatValue.newBuilder().setValue(2.0f).build()))
            .putAllInt64Value(mapOf("key" to Int64Value.newBuilder().setValue(3).build()))
            .putAllUint64Value(mapOf("key" to UInt64Value.newBuilder().setValue(4).build()))
            .putAllInt32Value(mapOf("key" to Int32Value.newBuilder().setValue(5).build()))
            .putAllUint32Value(mapOf("key" to UInt32Value.newBuilder().setValue(6).build()))
            .putAllBoolValue(mapOf("key" to BoolValue.newBuilder().setValue(true).build()))
            .putAllStringValue(mapOf("key" to StringValue.newBuilder().setValue("7").build()))
            .putAllBytesValue(
                mapOf(
                    "key" to BytesValue.newBuilder().setValue(
                        com.google.protobuf.ByteString.copyFromUtf8("8")
                    ).build()
                )
            )
            .build()
        val kroto = proto.toDataClass()
        Assertions.assertThat(kroto.doubleValue).isEqualTo(mapOf("key" to 1.0))
        Assertions.assertThat(kroto.floatValue).isEqualTo(mapOf("key" to 2.0f))
        Assertions.assertThat(kroto.int64Value).isEqualTo(mapOf("key" to 3L))
        Assertions.assertThat(kroto.uint64Value).isEqualTo(mapOf("key" to 4L))
        Assertions.assertThat(kroto.int32Value).isEqualTo(mapOf("key" to 5))
        Assertions.assertThat(kroto.uint32Value).isEqualTo(mapOf("key" to 6))
        Assertions.assertThat(kroto.boolValue).isEqualTo(mapOf("key" to true))
        Assertions.assertThat(kroto.stringValue).isEqualTo(mapOf("key" to "7"))
        Assertions.assertThat(kroto.bytesValue).isEqualTo(mapOf("key" to ByteString.copyFromUtf8("8")))
        val proto2 = kroto.toProto()
        Assertions.assertThat(proto2).isEqualTo(proto)
    }

    @Test
    fun `test message with map struct and any fields`() {
        val proto = MapStructAnyMessage.newBuilder()
            .putAllAny(
                mapOf(
                    "key" to com.google.protobuf.Any.pack(
                        Person.newBuilder()
                            .setName("name")
                            .build()
                    )
                )
            )
            .putAllStruct(
                mapOf(
                    "key" to com.google.protobuf.Struct.newBuilder()
                        .putFields("key", com.google.protobuf.Value.newBuilder().setStringValue("value").build())
                        .build()
                )
            )
            .build()
        val kroto = proto.toDataClass()
        Assertions.assertThat(kroto.any).isEqualTo(
            mapOf("key" to proto.anyMap["key"])
        )
        Assertions.assertThat(kroto.struct).isEqualTo(
            mapOf("key" to proto.structMap["key"])
        )
        val proto2 = kroto.toProto()
        Assertions.assertThat(proto2).isEqualTo(proto)
    }
}
