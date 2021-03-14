package com.br.samples.guide.oficialsite.composingsuspendfun

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

// https://kotlinlang.org/docs/composing-suspending-functions.html#async-style-functions

fun wrapperCoroutineAsync(coroutineContext: CoroutineContext, fn: suspend () -> Int) =
    CoroutineScope(context = coroutineContext).async { fn() }

fun main() {
    val time = measureTimeMillis {
        val r1 = wrapperCoroutineAsync(Dispatchers.Default) {
            delay(1000L)
            12
        }

        val r2 = wrapperCoroutineAsync(Dispatchers.Default) {
            delay(10000L)
            12
        }
        runBlocking {
            println(r2.await() + r1.await())
        }
    }

    println(time * 1.0 / 1000.0)
}