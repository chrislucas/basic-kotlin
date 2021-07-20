package com.br.sample.properties.delegated.function.localdelegated

import com.br.sample.properties.delegated.getValue


private fun show(init: () -> Int) {
    val i: Int by init
    println(i)
}


private val fn: () -> Int = { 0xfe }

fun main() {
    show(fn)
    show { 0x33 }
}