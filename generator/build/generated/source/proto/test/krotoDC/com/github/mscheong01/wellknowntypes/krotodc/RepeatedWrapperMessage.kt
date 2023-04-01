package com.github.mscheong01.wellknowntypes.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import com.google.protobuf.ByteString
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

@KrotoDC(forProto = com.github.mscheong01.wellknowntypes.RepeatedWrapperMessage::class)
public data class RepeatedWrapperMessage(
  public val doubleValue: List<Double> = listOf(),
  public val floatValue: List<Float> = listOf(),
  public val int64Value: List<Long> = listOf(),
  public val uint64Value: List<Long> = listOf(),
  public val int32Value: List<Int> = listOf(),
  public val uint32Value: List<Int> = listOf(),
  public val boolValue: List<Boolean> = listOf(),
  public val stringValue: List<String> = listOf(),
  public val bytesValue: List<ByteString> = listOf(),
)
