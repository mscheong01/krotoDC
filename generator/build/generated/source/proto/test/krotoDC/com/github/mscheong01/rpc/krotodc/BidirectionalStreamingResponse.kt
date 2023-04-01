package com.github.mscheong01.rpc.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import kotlin.String

@KrotoDC(forProto = com.github.mscheong01.rpc.Rpc.BidirectionalStreamingResponse::class)
public data class BidirectionalStreamingResponse(
  public val message: String = "",
)
