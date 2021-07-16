package com.br.sample.properties.delegated.inclass

import kotlin.reflect.KProperty

class DelegateParameterizableProperty<T : Comparable<T>>(init: () -> T) {
    val comparable: Comparable<T> by init
}

operator fun <R : Comparable<R>> (() -> R).getValue(
    wrapper: DelegateParameterizableProperty<R>,
    property: KProperty<*>
) = this()


fun main() {
    arrayOf(
        DelegateParameterizableProperty { 9 },
        DelegateParameterizableProperty { "String" },
        DelegateParameterizableProperty { 9.0 }).forEach { delegate ->

        println(delegate.comparable)
    }
}