package com.github.mscheong01.rpc.krotodc.serverstreamingrequest

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.rpc.Rpc
import com.github.mscheong01.rpc.krotodc.ServerStreamingRequest

/**
 * Converts [Rpc.ServerStreamingRequest] to [ServerStreamingRequest]
 */
@KrotoDCConverter(
  from = Rpc.ServerStreamingRequest::class,
  to = ServerStreamingRequest::class,
)
public fun Rpc.ServerStreamingRequest.toDataClass(): ServerStreamingRequest =
    ServerStreamingRequest(name = name,
)

/**
 * Converts [ServerStreamingRequest] to [Rpc.ServerStreamingRequest]
 */
@KrotoDCConverter(
  from = ServerStreamingRequest::class,
  to = Rpc.ServerStreamingRequest::class,
)
public fun ServerStreamingRequest.toProto(): Rpc.ServerStreamingRequest =
    Rpc.ServerStreamingRequest.newBuilder()
.apply {
  setName(this@toProto.name)
}
.build()
