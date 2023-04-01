package com.github.mscheong01.test.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import kotlin.Int
import kotlin.String

@KrotoDC(forProto = com.github.mscheong01.test.OptionalMessage::class)
public data class OptionalMessage(
  public val optionalString: String? = null,
  public val optionalInt: Int? = null,
  public val optionalPerson: Person? = null,
)
