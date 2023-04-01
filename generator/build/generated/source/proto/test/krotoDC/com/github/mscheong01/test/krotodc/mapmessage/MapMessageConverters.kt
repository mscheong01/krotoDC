package com.github.mscheong01.test.krotodc.mapmessage

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.test.MapMessage
import com.github.mscheong01.test.krotodc.person.toDataClass
import com.github.mscheong01.test.krotodc.person.toProto

/**
 * Converts [MapMessage] to [com.github.mscheong01.test.krotodc.MapMessage]
 */
@KrotoDCConverter(
  from = MapMessage::class,
  to = com.github.mscheong01.test.krotodc.MapMessage::class,
)
public fun MapMessage.toDataClass(): com.github.mscheong01.test.krotodc.MapMessage =
    com.github.mscheong01.test.krotodc.MapMessage(mapStringString = mapStringStringMap,
mapStringPerson = mapStringPersonMap.mapValues { it.value.toDataClass() },
mapIntJob = mapIntJobMap,
)

/**
 * Converts [com.github.mscheong01.test.krotodc.MapMessage] to [MapMessage]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.test.krotodc.MapMessage::class,
  to = MapMessage::class,
)
public fun com.github.mscheong01.test.krotodc.MapMessage.toProto(): MapMessage =
    MapMessage.newBuilder()
.apply {
  putAllMapStringString(this@toProto.mapStringString)
  putAllMapStringPerson(this@toProto.mapStringPerson.mapValues { it.value.toProto() })
  putAllMapIntJob(this@toProto.mapIntJob)
}
.build()
