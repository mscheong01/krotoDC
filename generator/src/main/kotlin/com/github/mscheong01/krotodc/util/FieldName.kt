package com.github.mscheong01.krotodc.util

// Protocol Buffers - Google's data interchange format
// Copyright 2008 Google Inc.  All rights reserved.
// https://developers.google.com/protocol-buffers/
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are
// met:
//
//     * Redistributions of source code must retain the above copyright
// notice, this list of conditions and the following disclaimer.
//     * Redistributions in binary form must reproduce the above
// copyright notice, this list of conditions and the following disclaimer
// in the documentation and/or other materials provided with the
// distribution.
//     * Neither the name of Google Inc. nor the names of its
// contributors may be used to endorse or promote products derived from
// this software without specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
// A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
// OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
// SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
// LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
// DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
// THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
// (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
// OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

// This method was copied from protocolbuffers/protobuf:
// https://github.com/protocolbuffers/protobuf/blob/8c8b2be3a830755014d338d023c8b60779f70b8b/java/core/src/main/java/com/google/protobuf/Descriptors.java
// This method should match exactly with the ToJsonName() function in C++
// descriptor.cc.
internal fun fieldNameToJsonName(name: String): String {
    val length = name.length
    val result = StringBuilder(length)
    var isNextUpperCase = false
    for (i in 0 until length) {
        var ch = name[i]
        if (ch == '_') {
            isNextUpperCase = true
        } else if (isNextUpperCase) {
            // This closely matches the logic for ASCII characters in:
            // http://google3/google/protobuf/descriptor.cc?l=249-251&rcl=228891689
            if ('a' <= ch && ch <= 'z') {
                ch = (ch - 'a' + 'A'.code).toChar()
            }
            result.append(ch)
            isNextUpperCase = false
        } else {
            result.append(ch)
        }
    }
    return result.toString()
}
