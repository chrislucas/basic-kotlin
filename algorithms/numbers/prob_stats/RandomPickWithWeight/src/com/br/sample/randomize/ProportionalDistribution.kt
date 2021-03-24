package com.br.sample

import com.br.sample.helpers.distribution
import com.br.sample.helpers.string

fun main() {

    arrayOf(.95, .35, .4, .75, .90).forEach { maxProbability ->
        println("$maxProbability: ${distribution(maxProbability, 13).string()}")
    }
}