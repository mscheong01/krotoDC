package com.github.mscheong01.test.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import com.google.protobuf.ByteString
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String

@KrotoDC(forProto = com.github.mscheong01.test.PrimitiveMessage::class)
public data class PrimitiveMessage(
  public val int32Field: Int = 0,
  public val int64Field: Long = 0L,
  public val uint32Field: Int = 0,
  public val uint64Field: Long = 0L,
  public val sint32Field: Int = 0,
  public val sint64Field: Long = 0L,
  public val fixed32Field: Int = 0,
  public val fixed64Field: Long = 0L,
  public val sfixed32Field: Int = 0,
  public val sfixed64Field: Long = 0L,
  public val floatField: Float = 0.0f,
  public val doubleField: Double = 0.0,
  public val boolField: Boolean = false,
  public val stringField: String = "",
  public val bytesField: ByteString = com.google.protobuf.ByteString.EMPTY,
)
