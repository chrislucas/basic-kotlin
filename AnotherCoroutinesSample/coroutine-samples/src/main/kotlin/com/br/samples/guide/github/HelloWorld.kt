package com.br.samples.guide.github

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


fun helloWorld() {
    runBlocking {
        withContext(Dispatchers.Default) {
            println(0xff)
        }
    }
}

fun main() {
    helloWorld()
}