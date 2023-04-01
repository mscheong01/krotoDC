package com.github.mscheong01.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.0)",
    comments = "Source: rpc.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CommonMessageUseServiceGrpc {

  private CommonMessageUseServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.rpc.CommonMessageUseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.CommonRequest,
      com.github.mscheong01.rpc.Rpc.CommonResponse> getUnaryRPCMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnaryRPC",
      requestType = com.github.mscheong01.rpc.Rpc.CommonRequest.class,
      responseType = com.github.mscheong01.rpc.Rpc.CommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.CommonRequest,
      com.github.mscheong01.rpc.Rpc.CommonResponse> getUnaryRPCMethod() {
    io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.CommonRequest, com.github.mscheong01.rpc.Rpc.CommonResponse> getUnaryRPCMethod;
    if ((getUnaryRPCMethod = CommonMessageUseServiceGrpc.getUnaryRPCMethod) == null) {
      synchronized (CommonMessageUseServiceGrpc.class) {
        if ((getUnaryRPCMethod = CommonMessageUseServiceGrpc.getUnaryRPCMethod) == null) {
          CommonMessageUseServiceGrpc.getUnaryRPCMethod = getUnaryRPCMethod =
              io.grpc.MethodDescriptor.<com.github.mscheong01.rpc.Rpc.CommonRequest, com.github.mscheong01.rpc.Rpc.CommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UnaryRPC"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.mscheong01.rpc.Rpc.CommonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.mscheong01.rpc.Rpc.CommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommonMessageUseServiceMethodDescriptorSupplier("UnaryRPC"))
              .build();
        }
      }
    }
    return getUnaryRPCMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.CommonRequest,
      com.github.mscheong01.rpc.Rpc.CommonResponse> getServerStreamingRPCMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ServerStreamingRPC",
      requestType = com.github.mscheong01.rpc.Rpc.CommonRequest.class,
      responseType = com.github.mscheong01.rpc.Rpc.CommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.CommonRequest,
      com.github.mscheong01.rpc.Rpc.CommonResponse> getServerStreamingRPCMethod() {
    io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.CommonRequest, com.github.mscheong01.rpc.Rpc.CommonResponse> getServerStreamingRPCMethod;
    if ((getServerStreamingRPCMethod = CommonMessageUseServiceGrpc.getServerStreamingRPCMethod) == null) {
      synchronized (CommonMessageUseServiceGrpc.class) {
        if ((getServerStreamingRPCMethod = CommonMessageUseServiceGrpc.getServerStreamingRPCMethod) == null) {
          CommonMessageUseServiceGrpc.getServerStreamingRPCMethod = getServerStreamingRPCMethod =
              io.grpc.MethodDescriptor.<com.github.mscheong01.rpc.Rpc.CommonRequest, com.github.mscheong01.rpc.Rpc.CommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ServerStreamingRPC"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.mscheong01.rpc.Rpc.CommonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.mscheong01.rpc.Rpc.CommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommonMessageUseServiceMethodDescriptorSupplier("ServerStreamingRPC"))
              .build();
        }
      }
    }
    return getServerStreamingRPCMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.CommonRequest,
      com.github.mscheong01.rpc.Rpc.CommonResponse> getClientStreamingRPCMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ClientStreamingRPC",
      requestType = com.github.mscheong01.rpc.Rpc.CommonRequest.class,
      responseType = com.github.mscheong01.rpc.Rpc.CommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.CommonRequest,
      com.github.mscheong01.rpc.Rpc.CommonResponse> getClientStreamingRPCMethod() {
    io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.CommonRequest, com.github.mscheong01.rpc.Rpc.CommonResponse> getClientStreamingRPCMethod;
    if ((getClientStreamingRPCMethod = CommonMessageUseServiceGrpc.getClientStreamingRPCMethod) == null) {
      synchronized (CommonMessageUseServiceGrpc.class) {
        if ((getClientStreamingRPCMethod = CommonMessageUseServiceGrpc.getClientStreamingRPCMethod) == null) {
          CommonMessageUseServiceGrpc.getClientStreamingRPCMethod = getClientStreamingRPCMethod =
              io.grpc.MethodDescriptor.<com.github.mscheong01.rpc.Rpc.CommonRequest, com.github.mscheong01.rpc.Rpc.CommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ClientStreamingRPC"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.mscheong01.rpc.Rpc.CommonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.mscheong01.rpc.Rpc.CommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommonMessageUseServiceMethodDescriptorSupplier("ClientStreamingRPC"))
              .build();
        }
      }
    }
    return getClientStreamingRPCMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.CommonRequest,
      com.github.mscheong01.rpc.Rpc.CommonResponse> getBidirectionalStreamingRPCMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BidirectionalStreamingRPC",
      requestType = com.github.mscheong01.rpc.Rpc.CommonRequest.class,
      responseType = com.github.mscheong01.rpc.Rpc.CommonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.CommonRequest,
      com.github.mscheong01.rpc.Rpc.CommonResponse> getBidirectionalStreamingRPCMethod() {
    io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.CommonRequest, com.github.mscheong01.rpc.Rpc.CommonResponse> getBidirectionalStreamingRPCMethod;
    if ((getBidirectionalStreamingRPCMethod = CommonMessageUseServiceGrpc.getBidirectionalStreamingRPCMethod) == null) {
      synchronized (CommonMessageUseServiceGrpc.class) {
        if ((getBidirectionalStreamingRPCMethod = CommonMessageUseServiceGrpc.getBidirectionalStreamingRPCMethod) == null) {
          CommonMessageUseServiceGrpc.getBidirectionalStreamingRPCMethod = getBidirectionalStreamingRPCMethod =
              io.grpc.MethodDescriptor.<com.github.mscheong01.rpc.Rpc.CommonRequest, com.github.mscheong01.rpc.Rpc.CommonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BidirectionalStreamingRPC"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.mscheong01.rpc.Rpc.CommonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.mscheong01.rpc.Rpc.CommonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommonMessageUseServiceMethodDescriptorSupplier("BidirectionalStreamingRPC"))
              .build();
        }
      }
    }
    return getBidirectionalStreamingRPCMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommonMessageUseServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommonMessageUseServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommonMessageUseServiceStub>() {
        @java.lang.Override
        public CommonMessageUseServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommonMessageUseServiceStub(channel, callOptions);
        }
      };
    return CommonMessageUseServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommonMessageUseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommonMessageUseServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommonMessageUseServiceBlockingStub>() {
        @java.lang.Override
        public CommonMessageUseServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommonMessageUseServiceBlockingStub(channel, callOptions);
        }
      };
    return CommonMessageUseServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommonMessageUseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommonMessageUseServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommonMessageUseServiceFutureStub>() {
        @java.lang.Override
        public CommonMessageUseServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommonMessageUseServiceFutureStub(channel, callOptions);
        }
      };
    return CommonMessageUseServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void unaryRPC(com.github.mscheong01.rpc.Rpc.CommonRequest request,
        io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.CommonResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnaryRPCMethod(), responseObserver);
    }

    /**
     */
    default void serverStreamingRPC(com.github.mscheong01.rpc.Rpc.CommonRequest request,
        io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.CommonResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getServerStreamingRPCMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.CommonRequest> clientStreamingRPC(
        io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.CommonResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getClientStreamingRPCMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.CommonRequest> bidirectionalStreamingRPC(
        io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.CommonResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getBidirectionalStreamingRPCMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CommonMessageUseService.
   */
  public static abstract class CommonMessageUseServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CommonMessageUseServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CommonMessageUseService.
   */
  public static final class CommonMessageUseServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CommonMessageUseServiceStub> {
    private CommonMessageUseServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommonMessageUseServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommonMessageUseServiceStub(channel, callOptions);
    }

    /**
     */
    public void unaryRPC(com.github.mscheong01.rpc.Rpc.CommonRequest request,
        io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.CommonResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnaryRPCMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void serverStreamingRPC(com.github.mscheong01.rpc.Rpc.CommonRequest request,
        io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.CommonResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getServerStreamingRPCMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.CommonRequest> clientStreamingRPC(
        io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.CommonResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getClientStreamingRPCMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.CommonRequest> bidirectionalStreamingRPC(
        io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.CommonResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getBidirectionalStreamingRPCMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CommonMessageUseService.
   */
  public static final class CommonMessageUseServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CommonMessageUseServiceBlockingStub> {
    private CommonMessageUseServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommonMessageUseServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommonMessageUseServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.github.mscheong01.rpc.Rpc.CommonResponse unaryRPC(com.github.mscheong01.rpc.Rpc.CommonRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnaryRPCMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.github.mscheong01.rpc.Rpc.CommonResponse> serverStreamingRPC(
        com.github.mscheong01.rpc.Rpc.CommonRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getServerStreamingRPCMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CommonMessageUseService.
   */
  public static final class CommonMessageUseServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CommonMessageUseServiceFutureStub> {
    private CommonMessageUseServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommonMessageUseServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommonMessageUseServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mscheong01.rpc.Rpc.CommonResponse> unaryRPC(
        com.github.mscheong01.rpc.Rpc.CommonRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnaryRPCMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UNARY_RPC = 0;
  private static final int METHODID_SERVER_STREAMING_RPC = 1;
  private static final int METHODID_CLIENT_STREAMING_RPC = 2;
  private static final int METHODID_BIDIRECTIONAL_STREAMING_RPC = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UNARY_RPC:
          serviceImpl.unaryRPC((com.github.mscheong01.rpc.Rpc.CommonRequest) request,
              (io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.CommonResponse>) responseObserver);
          break;
        case METHODID_SERVER_STREAMING_RPC:
          serviceImpl.serverStreamingRPC((com.github.mscheong01.rpc.Rpc.CommonRequest) request,
              (io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.CommonResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CLIENT_STREAMING_RPC:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.clientStreamingRPC(
              (io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.CommonResponse>) responseObserver);
        case METHODID_BIDIRECTIONAL_STREAMING_RPC:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.bidirectionalStreamingRPC(
              (io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.CommonResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getUnaryRPCMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.github.mscheong01.rpc.Rpc.CommonRequest,
              com.github.mscheong01.rpc.Rpc.CommonResponse>(
                service, METHODID_UNARY_RPC)))
        .addMethod(
          getServerStreamingRPCMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.github.mscheong01.rpc.Rpc.CommonRequest,
              com.github.mscheong01.rpc.Rpc.CommonResponse>(
                service, METHODID_SERVER_STREAMING_RPC)))
        .addMethod(
          getClientStreamingRPCMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.github.mscheong01.rpc.Rpc.CommonRequest,
              com.github.mscheong01.rpc.Rpc.CommonResponse>(
                service, METHODID_CLIENT_STREAMING_RPC)))
        .addMethod(
          getBidirectionalStreamingRPCMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.github.mscheong01.rpc.Rpc.CommonRequest,
              com.github.mscheong01.rpc.Rpc.CommonResponse>(
                service, METHODID_BIDIRECTIONAL_STREAMING_RPC)))
        .build();
  }

  private static abstract class CommonMessageUseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommonMessageUseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.github.mscheong01.rpc.Rpc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CommonMessageUseService");
    }
  }

  private static final class CommonMessageUseServiceFileDescriptorSupplier
      extends CommonMessageUseServiceBaseDescriptorSupplier {
    CommonMessageUseServiceFileDescriptorSupplier() {}
  }

  private static final class CommonMessageUseServiceMethodDescriptorSupplier
      extends CommonMessageUseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CommonMessageUseServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CommonMessageUseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommonMessageUseServiceFileDescriptorSupplier())
              .addMethod(getUnaryRPCMethod())
              .addMethod(getServerStreamingRPCMethod())
              .addMethod(getClientStreamingRPCMethod())
              .addMethod(getBidirectionalStreamingRPCMethod())
              .build();
        }
      }
    }
    return result;
  }
}
