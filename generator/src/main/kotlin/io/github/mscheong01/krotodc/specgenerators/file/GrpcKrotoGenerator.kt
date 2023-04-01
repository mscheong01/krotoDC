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
package io.github.mscheong01.krotodc.specgenerators.file

import com.google.protobuf.Descriptors
import com.google.protobuf.Descriptors.ServiceDescriptor
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.TypeSpec
import io.github.mscheong01.krotodc.specgenerators.FileSpecGenerator
import io.github.mscheong01.krotodc.specgenerators.TypeSpecGenerator
import io.github.mscheong01.krotodc.specgenerators.type.ClientStubGenerator
import io.github.mscheong01.krotodc.specgenerators.type.ServiceImplBaseGenerator
import io.github.mscheong01.krotodc.util.addAllImports
import io.github.mscheong01.krotodc.util.krotoDCPackage

class GrpcKrotoGenerator : FileSpecGenerator {
    override fun generate(fileNameToDescriptor: Map<String, Descriptors.FileDescriptor>): List<FileSpec> {
        val fileSpecs = mutableListOf<FileSpec>()

        fileNameToDescriptor.forEach { (_, descriptor) ->
            descriptor.services.forEach { service ->
                val generators: List<TypeSpecGenerator<ServiceDescriptor>> = listOf(
                    ServiceImplBaseGenerator(),
                    ClientStubGenerator()
                )
                val results = generators.map {
                    it.generate(service)
                }
                val krotoGrpcClassName = service.name + "GrpcKroto"
                fileSpecs.add(
                    FileSpec.builder(descriptor.krotoDCPackage, krotoGrpcClassName + ".kt")
                        .addType(
                            TypeSpec.objectBuilder(krotoGrpcClassName)
                                .apply {
                                    results.map {
                                        it.typeSpecs
                                    }.flatten().forEach {
                                        addType(it)
                                    }
                                }.build()
                        ).apply {
                            if (
                                service.methods.any {
                                    it.isServerStreaming || it.isClientStreaming
                                }
                            ) {
                                addImport("kotlinx.coroutines.flow", "map")
                            }
                            addAllImports(
                                results.map {
                                    it.imports
                                }.flatten().toSet()
                            )
                        }
                        .build()
                )
            }
        }

        return fileSpecs
    }
}
