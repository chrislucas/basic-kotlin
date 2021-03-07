package com.br.problems

private infix fun Double.exp(e: Long) : Double {
    return when (e) {
        0L -> { 1.0 }
        1L -> { this }
        else -> {
            var acc = 1.0
            var _e = e
            var _b = this
            while (_e > 0) {
                if ((_e and 1) == 1L) {
                    acc *= _b
                }
                _b *= _b
                _e = _e shr 1
            }
            acc
        }
    }
}

fun sampleExp() {
    println(1.0/365 exp 23L)
    println(1.0/365 exp 10L)
    println(3.5 exp 5L)
    println(2.5 exp 5L)
}