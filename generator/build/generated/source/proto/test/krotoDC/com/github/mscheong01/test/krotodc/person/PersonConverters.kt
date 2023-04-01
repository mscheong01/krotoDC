package com.github.mscheong01.test.krotodc.person

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.test.Person

/**
 * Converts [Person] to [com.github.mscheong01.test.krotodc.Person]
 */
@KrotoDCConverter(
  from = Person::class,
  to = com.github.mscheong01.test.krotodc.Person::class,
)
public fun Person.toDataClass(): com.github.mscheong01.test.krotodc.Person =
    com.github.mscheong01.test.krotodc.Person(name = name,
age = age,
)

/**
 * Converts [com.github.mscheong01.test.krotodc.Person] to [Person]
 */
@KrotoDCConverter(
  from = com.github.mscheong01.test.krotodc.Person::class,
  to = Person::class,
)
public fun com.github.mscheong01.test.krotodc.Person.toProto(): Person = Person.newBuilder()
.apply {
  setName(this@toProto.name)
  setAge(this@toProto.age)
}
.build()
