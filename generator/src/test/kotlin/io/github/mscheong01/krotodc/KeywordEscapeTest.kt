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

import io.github.mscheong01.keyword.KeywordMessage
import io.github.mscheong01.keyword.ProtobufJavaEscapedFieldMessage
import io.github.mscheong01.keyword.ProtobufJavaEscapedMapMessage
import io.github.mscheong01.keyword.ProtobufJavaEscapedOneOfFieldMessage
import io.github.mscheong01.keyword.ProtobufJavaEscapedOneOfMessage
import io.github.mscheong01.keyword.ProtobufJavaEscapedRepeatedMessage
import io.github.mscheong01.keyword.krotodc.keywordmessage.toDataClass
import io.github.mscheong01.keyword.krotodc.keywordmessage.toProto
import io.github.mscheong01.keyword.krotodc.protobufjavaescapedfieldmessage.toDataClass
import io.github.mscheong01.keyword.krotodc.protobufjavaescapedfieldmessage.toProto
import io.github.mscheong01.keyword.krotodc.protobufjavaescapedmapmessage.toDataClass
import io.github.mscheong01.keyword.krotodc.protobufjavaescapedmapmessage.toProto
import io.github.mscheong01.keyword.krotodc.protobufjavaescapedoneoffieldmessage.toDataClass
import io.github.mscheong01.keyword.krotodc.protobufjavaescapedoneoffieldmessage.toProto
import io.github.mscheong01.keyword.krotodc.protobufjavaescapedoneofmessage.toDataClass
import io.github.mscheong01.keyword.krotodc.protobufjavaescapedoneofmessage.toProto
import io.github.mscheong01.keyword.krotodc.protobufjavaescapedrepeatedmessage.toDataClass
import io.github.mscheong01.keyword.krotodc.protobufjavaescapedrepeatedmessage.toProto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class KeywordEscapeTest {

    /**
     * message KeywordMessage {
     *   string in = 1;
     *   string fun = 2;
     *   string if = 3;
     *   string object = 4;
     *   oneof as {
     *     string typeof = 6;
     *     string while = 7;
     *   }
     *   repeated string for = 8;
     *   map<string, string> else = 9;
     *   string public = 10;
     *   string package = 11;
     * }
     */
    @Test
    fun someKotlinKeywordEscape() {
        val proto1 = KeywordMessage.newBuilder()
            .setIn("in")
            .setFun("fun")
            .setIf("if")
            .setObject("object")
            .setTypeof("typeof")
            .addAllFor(listOf("for1", "for2"))
            .putAllElse(mapOf("else1" to "else2"))
            .setPublic("public")
            .setPackage("package")
            .build()
        val dataClass = proto1.toDataClass()
        val proto2 = dataClass.toProto()
        Assertions.assertThat(proto1).isEqualTo(proto2)
    }

    /**
     * message ProtobufJavaEscapedFieldMessage {
     *   string class = 1;
     * }
     */
    @Test
    fun ProtobufJavaEscapedFieldTest() {
        val proto1 = ProtobufJavaEscapedFieldMessage.newBuilder()
            .setClass_("class")
            .build()
        val dataClass = proto1.toDataClass()
        val proto2 = dataClass.toProto()
        Assertions.assertThat(proto1).isEqualTo(proto2)
    }

    /**
     * message ProtobufJavaEscapedRepeatedMessage {
     *   repeated string class = 1;
     * }
     */
    @Test
    fun ProtobufJavaEscapedRepeatedTest() {
        val proto1 = ProtobufJavaEscapedRepeatedMessage.newBuilder()
            .addClass_("class1")
            .addClass_("class2")
            .addAllClass_(listOf("class3", "class4"))
            .build()
        val dataClass = proto1.toDataClass()
        val proto2 = dataClass.toProto()
        Assertions.assertThat(proto1).isEqualTo(proto2)
    }

    /**
     * message ProtobufJavaEscapedMapMessage {
     *   map<string, string> class = 1;
     * }
     */
    @Test
    fun ProtobufJavaEscapedMapTest() {
        val proto1 = ProtobufJavaEscapedMapMessage.newBuilder()
            .putClass_("class1", "class2")
            .putClass_("class3", "class4")
            .putAllClass_(mapOf("class5" to "class6"))
            .build()
        val dataClass = proto1.toDataClass()
        val proto2 = dataClass.toProto()
        Assertions.assertThat(proto1).isEqualTo(proto2)
    }

    /**
     * message ProtobufJavaEscapedOneOfMessage {
     *   oneof class {
     *     string name = 1;
     *   }
     * }
     */
    @Test
    fun ProtobufJavaEscapedOneOfTest() {
        val proto1 = ProtobufJavaEscapedOneOfMessage.newBuilder()
            .setName("name")
            .build()
        val dataClass = proto1.toDataClass()
        val proto2 = dataClass.toProto()
        Assertions.assertThat(proto1).isEqualTo(proto2)
    }

    /**
     * message ProtobufJavaEscapedOneOfFieldMessage {
     *   oneof name {
     *     string class = 1;
     *   }
     * }
     */
    @Test
    fun ProtobufJavaEscapedOneOfFieldTest() {
        val proto1 = ProtobufJavaEscapedOneOfFieldMessage.newBuilder()
            .setClass_("class")
            .build()
        val dataClass = proto1.toDataClass()
        val proto2 = dataClass.toProto()
        Assertions.assertThat(proto1).isEqualTo(proto2)
    }
}
