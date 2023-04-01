package com.github.mscheong01.test.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import com.github.mscheong01.test.Job
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

@KrotoDC(forProto = com.github.mscheong01.test.MapMessage::class)
public data class MapMessage(
  public val mapStringString: Map<String, String> = mapOf(),
  public val mapStringPerson: Map<String, Person> = mapOf(),
  public val mapIntJob: Map<Int, Job> = mapOf(),
)
