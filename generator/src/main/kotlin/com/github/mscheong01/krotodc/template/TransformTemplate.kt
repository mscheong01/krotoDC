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
package com.github.mscheong01.krotodc.template

import com.squareup.kotlinpoet.CodeBlock

/**
 * A Transform Template is a kotlin poet string template that transforms a KrotoDC type to Protobuf Java type, or vice versa.
 * The template is a string that contains single or no placeholder (%L), which is the input.
 * This behavior is validated on instantiation.
 *
 * Example:
 * ```
 * val transformTemplate = TransformTemplate("%L.toProto()")
 * val input = CodeBlock.of("java.time.LocalDateTime.now()")
 * val output = transformTemplate.safeCall(input)
 * // output == CodeBlock.of("java.time.LocalDateTime.now().toProto()")
 * ```
 */
@JvmInline
value class TransformTemplate(val value: String) {
    init {
        require(value.count { it == '%' } <= 1) {
            "TransformTemplate must contain single or no placeholder"
        }
        require(value.count { it == '%' } == 0 || value.contains("%L")) {
            "TransformTemplate must only containe the (%L) placeholder"
        }
    }
    fun safeCall(input: CodeBlock): CodeBlock = if (value.contains("%L")) {
        CodeBlock.of(value, input)
    } else {
        CodeBlock.of(value)
    }
    fun safeCall(input: String): CodeBlock = safeCall(CodeBlock.of(input))
}
