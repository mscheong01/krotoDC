package com.github.mscheong01.test.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import kotlin.Deprecated
import kotlin.Int
import kotlin.String

@KrotoDC(forProto = com.github.mscheong01.test.DeprecatedMessage::class)
public data class DeprecatedMessage(
  public val oneofField: OneofField? = null,
  @Deprecated("The underlying message field is marked deprecated.")
  public val name: String = "",
) {
  public sealed interface OneofField {
    @Deprecated("The underlying field is marked deprecated.")
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
