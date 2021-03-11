package br.com.sample.tutorials

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread

/**
 * https://kotlinlang.org/docs/coroutines-basic-jvm.html#let-s-run-a-lot-of-them
 * */

private fun startALofOfThreads() {
    val s = System.currentTimeMillis()
    val c = AtomicLong()
    for (i in 1 .. 1_000_000L) {
        thread (start = true) {
            c.addAndGet(i)
        }
    }
    val e = System.currentTimeMillis() - s
    println("$c, ${c.get()} ${e / 1000.0}")
}

private fun startALofOfCoroutines() {
    val s = System.currentTimeMillis()
    val c = AtomicLong()
    val scope = CoroutineScope(Dispatchers.Default)
    for (i in 1 .. 1_000_000L) {
        scope.launch {
            c.addAndGet(i)
        }
    }
    val e = System.currentTimeMillis() - s
    println("$c, ${c.get()} ${e / 1000.0}")
}

private fun startALofOfCoroutinesWithGlobalScope() {
    val s = System.currentTimeMillis()
    val c = AtomicLong()
    for (i in 1 .. 1_000_000L) {
        GlobalScope.launch {
            c.addAndGet(i)
        }
    }
    val e = System.currentTimeMillis() - s
    println("$c, ${c.get()} ${e / 1000.0}")
}


fun main() {
    startALofOfThreads()
}