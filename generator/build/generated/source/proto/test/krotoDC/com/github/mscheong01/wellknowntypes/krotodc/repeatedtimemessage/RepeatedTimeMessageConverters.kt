package com.github.mscheong01.wellknowntypes.krotodc.repeatedtimemessage

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.krotodc.toDuration
import com.github.mscheong01.krotodc.toLocalDateTime
import com.github.mscheong01.krotodc.toProtoDuration
import com.github.mscheong01.krotodc.toProtoTimestamp
import com.github.mscheong01.wellknowntypes.RepeatedTimeMessage

/**
 * Converts [RepeatedTimeMessage] to
 * [com.github.mscheong01.wellknowntypes.krotodc.RepeatedTimeMessage]
 */
@KrotoDCConverter(
  from = RepeatedTimeMessage::class,
  to = com.github.mscheong01.wellknowntypes.krotodc.RepeatedTimeMessage::class,
)
public fun RepeatedTimeMessage.toDataClass():
    com.github.mscheong01.wellknowntypes.krotodc.RepeatedTimeMessage =
    com.github.mscheong01.wellknowntypes.krotodc.RepeatedTimeMessage(timestamp = timestampList.map {
    it.toLocalDateTime() },
duration = durationList.map { it.toDuration() },
)

/**
 * Converts [com.github.mscheong01.wellknowntypes.krotodc.RepeatedTimeMessage] to
 * [RepeatedTimeMessage]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.wellknowntypes.krotodc.RepeatedTimeMessage::class,
  to = RepeatedTimeMessage::class,
)
public fun com.github.mscheong01.wellknowntypes.krotodc.RepeatedTimeMessage.toProto():
    RepeatedTimeMessage = RepeatedTimeMessage.newBuilder()
.apply {
  addAllTimestamp(this@toProto.timestamp.map { it.toProtoTimestamp() })
  addAllDuration(this@toProto.duration.map { it.toProtoDuration() })
}
.build()
