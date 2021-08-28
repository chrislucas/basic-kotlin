package com.br.sample.properties.delegated.function.localdelegated

import com.br.sample.properties.delegated.getValue

/**
 * https://kotlinlang.org/docs/delegated-properties.html#local-delegated-properties
 * Podemos usar variaveis locais como delegated properties
 * */


fun <T> lazyCreate(provider: () -> T) {
    val data: T by lazy(provider)
    println(data)
}

fun <T> create(provider: () -> T) {
    val data: T by provider
    println(data)
}

private fun check() {
    create { 12 }
    create { "String" }
    create { 10.0 to 123.12 }
    lazyCreate { 12 }
    lazyCreate { 12.0 to -120 }
}

fun main() {
    check()
}