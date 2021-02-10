package br.com.sample

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking


private suspend fun looper() {
    var started = false
    val time = System.currentTimeMillis()
    while (true) {
        if (!started) {
            started = true
            val result = GlobalScope.async {
                process()
            }
            if (result.await()) {
                println(System.currentTimeMillis() - time)
                break
            }
        }
    }
}

suspend fun process(): Boolean {
    wait(10000L)
    return true
}

fun main() {
    runBlocking {
        looper()
    }
}