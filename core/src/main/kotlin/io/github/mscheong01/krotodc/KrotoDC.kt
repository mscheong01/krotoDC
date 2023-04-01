package io.github.mscheong01.krotodc

import com.google.protobuf.GeneratedMessageV3
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
annotation class KrotoDC(
    val forProto: KClass<out GeneratedMessageV3>
)
