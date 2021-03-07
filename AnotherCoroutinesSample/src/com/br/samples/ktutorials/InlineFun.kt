package com.br.samples.ktutorials

/**
 * https://kotlinlang.org/docs/reference/inline-functions.html#inline-functions
 *
 * Interessante explicacao sobre o modificador de funcoes 'inline'  e o fato dela evitar a criacao de uma interface anonima
 * para executar uma lambda expression passada como argumento para uma funcao
 * https://stackoverflow.com/questions/44471284/when-to-use-an-inline-function-in-kotlin
 *
 * Pesquisar por: "megamorphic" call-sites inside loops
 *
 * Problemas ao usar
 *
 *
 * */

fun noInlinedLambda(fn: () -> Unit): () -> Unit = fn

fun anotherNoInlinedLambda(fn: () -> Unit) = fn()

inline fun inlined(fn: () -> Unit) = fn()

/**
 * Illegal usage of inline-parameter 'fn' in
 * 'public inline fun <R> test(fn: () -> R): () -> R
 * defined in com.br.samples.ktutorials in file InlineFun.kt'.
 * Add 'noinline' modifier to the parameter declaration
 *
 * inline fun <R> test( fn: () -> R): () -> R = fn
 *
 * Ler
 * https://medium.com/androiddevelopers/inline-functions-under-the-hood-12ddcc0b3a56
 *
 * E a discussao do usuario s1m0nw1
 * https://stackoverflow.com/questions/44471284/when-to-use-an-inline-function-in-kotlin
 *
 * Momentos onde podemos/devemos usar o modificador inline
 *  - Numa funcao A que possui pelo menos um argumento T que seja uma funcao  e essa
 *  e funcao T() eh chamada dentro de A, ou passada para uma outra funcao inline
 *      - Demais argumentos que forem uma funcao e nao se enquadrem nas regras
 *      anteriores, como por exemplo uma funcao que eh atribuida a uma variavel,
 *      devem receber o atributo noinline
 *      Exemplo:
        inline fun sample(noinline lambda: () -> Unit, fn: () -> Unit) {
            val op = lambda
        }
    - Ao usar o modificador 'reified' junto a parametrizacao de tipos genericos o modificador
 inline eh obrigatorio

 *
 * Quando nao usar inline
 *  - Funcoes que recebem outras funcoes como argumento e essas por sua vez sao atribuidas
 *  a uma variavel.
 *  - Funcoes com muitas linhas de codigo, talvez o ganho de performance nao seja alcancado
 *  devido ao tamanho do bytecode gerado
 *
 *  A algumas discussoes sobre o real ganho de performance uma vez o JIT otimiza o codigo trazendo
 *  o corpo de funcoes pequenas para dentro das funcoes que as invocam (Estudar sobre essa otimizacao
 *  do JIT). Nesse mesma discussao no stackoverflow, um usuario informa que ganha-se performace no caso
 *  em q a funcao passada por argumento eh chamada muitas vezes
 *
 * Entao, ao usar o modificador inline numa funcao T, o corpo dela eh copiado pelo compilador
 * e introduzido no lugar da chamada, e as funcoes passadas como argumento tambem que nao
 * sao marcadas como noinline sofrem o mesmo processo
 *
 *
 * */



/**
 * exemplo baseado na documentacao sobre high order function
 *
 * */

class ToggleLockProcessHelper {
    fun lock() {
        println("lock process")
    }

    fun unlock() {
        println("unlock process")
    }
}

// non-inline fun
/**
 * funcoes nao inline que recebem um lambda expression por argumento, ao serem compiladas
 * transformam a expressao numa implementacao de interface anonima. Isso causa um overhead
 * de consumo de memoria, uma vez que um objeto precisa ser criado em tempo de execucao
 * fonte:
 * https://stackoverflow.com/questions/44471284/when-to-use-an-inline-function-in-kotlin
 * https://www.geeksforgeeks.org/kotlin-inline-functions/
 * */
fun noInlinedLockAndProcess(lock: ToggleLockProcessHelper, processing: () -> Unit) {
    process(lock, processing)
}

inline fun inlinedLockAndProcess(lock: ToggleLockProcessHelper, processing: () -> Unit) {
    process(lock, processing)
}

inline fun process(lock: ToggleLockProcessHelper, processing: () -> Unit) {
    lock.lock()
    try {
        processing()
    } finally {
        lock.unlock()
    }
}

fun <T> anotherNonInlinedProcess(lock: ToggleLockProcessHelper, data: T, processing: (T) -> Unit) {
    process(lock, data, processing)
}

inline fun <T> anotherInlinedProcess(lock: ToggleLockProcessHelper, data: T, processing: (T) -> Unit) {
    process(lock, data, processing)
}

inline fun <T> process(lock: ToggleLockProcessHelper, data: T, processing: (T) -> Unit) {
    lock.lock()
    try {
        processing(data)
    } finally {
        lock.unlock()
    }
}


inline fun sample(noinline lambda: () -> Unit, fn: () -> Unit) {
    val op = lambda
}

fun callLambaExpressions() {
    noInlinedLambda {
        println("Ola")
    }.invoke()

    anotherNoInlinedLambda {
        println("Another lambda")
    }

    inlined {
        println("inlined fun")
    }
}

/**
 * Ao abrir o bytecode do metodo abaixo veremos algo bem interessante
 * */
fun sampleInlineAndNoInlineFunCalls() {

    /**
     * O código dentro do método abaixo e transportado para ca
     * */
    inlinedLockAndProcess(ToggleLockProcessHelper()) {
        println("Baixando configuracoes ...")
    }

    /**
     * Aqui o segundo argumento eh uma instancia da classe Function0
     * noInlinedLockAndProcess(new ToggleLockProcessHelper(), (Function0)null.INSTANCE);
     * */
    noInlinedLockAndProcess(ToggleLockProcessHelper()) {
        println("Outro processamento, mas numa funcao non-inline")
    }

    /**
     * A funcao abaixo por ser inline teve tod0 o seu codigo transportado para
     * dentro do corpo da funcao sampleInlineAndNoInlineFunCalls tbm. Os argumentos
     * tornaram-se variaveis locais dessa funcao. Interessante eh ver o reaproveitamento
     * de variaveis como as insta
     * */
    anotherInlinedProcess(ToggleLockProcessHelper(), 1 shl 21) {
        println(it xor 0x0f)
    }

    anotherNonInlinedProcess(ToggleLockProcessHelper(), 1 shl 21) {
        println(it xor 0x0f)
    }
}

fun main() {
    sampleInlineAndNoInlineFunCalls()
}