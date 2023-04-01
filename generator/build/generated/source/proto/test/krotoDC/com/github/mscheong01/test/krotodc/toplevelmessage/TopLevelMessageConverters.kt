package com.github.mscheong01.test.krotodc.toplevelmessage

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.test.TopLevelMessage
import com.github.mscheong01.test.krotodc.toplevelmessage.toDataClass
import com.github.mscheong01.test.krotodc.toplevelmessage.toProto

/**
 * Converts [TopLevelMessage] to [com.github.mscheong01.test.krotodc.TopLevelMessage]
 */
@KrotoDCConverter(
  from = TopLevelMessage::class,
  to = com.github.mscheong01.test.krotodc.TopLevelMessage::class,
)
public fun TopLevelMessage.toDataClass(): com.github.mscheong01.test.krotodc.TopLevelMessage =
    com.github.mscheong01.test.krotodc.TopLevelMessage(name = name,
nestedMessage = nestedMessage.toDataClass(),
nestedEnum = nestedEnum,
)

/**
 * Converts [com.github.mscheong01.test.krotodc.TopLevelMessage] to [TopLevelMessage]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.test.krotodc.TopLevelMessage::class,
  to = TopLevelMessage::class,
)
public fun com.github.mscheong01.test.krotodc.TopLevelMessage.toProto(): TopLevelMessage =
    TopLevelMessage.newBuilder()
.apply {
  setName(this@toProto.name)
  setNestedMessage(this@toProto.nestedMessage.toProto())
  setNestedEnum(this@toProto.nestedEnum)
}
.build()

/**
 * Converts [TopLevelMessage.NestedMessage] to
 * [com.github.mscheong01.test.krotodc.TopLevelMessage.NestedMessage]
 */
@KrotoDCConverter(
  from = TopLevelMessage.NestedMessage::class,
  to = com.github.mscheong01.test.krotodc.TopLevelMessage.NestedMessage::class,
)
public fun TopLevelMessage.NestedMessage.toDataClass():
    com.github.mscheong01.test.krotodc.TopLevelMessage.NestedMessage =
    com.github.mscheong01.test.krotodc.TopLevelMessage.NestedMessage(name = name,
)

/**
 * Converts [com.github.mscheong01.test.krotodc.TopLevelMessage.NestedMessage] to
 * [TopLevelMessage.NestedMessage]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.test.krotodc.TopLevelMessage.NestedMessage::class,
  to = TopLevelMessage.NestedMessage::class,
)
public fun com.github.mscheong01.test.krotodc.TopLevelMessage.NestedMessage.toProto():
    TopLevelMessage.NestedMessage = TopLevelMessage.NestedMessage.newBuilder()
.apply {
  setName(this@toProto.name)
}
.build()
