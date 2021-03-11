package br.com.sample.tutorials.contextscope;

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.coroutineContext


fun main() {

    /**
     * Criando uma suspend function sem argumentos
     * */
    val function : suspend () -> Unit = suspend {
        coroutineScope {
            println("Escopo: $this - Contexto: $coroutineContext")
        }
        println("Contexto da suspend function: $coroutineContext")
    }

    runBlocking {
        function()
        println(function)
    }
}