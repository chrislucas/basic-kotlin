package br.com.sample.tutorials.contextscope

import br.com.sample.log
import br.com.sample.wait
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.coroutineContext

class SimpleCoroutineContext() : CoroutineContext {
    override fun <R> fold(initial: R, operation: (R, CoroutineContext.Element) -> R): R {
        return initial //operation(initial, this)
    }

    override fun <E : CoroutineContext.Element> get(key: CoroutineContext.Key<E>): E? {
        return null
    }

    override fun minusKey(key: CoroutineContext.Key<*>): CoroutineContext {
        return this
    }
}

class SimpleCoroutineScope(override val coroutineContext: CoroutineContext) : CoroutineScope {}

fun customCoroutineScope() {
    val scope = SimpleCoroutineScope(EmptyCoroutineContext)
    runBlocking {
        scope.launch {
            println("${check(this)}")
        }
    }

    val anotherScope = CoroutineScope(EmptyCoroutineContext)
    runBlocking {
        anotherScope.launch {
            println("${check(this)}")
        }
    }
}

internal fun compareCoroutineScopeUsingLaunchFun() {
    runBlocking {
        launch {
            println("${check(this)}")
            // Teste
            coroutineScope {
                println("${check(this)}")
            }
        }
    }
}

internal fun compareCoroutineScopeUsingCoroutineScopeFun() {
    runBlocking {
        coroutineScope {
            println("${check(this)}")
            launch {
                println("${check(this)}")
            }
        }
    }
}

/**
 * https://elizarov.medium.com/coroutine-context-and-scope-c8b255d59055
 * */
suspend fun check(scope: CoroutineScope) = run {
    println("${scope.coroutineContext} | $coroutineContext\nScope: $scope")
    scope.coroutineContext === coroutineContext
}

/**
 * CoroutineScope.launch:
 * ext function de CoroutineScope que recebe como argumento uma CoroutineContext, assim
 * temos duas referencia a context ja que CoroutineScope eh uma referencia a CoroutineContext
 * (A interface CoroutineScope possui o atributo public val coroutineContext: CoroutineContext ).
 *
 * O proposito de funcoes como async e launch eh fornecer uma referece ao escopo em que a
 * coroutine será executada. Essas funcoes sao conhecidas como Coroutine Builders
 *
 * Uma CoroutineScope possui um context (CoroutineContext) que por sua vez possui
 * um Job. Esse Job se tornara o Pai da nova Coroutine.
 *
 * O arugmento CoroutineContext passado para funcao launcher eh
 * um contexto adicional que sera vinculado a nova coroutine e o novo context que serao criados pela
 * funcao buider (launcher), sobreescrevendo
 *
 * Um Job (interface Job : CoroutineContext.Element)
 *
 * O contexto passado por argumento eh juntado ao contexto da CoroutineScope atraves do operador
 *  "+" (veja implementacao CoroutineScope.newCoroutineContext(context: CoroutineContext) )
 * */
fun launchFunFromGlobalScope() = GlobalScope.launch {
    println(this.log("GlobalScope"))
}

/**
 * Exemplo do contexto passado como argumento para funcao launcher e de como esse contexto
 * eh adicionado a coroutine
 * */
fun sampleCoroutinteContext() {
    runBlocking {
        CoroutineScope(Dispatchers.Unconfined).launch(CoroutineName("child")) {
            println("CoroutineContext: $coroutineContext")
        }
        launch (CoroutineName("AnotherChild")) {
            println("CoroutineContext: $coroutineContext")
        }

        launch {
            println("CoroutineContext: $coroutineContext")
        }
    }
}

fun launchFunFromCoroutineScopeFun() = CoroutineScope(Dispatchers.Unconfined).launch {
    println(this.log("CoroutineScope(Dispatchers.Unconfined)"))
}

fun playSampleLaunch() {
    runBlocking {
        wait(3000L)
        val coroutine = launchFunFromGlobalScope()
        println("GlobalScope.launch returned -> ${coroutine[Job]}")
    }
}


fun main() {
    sampleCoroutinteContext()

    println("************************************************************************************************")
    launchFunFromGlobalScope().run {
        //runBlocking { wait(100L) }
        println(this.log())
    }
    println("************************************************************************************************")
    launchFunFromCoroutineScopeFun().run {
        //runBlocking { wait(100L) }
        println(this.log())
    }
}