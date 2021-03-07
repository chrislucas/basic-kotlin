package br.com.sample.chp.keypieces

import br.com.sample.wait
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


fun main() {
    val mainScope = MainScope()
    mainScope.launch {
        println("MainScope $this")
        wait(1000L)
        println("Fim")
    }
}