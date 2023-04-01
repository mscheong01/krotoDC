package com.github.mscheong01.wellknowntypes.krotodc.messagewithempty

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.wellknowntypes.MessageWithEmpty
import com.google.protobuf.Empty

/**
 * Converts [MessageWithEmpty] to [com.github.mscheong01.wellknowntypes.krotodc.MessageWithEmpty]
 */
@KrotoDCConverter(
  from = MessageWithEmpty::class,
  to = com.github.mscheong01.wellknowntypes.krotodc.MessageWithEmpty::class,
)
public fun MessageWithEmpty.toDataClass():
    com.github.mscheong01.wellknowntypes.krotodc.MessageWithEmpty =
    com.github.mscheong01.wellknowntypes.krotodc.MessageWithEmpty(empty = Unit,
)

/**
 * Converts [com.github.mscheong01.wellknowntypes.krotodc.MessageWithEmpty] to [MessageWithEmpty]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.wellknowntypes.krotodc.MessageWithEmpty::class,
  to = MessageWithEmpty::class,
)
public fun com.github.mscheong01.wellknowntypes.krotodc.MessageWithEmpty.toProto(): MessageWithEmpty
    = MessageWithEmpty.newBuilder()
.apply {
  setEmpty(Empty.getDefaultInstance())
}
.build()
