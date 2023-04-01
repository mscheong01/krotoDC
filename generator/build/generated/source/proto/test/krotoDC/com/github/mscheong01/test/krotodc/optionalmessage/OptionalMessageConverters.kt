package com.github.mscheong01.test.krotodc.optionalmessage

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.test.OptionalMessage
import com.github.mscheong01.test.krotodc.person.toDataClass
import com.github.mscheong01.test.krotodc.person.toProto

/**
 * Converts [OptionalMessage] to [com.github.mscheong01.test.krotodc.OptionalMessage]
 */
@KrotoDCConverter(
  from = OptionalMessage::class,
  to = com.github.mscheong01.test.krotodc.OptionalMessage::class,
)
public fun OptionalMessage.toDataClass(): com.github.mscheong01.test.krotodc.OptionalMessage =
    com.github.mscheong01.test.krotodc.OptionalMessage(optionalString = if (hasOptionalString()) {
  optionalString} else {
  null}
,
optionalInt = if (hasOptionalInt()) {
  optionalInt} else {
  null}
,
optionalPerson = if (hasOptionalPerson()) {
  optionalPerson.toDataClass()} else {
  null}
,
)

/**
 * Converts [com.github.mscheong01.test.krotodc.OptionalMessage] to [OptionalMessage]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.test.krotodc.OptionalMessage::class,
  to = OptionalMessage::class,
)
public fun com.github.mscheong01.test.krotodc.OptionalMessage.toProto(): OptionalMessage =
    OptionalMessage.newBuilder()
.apply {
  if (this@toProto.optionalString != null) {
    setOptionalString(this@toProto.optionalString)
  }
  if (this@toProto.optionalInt != null) {
    setOptionalInt(this@toProto.optionalInt)
  }
  if (this@toProto.optionalPerson != null) {
    setOptionalPerson(this@toProto.optionalPerson.toProto())
  }
}
.build()
