package basics.function

import java.lang.Comparable
import kotlin.reflect.full.companionObjectInstance
import kotlin.reflect.jvm.jvmName

/**
 * https://kotlinlang.org/docs/reference/inline-functions.html#reified-type-parameters
 *
 * Funcoes de primeira/alta ordem impoem certas penalidades em tempo de execucao: Cada funcao
 * tambem pe um objeto. Alocacao de meoria seja para funcos ou classes e chamadas virtuais
 * introduzem um consumo de memoria (overhead) em tempo de execucao
 *
 * Segundo a documentacao da linguagem, podemos em muitos casos eliminar esse overhead transformando
 * funcoes em 'inline lambda expressions'
 *
 * Quem aplica essa transformacao eh o compilador, mas para que isso ocorra precisamos definir
 * nossa funcao com o modificador 'inline' e escreve-la na forma de lambda
 *
 * O modificador inline afeta a propria funcao e a funcao lambda passada por parametro
 * inline fun <T> lock(lock: Lock, body: () -> T): T { ... })
 *
 * Existe o modificador no inline, para o caso que nao queremos que uma funcao lambda sofra a modificacao
 *
 * inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) { ... }
 *
 * https://blog.kotlin-academy.com/kotlin-programmer-dictionary-function-type-vs-function-literal-vs-lambda-expression-vs-anonymous-edc97e8873e
 * */

inline  fun <T> fn(k: T, v: T,  op1 : (T, T) -> T, noinline op2: (T, T) -> T) {
    println(op1(k, v))
    println(op2(k, v))
}


/**
 * se uma funcao inlined nao tiver como parametros outras funcoes inlined
 * o compilador ira alertar que o uso do modificador inline eh desnecessario
 *
 *  Explicacao interessante
 * https://kotlinexpertise.com/kotlin-reified-types/
 *
 * Se quisermos lidar com o tipo generico como se fosse uma classe
 * normal dentro do metodo nao consiguiriamos. Para fazermos isso
 * utilizamos a classe Class<T> para acessarmos o nosso tipo generico
 *
 * Entretando, se utilizarmos o modificador 'reified' (permite trarar o abstrato como concreto)
 * consiguimos trabalhar com o tipo generico como se fosse uma classe Normal
 *
 * Ponto importante
 * inline reified functions nao sao interoperaveis com o Java, inline functions
 * normais sao.
 * */

inline fun <reified T> inlinedFun(clazz: Class<T>, p: String) {
    println("Fields\n")
    clazz.fields.forEach { println(it) }
    println("Constructors\n")
    clazz.constructors.forEach { println(it) }
    println("Methods\n")
    clazz.methods.forEach { println(it) }
    println("")
    // https://kotlinlang.org/docs/reference/exceptions.html
    try {
        val q = 10 as T?
        println(q)
    } catch (e: Exception) {
        println(e.message)
    }

    // sem o modificador reified teriamos um erro de compilacao na expressao (p is T)
    println("$p : -> p is 'T = ${p is T}")
}


inline fun <reified P, Q> testReifiedModifier(value: P, q: Q, r: Class<Q>) {
    val q = 10
    println(q)
    println("q = $q\n${if (q is P) "q is instanceOf T" else "q is not instanceOf T"}\n")

    println("Constructors of ${P::class}\n")
    /**
     * Usando te como class. Isso so possivel gracas ao modificador reified
     * */
    P::class.java.constructors.forEach { println(it)}
    // a linha abaixo nao compila se nao usarmos o reified
    //Q::class
    // para acessar o atributo como classe precisamos passa-lo como uma classe
    println("Constructors of $r\n")
    r.constructors.forEach { println(it) }

    println("Member of of ${P::class}\n")
    val kClassP = P::class
    kClassP.members.forEach { println(it) }

    println("Kotlin JVM name: ${kClassP.jvmName}")
    println("Kotlin companionObjectInstance: ${kClassP.companionObjectInstance}")

    val jClassP = P::class.javaClass



}

/**
 * Refeid typed parameters
 * https://kotlinlang.org/docs/reference/inline-functions.html#reified-type-parameters
 * https://kotlinexpertise.com/kotlin-reified-types/
 * */


inline fun fn2(op: () -> Unit) { op() }

fun main(args: Array<String>) {
    //fn2 (fun () : Unit { println(0x0f)})
    //fn2 { println(0xff)}
    //inlinedFun(Double::class.javaObjectType, "10")
    testReifiedModifier("Teste", 10, Int::class.javaObjectType)
}


fun test() {
    val k = 1024
    val v = 128
    val op1 : (Int, Int) -> Int = { p, q -> p xor q}
    val op2 : (Int, Int) -> Int = { p, q -> p + q}
    fn(k, v, op1, op2)
}