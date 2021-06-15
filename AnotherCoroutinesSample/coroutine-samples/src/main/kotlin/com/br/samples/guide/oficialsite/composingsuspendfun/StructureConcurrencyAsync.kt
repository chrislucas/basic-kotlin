package com.br.samples.guide.oficialsite.composingsuspendfun

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * ESTUDAR MAIS ESSE TOPICO
 * */

/**
 * https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines/coroutine-scope.html
 * */



suspend fun <R> combinationAsync(list: List<Deferred<R>>, fn: suspend (List<Deferred<R>>) -> R): R =
    coroutineScope { fn(list) }

fun sample() {
    val time = measureTimeMillis {
        runBlocking {
            val r = withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                val functions = listOf(
                    async(start = CoroutineStart.LAZY) { 23 },
                    async(start = CoroutineStart.LAZY) { 23 },
                    async(start = CoroutineStart.LAZY) { 23 },
                    async(start = CoroutineStart.LAZY) { 9831 }
                )

                combinationAsync(functions) {
                    it.fold(0) { acc, deferred ->
                        acc + deferred.await()
                    }
                }
            }
            println(r)
        }
    }
    println(time * 1.0 / 1000.0)
}

fun main() {
    sample()
}