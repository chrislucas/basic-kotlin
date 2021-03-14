package com.br.samples.guide.oficialsite.composingsuspendfun

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

// https://kotlinlang.org/docs/composing-suspending-functions.html#concurrent-using-async

/**
 * Podemos criar uma coroutine assincrona no modo lazy. Para isso
 * a funcao async tem um argumento chamado start, basta passar a constante
 * CoroutineStart.LAZY
 *
 * Nesse modo a coroutine so eh iniciada quando o seu resultado for requerido
 * pela funaco await() ou pela funcao start() da classe Job (lembrando que:
 * interface Deferred<out T> : Job )
 * */

fun sampleLazyStartCoroutine() {
    runBlocking {
        val spent = measureTimeMillis {
            CoroutineScope(Dispatchers.Default).launch {
                val p = async(start = CoroutineStart.LAZY) {
                    delay(1000)
                    23
                }
                val q = async(start = CoroutineStart.LAZY) { 13 }
                println(q.await() + p.await())
            }
        }
        println(spent * 1.0 / 1000.0)
    }
}

/**
 * Testando o inicializador Lazy de coroutines assicronas.
 * */
fun anotherLazyAsyncCoroutineV1Async(): Deferred<Int> {
    println("anotherLazyAsyncCoroutineV1Async")
    return CoroutineScope(Dispatchers.Default).async(start = CoroutineStart.LAZY) {
        var r: Int = 0
        val spent = measureTimeMillis {
            lateinit var p: Deferred<Int>
            lateinit var q: Deferred<Int>
            CoroutineScope(Dispatchers.Default).async {
                p = async(start = CoroutineStart.LAZY) {
                    delay(1000L)
                    23
                }
                q = async(start = CoroutineStart.LAZY) {
                    delay(1000L)
                    13
                }
                p.start()
                q.start()
            }.join()
            r = q.await() + p.await()
        }
        println(spent * 1.0 / 1000.0)
        r
    }
}

suspend fun anotherLazyAsyncCoroutineV2Async(): Deferred<Int> {
    println("anotherLazyAsyncCoroutineV2Async")
    return CoroutineScope(Dispatchers.Default).async(start = CoroutineStart.LAZY) {
        var r: Int = 0
        val spent = measureTimeMillis {
            val p = async(start = CoroutineStart.LAZY) {
                delay(1000L)
                23
            }
            val q = async(start = CoroutineStart.LAZY) {
                delay(1000L)
                13
            }
            p.start()
            q.start()
            r = q.await() + p.await()
        }
        println(spent * 1.0 / 1000.0)
        r
    }
}

fun anotherLazyAsyncCoroutineSimpliest() = runBlocking {
    println("anotherLazyAsyncCoroutineSimpliest")

    val time = measureTimeMillis {
        val p = async(start = CoroutineStart.LAZY) {
            delay(10000L)
            23
        }
        val q = async(start = CoroutineStart.LAZY) { 32 }
        // if (p.start() && q.start()) { println(p.await() + q.await()) }
        println(p.await() + q.await())
    }
    println(time * 1.0 / 1000.0)
}

fun main() {
    runBlocking {
        //anotherLazyAsyncCoroutine().start()
        val q = anotherLazyAsyncCoroutineV1Async().await()
        println(q)

        val r = anotherLazyAsyncCoroutineV2Async().await()
        println(r)
    }

    anotherLazyAsyncCoroutineSimpliest()
}