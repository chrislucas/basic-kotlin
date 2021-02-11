package br.com.sample.tutorials.contextscope

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun playSampleWithContextFun() {
    runBlocking {
        println("Runblocking: $this | $coroutineContext")
        /**
         * WithContext
         * */
        withContext(coroutineContext) {
            println("WithContext: $this | $coroutineContext")
        }
        launch {
            withContext(coroutineContext) {
                println("Launch|WithContext: $this | $coroutineContext")
            }
        }
    }
}


fun main() {
    playSampleWithContextFun()
}