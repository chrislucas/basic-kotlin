package com.br.sample.general

import java.lang.StringBuilder


val <T> List<T>.string: String
    get() = this.joinTo(StringBuilder()).toString()

val <T> Array<T>.string: String
    get() = this.joinTo(StringBuilder()).toString()


fun <T> Array<T>.join(delimiter: String = ","): String =
    this.foldIndexed(StringBuilder()) { idx, init, value ->
        if (idx == 0) {
            init.append(value)
        } else {
            init.append("$delimiter $value")
        }
        init
    }.toString()