package com.br.samples.hw

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


fun testMockAsyncTask() {
    runBlocking {
        val result = mockAsyncTask {
            // TODO criar alguma funcao legal aqui
            42
        }
        println(result)
    }
}


fun testMockLaunchTask() {
    runBlocking {
        mockLaunchTask {
            println("Ola, mundo.")
        }
        println(0xff)
    }
}

fun testLoop() {
    CoroutineScope(Dispatchers.Default).launch {
        val result = test {
            delay(10000)
            21
        }
        println(result)
    }

    println(0xff)
}

fun main() {
    testLoop()
    println("Hello World")
}