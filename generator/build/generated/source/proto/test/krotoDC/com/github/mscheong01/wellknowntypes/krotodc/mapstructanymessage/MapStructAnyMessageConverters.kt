package com.github.mscheong01.wellknowntypes.krotodc.mapstructanymessage

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.wellknowntypes.MapStructAnyMessage

/**
 * Converts [MapStructAnyMessage] to
 * [com.github.mscheong01.wellknowntypes.krotodc.MapStructAnyMessage]
 */
@KrotoDCConverter(
  from = MapStructAnyMessage::class,
  to = com.github.mscheong01.wellknowntypes.krotodc.MapStructAnyMessage::class,
)
public fun MapStructAnyMessage.toDataClass():
    com.github.mscheong01.wellknowntypes.krotodc.MapStructAnyMessage =
    com.github.mscheong01.wellknowntypes.krotodc.MapStructAnyMessage(struct = structMap,
any = anyMap,
)

/**
 * Converts [com.github.mscheong01.wellknowntypes.krotodc.MapStructAnyMessage] to
 * [MapStructAnyMessage]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.wellknowntypes.krotodc.MapStructAnyMessage::class,
  to = MapStructAnyMessage::class,
)
public fun com.github.mscheong01.wellknowntypes.krotodc.MapStructAnyMessage.toProto():
    MapStructAnyMessage = MapStructAnyMessage.newBuilder()
.apply {
  putAllStruct(this@toProto.struct)
  putAllAny(this@toProto.any)
}
.build()
