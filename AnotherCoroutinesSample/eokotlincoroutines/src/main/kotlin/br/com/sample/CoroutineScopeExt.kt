package br.com.sample

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * https://elizarov.medium.com/coroutine-context-and-scope-c8b255d59055
 * */
fun CoroutineScope.keepRunning(fn: () -> Unit){
    launch {
        fn()
    }
}

fun CoroutineScope.log(source: String) = "Source: $source\nCoroutineScope: $this\n" +
        "Binded Context: $coroutineContext\nKey: ${coroutineContext[Job]}"


fun CoroutineScope.builder(fn: suspend CoroutineScope.() -> Unit) {

}