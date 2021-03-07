package com.br.samples.ktutorials

import java.lang.Exception

data class BoxResult<T>(val result: T)

inline fun <T, R> process(data: T, fn: (data: T) -> BoxResult<R>) = fn(data)

inline fun process(fn: () -> Int, ax: () -> Double): Unit {
    fn()
    ax()
}

/**
 * o modificador inline permite que as lambdas expressions passadas por argumento
 * consigam usar a keyword 'return' (ainda estou pensado numa aplicacao para isso)
 * */
inline fun func(stepOne: () -> Unit, steoTwo: () -> Unit) {
    stepOne()
    steoTwo()
}

fun test() {
    process({
        println("fn")
        1
    }) {
        println("ax")
        1.0
    }
}

fun anotherTest() {
    val data = process("chris") { data ->
        BoxResult(data.length)
    }

    println(data)
}

fun main() {
    func({
        println("Ola")
        return
    }
    ) {
        println("parte inalcansavel por contar do return")
    }
}