package com.github.mscheong01.wellknowntypes.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import kotlin.Unit

@KrotoDC(forProto = com.github.mscheong01.wellknowntypes.MessageWithEmpty::class)
public data class MessageWithEmpty(
  public val empty: Unit = Unit,
)
