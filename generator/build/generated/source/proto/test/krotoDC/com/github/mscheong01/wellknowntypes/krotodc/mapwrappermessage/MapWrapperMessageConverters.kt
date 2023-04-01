package com.github.mscheong01.wellknowntypes.krotodc.mapwrappermessage

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
import com.github.mscheong01.wellknowntypes.MapWrapperMessage

/**
 * Converts [MapWrapperMessage] to [com.github.mscheong01.wellknowntypes.krotodc.MapWrapperMessage]
 */
@KrotoDCConverter(
  from = MapWrapperMessage::class,
  to = com.github.mscheong01.wellknowntypes.krotodc.MapWrapperMessage::class,
)
public fun MapWrapperMessage.toDataClass():
    com.github.mscheong01.wellknowntypes.krotodc.MapWrapperMessage =
    com.github.mscheong01.wellknowntypes.krotodc.MapWrapperMessage(doubleValue =
    doubleValueMap.mapValues { it.value.value },
floatValue = floatValueMap.mapValues { it.value.value },
int64Value = int64ValueMap.mapValues { it.value.value },
uint64Value = uint64ValueMap.mapValues { it.value.value },
int32Value = int32ValueMap.mapValues { it.value.value },
uint32Value = uint32ValueMap.mapValues { it.value.value },
boolValue = boolValueMap.mapValues { it.value.value },
stringValue = stringValueMap.mapValues { it.value.value },
bytesValue = bytesValueMap.mapValues { it.value.value },
)

/**
 * Converts [com.github.mscheong01.wellknowntypes.krotodc.MapWrapperMessage] to [MapWrapperMessage]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.wellknowntypes.krotodc.MapWrapperMessage::class,
  to = MapWrapperMessage::class,
)
public fun com.github.mscheong01.wellknowntypes.krotodc.MapWrapperMessage.toProto():
    MapWrapperMessage = MapWrapperMessage.newBuilder()
.apply {
  putAllDoubleValue(this@toProto.doubleValue.mapValues { it.value.toDoubleValue() })
  putAllFloatValue(this@toProto.floatValue.mapValues { it.value.toFloatValue() })
  putAllInt64Value(this@toProto.int64Value.mapValues { it.value.toInt64Value() })
  putAllUint64Value(this@toProto.uint64Value.mapValues { it.value.toUInt64Value() })
  putAllInt32Value(this@toProto.int32Value.mapValues { it.value.toInt32Value() })
  putAllUint32Value(this@toProto.uint32Value.mapValues { it.value.toUInt32Value() })
  putAllBoolValue(this@toProto.boolValue.mapValues { it.value.toBoolValue() })
  putAllStringValue(this@toProto.stringValue.mapValues { it.value.toStringValue() })
  putAllBytesValue(this@toProto.bytesValue.mapValues { it.value.toBytesValue() })
}
.build()
