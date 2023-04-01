package com.github.mscheong01.wellknowntypes.krotodc.structanymessage

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.wellknowntypes.StructAnyMessage

/**
 * Converts [StructAnyMessage] to [com.github.mscheong01.wellknowntypes.krotodc.StructAnyMessage]
 */
@KrotoDCConverter(
  from = StructAnyMessage::class,
  to = com.github.mscheong01.wellknowntypes.krotodc.StructAnyMessage::class,
)
public fun StructAnyMessage.toDataClass():
    com.github.mscheong01.wellknowntypes.krotodc.StructAnyMessage =
    com.github.mscheong01.wellknowntypes.krotodc.StructAnyMessage(struct = struct,
any = any,
)

/**
 * Converts [com.github.mscheong01.wellknowntypes.krotodc.StructAnyMessage] to [StructAnyMessage]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.wellknowntypes.krotodc.StructAnyMessage::class,
  to = StructAnyMessage::class,
)
public fun com.github.mscheong01.wellknowntypes.krotodc.StructAnyMessage.toProto(): StructAnyMessage
    = StructAnyMessage.newBuilder()
.apply {
  setStruct(this@toProto.struct)
  setAny(this@toProto.any)
}
.build()
