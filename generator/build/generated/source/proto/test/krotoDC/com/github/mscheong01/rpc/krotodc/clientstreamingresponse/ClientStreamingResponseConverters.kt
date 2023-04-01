package com.github.mscheong01.rpc.krotodc.clientstreamingresponse

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.rpc.Rpc
import com.github.mscheong01.rpc.krotodc.ClientStreamingResponse

/**
 * Converts [Rpc.ClientStreamingResponse] to [ClientStreamingResponse]
 */
@KrotoDCConverter(
  from = Rpc.ClientStreamingResponse::class,
  to = ClientStreamingResponse::class,
)
public fun Rpc.ClientStreamingResponse.toDataClass(): ClientStreamingResponse =
    ClientStreamingResponse(message = message,
)

/**
 * Converts [ClientStreamingResponse] to [Rpc.ClientStreamingResponse]
 */
@KrotoDCConverter(
  from = ClientStreamingResponse::class,
  to = Rpc.ClientStreamingResponse::class,
)
public fun ClientStreamingResponse.toProto(): Rpc.ClientStreamingResponse =
    Rpc.ClientStreamingResponse.newBuilder()
.apply {
  setMessage(this@toProto.message)
}
.build()
