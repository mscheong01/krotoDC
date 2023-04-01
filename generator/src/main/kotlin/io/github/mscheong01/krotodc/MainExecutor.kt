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

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest
import java.io.IOException

object MainExecutor {
    @JvmStatic
    fun main(args: Array<String>) {
        val request = try {
            CodeGeneratorRequest.parseFrom(System.`in`)
        } catch (e: Throwable) {
            throw IOException("Error occurred while parsing CodeGeneratorRequest for krotoDC", e)
        }
        try {
            KrotoDCCodeGenerator.generateCode(request)
        } catch (e: Throwable) {
            throw IOException("Error occurred while generating code through krotoDC", e)
        }
    }
}
