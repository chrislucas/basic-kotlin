package com.br.sample.properties.delegated.function.localdelegated

import com.br.sample.properties.delegated.getValue

/**
 * https://kotlinlang.org/docs/delegated-properties.html#local-delegated-properties
 *
 * */

data class Data(val x: Double, val isValid: Boolean = false)

fun showData(shouldStart: Boolean, provider: () -> Data) {
    /**
     * Local variable as delegated properties
     * */
    val point by provider
    /**
     * Se shouldStart nao for true a funcao delegate nem sera chamada
     * */
    if (shouldStart && point.isValid) {
        println(point)
    }
}

private fun showDataLazily(shouldStart: Boolean, provider: () -> Data) {
    val point by lazy(provider)
    if (shouldStart && point.isValid) {
        println(point)
    }
}


private fun check1() {
    showData(false) { Data(-1.2) }
    showData(true) { Data(-1.2) }
    showData(true) { Data(-1.2, true) }
}

private fun check2() {
    showDataLazily(false) { Data(-1.2) }
    showDataLazily(true) { Data(-1.2) }
    showDataLazily(true) { Data(-1.2, true) }
}

fun main() {
    check2()
}