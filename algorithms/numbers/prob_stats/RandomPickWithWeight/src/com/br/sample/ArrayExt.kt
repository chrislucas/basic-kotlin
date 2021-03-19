package com.br.sample

import kotlin.random.Random


private fun <T> Array<T>.swap(p: Int, q: Int) {
    val value = this[p]
    this[p] = this[q]
    this[q] = value
}

fun <T> Array<T>.shuffle(): Array<T> {
    for (i in indices) {
        val idx = Random.nextInt(0, i + 1)
        this.swap(i, idx)
    }
    return this
}

fun <T> Array<T>.string(d: String = ",") = this.run {
    val string = StringBuilder()
    this.forEachIndexed { i, v ->
        string.append(if (i == 0) v else (", $v"))
    }
    string
}
