package com.github.mscheong01.wellknowntypes.krotodc.repeatedwrappermessage

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.krotodc.toBoolValue
import com.github.mscheong01.krotodc.toBytesValue
import com.github.mscheong01.krotodc.toDoubleValue
import com.github.mscheong01.krotodc.toFloatValue
import com.github.mscheong01.krotodc.toInt32Value
import com.github.mscheong01.krotodc.toInt64Value
import com.github.mscheong01.krotodc.toStringValue
import com.github.mscheong01.krotodc.toUInt32Value
import com.github.mscheong01.krotodc.toUInt64Value
import com.github.mscheong01.wellknowntypes.RepeatedWrapperMessage

/**
 * Converts [RepeatedWrapperMessage] to
 * [com.github.mscheong01.wellknowntypes.krotodc.RepeatedWrapperMessage]
 */
@KrotoDCConverter(
  from = RepeatedWrapperMessage::class,
  to = com.github.mscheong01.wellknowntypes.krotodc.RepeatedWrapperMessage::class,
)
public fun RepeatedWrapperMessage.toDataClass():
    com.github.mscheong01.wellknowntypes.krotodc.RepeatedWrapperMessage =
    com.github.mscheong01.wellknowntypes.krotodc.RepeatedWrapperMessage(doubleValue =
    doubleValueList.map { it.value },
floatValue = floatValueList.map { it.value },
int64Value = int64ValueList.map { it.value },
uint64Value = uint64ValueList.map { it.value },
int32Value = int32ValueList.map { it.value },
uint32Value = uint32ValueList.map { it.value },
boolValue = boolValueList.map { it.value },
stringValue = stringValueList.map { it.value },
bytesValue = bytesValueList.map { it.value },
)

/**
 * Converts [com.github.mscheong01.wellknowntypes.krotodc.RepeatedWrapperMessage] to
 * [RepeatedWrapperMessage]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.wellknowntypes.krotodc.RepeatedWrapperMessage::class,
  to = RepeatedWrapperMessage::class,
)
public fun com.github.mscheong01.wellknowntypes.krotodc.RepeatedWrapperMessage.toProto():
    RepeatedWrapperMessage = RepeatedWrapperMessage.newBuilder()
.apply {
  addAllDoubleValue(this@toProto.doubleValue.map { it.toDoubleValue() })
  addAllFloatValue(this@toProto.floatValue.map { it.toFloatValue() })
  addAllInt64Value(this@toProto.int64Value.map { it.toInt64Value() })
  addAllUint64Value(this@toProto.uint64Value.map { it.toUInt64Value() })
  addAllInt32Value(this@toProto.int32Value.map { it.toInt32Value() })
  addAllUint32Value(this@toProto.uint32Value.map { it.toUInt32Value() })
  addAllBoolValue(this@toProto.boolValue.map { it.toBoolValue() })
  addAllStringValue(this@toProto.stringValue.map { it.toStringValue() })
  addAllBytesValue(this@toProto.bytesValue.map { it.toBytesValue() })
}
.build()
