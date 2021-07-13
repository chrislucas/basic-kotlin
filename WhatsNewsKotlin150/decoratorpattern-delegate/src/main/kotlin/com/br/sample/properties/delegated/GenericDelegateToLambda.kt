package com.br.sample.properties.delegated

import kotlin.reflect.KProperty

private fun initInt(init: () -> Int) {
    val value: Int by init
    println(value)
}

private fun <T> initGeneric(init: () -> T) {
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


operator fun <A, R> ((A?) -> R).getValue(arg: A?, property: KProperty<*>): R = this(arg)

operator fun <R> (() -> R).getValue(r: R?, property: KProperty<*>): R = this()


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
    initGeneric { 12 }
    initGeneric { "String Initialized" }
    initGeneric { 12.32 }
    initInt { 12 }


    sample()
}


