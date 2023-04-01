package com.github.mscheong01.wellknowntypes.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import com.google.protobuf.Any
import com.google.protobuf.Struct

@KrotoDC(forProto = com.github.mscheong01.wellknowntypes.StructAnyMessage::class)
public data class StructAnyMessage(
  public val struct: Struct = com.google.protobuf.Struct.getDefaultInstance(),
  public val any: Any = com.google.protobuf.Any.getDefaultInstance(),
)
