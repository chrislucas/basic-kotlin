package com.br.algorithms.extfun


/**
 * Testando umas ideias malucas
 *
 * */

fun <R> (() -> R).call(): R = this()

fun <R, Arg, F: (arg: Arg) -> R> F.call(arg: Arg) : R =  this(arg)