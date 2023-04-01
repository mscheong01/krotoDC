package com.github.mscheong01.test.krotodc.oneofmessage

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.test.OneOfMessage
import com.github.mscheong01.test.krotodc.person.toDataClass
import com.github.mscheong01.test.krotodc.person.toProto

/**
 * Converts [OneOfMessage] to [com.github.mscheong01.test.krotodc.OneOfMessage]
 */
@KrotoDCConverter(
  from = OneOfMessage::class,
  to = com.github.mscheong01.test.krotodc.OneOfMessage::class,
)
public fun OneOfMessage.toDataClass(): com.github.mscheong01.test.krotodc.OneOfMessage =
    com.github.mscheong01.test.krotodc.OneOfMessage(oneofField = when (oneofFieldCase) {
  com.github.mscheong01.test.OneOfMessage.OneofFieldCase.ONEOF_STRING ->
      com.github.mscheong01.test.krotodc.OneOfMessage.OneofField.OneofString( oneofString =
      oneofString )
  com.github.mscheong01.test.OneOfMessage.OneofFieldCase.ONEOF_INT ->
      com.github.mscheong01.test.krotodc.OneOfMessage.OneofField.OneofInt( oneofInt = oneofInt )
  com.github.mscheong01.test.OneOfMessage.OneofFieldCase.ONEOF_PERSON ->
      com.github.mscheong01.test.krotodc.OneOfMessage.OneofField.OneofPerson( oneofPerson =
      oneofPerson.toDataClass() )
  com.github.mscheong01.test.OneOfMessage.OneofFieldCase.ONEOFFIELD_NOT_SET -> null
},
)

/**
 * Converts [com.github.mscheong01.test.krotodc.OneOfMessage] to [OneOfMessage]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.test.krotodc.OneOfMessage::class,
  to = OneOfMessage::class,
)
public fun com.github.mscheong01.test.krotodc.OneOfMessage.toProto(): OneOfMessage =
    OneOfMessage.newBuilder()
.apply {
  when (oneofField) {
    is com.github.mscheong01.test.krotodc.OneOfMessage.OneofField.OneofString -> {
      setOneofString(oneofField.oneofString)
    }
    is com.github.mscheong01.test.krotodc.OneOfMessage.OneofField.OneofInt -> {
      setOneofInt(oneofField.oneofInt)
    }
    is com.github.mscheong01.test.krotodc.OneOfMessage.OneofField.OneofPerson -> {
      setOneofPerson(oneofField.oneofPerson.toProto())
    }
    null -> {}
  }
}
.build()
