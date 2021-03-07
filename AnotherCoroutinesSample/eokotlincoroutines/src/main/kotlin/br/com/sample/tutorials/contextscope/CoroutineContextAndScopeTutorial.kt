package br.com.sample.tutorials.contextscope

import kotlinx.coroutines.*

/**
 * https://elizarov.medium.com/coroutine-context-and-scope-c8b255d59055
 *
 * Diferenca entre Context e Scope: A diferenca está em seu proposito.
 * Uma CoroutineScope possui uma referencia a CoroutineContext
 * */

/**
 * Run a new coroutine and blocks the current Thread until its completion
 *
 * Coroutines sao imutaveis mas podemos adicionar elementos ao seu contexto atraves
 * do operador plus
 * */
fun sampleRunblocking() = runBlocking<Unit> {
    var scope = this
    scope += CoroutineName("Um novo elemento")
    println("Scope: $scope\nScope: $this")
    println("CoroutineContext: $coroutineContext")
    /**
     * Uma coroutine eh representada por um Job, ele eh responsavel pelo
     * ciclo de vida, cancelamento e coroutines 'filhos' da coroutine que ele
     * representa
     * */
    println("Job: ${coroutineContext[Job]}\nJobKey: $Job")
}

suspend fun wrapSuspendFunctionLab(fn: suspend () -> Unit) = fn()


fun sample1() {
    runBlocking {
        wrapSuspendFunctionLab {

            withContext(Dispatchers.IO) {
                println("GlobalScope.launch -> CoroutineScope: $this | Binded Context: $coroutineContext")
            }

            withContext(Dispatchers.Unconfined) {
                println("GlobalScope.launch -> CoroutineScope: $this | Binded Context: $coroutineContext")
            }
/*
            Exception in thread "main" java.lang.IllegalStateException:
            Module with the Main dispatcher is missing.
            Add dependency providing the Main dispatcher, e.g.
            'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'

            withContext(Dispatchers.Main) {
                println("GlobalScope.launch -> CoroutineScope: $this | Binded Context: $coroutineContext")
            }
 */

            withContext(Dispatchers.Default) {
                println("GlobalScope.launch -> CoroutineScope: $this | Binded Context: $coroutineContext")
            }

            println("GlobalScope.launch -> CoroutineScope: $this | Binded Context: $coroutineContext")
        }
    }
}

fun main() {

}

