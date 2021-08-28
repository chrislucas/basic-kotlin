package com.br.sample.properties.delegated.requirements

import com.br.sample.properties.delegated.createGenericDelegateReadAndWrite
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * https://kotlinlang.org/docs/delegated-properties.html#property-delegate-requirements
 *
 * os operadores getValue() e/ou setValue de um Delegate podem ser implementados como
 * funcoes membros de uma classe Delegate ou como extension functions. Este ultimo
 *
 * */


fun <V> genericDelegateReadAndWrite(init: V): ReadWriteProperty<Nothing?, V> =
    object : ReadWriteProperty<Nothing?, V> {
        var value: V = init

        override fun getValue(thisRef: Nothing?, property: KProperty<*>): V = value

        override fun setValue(thisRef: Nothing?, property: KProperty<*>, value: V) {
            this.value = value
        }
    }


class GenericReadWriteProperty<V>(private var init: V) : ReadWriteProperty<Nothing?, V> {

    override fun getValue(thisRef: Nothing?, property: KProperty<*>): V = init

    override fun setValue(thisRef: Nothing?, property: KProperty<*>, value: V) {
        this.init = value
    }
}


data class Point2f(val pair: Pair<Long, Long>)

fun create() {
    var point2f: Point2f by genericDelegateReadAndWrite(Point2f(20L to 12L))
    println(point2f)
    point2f = Point2f(30L to 150L)
    println(point2f)

    var point2f2: Point2f by GenericReadWriteProperty(point2f)
    println(point2f2)
    point2f2 = Point2f(23L to -123L)
    println(point2f2)
    println(point2f)
}

private fun createInt() {
    var value: Int by createGenericDelegateReadAndWrite(0)
    println(value)
    value = -123
    println(value)
}


fun main() {
    create()
}