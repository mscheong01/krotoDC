package com.github.mscheong01.importtest.krotodc.importtestmessage

import com.github.mscheong01.importtest.ImportFromOtherFileTest
import com.github.mscheong01.importtest.krotodc.ImportTestMessage
import com.github.mscheong01.krotodc.KrotoDCConverter
import com.github.mscheong01.test.krotodc.person.toDataClass
import com.github.mscheong01.test.krotodc.person.toProto
import com.github.mscheong01.test.krotodc.toplevelmessage.toDataClass
import com.github.mscheong01.test.krotodc.toplevelmessage.toProto

/**
 * Converts [ImportFromOtherFileTest.ImportTestMessage] to [ImportTestMessage]
 */
@KrotoDCConverter(
  from = ImportFromOtherFileTest.ImportTestMessage::class,
  to = ImportTestMessage::class,
)
public fun ImportFromOtherFileTest.ImportTestMessage.toDataClass(): ImportTestMessage =
    ImportTestMessage(importedNestedMessage = importedNestedMessage.toDataClass(),
importedPerson = importedPerson.toDataClass(),
)

/**
 * Converts [ImportTestMessage] to [ImportFromOtherFileTest.ImportTestMessage]
 */
@KrotoDCConverter(
  from = ImportTestMessage::class,
  to = ImportFromOtherFileTest.ImportTestMessage::class,
)
public fun ImportTestMessage.toProto(): ImportFromOtherFileTest.ImportTestMessage =
    ImportFromOtherFileTest.ImportTestMessage.newBuilder()
.apply {
  setImportedNestedMessage(this@toProto.importedNestedMessage.toProto())
  setImportedPerson(this@toProto.importedPerson.toProto())
}
.build()
