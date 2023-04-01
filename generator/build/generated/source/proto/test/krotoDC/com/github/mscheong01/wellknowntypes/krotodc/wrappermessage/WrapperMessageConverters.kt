package com.github.mscheong01.wellknowntypes.krotodc.wrappermessage

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
import com.github.mscheong01.wellknowntypes.WrapperMessage

/**
 * Converts [WrapperMessage] to [com.github.mscheong01.wellknowntypes.krotodc.WrapperMessage]
 */
@KrotoDCConverter(
  from = WrapperMessage::class,
  to = com.github.mscheong01.wellknowntypes.krotodc.WrapperMessage::class,
)
public fun WrapperMessage.toDataClass(): com.github.mscheong01.wellknowntypes.krotodc.WrapperMessage
    = com.github.mscheong01.wellknowntypes.krotodc.WrapperMessage(doubleValue = if
    (hasDoubleValue()) {
  doubleValue.value} else {
  null}
,
floatValue = if (hasFloatValue()) {
  floatValue.value} else {
  null}
,
int64Value = if (hasInt64Value()) {
  int64Value.value} else {
  null}
,
uint64Value = if (hasUint64Value()) {
  uint64Value.value} else {
  null}
,
int32Value = if (hasInt32Value()) {
  int32Value.value} else {
  null}
,
uint32Value = if (hasUint32Value()) {
  uint32Value.value} else {
  null}
,
boolValue = if (hasBoolValue()) {
  boolValue.value} else {
  null}
,
stringValue = if (hasStringValue()) {
  stringValue.value} else {
  null}
,
bytesValue = if (hasBytesValue()) {
  bytesValue.value} else {
  null}
,
)

/**
 * Converts [com.github.mscheong01.wellknowntypes.krotodc.WrapperMessage] to [WrapperMessage]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.wellknowntypes.krotodc.WrapperMessage::class,
  to = WrapperMessage::class,
)
public fun com.github.mscheong01.wellknowntypes.krotodc.WrapperMessage.toProto(): WrapperMessage =
    WrapperMessage.newBuilder()
.apply {
  if (this@toProto.doubleValue != null) {
    setDoubleValue(this@toProto.doubleValue.toDoubleValue())
  }
  if (this@toProto.floatValue != null) {
    setFloatValue(this@toProto.floatValue.toFloatValue())
  }
  if (this@toProto.int64Value != null) {
    setInt64Value(this@toProto.int64Value.toInt64Value())
  }
  if (this@toProto.uint64Value != null) {
    setUint64Value(this@toProto.uint64Value.toUInt64Value())
  }
  if (this@toProto.int32Value != null) {
    setInt32Value(this@toProto.int32Value.toInt32Value())
  }
  if (this@toProto.uint32Value != null) {
    setUint32Value(this@toProto.uint32Value.toUInt32Value())
  }
  if (this@toProto.boolValue != null) {
    setBoolValue(this@toProto.boolValue.toBoolValue())
  }
  if (this@toProto.stringValue != null) {
    setStringValue(this@toProto.stringValue.toStringValue())
  }
  if (this@toProto.bytesValue != null) {
    setBytesValue(this@toProto.bytesValue.toBytesValue())
  }
}
.build()
