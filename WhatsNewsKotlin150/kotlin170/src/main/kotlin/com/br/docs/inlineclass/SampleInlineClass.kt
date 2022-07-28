package com.br.docs.inlineclass

/*
    https://kotlinlang.org/docs/inline-classes.html
    - Por vezes se faz necessario criar classes que "envelopam"
    algum outro tipo (seja uma classe ou um tipo primitivo).

    Para além disso, quando encapsulamos um tipo primitivo, o desempenho
    é afetado, porque tipos primitivos sao geralmente otimizados de forma "agressiva/pesada"
    em tempo de execucao, enquanto uma classe Wrapper nao recebe nenhuma otimizacao

    Para resolver isso, foi introduzido ao kotlin um tipo especial de classe chamada
    inline class. Inline class eh um subconjunto de value-based class
    https://github.com/Kotlin/KEEP/blob/master/notes/value-classes.md

    Ela nao tem uma identidade e so pode conter valores
 */

@JvmInline
value class Password(private val data: String)


private fun createPassword() {
    val pwd = Password("asd8ad7a9da79da7d9a7d")
    println(pwd)
}

@JvmInline
value class Name(private val data: String) {
    init {
        require(data.isNotEmpty())
    }
}


private fun checkNameClass() {
    println(Name(""))
}

fun main() {
    //createPassword()
    checkNameClass()
}