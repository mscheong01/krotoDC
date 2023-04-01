package com.github.mscheong01.test.krotodc.deprecatedmessage

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.test.DeprecatedMessage
import com.github.mscheong01.test.krotodc.person.toDataClass
import com.github.mscheong01.test.krotodc.person.toProto

/**
 * Converts [DeprecatedMessage] to [com.github.mscheong01.test.krotodc.DeprecatedMessage]
 */
@KrotoDCConverter(
  from = DeprecatedMessage::class,
  to = com.github.mscheong01.test.krotodc.DeprecatedMessage::class,
)
public fun DeprecatedMessage.toDataClass(): com.github.mscheong01.test.krotodc.DeprecatedMessage =
    com.github.mscheong01.test.krotodc.DeprecatedMessage(oneofField = when (oneofFieldCase) {
  com.github.mscheong01.test.DeprecatedMessage.OneofFieldCase.ONEOF_STRING ->
      com.github.mscheong01.test.krotodc.DeprecatedMessage.OneofField.OneofString( oneofString =
      oneofString )
  com.github.mscheong01.test.DeprecatedMessage.OneofFieldCase.ONEOF_INT ->
      com.github.mscheong01.test.krotodc.DeprecatedMessage.OneofField.OneofInt( oneofInt = oneofInt
      )
  com.github.mscheong01.test.DeprecatedMessage.OneofFieldCase.ONEOF_PERSON ->
      com.github.mscheong01.test.krotodc.DeprecatedMessage.OneofField.OneofPerson( oneofPerson =
      oneofPerson.toDataClass() )
  com.github.mscheong01.test.DeprecatedMessage.OneofFieldCase.ONEOFFIELD_NOT_SET -> null
},
name = name,
)

/**
 * Converts [com.github.mscheong01.test.krotodc.DeprecatedMessage] to [DeprecatedMessage]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.test.krotodc.DeprecatedMessage::class,
  to = DeprecatedMessage::class,
)
public fun com.github.mscheong01.test.krotodc.DeprecatedMessage.toProto(): DeprecatedMessage =
    DeprecatedMessage.newBuilder()
.apply {
  when (oneofField) {
    is com.github.mscheong01.test.krotodc.DeprecatedMessage.OneofField.OneofString -> {
      setOneofString(oneofField.oneofString)
    }
    is com.github.mscheong01.test.krotodc.DeprecatedMessage.OneofField.OneofInt -> {
      setOneofInt(oneofField.oneofInt)
    }
    is com.github.mscheong01.test.krotodc.DeprecatedMessage.OneofField.OneofPerson -> {
      setOneofPerson(oneofField.oneofPerson.toProto())
    }
    null -> {}
  }
  setName(this@toProto.name)
}
.build()
