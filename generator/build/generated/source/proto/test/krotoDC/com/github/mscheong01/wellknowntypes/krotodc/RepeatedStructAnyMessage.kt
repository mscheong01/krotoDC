package com.github.mscheong01.wellknowntypes.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import com.google.protobuf.Any
import com.google.protobuf.Struct
import kotlin.collections.List

@KrotoDC(forProto = com.github.mscheong01.wellknowntypes.RepeatedStructAnyMessage::class)
public data class RepeatedStructAnyMessage(
  public val struct: List<Struct> = listOf(),
  public val any: List<Any> = listOf(),
)
