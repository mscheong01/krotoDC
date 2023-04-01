package com.github.mscheong01.wellknowntypes.krotodc.repeatedstructanymessage

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.wellknowntypes.RepeatedStructAnyMessage

/**
 * Converts [RepeatedStructAnyMessage] to
 * [com.github.mscheong01.wellknowntypes.krotodc.RepeatedStructAnyMessage]
 */
@KrotoDCConverter(
  from = RepeatedStructAnyMessage::class,
  to = com.github.mscheong01.wellknowntypes.krotodc.RepeatedStructAnyMessage::class,
)
public fun RepeatedStructAnyMessage.toDataClass():
    com.github.mscheong01.wellknowntypes.krotodc.RepeatedStructAnyMessage =
    com.github.mscheong01.wellknowntypes.krotodc.RepeatedStructAnyMessage(struct = structList,
any = anyList,
)

/**
 * Converts [com.github.mscheong01.wellknowntypes.krotodc.RepeatedStructAnyMessage] to
 * [RepeatedStructAnyMessage]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.wellknowntypes.krotodc.RepeatedStructAnyMessage::class,
  to = RepeatedStructAnyMessage::class,
)
public fun com.github.mscheong01.wellknowntypes.krotodc.RepeatedStructAnyMessage.toProto():
    RepeatedStructAnyMessage = RepeatedStructAnyMessage.newBuilder()
.apply {
  addAllStruct(this@toProto.struct)
  addAllAny(this@toProto.any)
}
.build()
