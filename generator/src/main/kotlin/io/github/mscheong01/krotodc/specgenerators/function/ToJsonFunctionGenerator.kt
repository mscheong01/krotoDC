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
package io.github.mscheong01.krotodc.specgenerators.function

import com.google.protobuf.Descriptors.Descriptor
import com.squareup.kotlinpoet.FunSpec
import io.github.mscheong01.krotodc.import.FunSpecsWithImports
import io.github.mscheong01.krotodc.import.Import
import io.github.mscheong01.krotodc.specgenerators.FunSpecGenerator
import io.github.mscheong01.krotodc.util.krotoDCTypeName

class ToJsonFunctionGenerator : FunSpecGenerator<Descriptor> {
    override fun generate(descriptor: Descriptor): FunSpecsWithImports {
        val imports = mutableSetOf<Import>()
        val generatedType = descriptor.krotoDCTypeName
        val functionBuilder = FunSpec.builder("toJson")
            .receiver(generatedType)
            .returns(String::class)
        functionBuilder.addCode("return JsonFormat.printer().print(this@toJson.toProto())")
        imports.add(Import("com.google.protobuf.util", listOf("JsonFormat")))
        return FunSpecsWithImports(
            listOf(functionBuilder.build()),
            imports
        )
    }
}
