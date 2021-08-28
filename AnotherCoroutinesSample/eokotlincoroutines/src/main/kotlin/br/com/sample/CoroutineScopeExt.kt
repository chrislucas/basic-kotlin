package br.com.sample

import kotlinx.coroutines.*

/**
 * https://elizarov.medium.com/coroutine-context-and-scope-c8b255d59055
 *
 * Criando uma coroutine que continue executando
 *
 *
 * "Suspend fun sao construidas para ser non-blocking e assim nao devem causar efeitos colaterais
 * tais como lancar qualquer execucao concorrente"
 *
 * "Suspend fun devem completar t*do o seu processo antes de retornarem para quem as chamou"
 * (https://medium.com/@elizarov/blocking-threads-suspending-coroutines-d33e11bf4761)
 *
 * */
fun CoroutineScope.keepingExt(fn: () -> Unit) = launch { fn() }

//fun CoroutineScope.keepingExt(fn:  suspend () -> Unit) = launch { fn() }

fun keeping(scope: CoroutineScope, fn: () -> Unit) =
        scope.launch { fn() }

fun main() {
    runBlocking {
        keepingExt {
            println(this.log("keepingExt"))
        }
        println("******************************************************************")
        keeping(this) {
            println(this.log("keeping"))
        }
        println("******************************************************************")
        println(this.log("runblocking"))
    }
}


fun CoroutineScope.log(source: String) = "Source: $source\nCoroutineScope: $this\n" +
        "Binded Context: $coroutineContext\nKey: ${coroutineContext[Job]}"


fun CoroutineScope.builder(fn: suspend CoroutineScope.() -> Unit) {}