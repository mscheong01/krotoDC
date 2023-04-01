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
package com.github.mscheong01.krotodc.specgenerators.file

import com.github.mscheong01.krotodc.import.FunSpecsWithImports
import com.github.mscheong01.krotodc.import.Import
import com.github.mscheong01.krotodc.specgenerators.FileSpecGenerator
import com.github.mscheong01.krotodc.specgenerators.function.MessageToDataClassFunctionGenerator
import com.github.mscheong01.krotodc.specgenerators.function.MessageToProtoFunctionGenerator
import com.github.mscheong01.krotodc.util.addAllImports
import com.github.mscheong01.krotodc.util.isPredefinedType
import com.github.mscheong01.krotodc.util.krotoDCPackage
import com.google.protobuf.Descriptors
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec

class ConverterGenerator : FileSpecGenerator {
    val fileSpecs = mutableMapOf<String, FileSpec>()
    val messageToDataClassGenerator = MessageToDataClassFunctionGenerator()
    val messageToProtoGenerator = MessageToProtoFunctionGenerator()

    override fun generate(fileNameToDescriptor: Map<String, Descriptors.FileDescriptor>): List<FileSpec> {
        for ((_, descriptor) in fileNameToDescriptor) {
            for (messageType in descriptor.messageTypes) {
                val packageValue = messageType.file.krotoDCPackage + '.' + messageType.name.lowercase()
                val fileBuilder = FileSpec
                    .builder(packageValue, "${messageType.name}Converters.kt")
                val (funSpecs, imports) = generateConvertersForMessageDescriptor(messageType)
                funSpecs.forEach { fileBuilder.addFunction(it) }
                fileBuilder.addAllImports(imports)
                fileSpecs[messageType.fullName] = fileBuilder.build()
            }
        }
        return fileSpecs.values.toList()
    }

    fun generateConvertersForMessageDescriptor(
        messageDescriptor: Descriptors.Descriptor
    ): FunSpecsWithImports {
        if (
            messageDescriptor.isPredefinedType() ||
            messageDescriptor.options.mapEntry
        ) {
            return FunSpecsWithImports.EMPTY
        }
        val funSpecs = mutableListOf<FunSpec>()
        val imports = mutableSetOf<Import>()

        messageToDataClassGenerator.generate(messageDescriptor).let {
            funSpecs.addAll(it.funSpecs)
            imports.addAll(it.imports)
        }
        messageToProtoGenerator.generate(messageDescriptor).let {
            funSpecs.addAll(it.funSpecs)
            imports.addAll(it.imports)
        }
        messageDescriptor.nestedTypes.forEach { nestedType ->
            generateConvertersForMessageDescriptor(nestedType).let {
                funSpecs.addAll(it.funSpecs)
                imports.addAll(it.imports)
            }
        }

        return FunSpecsWithImports(
            funSpecs = funSpecs,
            imports = imports
        )
    }
}
