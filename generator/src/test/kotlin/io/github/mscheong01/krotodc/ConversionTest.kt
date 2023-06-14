// Copyright 2023 Minsoo Cheong
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package io.github.mscheong01.krotodc

import com.example.importtest.OuterClassNameTestProto
import com.google.protobuf.ByteString
import io.github.mscheong01.importtest.ImportFromOtherFileTest.ImportTestMessage
import io.github.mscheong01.importtest.krotodc.importtestmessage.toDataClass
import io.github.mscheong01.importtest.krotodc.importtestmessage.toProto
import io.github.mscheong01.test.DeprecatedMessage
import io.github.mscheong01.test.Employee
import io.github.mscheong01.test.EmptyMessage
import io.github.mscheong01.test.Job
import io.github.mscheong01.test.MapMessage
import io.github.mscheong01.test.OneOfMessage
import io.github.mscheong01.test.OptionalMessage
import io.github.mscheong01.test.Person
import io.github.mscheong01.test.PrimitiveMessage
import io.github.mscheong01.test.RepeatedMessage
import io.github.mscheong01.test.TopLevelMessage
import io.github.mscheong01.test.krotodc.deprecatedmessage.toDataClass
import io.github.mscheong01.test.krotodc.employee.toDataClass
import io.github.mscheong01.test.krotodc.employee.toProto
import io.github.mscheong01.test.krotodc.emptymessage.toDataClass
import io.github.mscheong01.test.krotodc.emptymessage.toProto
import io.github.mscheong01.test.krotodc.mapmessage.toDataClass
import io.github.mscheong01.test.krotodc.mapmessage.toProto
import io.github.mscheong01.test.krotodc.oneofmessage.toDataClass
import io.github.mscheong01.test.krotodc.oneofmessage.toProto
import io.github.mscheong01.test.krotodc.optionalmessage.toDataClass
import io.github.mscheong01.test.krotodc.optionalmessage.toProto
import io.github.mscheong01.test.krotodc.person.toDataClass
import io.github.mscheong01.test.krotodc.person.toProto
import io.github.mscheong01.test.krotodc.primitivemessage.toDataClass
import io.github.mscheong01.test.krotodc.primitivemessage.toProto
import io.github.mscheong01.test.krotodc.repeatedmessage.toDataClass
import io.github.mscheong01.test.krotodc.repeatedmessage.toProto
import io.github.mscheong01.test.krotodc.toplevelmessage.toDataClass
import io.github.mscheong01.test.krotodc.toplevelmessage.toProto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.util.Map.entry

class ConversionTest {

    @Test
    fun `test simple message`() {
        val proto = Person.newBuilder()
            .setName("John")
            .setAge(30)
            .build()
        val kroto = proto.toDataClass()
        Assertions.assertThat(kroto.name).isEqualTo("John")
        Assertions.assertThat(kroto.age).isEqualTo(30)
        val proto2 = kroto.toProto()
        Assertions.assertThat(proto2.name).isEqualTo("John")
        Assertions.assertThat(proto2.age).isEqualTo(30)
        Assertions.assertThat(proto2).isEqualTo(proto)
    }

    @Test
    fun `test message with enum`() {
        val proto = Employee.newBuilder()
            .setName("John")
            .setAge(30)
            .setJob(Job.ENGINEER)
            .build()
        val kroto = proto.toDataClass()
        Assertions.assertThat(kroto.name).isEqualTo("John")
        Assertions.assertThat(kroto.age).isEqualTo(30)
        Assertions.assertThat(kroto.job).isEqualTo(Job.ENGINEER)
        val proto2 = kroto.toProto()
        Assertions.assertThat(proto2.name).isEqualTo("John")
        Assertions.assertThat(proto2.age).isEqualTo(30)
        Assertions.assertThat(proto2.job).isEqualTo(Job.ENGINEER)
        Assertions.assertThat(proto2).isEqualTo(proto)
    }

