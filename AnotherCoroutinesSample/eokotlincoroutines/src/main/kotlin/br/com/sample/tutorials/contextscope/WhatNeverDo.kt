package br.com.sample.tutorials.contextscope

import br.com.sample.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.coroutineContext

/**
 * https://elizarov.medium.com/coroutine-context-and-scope-c8b255d59055
 * Scope vs Context
 *
 * Em suma, uma CoroutineScope possui uma CoroutineContext
 *
 * Nunca criar coroutines que nao tenha uma CoroutineScope explicito
 * */
suspend fun sample(): Job =
    CoroutineScope(coroutineContext).launch {
        println("Confusing")
    }



fun main() {
    runBlocking {
        val job = sample()
        println(job.log())
    }
}
