package com.br.sample

fun checkNullableList(list: List<Int>?, check: (Int) -> Boolean) : Boolean = list?.all { check(it) } ?: false


fun main() {
    println(checkNullableList(null) {i -> i and 1 == 1})
}