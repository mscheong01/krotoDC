// Copyright 2024 Minsoo Cheong
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

import com.example.defaultvaluestest.krotodc.DefaultValueNestedMessage
import com.example.defaultvaluestest.krotodc.DefaultValueTest
import com.example.defaultvaluestest.krotodc.defaultvaluetest.toJson
import io.github.mscheong01.test.Person
import io.github.mscheong01.test.krotodc.person.fromJson
import io.github.mscheong01.test.krotodc.person.toDataClass
import io.github.mscheong01.test.krotodc.person.toJson
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class JsonConverterTest {

    @Test
    fun `test simple message`() {
        val proto = Person.newBuilder()
            .setName("John")
            .setAge(30)
            .build()
        val dataClass = proto.toDataClass()
        val json = dataClass.toJson()
        Assertions.assertThat(json).isEqualTo(
            "{\n  \"name\": \"John\",\n  \"age\": 30\n}"
        )
        val deserializedDataClass = io.github.mscheong01.test.krotodc.Person.fromJson(json)
        Assertions.assertThat(dataClass).isEqualTo(deserializedDataClass)
    }

    @Test
    fun `test including default values in toJson call`() {
        val proto = DefaultValueTest(
            intField = 0,
            stringList = emptyList(),
            defaultValueNestedMessage = DefaultValueNestedMessage(
                doubleField = 31.08,
                booleanField = false
            )
        )
        val json = proto.toJson(includeDefaultValues = true)
        Assertions.assertThat(json).isEqualTo(
            "{\"intField\":0,\"stringList\":[],\"defaultValueNestedMessage\":{\"doubleField\":31.08,\"booleanField\":false}}"
        )
    }
}
