package com.github.mscheong01.krotodc

import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
annotation class KrotoDCConverter(
    val from: KClass<out Any>,
    val to: KClass<out Any>
)
