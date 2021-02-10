package com.br.algorithms.extfun

private fun manyArguments(p: Int, q: Double, s: String)  = "$p, $q, $s"

private fun simpleSample() {
    val q = fun() : Double {
        println(0xff)
        return 0.0
    }
    q.call()
}

private val wrapperFunManyArguments: (Array<Any>) -> String = {
    val (p, q, s) = it
    manyArguments(p as Int, q as Double, s as String)
}

val wrapperSimpleNonArgumentFun: (() -> Unit) -> Unit = { execute -> execute() }

private fun complexSample() {
    println(wrapperFunManyArguments.call(arrayOf(1,2.0, "a")))
}

private fun playWithTimeSpentExtFun() {

    val delay = fun() { for (i in 0 .. 10000000000) {} }

    /**
     * aqui temos uma ext function para funcoes
     *
     * Ela eh capaz de calcular o tempo de execucao de calcular o tempo de execucao
     * de quqlquer funcao
     * */
    println(wrapperSimpleNonArgumentFun.timeSpent(delay))

    println(wrapperFunManyArguments.timeSpent(arrayOf(1,2.0, "a")))
}

fun main() {
    playWithTimeSpentExtFun()
}