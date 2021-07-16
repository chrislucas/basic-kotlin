package com.br.sample.properties.delegated.inclass

import kotlin.reflect.KProperty

class WrapperComparableProperty<T : Comparable<T>>(provider: () -> T) {
    val comparable: Comparable<T> by provider
}

operator fun <R : Comparable<R>> (() -> R).getValue(
    wrapper: WrapperComparableProperty<R>,
    property: KProperty<*>
) = this()


fun main() {
    arrayOf(
        WrapperComparableProperty { 9 },
        WrapperComparableProperty { "String" },
        WrapperComparableProperty { 9.0 }).forEach { delegate ->

        println(delegate.comparable)
    }
}