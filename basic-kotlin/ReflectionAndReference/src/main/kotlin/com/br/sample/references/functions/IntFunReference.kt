package com.br.sample.references


fun applyOperationOnInt(x: Int, fn: (Int) -> Boolean) = fn(x)

fun isOdd(x: Int) = x and 1 == 1

fun main() {
    println(applyOperationOnInt(10, ::isOdd))
}