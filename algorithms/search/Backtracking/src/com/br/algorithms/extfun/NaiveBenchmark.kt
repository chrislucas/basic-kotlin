package com.br.algorithms.extfun


fun <R, Arg, F: (arg: Arg) -> R> F.timeSpent(arg: Arg) : Double {
    val s = System.currentTimeMillis()
    this(arg)
    return (System.currentTimeMillis() - s) / 1000.0
}

inline fun <R> computeBenchmark(fn: () -> R) : Double {
    val s = System.currentTimeMillis()
    fn()
    return (System.currentTimeMillis() - s) / 1000.0
}
