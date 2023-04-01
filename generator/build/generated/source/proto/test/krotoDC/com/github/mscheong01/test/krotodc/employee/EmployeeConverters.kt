package com.github.mscheong01.test.krotodc.employee

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.test.Employee

/**
 * Converts [Employee] to [com.github.mscheong01.test.krotodc.Employee]
 */
@KrotoDCConverter(
  from = Employee::class,
  to = com.github.mscheong01.test.krotodc.Employee::class,
)
public fun Employee.toDataClass(): com.github.mscheong01.test.krotodc.Employee =
    com.github.mscheong01.test.krotodc.Employee(name = name,
age = age,
job = job,
)

/**
 * Converts [com.github.mscheong01.test.krotodc.Employee] to [Employee]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.test.krotodc.Employee::class,
  to = Employee::class,
)
public fun com.github.mscheong01.test.krotodc.Employee.toProto(): Employee = Employee.newBuilder()
.apply {
  setName(this@toProto.name)
  setAge(this@toProto.age)
  setJob(this@toProto.job)
}
.build()
