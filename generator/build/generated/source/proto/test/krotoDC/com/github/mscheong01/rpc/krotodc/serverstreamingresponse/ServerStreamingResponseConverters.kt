package com.github.mscheong01.rpc.krotodc.serverstreamingresponse

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.rpc.Rpc
import com.github.mscheong01.rpc.krotodc.ServerStreamingResponse

/**
 * Converts [Rpc.ServerStreamingResponse] to [ServerStreamingResponse]
 */
@KrotoDCConverter(
  from = Rpc.ServerStreamingResponse::class,
  to = ServerStreamingResponse::class,
)
public fun Rpc.ServerStreamingResponse.toDataClass(): ServerStreamingResponse =
    ServerStreamingResponse(message = message,
)

/**
 * Converts [ServerStreamingResponse] to [Rpc.ServerStreamingResponse]
 */
@KrotoDCConverter(
  from = ServerStreamingResponse::class,
  to = Rpc.ServerStreamingResponse::class,
)
public fun ServerStreamingResponse.toProto(): Rpc.ServerStreamingResponse =
    Rpc.ServerStreamingResponse.newBuilder()
.apply {
  setMessage(this@toProto.message)
}
.build()
