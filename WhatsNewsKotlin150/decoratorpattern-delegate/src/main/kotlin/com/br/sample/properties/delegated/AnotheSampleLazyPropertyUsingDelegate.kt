package com.br.sample.properties.delegated

import kotlin.reflect.KProperty

// https://play.kotlinlang.org/koans/Properties/Delegates%20examples/Task.kt



class LazyProperty(val initializer: () -> Int) {
    val lazyValue: Int by initializer()
}

/*
private operator fun <T> Comparable<T>.getValue(lazyProperty: LazyProperty, property: KProperty<T?>): T? {
    return property.call()
}
*/

private operator fun Int.getValue(lazyProperty: LazyProperty, property: KProperty<*>): Int {
    println("LazyValue: $lazyProperty\nProperty: $property")
    return lazyProperty.initializer()
}


private fun sampleLazyProperty() {
    val lazyProperty = LazyProperty {
        100
    }
    println(lazyProperty.lazyValue)
}


private fun sample() {
    val init: () -> Int = {
        0xff
    }

    val lazy = LazyProperty(init)

    println(lazy.lazyValue)

}

fun main() {
    sample()
}
