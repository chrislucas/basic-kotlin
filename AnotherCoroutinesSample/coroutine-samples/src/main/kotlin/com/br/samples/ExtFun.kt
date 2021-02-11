package com.br.samples

fun <T, R> unaryOp(value: T, fn: T.() -> R) = fn(value)


fun main() {
    unaryOp("chris") {
        ""
    }
}