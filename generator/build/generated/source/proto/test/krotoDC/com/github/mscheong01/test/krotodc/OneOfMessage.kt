package com.github.mscheong01.test.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import kotlin.Int
import kotlin.String

@KrotoDC(forProto = com.github.mscheong01.test.OneOfMessage::class)
public data class OneOfMessage(
  public val oneofField: OneofField? = null,
) {
  public sealed interface OneofField {
    public data class OneofString(
      public val oneofString: String = "",
    ) : OneofField

    public data class OneofInt(
      public val oneofInt: Int = 0,
    ) : OneofField

    public data class OneofPerson(
      public val oneofPerson: Person = com.github.mscheong01.test.krotodc.Person(),
    ) : OneofField
  }
}
