package com.br.sample.deck

import kotlin.random.Random

// https://www.tutorialspoint.com/random-pick-with-weight-in-cplusplus

class RandomPickWeight(weights: Array<Int>) {
    val sample: Array<Int> = Array(weights.size) { 0 }

    init {
        for (i in weights.indices) {
            sample[i] += weights[i]
        }
    }

    fun pickIndex() = Random.nextInt(0, sample.size) % sample.last() + sample.first()
}


fun main() {
    val fn = RandomPickWeight(arrayOf(1, 3))
    val freq = mutableMapOf<Int, Int>()
    for(i in 0 until 100) {
        fn.pickIndex().let {
            freq[it] = freq[it]?.plus(1) ?: 1
        }
    }

    println(freq)
}