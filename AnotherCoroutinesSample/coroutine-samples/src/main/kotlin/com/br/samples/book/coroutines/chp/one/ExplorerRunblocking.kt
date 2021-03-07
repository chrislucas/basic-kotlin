package com.br.samples.book.coroutines.chp.one

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun sampleWithContext() {
    suspend {
        withContext(Dispatchers.Default) {
            println(0xff)
        }
    }
}

fun sampleRunBlocking() {
    /**
     * https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines/run-blocking.html
     * Executa uma nova coroutine e bloqueia a Thread corrente de forma interruptivel
     * ate que a suspend function termine.
     *
     * Projetada para interligar codigo bloqueantes a libraries que sao escritas em suspending-style
     * Util em main functions e funcoes de tests
     *
     * - A Corou
     *
     *
     * */
    runBlocking {
        /**
         * Criando uma suspend function
         * */
        val suspendFunction = suspend {
            withContext(Dispatchers.Default) {
                for(i in 0 until 10) {
                    println(System.currentTimeMillis())
                    delay(1000)
                }
            }
            println("Dentro de um bloco suspend")
        }
        //suspendFunction.invoke()
    }
    println("Apos o bloco runBlocking")
}


fun sampleRunBlocking2() {
    runBlocking {
        val op1 = suspend {
            delay(3000)
            println("Finished Op1")
        }
        op1.invoke()
        val op2 = suspend {
            delay(500)
            println("Finished Op2")
        }
        op2.invoke()
    }
}

fun main() {
    sampleRunBlocking2()
}