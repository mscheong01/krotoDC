package com.github.mscheong01.wellknowntypes.krotodc.mapemptymessage

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.wellknowntypes.MapEmptyMessage
import com.google.protobuf.Empty

/**
 * Converts [MapEmptyMessage] to [com.github.mscheong01.wellknowntypes.krotodc.MapEmptyMessage]
 */
@KrotoDCConverter(
  from = MapEmptyMessage::class,
  to = com.github.mscheong01.wellknowntypes.krotodc.MapEmptyMessage::class,
)
public fun MapEmptyMessage.toDataClass():
    com.github.mscheong01.wellknowntypes.krotodc.MapEmptyMessage =
    com.github.mscheong01.wellknowntypes.krotodc.MapEmptyMessage(empty = emptyMap.mapValues { Unit
    },
)

/**
 * Converts [com.github.mscheong01.wellknowntypes.krotodc.MapEmptyMessage] to [MapEmptyMessage]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.wellknowntypes.krotodc.MapEmptyMessage::class,
  to = MapEmptyMessage::class,
)
public fun com.github.mscheong01.wellknowntypes.krotodc.MapEmptyMessage.toProto(): MapEmptyMessage =
    MapEmptyMessage.newBuilder()
.apply {
  putAllEmpty(this@toProto.empty.mapValues { Empty.getDefaultInstance() })
}
.build()
