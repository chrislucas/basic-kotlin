package com.br.sample.properties.delegated


fun <T : Comparable<T>> function(init: () -> T) {
    val comparable: T by init
    println(comparable)
}

fun main() {
    function { 0 }
    function { "chrisluccas" }
    function { 12.3 }
}