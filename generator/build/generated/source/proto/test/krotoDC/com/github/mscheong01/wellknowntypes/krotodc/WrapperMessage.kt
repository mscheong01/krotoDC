package com.github.mscheong01.wellknowntypes.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import com.google.protobuf.ByteString
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String

@KrotoDC(forProto = com.github.mscheong01.wellknowntypes.WrapperMessage::class)
public data class WrapperMessage(
  public val doubleValue: Double? = null,
  public val floatValue: Float? = null,
  public val int64Value: Long? = null,
  public val uint64Value: Long? = null,
  public val int32Value: Int? = null,
  public val uint32Value: Int? = null,
  public val boolValue: Boolean? = null,
  public val stringValue: String? = null,
  public val bytesValue: ByteString? = null,
)
