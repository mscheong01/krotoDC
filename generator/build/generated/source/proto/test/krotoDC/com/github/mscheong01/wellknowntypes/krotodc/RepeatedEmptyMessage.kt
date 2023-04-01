package com.github.mscheong01.wellknowntypes.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import kotlin.Unit
import kotlin.collections.List

@KrotoDC(forProto = com.github.mscheong01.wellknowntypes.RepeatedEmptyMessage::class)
public data class RepeatedEmptyMessage(
  public val empty: List<Unit> = listOf(),
)
