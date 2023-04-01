package com.github.mscheong01.test.krotodc.primitivemessage

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.test.PrimitiveMessage

/**
 * Converts [PrimitiveMessage] to [com.github.mscheong01.test.krotodc.PrimitiveMessage]
 */
@KrotoDCConverter(
  from = PrimitiveMessage::class,
  to = com.github.mscheong01.test.krotodc.PrimitiveMessage::class,
)
public fun PrimitiveMessage.toDataClass(): com.github.mscheong01.test.krotodc.PrimitiveMessage =
    com.github.mscheong01.test.krotodc.PrimitiveMessage(int32Field = int32Field,
int64Field = int64Field,
uint32Field = uint32Field,
uint64Field = uint64Field,
sint32Field = sint32Field,
sint64Field = sint64Field,
fixed32Field = fixed32Field,
fixed64Field = fixed64Field,
sfixed32Field = sfixed32Field,
sfixed64Field = sfixed64Field,
floatField = floatField,
doubleField = doubleField,
boolField = boolField,
stringField = stringField,
bytesField = bytesField,
)

/**
 * Converts [com.github.mscheong01.test.krotodc.PrimitiveMessage] to [PrimitiveMessage]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.test.krotodc.PrimitiveMessage::class,
  to = PrimitiveMessage::class,
)
public fun com.github.mscheong01.test.krotodc.PrimitiveMessage.toProto(): PrimitiveMessage =
    PrimitiveMessage.newBuilder()
.apply {
  setInt32Field(this@toProto.int32Field)
  setInt64Field(this@toProto.int64Field)
  setUint32Field(this@toProto.uint32Field)
  setUint64Field(this@toProto.uint64Field)
  setSint32Field(this@toProto.sint32Field)
  setSint64Field(this@toProto.sint64Field)
  setFixed32Field(this@toProto.fixed32Field)
  setFixed64Field(this@toProto.fixed64Field)
  setSfixed32Field(this@toProto.sfixed32Field)
  setSfixed64Field(this@toProto.sfixed64Field)
  setFloatField(this@toProto.floatField)
  setDoubleField(this@toProto.doubleField)
  setBoolField(this@toProto.boolField)
  setStringField(this@toProto.stringField)
  setBytesField(this@toProto.bytesField)
}
.build()
