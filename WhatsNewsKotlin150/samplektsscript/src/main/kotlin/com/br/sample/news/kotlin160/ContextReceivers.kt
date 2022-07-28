package com.br.sample.news.kotlin160

import kotlin.random.Random

// https://www.youtube.com/watch?v=GISPalIVdQY&t=101s


fun main() {
    // println("funny".funWithString())
    checkFunWith()
    checkFunWithString()
}


// exemplos de ext functions e functions with receiver


fun String.funWithString(): String {
    return asIterable().joinToString("") {
        if (Random.nextBoolean()) {
            it.uppercase()
        } else {
            it.lowercase()
        }
    }
}

// lambda with receiver
fun funWithString(data: String, transform: String.() -> Unit) {
    println(data.transform())
}

private fun checkFunWithString() {
    funWithString("it is me") {
        this.funWithString()
    }
}

fun funWith(transform: String.() -> Unit) {
    val transformed = "chrisluccas".transform()
    println(transformed)
}

private fun checkFunWith() {
    funWith {
        funWithString()
    }
}