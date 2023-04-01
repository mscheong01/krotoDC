package com.github.mscheong01.wellknowntypes.krotodc.timemessage

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.krotodc.toDuration
import com.github.mscheong01.krotodc.toLocalDateTime
import com.github.mscheong01.krotodc.toProtoDuration
import com.github.mscheong01.krotodc.toProtoTimestamp
import com.github.mscheong01.wellknowntypes.TimeMessage

/**
 * Converts [TimeMessage] to [com.github.mscheong01.wellknowntypes.krotodc.TimeMessage]
 */
@KrotoDCConverter(
  from = TimeMessage::class,
  to = com.github.mscheong01.wellknowntypes.krotodc.TimeMessage::class,
)
public fun TimeMessage.toDataClass(): com.github.mscheong01.wellknowntypes.krotodc.TimeMessage =
    com.github.mscheong01.wellknowntypes.krotodc.TimeMessage(timestamp =
    timestamp.toLocalDateTime(),
duration = duration.toDuration(),
)

/**
 * Converts [com.github.mscheong01.wellknowntypes.krotodc.TimeMessage] to [TimeMessage]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.wellknowntypes.krotodc.TimeMessage::class,
  to = TimeMessage::class,
)
public fun com.github.mscheong01.wellknowntypes.krotodc.TimeMessage.toProto(): TimeMessage =
    TimeMessage.newBuilder()
.apply {
  setTimestamp(this@toProto.timestamp.toProtoTimestamp())
  setDuration(this@toProto.duration.toProtoDuration())
}
.build()
