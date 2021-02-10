package com.br.samples.ktutorials.functional


/**
 * Diving deeper into context-oriented programming in Kotlin
 * https://proandroiddev.com/diving-deeper-into-context-oriented-programming-in-kotlin-3ecb4ec38814
 *
 * https://kotlinlang.org/docs/reference/fun-interfaces.html
 * kotlin 1.4
 *
 * */
fun interface IntMapper {
    fun unaryOp(value: Int): Int
}

fun applyUnaryOp(value: Int, mapper: IntMapper) = mapper.unaryOp(value)

inline fun applyBinaryOp(p: Int, q: Int, op: (Int, Int) -> Int) = op(p, q)

val XorOperation: (Int, Int) -> Int = { p, q -> p xor q }

fun main() {
    // so a partir do kotlin 1.4
    val op = IntMapper { it xor 15 }
    applyUnaryOp(10, op)

    println(applyBinaryOp(10, 15, XorOperation))
}