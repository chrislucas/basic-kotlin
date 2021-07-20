package com.br.sample.properties.delegated.requirements

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun  delegateReadAndWriteInt(init: Int = 0) : ReadWriteProperty<Any?, Int> {
    return object: ReadWriteProperty<Any?, Int> {
        var currentValue = init
        override fun getValue(thisRef: Any?, property: KProperty<*>): Int = currentValue

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
            currentValue = value
        }
    }
}

fun main() {
    val value: Int by delegateReadAndWriteInt()
}