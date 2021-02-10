package com.br.samples.book.coroutines.chp.one

import kotlinx.coroutines.*

// https://klassbook.commonsware.com/lessons/Coroutine%20Basics/simple-sample.html

fun main() {
    val job = GlobalScope.launch {
        println("before stall")
        stall()
        println("after stall")
    }

    println("direct message")
    println("Job: $job")
}


suspend fun stall() =
        withContext(Dispatchers.Default) {
            delay(5000L)
        }