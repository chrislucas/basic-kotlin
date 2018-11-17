package basics.function

/**
 * https://kotlinlang.org/docs/reference/lambdas.html#function-literals-with-receiver
 * https://blog.kotlin-academy.com/programmer-dictionary-function-literal-with-receiver-vs-function-type-with-receiver-cc21dba0f4ff
 * */

open class ModularExp {
    /**
     * Usando Function Type Lambda
     * */
    val multiply: Long.(Long, Long) -> Long = {
        a, m -> ((a % m) * (this % m)) % m
    }
    /**
     * Function Literal With Receiver
     * */
    val exp: Long.(Long, Long, Long.(Long, Long) -> Long) -> Long = {
        e, m, fn: Long.(Long, Long) -> Long ->
        var b = this
        var e = e
        var acc = 1L
        when (e) {
            1L -> acc = b
            0L -> acc = 1L
        }
        while (e > 0) {
            if ( (e and 1) == 1L) {
                acc = fn(acc, b, m)
            }
            b = fn(b, b, m)
            e = e shr 1
        }
        acc
    }
}


open class ModExp {
    /**
     * Testando funcoes que recebe funcoes como argumento
     * */
    fun exp(b: Long, e: Long, m: Long, fn: (Long, Long, Long) -> Long) : Long {
        var acc = 1L
        var b = b
        var e = e
        when (e) {
            1L -> acc = b
            0L -> acc = 1L
        }
        while (e > 0) {
            if ( (e and 1) == 1L) {
                acc = fn(acc, b, m)
            }
            b = fn(b, b, m)
            e = e shr 1
        }
        return acc
    }
}

open class Exp {
    val exp: Double.(Long) -> Double = {
        e: Long ->
        var b= this
        var e = e
        var acc = 1.0
        when {
            e < 0 -> {
                b = 1/b
                e = -e
            }
            e == 0L -> acc = 1.0
            e == 1L -> acc = this
        }
        while (e > 0) {
            if ((e and 1L) == 1L) {
                acc *= b
            }
            b *= b
            e = e shr 1
        }
        acc
    }
}



fun testLambda2() {
    //val plus :  Int.(Int) -> Int = { a -> this + a }
    //println(plus(10, 20))
    val e = Exp()
    println(e.exp(5.0, -3))

    val m = ModularExp()
    println(m.exp(10L, 15L, 123L, m.multiply))
    println(m.exp(12L, 15L, 123L, m.multiply))

    val m1 = ModExp()
    // multiplicacao modular usando lambda
    val fn = { a: Long, b: Long, c: Long -> ((a % c) * (b % c)) % c }
    println(m1.exp(12L, 15L, 123L, fn))
}

fun testAnonymousFn() {
    val anon = fun(a: Int) : Boolean = a and 1 == 0
    val list = (0..100).toList().filter(anon)
    //val _list = (0..100).toList().filter { a: Int -> a and 1 == 0}
    println(list)
}


fun testClosure() {

}

fun main(args: Array<String>) {
    testAnonymousFn()
}