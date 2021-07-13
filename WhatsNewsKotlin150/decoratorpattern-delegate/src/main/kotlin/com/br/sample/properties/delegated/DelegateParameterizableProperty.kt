package com.br.sample.properties.delegated

import kotlin.reflect.KProperty


class DelegateParameterizableProperty<T : Comparable<T>>(init: () -> T) {
    val comparable: Comparable<T> by init
}

private operator fun <R : Comparable<R>> (() -> R).getValue(
    box: DelegateParameterizableProperty<R>,
    property: KProperty<*>
) = box.comparable


fun main() {
    val delegate = DelegateParameterizableProperty { 9 }

    println(delegate.comparable)
}