package com.github.mscheong01.rpc.krotodc.clientstreamingrequest

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.rpc.Rpc
import com.github.mscheong01.rpc.krotodc.ClientStreamingRequest

/**
 * Converts [Rpc.ClientStreamingRequest] to [ClientStreamingRequest]
 */
@KrotoDCConverter(
  from = Rpc.ClientStreamingRequest::class,
  to = ClientStreamingRequest::class,
)
public fun Rpc.ClientStreamingRequest.toDataClass(): ClientStreamingRequest =
    ClientStreamingRequest(name = name,
)

/**
 * Converts [ClientStreamingRequest] to [Rpc.ClientStreamingRequest]
 */
@KrotoDCConverter(
  from = ClientStreamingRequest::class,
  to = Rpc.ClientStreamingRequest::class,
)
public fun ClientStreamingRequest.toProto(): Rpc.ClientStreamingRequest =
    Rpc.ClientStreamingRequest.newBuilder()
.apply {
  setName(this@toProto.name)
}
.build()
