package com.br.samples.guide.oficialsite.composingsuspendfun

import kotlinx.coroutines.*

// https://kotlinlang.org/docs/composing-suspending-functions.html
/**
 * "The code in the Coroutine code is sequential by default"
 *
 * */

suspend fun fromDataToHash(): Int {
    delay(10000L)
    return 1000
}

suspend fun sendHashCode(hashCode: Int): Boolean {
    delay(10L)
    return true
}

fun sequencialCalls() {
    runBlocking {
        println("SequencialCalls")
        val s = System.currentTimeMillis()
        CoroutineScope(Dispatchers.Default).launch {
            val hash = fromDataToHash()
            println(sendHashCode(hash))
        }.join()

        println((System.currentTimeMillis() - s)/ 1000.0)
    }
}

/**
 * Concurrent using async
 * Conceitualmente as funcoes async e launch sao iguais, ambas criam uma
 * coroutine separada que eh uma light-weigtht thread, que funciona
 * concorrentemente com outras coroutines.
 *
 * A diferenca eh:
 *  - launch retorna uma instancia de Job
 *  - async retorna uma instancia da classe Deffered
 *  a light-weight non-block "Future" que representa uma "Promise"
 *  que ira prover o resultado da funcao assincrona que foi chamada
 *  assim que ela acabar.
 *
 *  Deffered<T>.await()
 *  Para recuperar o valor da funcao assincrona usamos o meotodo await()
 *   - Deffered eh um Job podendo ser cancelado
 *
 * */
fun asyncCalls() {
    runBlocking {
        println("AsyncCalls")
        val s = System.currentTimeMillis()
        val hash = async { fromDataToHash() }
        val result = async { sendHashCode(hash.await()) }
        println(result.await())
        println((System.currentTimeMillis() - s)/ 1000.0)
    }
}

fun anotherSequencialCalls() {
    val p = suspend {
        delay(1000L)
        12
    }
    val q = suspend { 25 }

    runBlocking {
        val r = p() + q()
        println(r)
    }
}


fun main() {
    asyncCalls()
    sequencialCalls()
}


