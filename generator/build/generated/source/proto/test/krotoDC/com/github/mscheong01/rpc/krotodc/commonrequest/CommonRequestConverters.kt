package com.github.mscheong01.rpc.krotodc.commonrequest

import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.rpc.Rpc
import com.github.mscheong01.rpc.krotodc.CommonRequest

/**
 * Converts [Rpc.CommonRequest] to [CommonRequest]
 */
@KrotoDCConverter(
  from = Rpc.CommonRequest::class,
  to = CommonRequest::class,
)
public fun Rpc.CommonRequest.toDataClass(): CommonRequest = CommonRequest(name = name,
)

/**
 * Converts [CommonRequest] to [Rpc.CommonRequest]
 */
@KrotoDCConverter(
  from = CommonRequest::class,
  to = Rpc.CommonRequest::class,
)
public fun CommonRequest.toProto(): Rpc.CommonRequest = Rpc.CommonRequest.newBuilder()
.apply {
  setName(this@toProto.name)
}
.build()
