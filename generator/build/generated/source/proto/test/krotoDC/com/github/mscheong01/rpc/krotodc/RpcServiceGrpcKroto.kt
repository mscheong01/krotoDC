package com.github.mscheong01.rpc.krotodc

import com.github.mscheong01.rpc.RpcServiceGrpc
import com.github.mscheong01.rpc.RpcServiceGrpc.getServiceDescriptor
import com.github.mscheong01.rpc.krotodc.bidirectionalstreamingrequest.toDataClass
import com.github.mscheong01.rpc.krotodc.bidirectionalstreamingrequest.toProto
import com.github.mscheong01.rpc.krotodc.bidirectionalstreamingresponse.toDataClass
import com.github.mscheong01.rpc.krotodc.bidirectionalstreamingresponse.toProto
import com.github.mscheong01.rpc.krotodc.clientstreamingrequest.toDataClass
import com.github.mscheong01.rpc.krotodc.clientstreamingrequest.toProto
import com.github.mscheong01.rpc.krotodc.clientstreamingresponse.toDataClass
import com.github.mscheong01.rpc.krotodc.clientstreamingresponse.toProto
import com.github.mscheong01.rpc.krotodc.serverstreamingrequest.toDataClass
import com.github.mscheong01.rpc.krotodc.serverstreamingrequest.toProto
import com.github.mscheong01.rpc.krotodc.serverstreamingresponse.toDataClass
import com.github.mscheong01.rpc.krotodc.serverstreamingresponse.toProto
import com.github.mscheong01.rpc.krotodc.unaryrequest.toDataClass
import com.github.mscheong01.rpc.krotodc.unaryrequest.toProto
import com.github.mscheong01.rpc.krotodc.unaryresponse.toDataClass
import com.github.mscheong01.rpc.krotodc.unaryresponse.toProto
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

public object RpcServiceGrpcKroto {
  public abstract class RpcServiceCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    public open suspend fun unaryTest(request: UnaryRequest): UnaryResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.rpc.RpcService.UnaryTest is unimplemented"))

    public open fun serverStreamingTest(request: ServerStreamingRequest):
        Flow<ServerStreamingResponse> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.rpc.RpcService.ServerStreamingTest is unimplemented"))

    public open suspend fun clientStreamingTest(requests: Flow<ClientStreamingRequest>):
        ClientStreamingResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.rpc.RpcService.ClientStreamingTest is unimplemented"))

    public open fun bidirectionalStreamingTest(requests: Flow<BidirectionalStreamingRequest>):
        Flow<BidirectionalStreamingResponse> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.rpc.RpcService.BidirectionalStreamingTest is unimplemented"))

    public final override fun bindService(): ServerServiceDefinition =
        builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
        context = this.context,
        descriptor = RpcServiceGrpc.getUnaryTestMethod(),
        implementation = { request ->
        unaryTest(request.toDataClass()).let { it.toProto() }
    },
    ))
      .addMethod(serverStreamingServerMethodDefinition(
        context = this.context,
        descriptor = RpcServiceGrpc.getServerStreamingTestMethod(),
        implementation = { request ->
        serverStreamingTest(request.toDataClass()).map { it.toProto() }
    },
    ))
      .addMethod(clientStreamingServerMethodDefinition(
        context = this.context,
        descriptor = RpcServiceGrpc.getClientStreamingTestMethod(),
        implementation = { requests ->
        clientStreamingTest(requests.map { it.toDataClass() }).let { it.toProto() }
    },
    ))
      .addMethod(bidiStreamingServerMethodDefinition(
        context = this.context,
        descriptor = RpcServiceGrpc.getBidirectionalStreamingTestMethod(),
        implementation = { requests ->
        bidirectionalStreamingTest(requests.map { it.toDataClass() }).map { it.toProto() }
    },
    )).build()
  }

  public class RpcServiceCoroutineStub(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<RpcServiceCoroutineStub>(channel, callOptions) {
    public suspend fun unaryTest(request: UnaryRequest, metadata: Metadata = Metadata()):
        UnaryResponse {
      return unaryRpc(
              channel,
              RpcServiceGrpc.getUnaryTestMethod(),
              request.toProto(),
              callOptions,
              metadata,
          ).let { it.toDataClass() }
    }

    public fun serverStreamingTest(request: ServerStreamingRequest, metadata: Metadata =
        Metadata()): Flow<ServerStreamingResponse> {
      return serverStreamingRpc(
              channel,
              RpcServiceGrpc.getServerStreamingTestMethod(),
              request.toProto(),
              callOptions,
              metadata,
          ).map { it.toDataClass() }
    }

    public suspend fun clientStreamingTest(requests: Flow<ClientStreamingRequest>,
        metadata: Metadata = Metadata()): ClientStreamingResponse {
      return clientStreamingRpc(
              channel,
              RpcServiceGrpc.getClientStreamingTestMethod(),
              requests.map { it.toProto() },
              callOptions,
              metadata,
          ).let { it.toDataClass() }
    }

    public fun bidirectionalStreamingTest(requests: Flow<BidirectionalStreamingRequest>,
        metadata: Metadata = Metadata()): Flow<BidirectionalStreamingResponse> {
      return bidiStreamingRpc(
              channel,
              RpcServiceGrpc.getBidirectionalStreamingTestMethod(),
              requests.map { it.toProto() },
              callOptions,
              metadata,
          ).map { it.toDataClass() }
    }

    public override fun build(channel: Channel, callOptions: CallOptions): RpcServiceCoroutineStub =
        RpcServiceCoroutineStub(channel, callOptions)
  }
}
