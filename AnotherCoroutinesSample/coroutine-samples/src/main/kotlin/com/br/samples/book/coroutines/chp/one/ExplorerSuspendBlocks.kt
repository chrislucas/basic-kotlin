package com.br.samples.book.coroutines.chp.one

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

suspend fun processing() {
    delay(1000)
    println("Processing something")
}

/**
 * https://kotlinlang.org/docs/reference/inline-functions.html#inline-functions
 *
 * Ao usarmos high order function pagamos o preco sobre a performance de sua execucao
 * pois cada funcao eh um objeto.
 *  - Existe o custo da alocacao de memoria
 *      - Para objetos/funcoes e classes
 *      - e chamadas virtuais em tempo de execucao que inserem uma sobrecarga
 *
 * Em alguns casos eh possivel eliminar essa sobrecarga (overhead) aplicando o chamado
 * inlining nas 'lambdas expressions'.
 *
 * INLINE modifier:
 * O modificardor inline afeta a funcao em si e a funcao lambda passada para ela. Ambas serao transformadas
 * (a funcao lambda passara a fazer parte do corpo da funcao que a recebe) no local de chamada.
 * O processo de inlining pode causar um aumento codigo gerado no final. Porem utilizando o recurso de forma inteligente
 * (nao aplicando inline em lambdas cujo codigo é grande), pode-se alcancar ganhos de desempenho do programa.
 *      - Um exemplo de ganho de desempenho destacado pela documentacao eh o caso: "megamorphic" call-sites inside loops
 *      (pesquisar sobre)
 *
 * NONINLINE modifier:
 * Usado nas lambdas passada por argumento para outras funcoes.
 *
 * */

inline fun lambda(noinline fn: () -> Unit): () -> Unit = fn

fun anotherLambda(fn: () -> Unit): () -> Unit = fn

val anotherOp = fun() { println("Uma funcao anonima") }

fun sampleLambdaExpression() {
    val op: () -> Unit = {
        println("Sou uma lambda chamada por outra")
    }
    lambda(op).invoke()
    anotherLambda(anotherOp).invoke()
}


fun sampleSuspendBlock() {
    val suspendFunFakeProcessing = suspend {
        withContext(Dispatchers.Default) {
            processing()
        }
    }
    runBlocking {
        withContext(Dispatchers.Default) {
            suspendFunFakeProcessing.invoke()
        }
    }
}

fun main() {
    sampleSuspendBlock()
}