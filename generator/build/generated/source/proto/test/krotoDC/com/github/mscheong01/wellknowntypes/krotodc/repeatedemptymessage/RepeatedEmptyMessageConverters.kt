package com.github.mscheong01.wellknowntypes.krotodc.repeatedemptymessage

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.wellknowntypes.RepeatedEmptyMessage
import com.google.protobuf.Empty

/**
 * Converts [RepeatedEmptyMessage] to
 * [com.github.mscheong01.wellknowntypes.krotodc.RepeatedEmptyMessage]
 */
@KrotoDCConverter(
  from = RepeatedEmptyMessage::class,
  to = com.github.mscheong01.wellknowntypes.krotodc.RepeatedEmptyMessage::class,
)
public fun RepeatedEmptyMessage.toDataClass():
    com.github.mscheong01.wellknowntypes.krotodc.RepeatedEmptyMessage =
    com.github.mscheong01.wellknowntypes.krotodc.RepeatedEmptyMessage(empty = emptyList.map { Unit
    },
)

/**
 * Converts [com.github.mscheong01.wellknowntypes.krotodc.RepeatedEmptyMessage] to
 * [RepeatedEmptyMessage]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.wellknowntypes.krotodc.RepeatedEmptyMessage::class,
  to = RepeatedEmptyMessage::class,
)
public fun com.github.mscheong01.wellknowntypes.krotodc.RepeatedEmptyMessage.toProto():
    RepeatedEmptyMessage = RepeatedEmptyMessage.newBuilder()
.apply {
  addAllEmpty(this@toProto.empty.map { Empty.getDefaultInstance() })
}
.build()
