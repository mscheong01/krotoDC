package com.github.mscheong01.rpc.krotodc.unaryrequest

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.rpc.Rpc
import com.github.mscheong01.rpc.krotodc.UnaryRequest

/**
 * Converts [Rpc.UnaryRequest] to [UnaryRequest]
 */
@KrotoDCConverter(
  from = Rpc.UnaryRequest::class,
  to = UnaryRequest::class,
)
public fun Rpc.UnaryRequest.toDataClass(): UnaryRequest = UnaryRequest(name = name,
)

/**
 * Converts [UnaryRequest] to [Rpc.UnaryRequest]
 */
@KrotoDCConverter(
  from = UnaryRequest::class,
  to = Rpc.UnaryRequest::class,
)
public fun UnaryRequest.toProto(): Rpc.UnaryRequest = Rpc.UnaryRequest.newBuilder()
.apply {
  setName(this@toProto.name)
}
.build()
