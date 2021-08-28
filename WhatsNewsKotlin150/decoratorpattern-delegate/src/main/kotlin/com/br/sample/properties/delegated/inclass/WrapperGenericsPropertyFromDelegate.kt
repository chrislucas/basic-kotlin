package com.br.sample.properties.delegated.inclass

import com.br.sample.general.string
import kotlin.reflect.KProperty

class GenericTypeProvider<T>(val provider: (T?, KProperty<*>) -> T) {

    operator fun getValue(ref: T?, property: KProperty<*>): T = provider(ref, property)

    operator fun setValue(ref: T?, property: KProperty<*>, value: T) {
        println("Set Value: '${property.name}' = '$value' and it reference '$ref'")
    }
}


private fun sampleGenericDelegateWithIntType() {
    var value: Int by GenericTypeProvider { ref: Int?, property: KProperty<*> ->
        println(
            "Reference '$ref' delegates the propertyName Property: ${property.string}"
        )
        1
    }
    println(value)
    value = 10
    println(value)
}

private fun sampleGenericDelegateWithDoubleType() {
    var value: Double by GenericTypeProvider { ref: Double?, property: KProperty<*> ->
        println(
            "Reference '$ref' delegates the propertyName Property: ${property.string}\n"
        )
        1.0
    }
    println("Print Value: $value")
    value = 10.0
    println("Print Value: $value")
}

fun main() {
    //sampleGenericDelegateWithIntType()
    sampleGenericDelegateWithDoubleType()
}