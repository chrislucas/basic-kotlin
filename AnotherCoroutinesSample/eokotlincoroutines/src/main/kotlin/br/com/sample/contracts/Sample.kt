package br.com.sample.contracts

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind

import kotlin.contracts.contract

/**
 * O compilador kotlin faz analise estatica de codigo com objetivo de reduzir boilerplate e prover warnings sobre
 * mas pratica e melhorias de codigo. Alem disso, essa analise eh capaz de fazer o chamado smartcast como por exemplo
 *
 * fn(s: String?) {
 *  if(s != null) s.length // aqui nao eh necessario usar o operador null-safety por causa da analise estatica e o smartcast
 * }
 *
 * entretanto, quando colocamos a validacao acima num metodo separado, o smartcast nao eh realizado. Para suprir essa
 * deficiencia surgiu o recurso chamado 'contract'
 *
 * Contracts permite que uma funcao descreva seu comportamento para o compilador
 *
 * Atualmente 2 tipos de casos sao suportados
 *  A - Melhora de analise de smartcasting ao declarar a relacao entre o resultado da chamada de um funcao e os
 *  argumentos passados para ela
 *  B - Melhora a analise de inicializacao de varuavek diante de uma high-order fun
 * */

// caso A.
@ExperimentalContracts
fun require(condition: Boolean, execute: () -> Unit) {
    contract {
        returns() implies condition
    }
    if (condition) {
        execute()
    }
}
// A - o argumento passado por essa funcao sera avaliado pela funcao require que possui um contrato
// que define que o argumento tem que ser aceito por uma condicao
@ExperimentalContracts
fun process(data: String?) {
    // smartcast
    require(data is String) {
        println(data)
    }
}
// Caso B
@ExperimentalContracts
fun <T, R> execute(p: T, q: T, fn:  (T, T) -> R) : R {
    contract {
        // Aqui informacamos ao compilador que fn sera invocado dentro dessa funcao
        // exatamente uma vez
        callsInPlace(fn, InvocationKind.EXACTLY_ONCE)
    }
    return fn(p, q)
}

fun sampleRunBlocking1() {
    val fn: suspend (Int, Int) -> Int = { i, j -> i + j }
    runBlocking {
        withContext(Dispatchers.Default) {
            println(fn(2, 4))
        }
    }
}

@ExperimentalContracts
fun main() {
    process("teste")
    process(null)

    val rs = execute(1, 2) { p, q -> p + q }
    println(rs)
}