package com.br.sample.properties.delegated.inclass

import kotlin.reflect.KProperty

// https://kotlinlang.org/docs/delegated-properties.html

/**
 * Delegated properties
 * */


class StaticStringProvider {
    operator fun getValue(ref: Any?, property: KProperty<*>): String {
        return "Reference '$ref' delegates the propertyName '${property.name}' to '${javaClass.name}'"
    }

    operator fun setValue(ref: Any?, property: KProperty<*>, value: String) {
        println("'${property.name}' = '$value' and it reference '$ref'")
    }
}

private fun sampleStaticDelegateString() {
    var strValue: String by StaticStringProvider()
    // get
    println(strValue)
    // set
    strValue = "ola, mundo"
    // get
    println(strValue)

    /**
     * Property delegate must have a 'setValue(Nothing?, KProperty*>, Int)' method.
     * None of the following functions are suitable.
     * */
    // var value1: Int by DelegateCreateString()
}


fun main() {
    sampleStaticDelegateString()
}


