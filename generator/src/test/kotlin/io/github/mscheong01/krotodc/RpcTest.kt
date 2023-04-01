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

import io.github.mscheong01.rpc.krotodc.BidirectionalStreamingRequest
import io.github.mscheong01.rpc.krotodc.BidirectionalStreamingResponse
import io.github.mscheong01.rpc.krotodc.ClientStreamingRequest
import io.github.mscheong01.rpc.krotodc.ClientStreamingResponse
import io.github.mscheong01.rpc.krotodc.RpcServiceGrpcKroto
import io.github.mscheong01.rpc.krotodc.ServerStreamingRequest
import io.github.mscheong01.rpc.krotodc.ServerStreamingResponse
import io.github.mscheong01.rpc.krotodc.UnaryRequest
import io.github.mscheong01.rpc.krotodc.UnaryResponse
import io.grpc.inprocess.InProcessChannelBuilder
import io.grpc.inprocess.InProcessServerBuilder
import io.grpc.testing.GrpcCleanupRule
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RpcTest {

    @JvmField
    @Rule
    val grpcCleanup = GrpcCleanupRule()

    private val serviceImpl = object : RpcServiceGrpcKroto.RpcServiceCoroutineImplBase() {
        override suspend fun unaryTest(request: UnaryRequest): UnaryResponse {
            return UnaryResponse(request.name.reversed())
        }

        override fun serverStreamingTest(request: ServerStreamingRequest) =
            flowOf(ServerStreamingResponse(request.name.reversed()))

        override suspend fun clientStreamingTest(requests: Flow<ClientStreamingRequest>): ClientStreamingResponse {
            val messages = requests.toList().joinToString(separator = ", ") { it.name }
            return ClientStreamingResponse(messages)
        }

        override fun bidirectionalStreamingTest(requests: Flow<BidirectionalStreamingRequest>) =
            requests.map { BidirectionalStreamingResponse(it.name.reversed()) }
    }

    private val serverName = InProcessServerBuilder.generateName()

    init {
        grpcCleanup.register(
            InProcessServerBuilder.forName(serverName).directExecutor().addService(serviceImpl).build().start()
        )
    }

    private val channel =
        grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build())
    private val stub = RpcServiceGrpcKroto.RpcServiceCoroutineStub(channel)

    @Test
    fun `unaryTest returns reversed message`() = runBlocking {
        val request = UnaryRequest("Hello")
        val response = stub.unaryTest(request)
        assertEquals("olleH", response.message)
    }

    @Test
    fun `serverStreamingTest returns reversed message`() = runBlocking {
        val request = ServerStreamingRequest("World")
        val responseList = stub.serverStreamingTest(request).toList()
        assertEquals(1, responseList.size)
        assertEquals("dlroW", responseList[0].message)
    }

    @Test
    fun `clientStreamingTest returns concatenated messages`() = runBlocking {
        val requests = flowOf(
            ClientStreamingRequest("One"),
            ClientStreamingRequest("Two"),
            ClientStreamingRequest("Three")
        )
        val response = stub.clientStreamingTest(requests)
        assertEquals("One, Two, Three", response.message)
    }

    @Test
    fun `bidirectionalStreamingTest returns reversed messages`() = runBlocking {
        val requests = flowOf(
            BidirectionalStreamingRequest("One"),
            BidirectionalStreamingRequest("Two"),
            BidirectionalStreamingRequest("Three")
        )
        val responseList = stub.bidirectionalStreamingTest(requests).toList()
        assertEquals(3, responseList.size)
        assertEquals("enO", responseList[0].message)
        assertEquals("owT", responseList[1].message)
        assertEquals("eerhT", responseList[2].message)
    }
}
