package com.github.mscheong01.test.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import kotlin.Int
import kotlin.String

@KrotoDC(forProto = com.github.mscheong01.test.Person::class)
public data class Person(
  public val name: String = "",
  public val age: Int = 0,
)
