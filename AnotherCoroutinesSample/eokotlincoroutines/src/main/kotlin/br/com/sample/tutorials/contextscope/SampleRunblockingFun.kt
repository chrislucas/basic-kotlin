package br.com.sample

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        wait(1000L)
        GlobalScope.launch {
            println("GlobalScope.launch Inside Main")
        }
    }
}