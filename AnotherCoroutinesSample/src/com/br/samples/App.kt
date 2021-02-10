package com.br.samples

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main( ) {
    println("ok")

    runBlocking {
        delayedFun()
        println("Message #%d".format(0xff))
    }

    println("Execucao apos o block 'RunBlocking'.")
}


suspend fun delayedFun() {
    withContext(Dispatchers.Default) {
        delay(2000L)
    }
}