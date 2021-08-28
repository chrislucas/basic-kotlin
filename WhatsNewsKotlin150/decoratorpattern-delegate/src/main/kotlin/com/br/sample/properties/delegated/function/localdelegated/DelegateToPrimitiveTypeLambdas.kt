package com.br.sample.properties.delegated.function.localdelegated

import com.br.sample.general.join
import com.br.sample.properties.delegated.getValue
import com.br.sample.general.string

private fun showInt(init: () -> Int) {
    val value: Int by init
    println(value)
}

private fun showShort(init: () -> Short) {
    val value: Short by init
    println(value)
}

private fun showChar(init: () -> Char) {
    val value: Char by init
    println(value)
}

private fun showLong(init: () -> Long) {
    val value: Long by init
    println(value)
}

private fun showDouble(init: () -> Double) {
    val value: Double by init
    println(value)
}

private fun showDoubles(init: () -> Array<Double>) {
    val values: Array<Double> by init
    println(values.join())
    println(values.string)
}

private fun showCharConstants() {
    showChar { Char.MAX_HIGH_SURROGATE }
    showChar { Char.MIN_HIGH_SURROGATE }
    showChar { Char.MAX_LOW_SURROGATE }
    showChar { Char.MIN_LOW_SURROGATE }
    showChar { Char.MAX_VALUE }
    showChar { Char.MIN_VALUE }
    showInt { Char.SIZE_BITS }
    showInt { Char.SIZE_BYTES }
}

private fun showIntConstants() {
    showInt { Int.SIZE_BITS }
    showInt { Int.SIZE_BYTES }
}

private fun showShorConstants() {
    showShort { Short.MAX_VALUE }
    showShort { Short.MIN_VALUE }
    showInt { Short.SIZE_BITS }
    showInt { Short.SIZE_BYTES }
}

private fun showLongConstants() {
    showLong { Long.MAX_VALUE }
    showLong { Long.MIN_VALUE }
    showInt { Long.SIZE_BITS }
    showInt { Long.SIZE_BYTES }
}

private fun showDoubleConstants() {
    showDouble { Double.MAX_VALUE }
    showDouble { Double.MIN_VALUE }
    showInt { Double.SIZE_BITS }
    showInt { Double.SIZE_BYTES }
}

fun main() {
   // showCharConstants()

    showDoubles { arrayOf(0.0, 1.0, -2.0) }
}