package br.com.sample

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking


private suspend fun looper(): Long {
    var started = false
    val time = System.currentTimeMillis()
    while (true) {
        if (!started) {
            started = true
            val result = GlobalScope.async {
                process()
            }
            if (result.await()) {
                return System.currentTimeMillis() - time
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
        println("Difference: ${looper()}")
    }
}