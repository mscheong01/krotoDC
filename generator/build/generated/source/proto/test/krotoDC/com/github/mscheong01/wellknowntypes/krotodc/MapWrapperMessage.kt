package com.github.mscheong01.wellknowntypes.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import com.google.protobuf.ByteString
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.Map

@KrotoDC(forProto = com.github.mscheong01.wellknowntypes.MapWrapperMessage::class)
public data class MapWrapperMessage(
  public val doubleValue: Map<String, Double> = mapOf(),
  public val floatValue: Map<String, Float> = mapOf(),
  public val int64Value: Map<String, Long> = mapOf(),
  public val uint64Value: Map<String, Long> = mapOf(),
  public val int32Value: Map<String, Int> = mapOf(),
  public val uint32Value: Map<String, Int> = mapOf(),
  public val boolValue: Map<String, Boolean> = mapOf(),
  public val stringValue: Map<String, String> = mapOf(),
  public val bytesValue: Map<String, ByteString> = mapOf(),
)
