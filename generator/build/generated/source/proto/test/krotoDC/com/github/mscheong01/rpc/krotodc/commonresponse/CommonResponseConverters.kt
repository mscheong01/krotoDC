package com.github.mscheong01.rpc.krotodc.commonresponse

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.rpc.Rpc
import com.github.mscheong01.rpc.krotodc.CommonResponse

/**
 * Converts [Rpc.CommonResponse] to [CommonResponse]
 */
@KrotoDCConverter(
  from = Rpc.CommonResponse::class,
  to = CommonResponse::class,
)
public fun Rpc.CommonResponse.toDataClass(): CommonResponse = CommonResponse(message = message,
)

/**
 * Converts [CommonResponse] to [Rpc.CommonResponse]
 */
@KrotoDCConverter(
  from = CommonResponse::class,
  to = Rpc.CommonResponse::class,
)
public fun CommonResponse.toProto(): Rpc.CommonResponse = Rpc.CommonResponse.newBuilder()
.apply {
  setMessage(this@toProto.message)
}
.build()
