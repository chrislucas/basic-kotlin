package com.br.sample

import kotlinx.coroutines.*


/**
 * https://www.raywenderlich.com/books/kotlin-coroutines-by-tutorials/v2.0/chapters/13-producers-actors#toc-chapter-017-anchor-001
 *
 * Inheritors
 * https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines/-coroutine-scope/
 */

suspend fun helloworld() {
    println(0xff)
}

fun callHelloWorld() {
    CoroutineScope(Dispatchers.Default).launch {
        helloworld()
    }
}

fun main() {


}