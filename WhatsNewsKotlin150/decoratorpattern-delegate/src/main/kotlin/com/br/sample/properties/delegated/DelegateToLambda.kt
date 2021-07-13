package com.br.sample.properties.delegated

import kotlin.reflect.KProperty

private fun sample(init: () -> Int) {
    val i: Int by init
    println(i)
}

private operator fun (() -> Int).getValue(not : Nothing?, property: KProperty<*>) = this()

private val fn: () -> Int = { 0xfe }

fun main() {
    sample(fn)
    sample { 0x33 }
}