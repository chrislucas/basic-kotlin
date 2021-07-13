package com.br.sample.properties.delegated

import kotlin.reflect.KProperty

class SampleGenericDelegate<T>(val build: (T?) -> T) {

    operator fun getValue(ref: T?, property: KProperty<*>): T {
        val value = build(ref)
        println("Reference '$ref' delegates the propertyName '${property.name}' to '${javaClass.name}'")
        return value
    }

    operator fun setValue(ref: T?, property: KProperty<*>, value: T) {
        println("'${property.name}' = '$value' and it reference '$ref'")
    }
}

private fun sampleGenericDelegateWithIntType() {
    var value: Int by SampleGenericDelegate { value ->
        value ?: 1
    }
    println(value)
    value = 10
    println(value)
}

fun main() {
    sampleGenericDelegateWithIntType()
}