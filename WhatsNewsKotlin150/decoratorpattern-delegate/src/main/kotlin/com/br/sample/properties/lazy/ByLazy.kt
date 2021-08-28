package com.br.sample.properties.lazy

import com.br.sample.properties.delegated.getValue

fun sample() {
    val refDefault = lazy { "test" }
    val str: String by refDefault
    println(str)
}

fun anotherSample() {
    val str: String by lazy (LazyThreadSafetyMode.PUBLICATION) { "test" }
    println(str)
}

fun sample(provider: () -> String) {
    val str: String by provider
    println(str)
}


fun main() {
    sample()
    sample { "show" }
    anotherSample()
}

