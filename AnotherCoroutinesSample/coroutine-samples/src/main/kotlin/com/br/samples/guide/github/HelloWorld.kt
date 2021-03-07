package com.br.samples.guide.github

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun helloWorld() {
    runBlocking {
        withContext(Dispatchers.Default) {
            println(coroutineContext)
        }

        withContext(Dispatchers.Unconfined) {
            println(coroutineContext)
        }

        withContext(Dispatchers.IO) {
            println(coroutineContext)
        }
    }
}

fun main() {
    helloWorld()
}