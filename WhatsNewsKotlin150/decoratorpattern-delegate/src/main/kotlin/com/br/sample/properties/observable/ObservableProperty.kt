package com.br.sample.properties.observable

import com.br.sample.general.log
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * https://kotlinlang.org/docs/delegated-properties.html#observable-properties
 *
 * Delegates.observable recebe 2 arumentos
 *  - O valor inicial que sera atribuido a variavel
 *  - uma funcao lambda que sera chamada quando a variavel mudar de valor
 *
 * */

class Timer {
    var timestamp: Long by Delegates.observable(System.currentTimeMillis()) {
        property: KProperty<*>, oldValue: Long, newValue: Long ->
        property.log()
        println("\nOld: $oldValue, New: $newValue\n")
    }
}

fun main() {
    val timer = Timer()
    var counter = 0
    while (true) {
        if (counter > 10)
            break
        counter+=1
        timer.timestamp = System.currentTimeMillis()
        Thread.sleep(1000)
    }
}