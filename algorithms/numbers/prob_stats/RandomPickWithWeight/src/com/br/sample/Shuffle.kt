package com.br.sample

fun main() {
    val weightCards = fun() = (1..13).toArray().shuffle()
    val weightSuits = fun() = (1..4).toArray().shuffle()
    repeat(100) {
        println(weightCards.toString())
        println(weightSuits.toString())
    }
}