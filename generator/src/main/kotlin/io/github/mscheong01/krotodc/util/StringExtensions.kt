package io.github.mscheong01.krotodc.util

fun String.snakeToCamelCaseNoRegex(): String {
    var preChar = '.' // tricks, because the first char could not be dot(.) in real case.
    return this.fold(StringBuilder()) { acc, s ->
        acc.let {
            if (s == '_') {
                return@let acc
            } else if (preChar == '.') {
                acc.append(s)
            } else if (s.isDigit()) {
                acc.append(s)
            } else if (preChar == '_' || preChar.isDigit()) {
                acc.append(s.uppercase())
            } else {
                acc.append(s)
            }
        }
        preChar = s
        acc
    }.toString()
}
