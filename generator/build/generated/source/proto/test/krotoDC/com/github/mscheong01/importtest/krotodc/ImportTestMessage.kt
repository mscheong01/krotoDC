package com.github.mscheong01.importtest.krotodc

import com.github.mscheong01.krotodc.KrotoDC
import com.github.mscheong01.test.krotodc.Person
import com.github.mscheong01.test.krotodc.TopLevelMessage

@KrotoDC(forProto =
    com.github.mscheong01.importtest.ImportFromOtherFileTest.ImportTestMessage::class)
public data class ImportTestMessage(
  public val importedNestedMessage: TopLevelMessage.NestedMessage =
      com.github.mscheong01.test.krotodc.TopLevelMessage.NestedMessage(),
  public val importedPerson: Person = com.github.mscheong01.test.krotodc.Person(),
)
