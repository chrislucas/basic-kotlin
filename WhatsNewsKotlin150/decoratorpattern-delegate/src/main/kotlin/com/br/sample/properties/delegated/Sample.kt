package com.br.sample.properties.delegated

import com.br.sample.checkNullableList
import kotlin.reflect.KProperty

// https://kotlinlang.org/docs/delegated-properties.html

/**
 * Delegated properties
 * */


class DelegateCreateString {
    operator fun getValue(ref: Any?, property: KProperty<*>): String {
        return "Reference '$ref' delegates the propertyName '${property.name}' to '${javaClass.name}'"
    }

    operator fun setValue(ref: Any?, property: KProperty<*>, value: String) {
        println("'${property.name}' = '$value' and it reference '$ref'")
    }
}


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

private fun sample() {
    var strValue: String by DelegateCreateString()
    println(strValue)
    strValue = "ola, mundo"
    println(strValue)

    /**
     * Property delegate must have a 'setValue(Nothing?, KProperty*>, Int)' method.
     * None of the following functions are suitable.
     * */
    // var value1: Int by DelegateCreateString()
}


fun sample1() {
    var value: Int by SampleGenericDelegate { value ->
        value ?: 1
    }
    println(value)
    value = 10
    println(value)
}


fun sample2() {
    //var value: Int by Delegate
}

fun main() {
    //sample()
    //sample1()
}


