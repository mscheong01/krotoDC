package com.github.mscheong01.wellknowntypes.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import java.time.Duration
import java.time.LocalDateTime
import kotlin.String
import kotlin.collections.Map

@KrotoDC(forProto = com.github.mscheong01.wellknowntypes.MapTimeMessage::class)
public data class MapTimeMessage(
  public val timestamp: Map<String, LocalDateTime> = mapOf(),
  public val duration: Map<String, Duration> = mapOf(),
)
