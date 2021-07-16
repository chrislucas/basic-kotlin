package com.br.sample.properties.delegated.function

import com.br.sample.properties.delegated.getValue

private fun <T : Comparable<T>> showComparable(init: () -> T) {
    val comparable: T by init
    println(comparable)
}

fun main() {
    showComparable { 0 }
    showComparable { "chrisluccas" }
    showComparable { 12.3 }
    showComparable { 'a' }
}