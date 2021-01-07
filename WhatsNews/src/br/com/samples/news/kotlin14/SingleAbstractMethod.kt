package com.br.samples.news.kotlin14

/**
 * https://kotlinlang.org/docs/reference/fun-interfaces.html
 * Kotlin 1.4
 *
 * "An interface with only one abstract method is called 'functional interface' or a
 * Single Abstract Method (SAM) interface"
 *
 * Diferencas entre Functional Interfaces e TypeAlias
 *  - Servem a propositos diferentes
 *      - Typealias eh um recurso para renomear tipos, nao sendo capaz de criar novos tipos, FuncInterface consegue
 *      - Typealias pode ter um unico membro, ao passo que FuncInterface pode possuir N nao abstratos membros porem
 *      uma unica membro abstrato
 *      - Functional interfaces podem extender a outras interfaces
 *
 * */

// Abauxi temos uma functional interface
private fun interface SimpleMatch {
    fun isMatching(data: String, regex: Regex) : Boolean
}

// udsnfo lambda para criar uma instance ao inves
private val validate = SimpleMatch { data, regex -> data.matches(regex) }

fun main() {
    val rs = validate.isMatching("321.141.456-78", Regex("(\\d{3}\\.){2}\\d{3}-\\d{2}"))
    println(rs)
}