package com.br.sample.properties.delegated.requirements

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun <M, V> genericFunctionReadWriteProperty(init: V): () -> ReadWriteProperty<M?, V> =
    { genericReadWriteProperty(init) }

fun <M, V> genericReadWriteProperty(init: V): ReadWriteProperty<M?, V> =
    object : ReadWriteProperty<M?, V> {
        var value: V = init

        override fun getValue(thisRef: M?, property: KProperty<*>): V = value

        override fun setValue(thisRef: M?, property: KProperty<*>, value: V) {
            this.value = value
        }
    }