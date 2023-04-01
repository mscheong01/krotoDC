package com.github.mscheong01.test.krotodc.repeatedmessage

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.test.RepeatedMessage
import com.github.mscheong01.test.krotodc.person.toDataClass
import com.github.mscheong01.test.krotodc.person.toProto

/**
 * Converts [RepeatedMessage] to [com.github.mscheong01.test.krotodc.RepeatedMessage]
 */
@KrotoDCConverter(
  from = RepeatedMessage::class,
  to = com.github.mscheong01.test.krotodc.RepeatedMessage::class,
)
public fun RepeatedMessage.toDataClass(): com.github.mscheong01.test.krotodc.RepeatedMessage =
    com.github.mscheong01.test.krotodc.RepeatedMessage(repeatedString = repeatedStringList,
repeatedPerson = repeatedPersonList.map { it.toDataClass() },
repeatedJob = repeatedJobList,
)

/**
 * Converts [com.github.mscheong01.test.krotodc.RepeatedMessage] to [RepeatedMessage]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.test.krotodc.RepeatedMessage::class,
  to = RepeatedMessage::class,
)
public fun com.github.mscheong01.test.krotodc.RepeatedMessage.toProto(): RepeatedMessage =
    RepeatedMessage.newBuilder()
.apply {
  addAllRepeatedString(this@toProto.repeatedString)
  addAllRepeatedPerson(this@toProto.repeatedPerson.map { it.toProto() })
  addAllRepeatedJob(this@toProto.repeatedJob)
}
.build()
