package com.github.mscheong01.rpc.krotodc

import com.github.mscheong01.krotodc.toBoolValue
import com.github.mscheong01.krotodc.toBytesValue
import com.github.mscheong01.krotodc.toDoubleValue
import com.github.mscheong01.krotodc.toDuration
import com.github.mscheong01.krotodc.toFloatValue
import com.github.mscheong01.krotodc.toInt32Value
import com.github.mscheong01.krotodc.toInt64Value
import com.github.mscheong01.krotodc.toLocalDateTime
import com.github.mscheong01.krotodc.toProtoDuration
import com.github.mscheong01.krotodc.toProtoTimestamp
import com.github.mscheong01.krotodc.toStringValue
import com.github.mscheong01.krotodc.toUInt32Value
import com.github.mscheong01.krotodc.toUInt64Value
import com.github.mscheong01.rpc.WellKnownTypeUseServiceGrpc
import com.github.mscheong01.rpc.WellKnownTypeUseServiceGrpc.getServiceDescriptor
import com.google.protobuf.Any
import com.google.protobuf.ByteString
import com.google.protobuf.Empty
import com.google.protobuf.Struct
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
import io.grpc.kotlin.ClientCalls
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import java.time.Duration
import java.time.LocalDateTime
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

public object WellKnownTypeUseServiceGrpcKroto {
  public abstract class WellKnownTypeUseServiceCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    public open suspend fun echoEmpty(request: Unit): Unit = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.rpc.WellKnownTypeUseService.EchoEmpty is unimplemented"))

    public open suspend fun echoString(request: String): String = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.rpc.WellKnownTypeUseService.EchoString is unimplemented"))

    public open suspend fun echoBytes(request: ByteString): ByteString = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.rpc.WellKnownTypeUseService.EchoBytes is unimplemented"))

    public open suspend fun echoInt32(request: Int): Int = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.rpc.WellKnownTypeUseService.EchoInt32 is unimplemented"))

    public open suspend fun echoInt64(request: Long): Long = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.rpc.WellKnownTypeUseService.EchoInt64 is unimplemented"))

    public open suspend fun echoUInt32(request: Int): Int = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.rpc.WellKnownTypeUseService.EchoUInt32 is unimplemented"))

    public open suspend fun echoUInt64(request: Long): Long = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.rpc.WellKnownTypeUseService.EchoUInt64 is unimplemented"))

    public open suspend fun echoFloat(request: Float): Float = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.rpc.WellKnownTypeUseService.EchoFloat is unimplemented"))

    public open suspend fun echoDouble(request: Double): Double = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.rpc.WellKnownTypeUseService.EchoDouble is unimplemented"))

    public open suspend fun echoBool(request: Boolean): Boolean = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.rpc.WellKnownTypeUseService.EchoBool is unimplemented"))

    public open suspend fun echoTimestamp(request: LocalDateTime): LocalDateTime = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.rpc.WellKnownTypeUseService.EchoTimestamp is unimplemented"))

    public open suspend fun echoDuration(request: Duration): Duration = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.rpc.WellKnownTypeUseService.EchoDuration is unimplemented"))

    public open suspend fun echoStruct(request: Struct): Struct = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.rpc.WellKnownTypeUseService.EchoStruct is unimplemented"))

    public open suspend fun echoAny(request: Any): Any = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.example.rpc.WellKnownTypeUseService.EchoAny is unimplemented"))

