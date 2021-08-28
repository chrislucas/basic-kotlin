package com.br.sample.properties.interceptassign

import java.lang.IllegalArgumentException
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Recurso para interceptar assignment (set/definicao) permitindo até mesmo vetar
 * um assign
 * https://kotlinlang.org/docs/delegated-properties.html#observable-properties
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-delegates/vetoable.html
 *
 * Retornar um metodo que consegue interceptar leitura/escrita de valores numa variavel e executar
 * um callback antes mesmo desse valor mudar
 * */

class Timer {
    var timestamp: Long by Delegates.vetoable(0) { _: KProperty<*>, oldValue: Long, newValue: Long ->
        if (newValue > oldValue) {
            true
        } else {
            throw IllegalArgumentException("Novos valores so podem ser maior que $oldValue")
        }
    }
}


val vetoMinValue: (Int) -> ReadWriteProperty<Any?, Int> = {
    Delegates.vetoable(it) { _, old, new -> old < new }
}

private fun checkAssignIntValue() {
    val veto = vetoMinValue(9)

    var value: Int by veto
    println(value)
    value = 10
    println(value)
    value = 11
    println(value)
    value = 10
    println(value)
}

private fun checkAssignTimestamp() {
    val timer = Timer()
    timer.timestamp = 1
    timer.timestamp = 2
    timer.timestamp = 1
}


fun main() {
    checkAssignIntValue()
}