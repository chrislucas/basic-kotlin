package br.com.sample

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


/**
 * CoroutineScope.launch:
 * ext function de CoroutineScope que recebe como argumento uma CoroutineContext, assim
 * temos duas referencia a context ja que CoroutineScope eh uma referencia a CoroutineContext.
 *
 * O contexto passado por argumento eh juntado ao contexto da CoroutineScope atraves do operador
 *  "+" (veja implementacao CoroutineScope.newCoroutineContext(context: CoroutineContext) )
 * */
fun sampleLaunch() = GlobalScope.launch {
    println("GlobalScope.launch -> CoroutineScope: $this | Binded Context: $coroutineContext")
}

fun playSampleLaunch() {
    runBlocking {
        wait(3000L)
        val coroutine = sampleLaunch()
        println("GlobalScope.launch returned -> ${coroutine[Job]}")
    }
}

fun main() {
    playSampleLaunch()
}