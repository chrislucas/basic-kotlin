package com.br.sample.properties.delegated.inclass

import kotlin.reflect.KProperty

// https://kotlinlang.org/docs/delegated-properties.html


class DynamicStringProvider<Ref>(val provider: (Ref?, KProperty<*>) -> String) {
    operator fun getValue(ref: Ref?, property: KProperty<*>): String = provider(ref, property)
}

private fun sampleStringWithDefaultValue() {
    val str1: String by DynamicStringProvider { ref: String?, prop: KProperty<*> ->
        println("Log: [$ref, $prop]")
        "default value"
    }
    println(str1)

    val str2: String by DynamicStringProvider { ref: Any?, prop: KProperty<*> ->
        println("Log: [$ref, $prop]")
        "default value"
    }
    println(str2)
}

fun main() {
    sampleStringWithDefaultValue()
}


