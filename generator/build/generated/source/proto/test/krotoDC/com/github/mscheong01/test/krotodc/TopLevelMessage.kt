package com.github.mscheong01.test.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import com.github.mscheong01.test.TopLevelMessage.NestedEnum
import kotlin.String

@KrotoDC(forProto = com.github.mscheong01.test.TopLevelMessage::class)
public data class TopLevelMessage(
  public val name: String = "",
  public val nestedMessage: NestedMessage =
      com.github.mscheong01.test.krotodc.TopLevelMessage.NestedMessage(),
  public val nestedEnum: com.github.mscheong01.test.TopLevelMessage.NestedEnum =
      com.github.mscheong01.test.TopLevelMessage.NestedEnum.values()[0],
) {
  @KrotoDC(forProto = com.github.mscheong01.test.TopLevelMessage.NestedMessage::class)
  public data class NestedMessage(
    public val name: String = "",
  )
}
