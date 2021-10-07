package com.br.samples.hw

import kotlinx.coroutines.*

suspend fun <T> mockAsyncTask(timer: Long = 10000L, fn: suspend () -> T): T {
    return withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
        delay(timer)
        fn()
    }
}

suspend fun mockLaunchTask(timer: Long = 10000L, fn: suspend () -> Unit) {
    CoroutineScope(Dispatchers.IO).launch {
        delay(timer)
        fn()
    }
}


suspend fun <T> test(fn: suspend () -> T): T {
    while (true) {
        return withContext(CoroutineScope(Dispatchers.IO).coroutineContext) { fn() }
        // return CoroutineScope(Dispatchers.IO).async { fn() }.await()
    }
}