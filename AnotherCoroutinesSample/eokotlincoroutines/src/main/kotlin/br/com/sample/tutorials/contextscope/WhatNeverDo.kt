package br.com.sample.tutorials.contextscope

import br.com.sample.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.coroutineContext

/**
 * https://elizarov.medium.com/coroutine-context-and-scope-c8b255d59055
 * Scope vs Context
 *
 * Em suma, uma CoroutineScope possui uma CoroutineContext assim
 * uma um escopo tem referencia a um contexto. Ao utilizar uma funcao
 * builder (CoroutinexScope.launch ou CoroutineScope.async) uma nova
 * coroutine sera criada que tera uma nova instancia de Job associada
 * a ela
 *
 * A IDE facilita o reconhecimento de um contexto de uma funcao builder
 * marcando o bloco que ela está sendo implementada com 'this: Coroutine'
 *
 * Quando nos deparamos com um bloco launch { ... } sem seu
 * respectivo receiver (No caso o Receiver seria uma instancia de CoroutineScope, por exemplo
 * o escopo de runBlocking fornece uma coroutine escope) podemos concluir que o escopo
 * que essa funcao esta sendo executada está no bloco acima, que a envolve.
 *
 * O contexto e o escopo  (CoroutineContext e CoroutineScope)
 * sao considerados praticamente a mesma coisa (isso foi dito pelo autor do arquivo, eh uma definicao
 * que ainda nao compreendo), assim podemos lancar uma coroutine sem ter acesso a uma coroutinescope
 * e sem usar o GlobalScope. Para isso basta
 *
 * 1) criar uma suspen function
 * 2) cria uma CoroutineScope atraves do metodo:
 *      - 'public fun CoroutineScope(context: CoroutineContext): CoroutineScope'
 *
 *      2.1) Usar o coroutineContext da suspend fun para criar uma instancia de
 *      CorountineScope(context) (wrapping)
 *
 * 3) a partir da instancia de coroutineScope chamar o metodo launch  { ... }
 *
 *
 * */

/**
 * Criando uma coroutine com o escopo vindo do metodo CoroutinteScope e o contexto
 * da propria suspend fun.
 *
 * O autor do artigp de onde esse exemplo foi tirado nos adverte para nunca
 * fazer isso alegando que o escopo que a coroutine sera lancada será 'opaco',
 * 'implicito' fazendo com que outro Job nao relacionado a essa coroutine seja capturado
 * para lança-la. "Uma coroutine eh um trecho de codigo que eh concorrente com o restante
 * do codigo do programa seu lancamento precisa ser explicito" (Roman Elizarov
 * Leia - https://elizarov.medium.com/explicit-concurrency-67a8e8fd9b25)
 * */

suspend fun example() =
        CoroutineScope(coroutineContext).launch {
            println("Whatever")
        }


suspend fun wrapperCoroutineFun(fn: () -> Unit): Job =
        CoroutineScope(coroutineContext).launch { fn() }

suspend fun wrapperCoroutineSuspendFun(fn: suspend () -> Unit): Job =
        CoroutineScope(coroutineContext).launch { fn() }

fun explorerJobInstance() {
    runBlocking {
        val job = wrapperCoroutineFun {
            println("explorerJobInstance\n${this.log("sample")}")
        }
        println(job.log())
    }
}

fun explorerCoroutineScope() {
    runBlocking {
        wrapperCoroutineFun {
            println("wrapperCoroutineFun\n${this.log("sample")}")
        }
    }
    println("*****************************************************************************")
    runBlocking {
        wrapperCoroutineSuspendFun {
            println("wrapperCoroutineSuspendFun\n${this.log("sample")}")
        }
    }
}

fun main() {
    explorerCoroutineScope()
}