    @Test
    fun `test message with nested types`() {
        val proto = TopLevelMessage.newBuilder()
            .setNestedMessage(TopLevelMessage.NestedMessage.newBuilder().setName("John").build())
            .setNestedEnum(TopLevelMessage.NestedEnum.A)
            .build()
        val kroto = proto.toDataClass()
        Assertions.assertThat(kroto.nestedMessage.name).isEqualTo("John")
        Assertions.assertThat(kroto.nestedEnum).isEqualTo(TopLevelMessage.NestedEnum.A)
        val proto2 = kroto.toProto()
        Assertions.assertThat(proto2.nestedMessage.name).isEqualTo("John")
        Assertions.assertThat(proto2.nestedEnum).isEqualTo(TopLevelMessage.NestedEnum.A)
        Assertions.assertThat(proto2).isEqualTo(proto)
    }

    @Test
    fun `test message with all primitive types`() {
        val proto = PrimitiveMessage.newBuilder()
            .setInt32Field(1).setInt64Field(2).setUint32Field(3).setUint64Field(4).setSint32Field(5)
            .setSint64Field(6).setFixed32Field(7).setFixed64Field(8).setSfixed32Field(9)
            .setSfixed64Field(10).setFloatField(11.0f).setDoubleField(12.0).setBoolField(true)
            .setStringField("13").setBytesField(ByteString.copyFromUtf8("14")).build()
        val kroto = proto.toDataClass()
        Assertions.assertThat(kroto.int32Field).isEqualTo(1)
        Assertions.assertThat(kroto.int64Field).isEqualTo(2)
        Assertions.assertThat(kroto.uint32Field).isEqualTo(3)
        Assertions.assertThat(kroto.uint64Field).isEqualTo(4)
        Assertions.assertThat(kroto.sint32Field).isEqualTo(5)
        Assertions.assertThat(kroto.sint64Field).isEqualTo(6)
        Assertions.assertThat(kroto.fixed32Field).isEqualTo(7)
        Assertions.assertThat(kroto.fixed64Field).isEqualTo(8)
        Assertions.assertThat(kroto.sfixed32Field).isEqualTo(9)
        Assertions.assertThat(kroto.sfixed64Field).isEqualTo(10)
        Assertions.assertThat(kroto.floatField).isEqualTo(11.0f)
        Assertions.assertThat(kroto.doubleField).isEqualTo(12.0)
        Assertions.assertThat(kroto.boolField).isEqualTo(true)
        Assertions.assertThat(kroto.stringField).isEqualTo("13")
        Assertions.assertThat(kroto.bytesField).isEqualTo(ByteString.copyFromUtf8("14"))
        val proto2 = kroto.toProto()
        Assertions.assertThat(proto2.int32Field).isEqualTo(1)
        Assertions.assertThat(proto2.int64Field).isEqualTo(2)
        Assertions.assertThat(proto2.uint32Field).isEqualTo(3)
        Assertions.assertThat(proto2.uint64Field).isEqualTo(4)
        Assertions.assertThat(proto2.sint32Field).isEqualTo(5)
        Assertions.assertThat(proto2.sint64Field).isEqualTo(6)
        Assertions.assertThat(proto2.fixed32Field).isEqualTo(7)
        Assertions.assertThat(proto2.fixed64Field).isEqualTo(8)
        Assertions.assertThat(proto2.sfixed32Field).isEqualTo(9)
        Assertions.assertThat(proto2.sfixed64Field).isEqualTo(10)
        Assertions.assertThat(proto2.floatField).isEqualTo(11.0f)
        Assertions.assertThat(proto2.doubleField).isEqualTo(12.0)
        Assertions.assertThat(proto2.boolField).isEqualTo(true)
        Assertions.assertThat(proto2.stringField).isEqualTo("13")
        Assertions.assertThat(proto2.bytesField).isEqualTo(ByteString.copyFromUtf8("14"))
        Assertions.assertThat(proto2).isEqualTo(proto)
    }

