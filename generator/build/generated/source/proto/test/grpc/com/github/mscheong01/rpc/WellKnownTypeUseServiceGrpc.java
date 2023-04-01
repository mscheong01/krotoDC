package com.github.mscheong01.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.0)",
    comments = "Source: rpc.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WellKnownTypeUseServiceGrpc {

  private WellKnownTypeUseServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.rpc.WellKnownTypeUseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.Empty> getEchoEmptyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EchoEmpty",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.Empty> getEchoEmptyMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.google.protobuf.Empty> getEchoEmptyMethod;
    if ((getEchoEmptyMethod = WellKnownTypeUseServiceGrpc.getEchoEmptyMethod) == null) {
      synchronized (WellKnownTypeUseServiceGrpc.class) {
        if ((getEchoEmptyMethod = WellKnownTypeUseServiceGrpc.getEchoEmptyMethod) == null) {
          WellKnownTypeUseServiceGrpc.getEchoEmptyMethod = getEchoEmptyMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EchoEmpty"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new WellKnownTypeUseServiceMethodDescriptorSupplier("EchoEmpty"))
              .build();
        }
      }
    }
    return getEchoEmptyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.google.protobuf.StringValue> getEchoStringMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EchoString",
      requestType = com.google.protobuf.StringValue.class,
      responseType = com.google.protobuf.StringValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      com.google.protobuf.StringValue> getEchoStringMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, com.google.protobuf.StringValue> getEchoStringMethod;
    if ((getEchoStringMethod = WellKnownTypeUseServiceGrpc.getEchoStringMethod) == null) {
      synchronized (WellKnownTypeUseServiceGrpc.class) {
        if ((getEchoStringMethod = WellKnownTypeUseServiceGrpc.getEchoStringMethod) == null) {
          WellKnownTypeUseServiceGrpc.getEchoStringMethod = getEchoStringMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, com.google.protobuf.StringValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EchoString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setSchemaDescriptor(new WellKnownTypeUseServiceMethodDescriptorSupplier("EchoString"))
              .build();
        }
      }
    }
    return getEchoStringMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.BytesValue,
      com.google.protobuf.BytesValue> getEchoBytesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EchoBytes",
      requestType = com.google.protobuf.BytesValue.class,
      responseType = com.google.protobuf.BytesValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.BytesValue,
      com.google.protobuf.BytesValue> getEchoBytesMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.BytesValue, com.google.protobuf.BytesValue> getEchoBytesMethod;
    if ((getEchoBytesMethod = WellKnownTypeUseServiceGrpc.getEchoBytesMethod) == null) {
      synchronized (WellKnownTypeUseServiceGrpc.class) {
        if ((getEchoBytesMethod = WellKnownTypeUseServiceGrpc.getEchoBytesMethod) == null) {
          WellKnownTypeUseServiceGrpc.getEchoBytesMethod = getEchoBytesMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.BytesValue, com.google.protobuf.BytesValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EchoBytes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BytesValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BytesValue.getDefaultInstance()))
              .setSchemaDescriptor(new WellKnownTypeUseServiceMethodDescriptorSupplier("EchoBytes"))
              .build();
        }
      }
    }
    return getEchoBytesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Int32Value,
      com.google.protobuf.Int32Value> getEchoInt32Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EchoInt32",
      requestType = com.google.protobuf.Int32Value.class,
      responseType = com.google.protobuf.Int32Value.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Int32Value,
      com.google.protobuf.Int32Value> getEchoInt32Method() {
    io.grpc.MethodDescriptor<com.google.protobuf.Int32Value, com.google.protobuf.Int32Value> getEchoInt32Method;
    if ((getEchoInt32Method = WellKnownTypeUseServiceGrpc.getEchoInt32Method) == null) {
      synchronized (WellKnownTypeUseServiceGrpc.class) {
        if ((getEchoInt32Method = WellKnownTypeUseServiceGrpc.getEchoInt32Method) == null) {
          WellKnownTypeUseServiceGrpc.getEchoInt32Method = getEchoInt32Method =
              io.grpc.MethodDescriptor.<com.google.protobuf.Int32Value, com.google.protobuf.Int32Value>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EchoInt32"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Int32Value.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Int32Value.getDefaultInstance()))
              .setSchemaDescriptor(new WellKnownTypeUseServiceMethodDescriptorSupplier("EchoInt32"))
              .build();
        }
      }
    }
    return getEchoInt32Method;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Int64Value,
      com.google.protobuf.Int64Value> getEchoInt64Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EchoInt64",
      requestType = com.google.protobuf.Int64Value.class,
      responseType = com.google.protobuf.Int64Value.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Int64Value,
      com.google.protobuf.Int64Value> getEchoInt64Method() {
    io.grpc.MethodDescriptor<com.google.protobuf.Int64Value, com.google.protobuf.Int64Value> getEchoInt64Method;
    if ((getEchoInt64Method = WellKnownTypeUseServiceGrpc.getEchoInt64Method) == null) {
      synchronized (WellKnownTypeUseServiceGrpc.class) {
        if ((getEchoInt64Method = WellKnownTypeUseServiceGrpc.getEchoInt64Method) == null) {
          WellKnownTypeUseServiceGrpc.getEchoInt64Method = getEchoInt64Method =
              io.grpc.MethodDescriptor.<com.google.protobuf.Int64Value, com.google.protobuf.Int64Value>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EchoInt64"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Int64Value.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Int64Value.getDefaultInstance()))
              .setSchemaDescriptor(new WellKnownTypeUseServiceMethodDescriptorSupplier("EchoInt64"))
              .build();
        }
      }
    }
    return getEchoInt64Method;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.UInt32Value,
      com.google.protobuf.UInt32Value> getEchoUInt32Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EchoUInt32",
      requestType = com.google.protobuf.UInt32Value.class,
      responseType = com.google.protobuf.UInt32Value.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.UInt32Value,
      com.google.protobuf.UInt32Value> getEchoUInt32Method() {
    io.grpc.MethodDescriptor<com.google.protobuf.UInt32Value, com.google.protobuf.UInt32Value> getEchoUInt32Method;
    if ((getEchoUInt32Method = WellKnownTypeUseServiceGrpc.getEchoUInt32Method) == null) {
      synchronized (WellKnownTypeUseServiceGrpc.class) {
        if ((getEchoUInt32Method = WellKnownTypeUseServiceGrpc.getEchoUInt32Method) == null) {
          WellKnownTypeUseServiceGrpc.getEchoUInt32Method = getEchoUInt32Method =
              io.grpc.MethodDescriptor.<com.google.protobuf.UInt32Value, com.google.protobuf.UInt32Value>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EchoUInt32"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.UInt32Value.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.UInt32Value.getDefaultInstance()))
              .setSchemaDescriptor(new WellKnownTypeUseServiceMethodDescriptorSupplier("EchoUInt32"))
              .build();
        }
      }
    }
    return getEchoUInt32Method;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.UInt64Value,
      com.google.protobuf.UInt64Value> getEchoUInt64Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EchoUInt64",
      requestType = com.google.protobuf.UInt64Value.class,
      responseType = com.google.protobuf.UInt64Value.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.UInt64Value,
      com.google.protobuf.UInt64Value> getEchoUInt64Method() {
    io.grpc.MethodDescriptor<com.google.protobuf.UInt64Value, com.google.protobuf.UInt64Value> getEchoUInt64Method;
    if ((getEchoUInt64Method = WellKnownTypeUseServiceGrpc.getEchoUInt64Method) == null) {
      synchronized (WellKnownTypeUseServiceGrpc.class) {
        if ((getEchoUInt64Method = WellKnownTypeUseServiceGrpc.getEchoUInt64Method) == null) {
          WellKnownTypeUseServiceGrpc.getEchoUInt64Method = getEchoUInt64Method =
              io.grpc.MethodDescriptor.<com.google.protobuf.UInt64Value, com.google.protobuf.UInt64Value>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EchoUInt64"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.UInt64Value.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.UInt64Value.getDefaultInstance()))
              .setSchemaDescriptor(new WellKnownTypeUseServiceMethodDescriptorSupplier("EchoUInt64"))
              .build();
        }
      }
    }
    return getEchoUInt64Method;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.FloatValue,
      com.google.protobuf.FloatValue> getEchoFloatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EchoFloat",
      requestType = com.google.protobuf.FloatValue.class,
      responseType = com.google.protobuf.FloatValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.FloatValue,
      com.google.protobuf.FloatValue> getEchoFloatMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.FloatValue, com.google.protobuf.FloatValue> getEchoFloatMethod;
    if ((getEchoFloatMethod = WellKnownTypeUseServiceGrpc.getEchoFloatMethod) == null) {
      synchronized (WellKnownTypeUseServiceGrpc.class) {
        if ((getEchoFloatMethod = WellKnownTypeUseServiceGrpc.getEchoFloatMethod) == null) {
          WellKnownTypeUseServiceGrpc.getEchoFloatMethod = getEchoFloatMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.FloatValue, com.google.protobuf.FloatValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EchoFloat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.FloatValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.FloatValue.getDefaultInstance()))
              .setSchemaDescriptor(new WellKnownTypeUseServiceMethodDescriptorSupplier("EchoFloat"))
              .build();
        }
      }
    }
    return getEchoFloatMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.DoubleValue,
      com.google.protobuf.DoubleValue> getEchoDoubleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EchoDouble",
      requestType = com.google.protobuf.DoubleValue.class,
      responseType = com.google.protobuf.DoubleValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.DoubleValue,
      com.google.protobuf.DoubleValue> getEchoDoubleMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.DoubleValue, com.google.protobuf.DoubleValue> getEchoDoubleMethod;
    if ((getEchoDoubleMethod = WellKnownTypeUseServiceGrpc.getEchoDoubleMethod) == null) {
      synchronized (WellKnownTypeUseServiceGrpc.class) {
        if ((getEchoDoubleMethod = WellKnownTypeUseServiceGrpc.getEchoDoubleMethod) == null) {
          WellKnownTypeUseServiceGrpc.getEchoDoubleMethod = getEchoDoubleMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.DoubleValue, com.google.protobuf.DoubleValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EchoDouble"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.DoubleValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.DoubleValue.getDefaultInstance()))
              .setSchemaDescriptor(new WellKnownTypeUseServiceMethodDescriptorSupplier("EchoDouble"))
              .build();
        }
      }
    }
    return getEchoDoubleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.BoolValue,
      com.google.protobuf.BoolValue> getEchoBoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EchoBool",
      requestType = com.google.protobuf.BoolValue.class,
      responseType = com.google.protobuf.BoolValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.BoolValue,
      com.google.protobuf.BoolValue> getEchoBoolMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.BoolValue, com.google.protobuf.BoolValue> getEchoBoolMethod;
    if ((getEchoBoolMethod = WellKnownTypeUseServiceGrpc.getEchoBoolMethod) == null) {
      synchronized (WellKnownTypeUseServiceGrpc.class) {
        if ((getEchoBoolMethod = WellKnownTypeUseServiceGrpc.getEchoBoolMethod) == null) {
          WellKnownTypeUseServiceGrpc.getEchoBoolMethod = getEchoBoolMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.BoolValue, com.google.protobuf.BoolValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EchoBool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.BoolValue.getDefaultInstance()))
              .setSchemaDescriptor(new WellKnownTypeUseServiceMethodDescriptorSupplier("EchoBool"))
              .build();
        }
      }
    }
    return getEchoBoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Timestamp,
      com.google.protobuf.Timestamp> getEchoTimestampMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EchoTimestamp",
      requestType = com.google.protobuf.Timestamp.class,
      responseType = com.google.protobuf.Timestamp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Timestamp,
      com.google.protobuf.Timestamp> getEchoTimestampMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Timestamp, com.google.protobuf.Timestamp> getEchoTimestampMethod;
    if ((getEchoTimestampMethod = WellKnownTypeUseServiceGrpc.getEchoTimestampMethod) == null) {
      synchronized (WellKnownTypeUseServiceGrpc.class) {
        if ((getEchoTimestampMethod = WellKnownTypeUseServiceGrpc.getEchoTimestampMethod) == null) {
          WellKnownTypeUseServiceGrpc.getEchoTimestampMethod = getEchoTimestampMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Timestamp, com.google.protobuf.Timestamp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EchoTimestamp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Timestamp.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Timestamp.getDefaultInstance()))
              .setSchemaDescriptor(new WellKnownTypeUseServiceMethodDescriptorSupplier("EchoTimestamp"))
              .build();
        }
      }
    }
    return getEchoTimestampMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Duration,
      com.google.protobuf.Duration> getEchoDurationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EchoDuration",
      requestType = com.google.protobuf.Duration.class,
      responseType = com.google.protobuf.Duration.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Duration,
      com.google.protobuf.Duration> getEchoDurationMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Duration, com.google.protobuf.Duration> getEchoDurationMethod;
    if ((getEchoDurationMethod = WellKnownTypeUseServiceGrpc.getEchoDurationMethod) == null) {
      synchronized (WellKnownTypeUseServiceGrpc.class) {
        if ((getEchoDurationMethod = WellKnownTypeUseServiceGrpc.getEchoDurationMethod) == null) {
          WellKnownTypeUseServiceGrpc.getEchoDurationMethod = getEchoDurationMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Duration, com.google.protobuf.Duration>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EchoDuration"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Duration.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Duration.getDefaultInstance()))
              .setSchemaDescriptor(new WellKnownTypeUseServiceMethodDescriptorSupplier("EchoDuration"))
              .build();
        }
      }
    }
    return getEchoDurationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Struct,
      com.google.protobuf.Struct> getEchoStructMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EchoStruct",
      requestType = com.google.protobuf.Struct.class,
      responseType = com.google.protobuf.Struct.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Struct,
      com.google.protobuf.Struct> getEchoStructMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Struct, com.google.protobuf.Struct> getEchoStructMethod;
    if ((getEchoStructMethod = WellKnownTypeUseServiceGrpc.getEchoStructMethod) == null) {
      synchronized (WellKnownTypeUseServiceGrpc.class) {
        if ((getEchoStructMethod = WellKnownTypeUseServiceGrpc.getEchoStructMethod) == null) {
          WellKnownTypeUseServiceGrpc.getEchoStructMethod = getEchoStructMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Struct, com.google.protobuf.Struct>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EchoStruct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Struct.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Struct.getDefaultInstance()))
              .setSchemaDescriptor(new WellKnownTypeUseServiceMethodDescriptorSupplier("EchoStruct"))
              .build();
        }
      }
    }
    return getEchoStructMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Any,
      com.google.protobuf.Any> getEchoAnyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EchoAny",
      requestType = com.google.protobuf.Any.class,
      responseType = com.google.protobuf.Any.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Any,
      com.google.protobuf.Any> getEchoAnyMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Any, com.google.protobuf.Any> getEchoAnyMethod;
    if ((getEchoAnyMethod = WellKnownTypeUseServiceGrpc.getEchoAnyMethod) == null) {
      synchronized (WellKnownTypeUseServiceGrpc.class) {
        if ((getEchoAnyMethod = WellKnownTypeUseServiceGrpc.getEchoAnyMethod) == null) {
          WellKnownTypeUseServiceGrpc.getEchoAnyMethod = getEchoAnyMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Any, com.google.protobuf.Any>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EchoAny"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Any.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Any.getDefaultInstance()))
              .setSchemaDescriptor(new WellKnownTypeUseServiceMethodDescriptorSupplier("EchoAny"))
              .build();
        }
      }
    }
    return getEchoAnyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WellKnownTypeUseServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WellKnownTypeUseServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WellKnownTypeUseServiceStub>() {
        @java.lang.Override
        public WellKnownTypeUseServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WellKnownTypeUseServiceStub(channel, callOptions);
        }
      };
    return WellKnownTypeUseServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WellKnownTypeUseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WellKnownTypeUseServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WellKnownTypeUseServiceBlockingStub>() {
        @java.lang.Override
        public WellKnownTypeUseServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WellKnownTypeUseServiceBlockingStub(channel, callOptions);
        }
      };
    return WellKnownTypeUseServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WellKnownTypeUseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WellKnownTypeUseServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WellKnownTypeUseServiceFutureStub>() {
        @java.lang.Override
        public WellKnownTypeUseServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WellKnownTypeUseServiceFutureStub(channel, callOptions);
        }
      };
    return WellKnownTypeUseServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void echoEmpty(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEchoEmptyMethod(), responseObserver);
    }

    /**
     */
    default void echoString(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEchoStringMethod(), responseObserver);
    }

    /**
     */
    default void echoBytes(com.google.protobuf.BytesValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BytesValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEchoBytesMethod(), responseObserver);
    }

    /**
     */
    default void echoInt32(com.google.protobuf.Int32Value request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Int32Value> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEchoInt32Method(), responseObserver);
    }

    /**
     */
    default void echoInt64(com.google.protobuf.Int64Value request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Int64Value> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEchoInt64Method(), responseObserver);
    }

    /**
     */
    default void echoUInt32(com.google.protobuf.UInt32Value request,
        io.grpc.stub.StreamObserver<com.google.protobuf.UInt32Value> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEchoUInt32Method(), responseObserver);
    }

    /**
     */
    default void echoUInt64(com.google.protobuf.UInt64Value request,
        io.grpc.stub.StreamObserver<com.google.protobuf.UInt64Value> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEchoUInt64Method(), responseObserver);
    }

    /**
     */
    default void echoFloat(com.google.protobuf.FloatValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.FloatValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEchoFloatMethod(), responseObserver);
    }

    /**
     */
    default void echoDouble(com.google.protobuf.DoubleValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.DoubleValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEchoDoubleMethod(), responseObserver);
    }

    /**
     */
    default void echoBool(com.google.protobuf.BoolValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEchoBoolMethod(), responseObserver);
    }

    /**
     */
    default void echoTimestamp(com.google.protobuf.Timestamp request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Timestamp> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEchoTimestampMethod(), responseObserver);
    }

    /**
     */
    default void echoDuration(com.google.protobuf.Duration request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Duration> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEchoDurationMethod(), responseObserver);
    }

    /**
     */
    default void echoStruct(com.google.protobuf.Struct request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Struct> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEchoStructMethod(), responseObserver);
    }

    /**
     */
    default void echoAny(com.google.protobuf.Any request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Any> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEchoAnyMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service WellKnownTypeUseService.
   */
  public static abstract class WellKnownTypeUseServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return WellKnownTypeUseServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service WellKnownTypeUseService.
   */
  public static final class WellKnownTypeUseServiceStub
      extends io.grpc.stub.AbstractAsyncStub<WellKnownTypeUseServiceStub> {
    private WellKnownTypeUseServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WellKnownTypeUseServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WellKnownTypeUseServiceStub(channel, callOptions);
    }

    /**
     */
    public void echoEmpty(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEchoEmptyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void echoString(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEchoStringMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void echoBytes(com.google.protobuf.BytesValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BytesValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEchoBytesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void echoInt32(com.google.protobuf.Int32Value request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Int32Value> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEchoInt32Method(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void echoInt64(com.google.protobuf.Int64Value request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Int64Value> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEchoInt64Method(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void echoUInt32(com.google.protobuf.UInt32Value request,
        io.grpc.stub.StreamObserver<com.google.protobuf.UInt32Value> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEchoUInt32Method(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void echoUInt64(com.google.protobuf.UInt64Value request,
        io.grpc.stub.StreamObserver<com.google.protobuf.UInt64Value> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEchoUInt64Method(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void echoFloat(com.google.protobuf.FloatValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.FloatValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEchoFloatMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void echoDouble(com.google.protobuf.DoubleValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.DoubleValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEchoDoubleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void echoBool(com.google.protobuf.BoolValue request,
        io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEchoBoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void echoTimestamp(com.google.protobuf.Timestamp request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Timestamp> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEchoTimestampMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void echoDuration(com.google.protobuf.Duration request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Duration> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEchoDurationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void echoStruct(com.google.protobuf.Struct request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Struct> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEchoStructMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void echoAny(com.google.protobuf.Any request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Any> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEchoAnyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service WellKnownTypeUseService.
   */
  public static final class WellKnownTypeUseServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WellKnownTypeUseServiceBlockingStub> {
    private WellKnownTypeUseServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WellKnownTypeUseServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WellKnownTypeUseServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty echoEmpty(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEchoEmptyMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.StringValue echoString(com.google.protobuf.StringValue request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEchoStringMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BytesValue echoBytes(com.google.protobuf.BytesValue request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEchoBytesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Int32Value echoInt32(com.google.protobuf.Int32Value request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEchoInt32Method(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Int64Value echoInt64(com.google.protobuf.Int64Value request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEchoInt64Method(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.UInt32Value echoUInt32(com.google.protobuf.UInt32Value request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEchoUInt32Method(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.UInt64Value echoUInt64(com.google.protobuf.UInt64Value request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEchoUInt64Method(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.FloatValue echoFloat(com.google.protobuf.FloatValue request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEchoFloatMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.DoubleValue echoDouble(com.google.protobuf.DoubleValue request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEchoDoubleMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.BoolValue echoBool(com.google.protobuf.BoolValue request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEchoBoolMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Timestamp echoTimestamp(com.google.protobuf.Timestamp request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEchoTimestampMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Duration echoDuration(com.google.protobuf.Duration request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEchoDurationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Struct echoStruct(com.google.protobuf.Struct request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEchoStructMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Any echoAny(com.google.protobuf.Any request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEchoAnyMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service WellKnownTypeUseService.
   */
  public static final class WellKnownTypeUseServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<WellKnownTypeUseServiceFutureStub> {
    private WellKnownTypeUseServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WellKnownTypeUseServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WellKnownTypeUseServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> echoEmpty(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEchoEmptyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.StringValue> echoString(
        com.google.protobuf.StringValue request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEchoStringMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BytesValue> echoBytes(
        com.google.protobuf.BytesValue request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEchoBytesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Int32Value> echoInt32(
        com.google.protobuf.Int32Value request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEchoInt32Method(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Int64Value> echoInt64(
        com.google.protobuf.Int64Value request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEchoInt64Method(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.UInt32Value> echoUInt32(
        com.google.protobuf.UInt32Value request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEchoUInt32Method(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.UInt64Value> echoUInt64(
        com.google.protobuf.UInt64Value request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEchoUInt64Method(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.FloatValue> echoFloat(
        com.google.protobuf.FloatValue request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEchoFloatMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.DoubleValue> echoDouble(
        com.google.protobuf.DoubleValue request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEchoDoubleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.BoolValue> echoBool(
        com.google.protobuf.BoolValue request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEchoBoolMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Timestamp> echoTimestamp(
        com.google.protobuf.Timestamp request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEchoTimestampMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Duration> echoDuration(
        com.google.protobuf.Duration request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEchoDurationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Struct> echoStruct(
        com.google.protobuf.Struct request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEchoStructMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Any> echoAny(
        com.google.protobuf.Any request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEchoAnyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ECHO_EMPTY = 0;
  private static final int METHODID_ECHO_STRING = 1;
  private static final int METHODID_ECHO_BYTES = 2;
  private static final int METHODID_ECHO_INT32 = 3;
  private static final int METHODID_ECHO_INT64 = 4;
  private static final int METHODID_ECHO_UINT32 = 5;
  private static final int METHODID_ECHO_UINT64 = 6;
  private static final int METHODID_ECHO_FLOAT = 7;
  private static final int METHODID_ECHO_DOUBLE = 8;
  private static final int METHODID_ECHO_BOOL = 9;
  private static final int METHODID_ECHO_TIMESTAMP = 10;
  private static final int METHODID_ECHO_DURATION = 11;
  private static final int METHODID_ECHO_STRUCT = 12;
  private static final int METHODID_ECHO_ANY = 13;

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
        case METHODID_ECHO_EMPTY:
          serviceImpl.echoEmpty((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_ECHO_STRING:
          serviceImpl.echoString((com.google.protobuf.StringValue) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.StringValue>) responseObserver);
          break;
        case METHODID_ECHO_BYTES:
          serviceImpl.echoBytes((com.google.protobuf.BytesValue) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BytesValue>) responseObserver);
          break;
        case METHODID_ECHO_INT32:
          serviceImpl.echoInt32((com.google.protobuf.Int32Value) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Int32Value>) responseObserver);
          break;
        case METHODID_ECHO_INT64:
          serviceImpl.echoInt64((com.google.protobuf.Int64Value) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Int64Value>) responseObserver);
          break;
        case METHODID_ECHO_UINT32:
          serviceImpl.echoUInt32((com.google.protobuf.UInt32Value) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.UInt32Value>) responseObserver);
          break;
        case METHODID_ECHO_UINT64:
          serviceImpl.echoUInt64((com.google.protobuf.UInt64Value) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.UInt64Value>) responseObserver);
          break;
        case METHODID_ECHO_FLOAT:
          serviceImpl.echoFloat((com.google.protobuf.FloatValue) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.FloatValue>) responseObserver);
          break;
        case METHODID_ECHO_DOUBLE:
          serviceImpl.echoDouble((com.google.protobuf.DoubleValue) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.DoubleValue>) responseObserver);
          break;
        case METHODID_ECHO_BOOL:
          serviceImpl.echoBool((com.google.protobuf.BoolValue) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.BoolValue>) responseObserver);
          break;
        case METHODID_ECHO_TIMESTAMP:
          serviceImpl.echoTimestamp((com.google.protobuf.Timestamp) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Timestamp>) responseObserver);
          break;
        case METHODID_ECHO_DURATION:
          serviceImpl.echoDuration((com.google.protobuf.Duration) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Duration>) responseObserver);
          break;
        case METHODID_ECHO_STRUCT:
          serviceImpl.echoStruct((com.google.protobuf.Struct) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Struct>) responseObserver);
          break;
        case METHODID_ECHO_ANY:
          serviceImpl.echoAny((com.google.protobuf.Any) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Any>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getEchoEmptyMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              com.google.protobuf.Empty>(
                service, METHODID_ECHO_EMPTY)))
        .addMethod(
          getEchoStringMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.StringValue,
              com.google.protobuf.StringValue>(
                service, METHODID_ECHO_STRING)))
        .addMethod(
          getEchoBytesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.BytesValue,
              com.google.protobuf.BytesValue>(
                service, METHODID_ECHO_BYTES)))
        .addMethod(
          getEchoInt32Method(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Int32Value,
              com.google.protobuf.Int32Value>(
                service, METHODID_ECHO_INT32)))
        .addMethod(
          getEchoInt64Method(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Int64Value,
              com.google.protobuf.Int64Value>(
                service, METHODID_ECHO_INT64)))
        .addMethod(
          getEchoUInt32Method(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.UInt32Value,
              com.google.protobuf.UInt32Value>(
                service, METHODID_ECHO_UINT32)))
        .addMethod(
          getEchoUInt64Method(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.UInt64Value,
              com.google.protobuf.UInt64Value>(
                service, METHODID_ECHO_UINT64)))
        .addMethod(
          getEchoFloatMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.FloatValue,
              com.google.protobuf.FloatValue>(
                service, METHODID_ECHO_FLOAT)))
        .addMethod(
          getEchoDoubleMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.DoubleValue,
              com.google.protobuf.DoubleValue>(
                service, METHODID_ECHO_DOUBLE)))
        .addMethod(
          getEchoBoolMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.BoolValue,
              com.google.protobuf.BoolValue>(
                service, METHODID_ECHO_BOOL)))
        .addMethod(
          getEchoTimestampMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Timestamp,
              com.google.protobuf.Timestamp>(
                service, METHODID_ECHO_TIMESTAMP)))
        .addMethod(
          getEchoDurationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Duration,
              com.google.protobuf.Duration>(
                service, METHODID_ECHO_DURATION)))
        .addMethod(
          getEchoStructMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Struct,
              com.google.protobuf.Struct>(
                service, METHODID_ECHO_STRUCT)))
        .addMethod(
          getEchoAnyMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Any,
              com.google.protobuf.Any>(
                service, METHODID_ECHO_ANY)))
        .build();
  }

  private static abstract class WellKnownTypeUseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WellKnownTypeUseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.github.mscheong01.rpc.Rpc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WellKnownTypeUseService");
    }
  }

  private static final class WellKnownTypeUseServiceFileDescriptorSupplier
      extends WellKnownTypeUseServiceBaseDescriptorSupplier {
    WellKnownTypeUseServiceFileDescriptorSupplier() {}
  }

  private static final class WellKnownTypeUseServiceMethodDescriptorSupplier
      extends WellKnownTypeUseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WellKnownTypeUseServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (WellKnownTypeUseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WellKnownTypeUseServiceFileDescriptorSupplier())
              .addMethod(getEchoEmptyMethod())
              .addMethod(getEchoStringMethod())
              .addMethod(getEchoBytesMethod())
              .addMethod(getEchoInt32Method())
              .addMethod(getEchoInt64Method())
              .addMethod(getEchoUInt32Method())
              .addMethod(getEchoUInt64Method())
              .addMethod(getEchoFloatMethod())
              .addMethod(getEchoDoubleMethod())
              .addMethod(getEchoBoolMethod())
              .addMethod(getEchoTimestampMethod())
              .addMethod(getEchoDurationMethod())
              .addMethod(getEchoStructMethod())
              .addMethod(getEchoAnyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
