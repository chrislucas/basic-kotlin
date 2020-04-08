package functions

// https://kotlinlang.org/docs/reference/functions.html

// lambda expression sintaxex
val modI = {p: Int, q: Int -> p % q}

// outra forma de escrever lambdas
val modI2: (Int, Int) -> Int = {p, q -> p %q}

// anonymous fun com single expression
val anounModI = fun(p: Int, q: Int) =  p % q

// usando typealias para definir tipos
val modAlias : BinOpInt = {p: Int, q: Int -> p % q}


object Test {

    @JvmStatic
    fun defaultParamsValues(a: Int, b: Int = 1, c: Int) {
        println(a+b+c)
    }

    fun sameFn() {
        println(modI(10, 7))
        println(anounModI(10, 7))
        println(modAlias(10, 7))
    }

    fun lambdaFn(fn: () -> Unit) {
        fn()
    }

    fun lambdaFn2(fn : (Int, Int) -> Unit, a: Int, b: Int) {
        fn(a,b)
    }

}


fun main(args: Array<String>) {
    //Test.defaultParamsValues(0, c = 10)
    Test.lambdaFn { println(0xff and 0xdd) }

    Test.lambdaFn2 ({p: Int, q: Int -> p * q }, 6, 7)

    val fn: (Int, Int) -> Unit = { p, q -> println( p * q) }
    Test.lambdaFn2 (fn, 6, 7)
}