    @Test
    fun `test message with repeated fields`() {
        val proto = RepeatedMessage.newBuilder()
            .addAllRepeatedString(listOf("1", "2", "3"))
            .addAllRepeatedJob(listOf(Job.ENGINEER, Job.PRODUCT_MANAGER))
            .addAllRepeatedPerson(
                listOf(
                    Person.newBuilder().setName("John").setAge(30).build(),
                    Person.newBuilder().setName("Jane").setAge(25).build()
                )
            )
            .build()
        val kroto = proto.toDataClass()
        Assertions.assertThat(kroto.repeatedString).containsExactly("1", "2", "3")
        Assertions.assertThat(kroto.repeatedJob).containsExactly(Job.ENGINEER, Job.PRODUCT_MANAGER)
        Assertions.assertThat(kroto.repeatedPerson).containsExactly(
            io.github.mscheong01.test.krotodc.Person(name = "John", age = 30),
            io.github.mscheong01.test.krotodc.Person(name = "Jane", age = 25)
        )
        val proto2 = kroto.toProto()
        Assertions.assertThat(proto2.repeatedStringList).containsExactly("1", "2", "3")
        Assertions.assertThat(proto2.repeatedJobList).containsExactly(Job.ENGINEER, Job.PRODUCT_MANAGER)
        Assertions.assertThat(proto2.repeatedPersonList).containsExactly(
            Person.newBuilder().setName("John").setAge(30).build(),
            Person.newBuilder().setName("Jane").setAge(25).build()
        )
        Assertions.assertThat(proto2).isEqualTo(proto)
    }

    @Test
    fun `test message with map fields`() {
        val proto = MapMessage.newBuilder()
            .putAllMapStringString(mapOf("1" to "2", "3" to "4"))
            .putAllMapStringPerson(mapOf("5" to Person.newBuilder().setName("John").setAge(30).build()))
            .putAllMapIntJob(mapOf(6 to Job.ENGINEER, 7 to Job.PRODUCT_MANAGER))
            .build()
        val kroto = proto.toDataClass()
        Assertions.assertThat(kroto.mapStringString).contains(entry("1", "2"), entry("3", "4"))
        Assertions.assertThat(kroto.mapStringPerson).contains(
            entry("5", io.github.mscheong01.test.krotodc.Person(name = "John", age = 30))
        )
        Assertions.assertThat(kroto.mapIntJob)
            .contains(entry(6, Job.ENGINEER), entry(7, Job.PRODUCT_MANAGER))
        val proto2 = kroto.toProto()
        Assertions.assertThat(proto2).isEqualTo(proto)
    }

    @Test
    fun `test message with optional fields`() {
        val proto = OptionalMessage.newBuilder()
            .setOptionalInt(1)
            .setOptionalPerson(Person.newBuilder().setName("John").setAge(30).build())
            .setOptionalString("2")
            .build()
        val kroto = proto.toDataClass()
        Assertions.assertThat(kroto.optionalInt).isEqualTo(1)
        Assertions.assertThat(kroto.optionalPerson).isEqualTo(
            io.github.mscheong01.test.krotodc.Person(name = "John", age = 30)
        )
        Assertions.assertThat(kroto.optionalString).isEqualTo("2")
        val proto2 = kroto.toProto()
        Assertions.assertThat(proto2.optionalInt).isEqualTo(1)
        Assertions.assertThat(proto2.optionalPerson).isEqualTo(
            Person.newBuilder().setName("John").setAge(30).build()
        )
        Assertions.assertThat(proto2.optionalString).isEqualTo("2")

        val unsetProto = OptionalMessage.newBuilder().build()
        val unsetKroto = unsetProto.toDataClass()
        Assertions.assertThat(unsetKroto.optionalInt).isNull()
        Assertions.assertThat(unsetKroto.optionalPerson).isNull()
        Assertions.assertThat(unsetKroto.optionalString).isNull()
        Assertions.assertThat(proto2).isEqualTo(proto)
    }

