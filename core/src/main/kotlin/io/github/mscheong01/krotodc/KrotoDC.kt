package io.github.mscheong01.krotodc

import com.google.protobuf.GeneratedMessage
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
annotation class KrotoDC(
    val forProto: KClass<out GeneratedMessage>
)
