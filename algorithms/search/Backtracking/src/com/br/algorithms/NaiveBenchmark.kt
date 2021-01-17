package com.br.algorithms

fun <R, T: Function<R>> T.execute() : Double {
    val s = System.currentTimeMillis()

    return (System.currentTimeMillis() - s) / 1000.0
}


fun <R> computeBenchmark(fn: () -> R) : Double {
    val s = System.currentTimeMillis()
    fn()
    return (System.currentTimeMillis() - s) / 1000.0
}
