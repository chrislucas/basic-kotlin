package com.br.algorithms


/**
 * Testando umas ideias malucas
 *
 * */

private fun <R> (() -> R).call(): R {
    return this()
}


private fun <F:((Array<out Any?>?) -> Unit)> F.calc(vararg args: Any?): Double {
    this(args)

    return 0.0
}


fun main() {
    val q = fun() : Double {
        println(0xff)
        return 0.0
    }
    q.call()
}