package com.br.sample.properties.delegated.function

import com.br.sample.properties.delegated.getValue

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

fun main() {
    showCharConstants()
}