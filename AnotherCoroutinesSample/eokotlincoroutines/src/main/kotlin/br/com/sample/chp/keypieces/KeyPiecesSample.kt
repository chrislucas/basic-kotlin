package br.com.sample.chp.keypieces

import br.com.sample.wait
import kotlinx.coroutines.*

const val DELAY = 10L

private fun sampleLaunchCoroutineScope() {
    /**
     * https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines/-coroutine-scope/
     * CoroutineScope: Define um escopo para uma nova coroutine.
     * T*do construtor de coroutine (launch, async) eh uma extensao de CoroutineScope
     *
     * GlobalScope: Uma CoroutineScope global nao vinculada a nenhum job
     *
     * Uma GlobalScope eh usada para lancar uma coroutine top-level que operam durante t*do
     * o ciclo de vida da aplicacao, nao sen do canceladas prematuramente.
     *
     * https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines/launch.html
     *
     * CoroutineScope.launch: Lanca uma nova coroutine sem bloquear a thread atual e retorna uma referencia
     * a uma coroutine na forma de uma instancia de 'Job'. A coroutine eh cancelada quando o Job resultante
     * eh cancelado
     * */
    val job = GlobalScope.launch {
        println("GlobalScope")
        wait(DELAY)
        println("launch")
    }
    println("Job: $job")

    job.invokeOnCompletion {
        println("Invoke_On_Completion: $it")
    }
}

fun sampleAsyncCoroutineScope(fn: () -> Unit) {
    /*
    * https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines/async.html
    * */
    val job = GlobalScope.async { fn() }
    println("Job: $job")
}

fun main() {
    sampleLaunchCoroutineScope()
    println("********************************************************************************")
    sampleAsyncCoroutineScope {
        println("GlobalScope")
        runBlocking {
            wait(10000L)
        }
        println("async")
    }
}
