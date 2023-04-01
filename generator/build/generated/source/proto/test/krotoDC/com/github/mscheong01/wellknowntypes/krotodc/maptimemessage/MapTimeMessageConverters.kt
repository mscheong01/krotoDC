package com.github.mscheong01.wellknowntypes.krotodc.maptimemessage

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.krotodc.toDuration
import com.github.mscheong01.krotodc.toLocalDateTime
import com.github.mscheong01.krotodc.toProtoDuration
import com.github.mscheong01.krotodc.toProtoTimestamp
import com.github.mscheong01.wellknowntypes.MapTimeMessage

/**
 * Converts [MapTimeMessage] to [com.github.mscheong01.wellknowntypes.krotodc.MapTimeMessage]
 */
@KrotoDCConverter(
  from = MapTimeMessage::class,
  to = com.github.mscheong01.wellknowntypes.krotodc.MapTimeMessage::class,
)
public fun MapTimeMessage.toDataClass(): com.github.mscheong01.wellknowntypes.krotodc.MapTimeMessage
    = com.github.mscheong01.wellknowntypes.krotodc.MapTimeMessage(timestamp = timestampMap.mapValues
    { it.value.toLocalDateTime() },
duration = durationMap.mapValues { it.value.toDuration() },
)

/**
 * Converts [com.github.mscheong01.wellknowntypes.krotodc.MapTimeMessage] to [MapTimeMessage]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.wellknowntypes.krotodc.MapTimeMessage::class,
  to = MapTimeMessage::class,
)
public fun com.github.mscheong01.wellknowntypes.krotodc.MapTimeMessage.toProto(): MapTimeMessage =
    MapTimeMessage.newBuilder()
.apply {
  putAllTimestamp(this@toProto.timestamp.mapValues { it.value.toProtoTimestamp() })
  putAllDuration(this@toProto.duration.mapValues { it.value.toProtoDuration() })
}
.build()