    public final override fun bindService(): ServerServiceDefinition =
        builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
        context = this.context,
        descriptor = WellKnownTypeUseServiceGrpc.getEchoEmptyMethod(),
        implementation = { request ->
        echoEmpty(Unit).let { Empty.getDefaultInstance() }
    },
    ))
      .addMethod(unaryServerMethodDefinition(
        context = this.context,
        descriptor = WellKnownTypeUseServiceGrpc.getEchoStringMethod(),
        implementation = { request ->
        echoString(request.value).let { it.toStringValue() }
    },
    ))
      .addMethod(unaryServerMethodDefinition(
        context = this.context,
        descriptor = WellKnownTypeUseServiceGrpc.getEchoBytesMethod(),
        implementation = { request ->
        echoBytes(request.value).let { it.toBytesValue() }
    },
    ))
      .addMethod(unaryServerMethodDefinition(
        context = this.context,
        descriptor = WellKnownTypeUseServiceGrpc.getEchoInt32Method(),
        implementation = { request ->
        echoInt32(request.value).let { it.toInt32Value() }
    },
    ))
      .addMethod(unaryServerMethodDefinition(
        context = this.context,
        descriptor = WellKnownTypeUseServiceGrpc.getEchoInt64Method(),
        implementation = { request ->
        echoInt64(request.value).let { it.toInt64Value() }
    },
    ))
      .addMethod(unaryServerMethodDefinition(
        context = this.context,
        descriptor = WellKnownTypeUseServiceGrpc.getEchoUInt32Method(),
        implementation = { request ->
        echoUInt32(request.value).let { it.toUInt32Value() }
    },
    ))
      .addMethod(unaryServerMethodDefinition(
        context = this.context,
        descriptor = WellKnownTypeUseServiceGrpc.getEchoUInt64Method(),
        implementation = { request ->
        echoUInt64(request.value).let { it.toUInt64Value() }
    },
    ))
      .addMethod(unaryServerMethodDefinition(
        context = this.context,
        descriptor = WellKnownTypeUseServiceGrpc.getEchoFloatMethod(),
        implementation = { request ->
        echoFloat(request.value).let { it.toFloatValue() }
    },
    ))
      .addMethod(unaryServerMethodDefinition(
        context = this.context,
        descriptor = WellKnownTypeUseServiceGrpc.getEchoDoubleMethod(),
        implementation = { request ->
        echoDouble(request.value).let { it.toDoubleValue() }
    },
    ))
      .addMethod(unaryServerMethodDefinition(
        context = this.context,
        descriptor = WellKnownTypeUseServiceGrpc.getEchoBoolMethod(),
        implementation = { request ->
        echoBool(request.value).let { it.toBoolValue() }
    },
    ))
      .addMethod(unaryServerMethodDefinition(
        context = this.context,
        descriptor = WellKnownTypeUseServiceGrpc.getEchoTimestampMethod(),
        implementation = { request ->
        echoTimestamp(request.toLocalDateTime()).let { it.toProtoTimestamp() }
    },
    ))
      .addMethod(unaryServerMethodDefinition(
        context = this.context,
        descriptor = WellKnownTypeUseServiceGrpc.getEchoDurationMethod(),
        implementation = { request ->
        echoDuration(request.toDuration()).let { it.toProtoDuration() }
    },
    ))
      .addMethod(unaryServerMethodDefinition(
        context = this.context,
        descriptor = WellKnownTypeUseServiceGrpc.getEchoStructMethod(),
        implementation = { request ->
        echoStruct(request).let { it }
    },
    ))
      .addMethod(unaryServerMethodDefinition(
        context = this.context,
        descriptor = WellKnownTypeUseServiceGrpc.getEchoAnyMethod(),
        implementation = { request ->
        echoAny(request).let { it }
    },
    )).build()
  }

  public class WellKnownTypeUseServiceCoroutineStub(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<WellKnownTypeUseServiceCoroutineStub>(channel, callOptions) {
    public suspend fun echoEmpty(request: Unit, metadata: Metadata = Metadata()): Unit {
      return unaryRpc(
              channel,
              WellKnownTypeUseServiceGrpc.getEchoEmptyMethod(),
              Empty.getDefaultInstance(),
              callOptions,
              metadata,
          ).let { Unit }
    }

    public suspend fun echoString(request: String, metadata: Metadata = Metadata()): String {
      return unaryRpc(
              channel,
              WellKnownTypeUseServiceGrpc.getEchoStringMethod(),
              request.toStringValue(),
              callOptions,
              metadata,
          ).let { it.value }
    }

    public suspend fun echoBytes(request: ByteString, metadata: Metadata = Metadata()): ByteString {
      return unaryRpc(
              channel,
              WellKnownTypeUseServiceGrpc.getEchoBytesMethod(),
              request.toBytesValue(),
              callOptions,
              metadata,
          ).let { it.value }
    }

    public suspend fun echoInt32(request: Int, metadata: Metadata = Metadata()): Int {
      return unaryRpc(
              channel,
              WellKnownTypeUseServiceGrpc.getEchoInt32Method(),
              request.toInt32Value(),
              callOptions,
              metadata,
          ).let { it.value }
    }

    public suspend fun echoInt64(request: Long, metadata: Metadata = Metadata()): Long {
      return unaryRpc(
              channel,
              WellKnownTypeUseServiceGrpc.getEchoInt64Method(),
              request.toInt64Value(),
              callOptions,
              metadata,
          ).let { it.value }
    }

    public suspend fun echoUInt32(request: Int, metadata: Metadata = Metadata()): Int {
      return unaryRpc(
              channel,
              WellKnownTypeUseServiceGrpc.getEchoUInt32Method(),
              request.toUInt32Value(),
              callOptions,
              metadata,
          ).let { it.value }
    }

    public suspend fun echoUInt64(request: Long, metadata: Metadata = Metadata()): Long {
      return unaryRpc(
              channel,
              WellKnownTypeUseServiceGrpc.getEchoUInt64Method(),
              request.toUInt64Value(),
              callOptions,
              metadata,
          ).let { it.value }
    }

    public suspend fun echoFloat(request: Float, metadata: Metadata = Metadata()): Float {
      return unaryRpc(
              channel,
              WellKnownTypeUseServiceGrpc.getEchoFloatMethod(),
              request.toFloatValue(),
              callOptions,
              metadata,
          ).let { it.value }
    }

    public suspend fun echoDouble(request: Double, metadata: Metadata = Metadata()): Double {
      return unaryRpc(
              channel,
              WellKnownTypeUseServiceGrpc.getEchoDoubleMethod(),
              request.toDoubleValue(),
              callOptions,
              metadata,
          ).let { it.value }
    }

    public suspend fun echoBool(request: Boolean, metadata: Metadata = Metadata()): Boolean {
      return unaryRpc(
              channel,
              WellKnownTypeUseServiceGrpc.getEchoBoolMethod(),
              request.toBoolValue(),
              callOptions,
              metadata,
          ).let { it.value }
    }

    public suspend fun echoTimestamp(request: LocalDateTime, metadata: Metadata = Metadata()):
        LocalDateTime {
      return unaryRpc(
              channel,
              WellKnownTypeUseServiceGrpc.getEchoTimestampMethod(),
              request.toProtoTimestamp(),
              callOptions,
              metadata,
          ).let { it.toLocalDateTime() }
    }

    public suspend fun echoDuration(request: Duration, metadata: Metadata = Metadata()): Duration {
      return unaryRpc(
              channel,
              WellKnownTypeUseServiceGrpc.getEchoDurationMethod(),
              request.toProtoDuration(),
              callOptions,
              metadata,
          ).let { it.toDuration() }
    }

    public suspend fun echoStruct(request: Struct, metadata: Metadata = Metadata()): Struct {
      return unaryRpc(
              channel,
              WellKnownTypeUseServiceGrpc.getEchoStructMethod(),
              request,
              callOptions,
              metadata,
          ).let { it }
    }

    public suspend fun echoAny(request: Any, metadata: Metadata = Metadata()): Any {
      return unaryRpc(
              channel,
              WellKnownTypeUseServiceGrpc.getEchoAnyMethod(),
              request,
              callOptions,
              metadata,
          ).let { it }
    }

    public override fun build(channel: Channel, callOptions: CallOptions):
        WellKnownTypeUseServiceCoroutineStub = WellKnownTypeUseServiceCoroutineStub(channel,
        callOptions)
  }
}
