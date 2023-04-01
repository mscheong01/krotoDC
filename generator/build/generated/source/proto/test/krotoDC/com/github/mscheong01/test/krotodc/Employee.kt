package com.github.mscheong01.test.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import com.github.mscheong01.test.Job
import kotlin.Int
import kotlin.String

@KrotoDC(forProto = com.github.mscheong01.test.Employee::class)
public data class Employee(
  public val name: String = "",
  public val age: Int = 0,
  public val job: Job = com.github.mscheong01.test.Job.values()[0],
)
