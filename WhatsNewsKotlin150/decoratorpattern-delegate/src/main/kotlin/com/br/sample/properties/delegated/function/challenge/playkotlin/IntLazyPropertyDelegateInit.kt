package com.br.sample.properties.delegated.function.challenge.playkotlin

import kotlin.reflect.KProperty

// https://play.kotlinlang.org/koans/Properties/Delegates%20examples/Task.kt

class IntLazyProperty(val initializer: () -> Int) {
    val lazyProperty: Int by initializer()
}

/*
private operator fun <T> Comparable<T>.getValue(intLazyProperty: IntLazyProperty, property: KProperty<*>): Int =
     intLazyProperty.initializer()
 */

private operator fun Int.getValue(intLazyProperty: IntLazyProperty, property: KProperty<*>): Int {
    println("LazyValue: $intLazyProperty\nProperty: $property")
    return intLazyProperty.initializer()
}

private fun sampleCreateInstanceUsingLambdaFunction() {
    val instance = IntLazyProperty { 100 }
    println(instance.lazyProperty)
}

private fun sampleCreateInstanceAndPassALocalLambdaFunction() {
    val lambda: () -> Int = { 0xff }
    val instance = IntLazyProperty(lambda)
    println(instance.lazyProperty)
}


fun main() {
    sampleCreateInstanceUsingLambdaFunction()
    sampleCreateInstanceAndPassALocalLambdaFunction()
}
