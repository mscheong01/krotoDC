package com.github.mscheong01.wellknowntypes.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

@KrotoDC(forProto = com.github.mscheong01.wellknowntypes.MapEmptyMessage::class)
public data class MapEmptyMessage(
  public val empty: Map<String, Unit> = mapOf(),
)
