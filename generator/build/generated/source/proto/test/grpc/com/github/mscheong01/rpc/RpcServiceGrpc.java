package com.github.mscheong01.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.0)",
    comments = "Source: rpc.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RpcServiceGrpc {

  private RpcServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.rpc.RpcService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.UnaryRequest,
      com.github.mscheong01.rpc.Rpc.UnaryResponse> getUnaryTestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnaryTest",
      requestType = com.github.mscheong01.rpc.Rpc.UnaryRequest.class,
      responseType = com.github.mscheong01.rpc.Rpc.UnaryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.UnaryRequest,
      com.github.mscheong01.rpc.Rpc.UnaryResponse> getUnaryTestMethod() {
    io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.UnaryRequest, com.github.mscheong01.rpc.Rpc.UnaryResponse> getUnaryTestMethod;
    if ((getUnaryTestMethod = RpcServiceGrpc.getUnaryTestMethod) == null) {
      synchronized (RpcServiceGrpc.class) {
        if ((getUnaryTestMethod = RpcServiceGrpc.getUnaryTestMethod) == null) {
          RpcServiceGrpc.getUnaryTestMethod = getUnaryTestMethod =
              io.grpc.MethodDescriptor.<com.github.mscheong01.rpc.Rpc.UnaryRequest, com.github.mscheong01.rpc.Rpc.UnaryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UnaryTest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.mscheong01.rpc.Rpc.UnaryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.mscheong01.rpc.Rpc.UnaryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcServiceMethodDescriptorSupplier("UnaryTest"))
              .build();
        }
      }
    }
    return getUnaryTestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.ServerStreamingRequest,
      com.github.mscheong01.rpc.Rpc.ServerStreamingResponse> getServerStreamingTestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ServerStreamingTest",
      requestType = com.github.mscheong01.rpc.Rpc.ServerStreamingRequest.class,
      responseType = com.github.mscheong01.rpc.Rpc.ServerStreamingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.ServerStreamingRequest,
      com.github.mscheong01.rpc.Rpc.ServerStreamingResponse> getServerStreamingTestMethod() {
    io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.ServerStreamingRequest, com.github.mscheong01.rpc.Rpc.ServerStreamingResponse> getServerStreamingTestMethod;
    if ((getServerStreamingTestMethod = RpcServiceGrpc.getServerStreamingTestMethod) == null) {
      synchronized (RpcServiceGrpc.class) {
        if ((getServerStreamingTestMethod = RpcServiceGrpc.getServerStreamingTestMethod) == null) {
          RpcServiceGrpc.getServerStreamingTestMethod = getServerStreamingTestMethod =
              io.grpc.MethodDescriptor.<com.github.mscheong01.rpc.Rpc.ServerStreamingRequest, com.github.mscheong01.rpc.Rpc.ServerStreamingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ServerStreamingTest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.mscheong01.rpc.Rpc.ServerStreamingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.mscheong01.rpc.Rpc.ServerStreamingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcServiceMethodDescriptorSupplier("ServerStreamingTest"))
              .build();
        }
      }
    }
    return getServerStreamingTestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.ClientStreamingRequest,
      com.github.mscheong01.rpc.Rpc.ClientStreamingResponse> getClientStreamingTestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ClientStreamingTest",
      requestType = com.github.mscheong01.rpc.Rpc.ClientStreamingRequest.class,
      responseType = com.github.mscheong01.rpc.Rpc.ClientStreamingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.ClientStreamingRequest,
      com.github.mscheong01.rpc.Rpc.ClientStreamingResponse> getClientStreamingTestMethod() {
    io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.ClientStreamingRequest, com.github.mscheong01.rpc.Rpc.ClientStreamingResponse> getClientStreamingTestMethod;
    if ((getClientStreamingTestMethod = RpcServiceGrpc.getClientStreamingTestMethod) == null) {
      synchronized (RpcServiceGrpc.class) {
        if ((getClientStreamingTestMethod = RpcServiceGrpc.getClientStreamingTestMethod) == null) {
          RpcServiceGrpc.getClientStreamingTestMethod = getClientStreamingTestMethod =
              io.grpc.MethodDescriptor.<com.github.mscheong01.rpc.Rpc.ClientStreamingRequest, com.github.mscheong01.rpc.Rpc.ClientStreamingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ClientStreamingTest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.mscheong01.rpc.Rpc.ClientStreamingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.mscheong01.rpc.Rpc.ClientStreamingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcServiceMethodDescriptorSupplier("ClientStreamingTest"))
              .build();
        }
      }
    }
    return getClientStreamingTestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.BidirectionalStreamingRequest,
      com.github.mscheong01.rpc.Rpc.BidirectionalStreamingResponse> getBidirectionalStreamingTestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BidirectionalStreamingTest",
      requestType = com.github.mscheong01.rpc.Rpc.BidirectionalStreamingRequest.class,
      responseType = com.github.mscheong01.rpc.Rpc.BidirectionalStreamingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.BidirectionalStreamingRequest,
      com.github.mscheong01.rpc.Rpc.BidirectionalStreamingResponse> getBidirectionalStreamingTestMethod() {
    io.grpc.MethodDescriptor<com.github.mscheong01.rpc.Rpc.BidirectionalStreamingRequest, com.github.mscheong01.rpc.Rpc.BidirectionalStreamingResponse> getBidirectionalStreamingTestMethod;
    if ((getBidirectionalStreamingTestMethod = RpcServiceGrpc.getBidirectionalStreamingTestMethod) == null) {
      synchronized (RpcServiceGrpc.class) {
        if ((getBidirectionalStreamingTestMethod = RpcServiceGrpc.getBidirectionalStreamingTestMethod) == null) {
          RpcServiceGrpc.getBidirectionalStreamingTestMethod = getBidirectionalStreamingTestMethod =
              io.grpc.MethodDescriptor.<com.github.mscheong01.rpc.Rpc.BidirectionalStreamingRequest, com.github.mscheong01.rpc.Rpc.BidirectionalStreamingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BidirectionalStreamingTest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.mscheong01.rpc.Rpc.BidirectionalStreamingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.mscheong01.rpc.Rpc.BidirectionalStreamingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RpcServiceMethodDescriptorSupplier("BidirectionalStreamingTest"))
              .build();
        }
      }
    }
    return getBidirectionalStreamingTestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RpcServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RpcServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RpcServiceStub>() {
        @java.lang.Override
        public RpcServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RpcServiceStub(channel, callOptions);
        }
      };
    return RpcServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RpcServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RpcServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RpcServiceBlockingStub>() {
        @java.lang.Override
        public RpcServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RpcServiceBlockingStub(channel, callOptions);
        }
      };
    return RpcServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RpcServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RpcServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RpcServiceFutureStub>() {
        @java.lang.Override
        public RpcServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RpcServiceFutureStub(channel, callOptions);
        }
      };
    return RpcServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * unary rpc
     * </pre>
     */
    default void unaryTest(com.github.mscheong01.rpc.Rpc.UnaryRequest request,
        io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.UnaryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnaryTestMethod(), responseObserver);
    }

    /**
     * <pre>
     * server streaming rpc
     * </pre>
     */
    default void serverStreamingTest(com.github.mscheong01.rpc.Rpc.ServerStreamingRequest request,
        io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.ServerStreamingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getServerStreamingTestMethod(), responseObserver);
    }

    /**
     * <pre>
     * client streaming rpc
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.ClientStreamingRequest> clientStreamingTest(
        io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.ClientStreamingResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getClientStreamingTestMethod(), responseObserver);
    }

    /**
     * <pre>
     * bidirectional streaming rpc
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.BidirectionalStreamingRequest> bidirectionalStreamingTest(
        io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.BidirectionalStreamingResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getBidirectionalStreamingTestMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RpcService.
   */
  public static abstract class RpcServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return RpcServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RpcService.
   */
  public static final class RpcServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RpcServiceStub> {
    private RpcServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RpcServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RpcServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary rpc
     * </pre>
     */
    public void unaryTest(com.github.mscheong01.rpc.Rpc.UnaryRequest request,
        io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.UnaryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnaryTestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * server streaming rpc
     * </pre>
     */
    public void serverStreamingTest(com.github.mscheong01.rpc.Rpc.ServerStreamingRequest request,
        io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.ServerStreamingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getServerStreamingTestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * client streaming rpc
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.ClientStreamingRequest> clientStreamingTest(
        io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.ClientStreamingResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getClientStreamingTestMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * bidirectional streaming rpc
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.BidirectionalStreamingRequest> bidirectionalStreamingTest(
        io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.BidirectionalStreamingResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getBidirectionalStreamingTestMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RpcService.
   */
  public static final class RpcServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RpcServiceBlockingStub> {
    private RpcServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RpcServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RpcServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary rpc
     * </pre>
     */
    public com.github.mscheong01.rpc.Rpc.UnaryResponse unaryTest(com.github.mscheong01.rpc.Rpc.UnaryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnaryTestMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * server streaming rpc
     * </pre>
     */
    public java.util.Iterator<com.github.mscheong01.rpc.Rpc.ServerStreamingResponse> serverStreamingTest(
        com.github.mscheong01.rpc.Rpc.ServerStreamingRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getServerStreamingTestMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service RpcService.
   */
  public static final class RpcServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RpcServiceFutureStub> {
    private RpcServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RpcServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RpcServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary rpc
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.mscheong01.rpc.Rpc.UnaryResponse> unaryTest(
        com.github.mscheong01.rpc.Rpc.UnaryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnaryTestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UNARY_TEST = 0;
  private static final int METHODID_SERVER_STREAMING_TEST = 1;
  private static final int METHODID_CLIENT_STREAMING_TEST = 2;
  private static final int METHODID_BIDIRECTIONAL_STREAMING_TEST = 3;

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
        case METHODID_UNARY_TEST:
          serviceImpl.unaryTest((com.github.mscheong01.rpc.Rpc.UnaryRequest) request,
              (io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.UnaryResponse>) responseObserver);
          break;
        case METHODID_SERVER_STREAMING_TEST:
          serviceImpl.serverStreamingTest((com.github.mscheong01.rpc.Rpc.ServerStreamingRequest) request,
              (io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.ServerStreamingResponse>) responseObserver);
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
        case METHODID_CLIENT_STREAMING_TEST:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.clientStreamingTest(
              (io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.ClientStreamingResponse>) responseObserver);
        case METHODID_BIDIRECTIONAL_STREAMING_TEST:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.bidirectionalStreamingTest(
              (io.grpc.stub.StreamObserver<com.github.mscheong01.rpc.Rpc.BidirectionalStreamingResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getUnaryTestMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.github.mscheong01.rpc.Rpc.UnaryRequest,
              com.github.mscheong01.rpc.Rpc.UnaryResponse>(
                service, METHODID_UNARY_TEST)))
        .addMethod(
          getServerStreamingTestMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.github.mscheong01.rpc.Rpc.ServerStreamingRequest,
              com.github.mscheong01.rpc.Rpc.ServerStreamingResponse>(
                service, METHODID_SERVER_STREAMING_TEST)))
        .addMethod(
          getClientStreamingTestMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.github.mscheong01.rpc.Rpc.ClientStreamingRequest,
              com.github.mscheong01.rpc.Rpc.ClientStreamingResponse>(
                service, METHODID_CLIENT_STREAMING_TEST)))
        .addMethod(
          getBidirectionalStreamingTestMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.github.mscheong01.rpc.Rpc.BidirectionalStreamingRequest,
              com.github.mscheong01.rpc.Rpc.BidirectionalStreamingResponse>(
                service, METHODID_BIDIRECTIONAL_STREAMING_TEST)))
        .build();
  }

  private static abstract class RpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RpcServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.github.mscheong01.rpc.Rpc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RpcService");
    }
  }

  private static final class RpcServiceFileDescriptorSupplier
      extends RpcServiceBaseDescriptorSupplier {
    RpcServiceFileDescriptorSupplier() {}
  }

  private static final class RpcServiceMethodDescriptorSupplier
      extends RpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RpcServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RpcServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RpcServiceFileDescriptorSupplier())
              .addMethod(getUnaryTestMethod())
              .addMethod(getServerStreamingTestMethod())
              .addMethod(getClientStreamingTestMethod())
              .addMethod(getBidirectionalStreamingTestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
