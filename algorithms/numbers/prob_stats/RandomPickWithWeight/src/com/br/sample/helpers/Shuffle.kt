package com.br.sample.helpers

import com.br.sample.helpers.shuffle
import com.br.sample.helpers.toArray

fun main() {
    val weightCards = fun() = (1..13).toArray().shuffle()
    val weightSuits = fun() = (1..4).toArray().shuffle()
    repeat(100) {
        println(weightCards.toString())
        println(weightSuits.toString())
    }
}