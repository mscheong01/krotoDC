package com.github.mscheong01.rpc.krotodc

import com.github.mscheong01.rpc.CommonMessageUseServiceGrpc
import com.github.mscheong01.rpc.CommonMessageUseServiceGrpc.getServiceDescriptor
import com.github.mscheong01.rpc.krotodc.commonrequest.toDataClass
import com.github.mscheong01.rpc.krotodc.commonrequest.toProto
import com.github.mscheong01.rpc.krotodc.commonresponse.toDataClass
import com.github.mscheong01.rpc.krotodc.commonresponse.toProto
import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.Status
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls.bidiStreamingRpc
import io.grpc.kotlin.ClientCalls.clientStreamingRpc
import io.grpc.kotlin.ClientCalls.serverStreamingRpc
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls.bidiStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.clientStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.serverStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

public object CommonMessageUseServiceGrpcKroto {
  public abstract class CommonMessageUseServiceCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    public open suspend fun unaryRPC(request: CommonRequest): CommonResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.rpc.CommonMessageUseService.UnaryRPC is unimplemented"))

    public open fun serverStreamingRPC(request: CommonRequest): Flow<CommonResponse> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.rpc.CommonMessageUseService.ServerStreamingRPC is unimplemented"))

    public open suspend fun clientStreamingRPC(requests: Flow<CommonRequest>): CommonResponse =
        throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.rpc.CommonMessageUseService.ClientStreamingRPC is unimplemented"))

    public open fun bidirectionalStreamingRPC(requests: Flow<CommonRequest>): Flow<CommonResponse> =
        throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.rpc.CommonMessageUseService.BidirectionalStreamingRPC is unimplemented"))

    public final override fun bindService(): ServerServiceDefinition =
        builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
        context = this.context,
        descriptor = CommonMessageUseServiceGrpc.getUnaryRPCMethod(),
        implementation = { request ->
        unaryRPC(request.toDataClass()).let { it.toProto() }
    },
    ))
      .addMethod(serverStreamingServerMethodDefinition(
        context = this.context,
        descriptor = CommonMessageUseServiceGrpc.getServerStreamingRPCMethod(),
        implementation = { request ->
        serverStreamingRPC(request.toDataClass()).map { it.toProto() }
    },
    ))
      .addMethod(clientStreamingServerMethodDefinition(
        context = this.context,
        descriptor = CommonMessageUseServiceGrpc.getClientStreamingRPCMethod(),
        implementation = { requests ->
        clientStreamingRPC(requests.map { it.toDataClass() }).let { it.toProto() }
    },
    ))
      .addMethod(bidiStreamingServerMethodDefinition(
        context = this.context,
        descriptor = CommonMessageUseServiceGrpc.getBidirectionalStreamingRPCMethod(),
        implementation = { requests ->
        bidirectionalStreamingRPC(requests.map { it.toDataClass() }).map { it.toProto() }
    },
    )).build()
  }

  public class CommonMessageUseServiceCoroutineStub(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<CommonMessageUseServiceCoroutineStub>(channel, callOptions) {
    public suspend fun unaryRPC(request: CommonRequest, metadata: Metadata = Metadata()):
        CommonResponse {
      return unaryRpc(
              channel,
              CommonMessageUseServiceGrpc.getUnaryRPCMethod(),
              request.toProto(),
              callOptions,
              metadata,
          ).let { it.toDataClass() }
    }

    public fun serverStreamingRPC(request: CommonRequest, metadata: Metadata = Metadata()):
        Flow<CommonResponse> {
      return serverStreamingRpc(
              channel,
              CommonMessageUseServiceGrpc.getServerStreamingRPCMethod(),
              request.toProto(),
              callOptions,
              metadata,
          ).map { it.toDataClass() }
    }

    public suspend fun clientStreamingRPC(requests: Flow<CommonRequest>, metadata: Metadata =
        Metadata()): CommonResponse {
      return clientStreamingRpc(
              channel,
              CommonMessageUseServiceGrpc.getClientStreamingRPCMethod(),
              requests.map { it.toProto() },
              callOptions,
              metadata,
          ).let { it.toDataClass() }
    }

    public fun bidirectionalStreamingRPC(requests: Flow<CommonRequest>, metadata: Metadata =
        Metadata()): Flow<CommonResponse> {
      return bidiStreamingRpc(
              channel,
              CommonMessageUseServiceGrpc.getBidirectionalStreamingRPCMethod(),
              requests.map { it.toProto() },
              callOptions,
              metadata,
          ).map { it.toDataClass() }
    }

    public override fun build(channel: Channel, callOptions: CallOptions):
        CommonMessageUseServiceCoroutineStub = CommonMessageUseServiceCoroutineStub(channel,
        callOptions)
  }
}
