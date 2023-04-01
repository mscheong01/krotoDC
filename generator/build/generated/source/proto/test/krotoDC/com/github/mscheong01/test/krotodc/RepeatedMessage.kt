package com.github.mscheong01.test.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import com.github.mscheong01.test.Job
import kotlin.String
import kotlin.collections.List

@KrotoDC(forProto = com.github.mscheong01.test.RepeatedMessage::class)
public data class RepeatedMessage(
  public val repeatedString: List<String> = listOf(),
  public val repeatedPerson: List<Person> = listOf(),
  public val repeatedJob: List<Job> = listOf(),
)
