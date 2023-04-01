package com.github.mscheong01.rpc.krotodc.bidirectionalstreamingrequest

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.rpc.Rpc
import com.github.mscheong01.rpc.krotodc.BidirectionalStreamingRequest

/**
 * Converts [Rpc.BidirectionalStreamingRequest] to [BidirectionalStreamingRequest]
 */
@KrotoDCConverter(
  from = Rpc.BidirectionalStreamingRequest::class,
  to = BidirectionalStreamingRequest::class,
)
public fun Rpc.BidirectionalStreamingRequest.toDataClass(): BidirectionalStreamingRequest =
    BidirectionalStreamingRequest(name = name,
)

/**
 * Converts [BidirectionalStreamingRequest] to [Rpc.BidirectionalStreamingRequest]
 */
@KrotoDCConverter(
  from = BidirectionalStreamingRequest::class,
  to = Rpc.BidirectionalStreamingRequest::class,
)
public fun BidirectionalStreamingRequest.toProto(): Rpc.BidirectionalStreamingRequest =
    Rpc.BidirectionalStreamingRequest.newBuilder()
.apply {
  setName(this@toProto.name)
}
.build()
