package com.br.algorithms

fun <F: (args: Array<out Any?>?) -> Any> F.timeSpent(vararg args: Any? = arrayOfNulls(0)) : Double {
    val s = System.currentTimeMillis()
    this(args)
    return (System.currentTimeMillis() - s) / 1000.0
}

inline fun <R> computeBenchmark(fn: () -> R) : Double {
    val s = System.currentTimeMillis()
    fn()
    return (System.currentTimeMillis() - s) / 1000.0
}
