package com.github.mscheong01.wellknowntypes.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import java.time.Duration
import java.time.LocalDateTime

@KrotoDC(forProto = com.github.mscheong01.wellknowntypes.TimeMessage::class)
public data class TimeMessage(
  public val timestamp: LocalDateTime = LocalDateTime.MIN,
  public val duration: Duration = java.time.Duration.ZERO,
)
