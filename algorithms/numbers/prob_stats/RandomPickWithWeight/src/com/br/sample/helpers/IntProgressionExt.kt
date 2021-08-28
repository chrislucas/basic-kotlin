package com.br.sample.helpers

fun IntProgression.toArray(): Array<Int> {
    return this.run {
        val diff = (last - first) / step + 1
        val array = Array(diff) { 0 }
        this.forEachIndexed { i, v ->
            array[i] = v
        }
        array
    }
}