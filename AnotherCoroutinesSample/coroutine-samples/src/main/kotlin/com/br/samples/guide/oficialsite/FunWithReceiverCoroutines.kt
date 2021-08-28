package com.br.samples.guide.oficialsite

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * Testando ideias
 *
 * Brincando e aprimorando a criatividade com function with receiver de uma CoroutineScope
 * */

fun <T> wrapperAsync(ctx: CoroutineContext, fn: suspend CoroutineScope.() -> T) : Deferred<T> {
    return CoroutineScope(ctx).async { fn() }
}

fun sample() {
    runBlocking {
        wrapperAsync(Dispatchers.Default) {
            val p = this.async { 12 }
            val q = this.async { 23 }
            val r = p.await() + q.await()
            println(r)
        }.await()
    }

}

fun main() {
    sample()
}