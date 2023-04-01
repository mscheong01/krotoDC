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
import com.google.protobuf.FloatValue
import com.google.protobuf.Int32Value
import com.google.protobuf.Int64Value
import com.google.protobuf.StringValue
import com.google.protobuf.Timestamp
import com.google.protobuf.UInt32Value
import com.google.protobuf.UInt64Value
import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

fun Timestamp.toLocalDateTime(): LocalDateTime {
    val instant = Instant.ofEpochSecond(this.seconds, this.nanos.toLong())
    return LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
}

fun LocalDateTime.toProtoTimestamp(): Timestamp {
    val instant = this.atZone(ZoneId.systemDefault()).toInstant()
    return Timestamp.newBuilder().setSeconds(instant.epochSecond)
        .setNanos(instant.nano)
        .build()
}

fun com.google.protobuf.Duration.toDuration(): Duration {
    return Duration.ofSeconds(this.seconds, this.nanos.toLong())
}

fun Duration.toProtoDuration(): com.google.protobuf.Duration {
    return com.google.protobuf.Duration.newBuilder()
        .setSeconds(this.seconds)
        .setNanos(this.nano)
        .build()
}

// Convert kotlin Double to protobuf DoubleValue
fun Double.toDoubleValue(): DoubleValue = DoubleValue.newBuilder().setValue(this).build()

// Convert kotlin Float to protobuf FloatValue
fun Float.toFloatValue(): FloatValue = FloatValue.newBuilder().setValue(this).build()

// Convert kotlin Long to protobuf Int64Value
fun Long.toInt64Value(): Int64Value = Int64Value.newBuilder().setValue(this).build()

// Convert kotlin Long to protobuf UInt64Value
fun Long.toUInt64Value(): UInt64Value = UInt64Value.newBuilder().setValue(this).build()

// Convert kotlin Int to protobuf Int32Value
fun Int.toInt32Value(): Int32Value = Int32Value.newBuilder().setValue(this).build()

// Convert kotlin Int to protobuf UInt32Value
fun Int.toUInt32Value(): UInt32Value = UInt32Value.newBuilder().setValue(this).build()

// Convert kotlin Boolean to protobuf BoolValue
fun Boolean.toBoolValue(): BoolValue = BoolValue.newBuilder().setValue(this).build()

// Convert kotlin String to protobuf StringValue
fun String.toStringValue(): StringValue = StringValue.newBuilder().setValue(this).build()

// Convert kotlin ByteString to protobuf BytesValue
fun ByteString.toBytesValue(): BytesValue = BytesValue.newBuilder().setValue(this).build()
