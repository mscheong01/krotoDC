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
package io.github.mscheong01.krotodc.import

import com.squareup.kotlinpoet.FunSpec

data class FunSpecsWithImports(
    val funSpecs: List<FunSpec>,
    val imports: Set<Import> = setOf()
) {
    companion object {
        val EMPTY = FunSpecsWithImports(emptyList())
    }
}