    @Test
    fun `test message with oneof fields`() {
        val personSetOneofProto = OneOfMessage.newBuilder()
            .setOneofPerson(Person.newBuilder().setName("John").setAge(30).build())
            .build()
        val kroto = personSetOneofProto.toDataClass()
        Assertions.assertThat(kroto.oneofField)
            .isInstanceOf(io.github.mscheong01.test.krotodc.OneOfMessage.OneofField.OneofPerson::class.java)
        Assertions.assertThat(
            kroto.oneofField as io.github.mscheong01.test.krotodc.OneOfMessage.OneofField.OneofPerson
        )
            .isEqualTo(
                io.github.mscheong01.test.krotodc.OneOfMessage.OneofField.OneofPerson(
                    io.github.mscheong01.test.krotodc.Person(name = "John", age = 30)
                )
            )
        val personSetOneofProto2 = kroto.toProto()
        Assertions.assertThat(personSetOneofProto2.oneofPerson).isEqualTo(
            Person.newBuilder().setName("John").setAge(30).build()
        )
        Assertions.assertThat(personSetOneofProto2.oneofFieldCase)
            .isEqualTo(OneOfMessage.OneofFieldCase.ONEOF_PERSON)

        val stringSetOneofProto = OneOfMessage.newBuilder()
            .setOneofString("1")
            .build()
        val kroto2 = stringSetOneofProto.toDataClass()
        Assertions.assertThat(kroto2.oneofField)
            .isInstanceOf(io.github.mscheong01.test.krotodc.OneOfMessage.OneofField.OneofString::class.java)
        Assertions.assertThat(
            kroto2.oneofField as io.github.mscheong01.test.krotodc.OneOfMessage.OneofField.OneofString
        )
            .isEqualTo(io.github.mscheong01.test.krotodc.OneOfMessage.OneofField.OneofString("1"))
        val stringSetOneofProto2 = kroto2.toProto()
        Assertions.assertThat(stringSetOneofProto2.oneofString).isEqualTo("1")
        Assertions.assertThat(stringSetOneofProto2.oneofFieldCase)
            .isEqualTo(OneOfMessage.OneofFieldCase.ONEOF_STRING)

        val unsetOneofProto = OneOfMessage.newBuilder().build()
        val unsetKroto = unsetOneofProto.toDataClass()
        Assertions.assertThat(unsetKroto.oneofField).isNull()
        val unsetOneofProto2 = unsetKroto.toProto()
        Assertions.assertThat(unsetOneofProto2.oneofFieldCase)
            .isEqualTo(OneOfMessage.OneofFieldCase.ONEOFFIELD_NOT_SET)
        Assertions.assertThat(unsetOneofProto2).isEqualTo(unsetOneofProto)
    }

    @Test
    fun `test message without any fields`() {
        val proto = EmptyMessage.newBuilder().build()
        val kroto = proto.toDataClass()
        Assertions.assertThat(kroto).isNotNull
        val proto2 = kroto.toProto()
        Assertions.assertThat(proto2).isNotNull
        Assertions.assertThat(proto2).isEqualTo(proto)
    }

    @Test
    fun `test message with deprecated fields`() {
        val proto = DeprecatedMessage.newBuilder()
            .setName("1")
            .setOneofString("2")
            .build()
        val kroto = proto.toDataClass()
        Assertions.assertThat(kroto::name.annotations)
            .anyMatch { it is Deprecated }
        Assertions.assertThat(kroto.oneofField!!::class.annotations)
            .anyMatch { it is Deprecated }
    }

    @Test
    fun `test message with imported type field`() {
        val proto = ImportTestMessage.newBuilder()
            .setImportedNestedMessage(TopLevelMessage.NestedMessage.newBuilder().setName("test").build())
            .setImportedPerson(Person.newBuilder().setName("John").setAge(30).build())
            .setImportedSimpleMessage(OuterClassNameTestProto.SimpleMessage.newBuilder().setName("test").build())
            .build()
        val kroto = proto.toDataClass()
        Assertions.assertThat(kroto.importedNestedMessage).isEqualTo(
            io.github.mscheong01.test.krotodc.TopLevelMessage.NestedMessage(name = "test")
        )
        Assertions.assertThat(kroto.importedPerson).isEqualTo(
            io.github.mscheong01.test.krotodc.Person(name = "John", age = 30)
        )
        val proto2 = kroto.toProto()
        Assertions.assertThat(proto2).isEqualTo(proto)
    }
}
