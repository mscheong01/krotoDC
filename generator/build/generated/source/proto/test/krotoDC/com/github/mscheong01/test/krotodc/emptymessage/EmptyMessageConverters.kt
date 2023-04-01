package com.github.mscheong01.test.krotodc.emptymessage

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.test.EmptyMessage

/**
 * Converts [EmptyMessage] to [com.github.mscheong01.test.krotodc.EmptyMessage]
 */
@KrotoDCConverter(
  from = EmptyMessage::class,
  to = com.github.mscheong01.test.krotodc.EmptyMessage::class,
)
public fun EmptyMessage.toDataClass(): com.github.mscheong01.test.krotodc.EmptyMessage =
    com.github.mscheong01.test.krotodc.EmptyMessage()

/**
 * Converts [com.github.mscheong01.test.krotodc.EmptyMessage] to [EmptyMessage]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.test.krotodc.EmptyMessage::class,
  to = EmptyMessage::class,
)
public fun com.github.mscheong01.test.krotodc.EmptyMessage.toProto(): EmptyMessage =
    EmptyMessage.newBuilder()
.apply {
}
.build()
