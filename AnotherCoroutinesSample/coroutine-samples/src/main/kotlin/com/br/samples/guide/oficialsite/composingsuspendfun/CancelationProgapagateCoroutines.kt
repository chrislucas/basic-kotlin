package com.br.samples.guide.oficialsite.composingsuspendfun

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * ESTUDAR MAIS ESSE TOPICO
 * */

/**
 * https://kotlinlang.org/docs/composing-suspending-functions.html#structured-concurrency-with-async
 * "Cancellation is always propagated through coroutines hierarchy
 * */
//


suspend fun <T, R> processOperationAsynchronous(list: List<Deferred<T>>, fn: suspend (List<Deferred<T>>) -> R): R =
    coroutineScope { fn(list) }



fun run() {
    val time = measureTimeMillis {
        runBlocking {
            withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                val functions = listOf(
                    async {
                        try {
                            println("Starting Async suspend fun 1")
                            delay( 1000)
                            println("Finishing Async suspend fun 1")
                        } catch (e: Exception) {
                            println("Error: $e\n suspend fun 1")
                        } finally {
                            println("Canceling Async suspend fun 1")
                        }
                    },
                    async {
                        try {
                            println("Starting Async suspend fun 2")
                            delay( 1L shl  30)
                            println("Finishing Async suspend fun 2")
                        } catch (e: Exception) {
                            println("Error: $e\n suspend fun 2")
                        } finally {
                            println("Canceling Async suspend fun 2")
                        }
                    },
                    async {
                        try {
                            println("Starting Async suspend fun 3")
                            delay( 100000)
                            println("Finishing Async suspend fun 3")
                        } catch (e: Exception) {
                            println("Error: $e\n suspend fun 3")
                        } finally {
                            println("Canceling Async suspend fun 3")
                        }
                    },
                    async {
                        println("Starting Async suspend fun 4")
                        delay(10000L)
                        throw Throwable("Simulando um erro")
                    },
                    async {
                        try {
                            println("Starting Async suspend fun 5")
                            delay( 100)
                            println("Finishing Async suspend fun 5")
                        } catch (e: Exception) {
                            println("Error: $e\n suspend fun 5")
                        } finally {
                            println("Canceling Async suspend fun 5")
                        }
                    }
                )

                processOperationAsynchronous(functions) {
                    it.forEach { deferred ->
                        deferred.await()
                    }
                }
            }
        }
    }

    println(time * 1.0 / 1000.0)
}

fun main() {
    run()
}
