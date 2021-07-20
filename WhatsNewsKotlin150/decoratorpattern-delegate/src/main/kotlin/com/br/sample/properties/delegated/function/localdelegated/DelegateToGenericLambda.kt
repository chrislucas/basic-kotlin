package com.br.sample.properties.delegated.function.localdelegated

import com.br.sample.properties.delegated.getValue



private fun <T> show(init: () -> T) {
    val value: T by init
    println(value)
}

private fun <C : Comparable<C>> initComparable(init: () -> C) {
    val comparable: C by init
    println(comparable)
}


private fun <A, R> initGenericWithNullableArg(transform: (A?) -> R) {
    val value: R by transform
    println(value)
}

private fun <A, R> initGenericWithNullableArgAndNullableReturn(transform: (A?) -> R?) {
    val value: R? by transform
    println(value)
}

private fun sample() {
    val isOdd: (Int?) -> Boolean = { value ->
        value?.let { it and 1 == 1 } ?: false
    }

    initGenericWithNullableArg(isOdd)

    val transform: (Int?) -> Boolean? = {
        it?.run(isOdd)
    }
    initGenericWithNullableArgAndNullableReturn(transform)
}


fun main() {
    show { 12 }
    show { "String Initialized" }
    show { 12.32 }
    sample()
}


