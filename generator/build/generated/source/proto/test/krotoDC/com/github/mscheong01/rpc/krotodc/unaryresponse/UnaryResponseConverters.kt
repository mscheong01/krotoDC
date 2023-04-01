package com.github.mscheong01.rpc.krotodc.unaryresponse

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.rpc.Rpc
import com.github.mscheong01.rpc.krotodc.UnaryResponse

/**
 * Converts [Rpc.UnaryResponse] to [UnaryResponse]
 */
@KrotoDCConverter(
  from = Rpc.UnaryResponse::class,
  to = UnaryResponse::class,
)
public fun Rpc.UnaryResponse.toDataClass(): UnaryResponse = UnaryResponse(message = message,
)

/**
 * Converts [UnaryResponse] to [Rpc.UnaryResponse]
 */
@KrotoDCConverter(
  from = UnaryResponse::class,
  to = Rpc.UnaryResponse::class,
)
public fun UnaryResponse.toProto(): Rpc.UnaryResponse = Rpc.UnaryResponse.newBuilder()
.apply {
  setMessage(this@toProto.message)
}
.build()
