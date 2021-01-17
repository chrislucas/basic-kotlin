package com.br.algorithms.extfun


/**
 * Testando umas ideias malucas
 *
 * */

fun <R> (() -> R).call(): R {
    return this()
}

fun <R, Arg, F: (arg: Arg) -> R> F.call(arg: Arg) : R { return this(arg) }