package com.github.mscheong01.wellknowntypes.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import com.google.protobuf.Any
import com.google.protobuf.Struct
import kotlin.String
import kotlin.collections.Map

@KrotoDC(forProto = com.github.mscheong01.wellknowntypes.MapStructAnyMessage::class)
public data class MapStructAnyMessage(
  public val struct: Map<String, Struct> = mapOf(),
  public val any: Map<String, Any> = mapOf(),
)
