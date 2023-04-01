package com.github.mscheong01.wellknowntypes.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import java.time.Duration
import java.time.LocalDateTime
import kotlin.collections.List

@KrotoDC(forProto = com.github.mscheong01.wellknowntypes.RepeatedTimeMessage::class)
public data class RepeatedTimeMessage(
  public val timestamp: List<LocalDateTime> = listOf(),
  public val duration: List<Duration> = listOf(),
)
