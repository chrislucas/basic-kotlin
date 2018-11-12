package basics.function

import java.util.function.Predicate


/**
 * https://blog.kotlin-academy.com/kotlin-programmer-dictionary-function-type-vs-function-literal-vs-lambda-expression-vs-anonymous-edc97e8873e
 * https://blog.kotlin-academy.com/programmer-dictionary-function-literal-with-receiver-vs-function-type-with-receiver-cc21dba0f4ff
 * https://stackoverflow.com/questions/44273241/explanation-on-function-literal-with-receiver-in-kotlin
 * Estudo exploratorio sobre os tipos de funcoes em kotlin
 *
 * Funcoes em kotlin sao categorizadas como 'first class citizens' (FCC), permitindo que programadores
 * definam variaveis como funcoes, passem funcoes como argumentos de funcoes ou as retorne como
 * resultado de outras funcoes.
 *
 * Variaveis em kotlin sao estaticamente tipadas. Assim, para que a linguagem possa tratar as funcoes
 * como FCC, elas necessitam ter um tipo, que eh definido pelo seu retorno. Esse caracteristica e denominada
 * de 'Function Type'.
 *
 * () -> Unit ...
 * (Int) -> Int ...
 * () -> () -> Unit ... Funcao que retorna uma funcao que nao retorna nada
 *
 * Function Type sao uma forma de escrever codigo (sintax suggar) para definir uma interface.
 * Podemos usa-las como interface, passando-as como argumentos de metodos ou implementando-as
 *
 * */


/**
 * Exemplo de implementacao de uma funcao como interface
 * https://try.kotlinlang.org/#/Kotlin%20Koans/Conventions/Invoke/Task.kt
 *
 * Objetos que implementam o metodo invoke podem ser chamados como funcoes
 * */

open class Point: () -> Unit {
    override fun invoke() {
        println("Test Point Invoke method")
    }
}


open class Temp {
    operator fun invoke() {
        println("Test Temp Invoke method")
    }
}

// extension
fun Int.isPowerOf2() = this.and(this-1) == 0
// outra extension
fun Int.isEven() = this.and(1) == 0

// function reference
val anonFun = fun() { println("Hello World!!!")}

val fnIsNumber = fun(): Regex =  "[0-9]*".toRegex()

val regexIsNumber =  "[0-9]*".toRegex()

fun String.isNumber() = this.matches(fnIsNumber())


fun  testPredicate(range: IntRange, s: Int,  pred: (Int) -> Boolean) {

    val rs = range.step(s).toList().toTypedArray().all { it -> pred(it) }

    println("Intervalo $range ${if (rs) "formado somente por pares" else "possui números impares" }")
}



fun main(args: Array<String>) {
    val p1 = Point()
    p1()
    println(::Point)

    val t1 = Temp()
    t1()
    println(::Temp)

    println(1::isEven)
    println(1::isPowerOf2)
    println(2.isPowerOf2())
    println(::anonFun)
    println(::fnIsNumber)
    println(::regexIsNumber )


    println(fnIsNumber is Predicate<*>)
    println("${Int::isEven} ${ if (Int::isEven is Predicate<*>) "is predicate" else "is not predicate"}" )
    println("${Int::isPowerOf2} ${ if (Int::isPowerOf2 is Predicate<*>) "is predicate" else "is not predicate"}" )

    val f : (Int) -> Boolean = { it.and(1) == 0}
    val p = fun(i: Int) =  i.and(1) == 0

    println("$f ${ if (f is Predicate<*>) "is predicate" else "is not predicate"}" )
    println("$p ${ if (p is Predicate<*>) "is predicate" else "is not predicate"}" )

    println("abc".isNumber())
    println("12456798798798797987".isNumber())


    testPredicate(0..100, 2, f)
    testPredicate(0..100, 1, f)



    println(arrayOf("123", "asdasd", "123asd123").filter(regexIsNumber::matches))

}