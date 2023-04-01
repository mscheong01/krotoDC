package com.github.mscheong01.rpc.krotodc.bidirectionalstreamingresponse

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.rpc.Rpc
import com.github.mscheong01.rpc.krotodc.BidirectionalStreamingResponse

/**
 * Converts [Rpc.BidirectionalStreamingResponse] to [BidirectionalStreamingResponse]
 */
@KrotoDCConverter(
  from = Rpc.BidirectionalStreamingResponse::class,
  to = BidirectionalStreamingResponse::class,
)
public fun Rpc.BidirectionalStreamingResponse.toDataClass(): BidirectionalStreamingResponse =
    BidirectionalStreamingResponse(message = message,
)

/**
 * Converts [BidirectionalStreamingResponse] to [Rpc.BidirectionalStreamingResponse]
 */
@KrotoDCConverter(
  from = BidirectionalStreamingResponse::class,
  to = Rpc.BidirectionalStreamingResponse::class,
)
public fun BidirectionalStreamingResponse.toProto(): Rpc.BidirectionalStreamingResponse =
    Rpc.BidirectionalStreamingResponse.newBuilder()
.apply {
  setMessage(this@toProto.message)
}
.build()
