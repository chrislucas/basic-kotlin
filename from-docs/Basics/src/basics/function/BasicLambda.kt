package basics.function

import kotlin.math.roundToInt
import kotlin.math.sqrt

/**
 * https://kotlinlang.org/docs/reference/lambdas.html#higher-order-functions-and-lambdas
 * https://kotlinlang.org/docs/reference/lambdas.html#lambda-expressions-and-anonymous-functions
 * */

val sum = {a: Int, b: Int -> a + b}


fun <E, R> test(_list: List<E>, acc: R, op: (R, E) -> R) : R {
    return _list.fold(acc, op)
}


fun testLambdaRangeInt() {
    /**
     * Criando uma funcao Lambda
     * */
    val summation = {
        acc: Int, i: Int ->
        val result = acc + i
        result
    }
    println(test((0..100).toList(), 0, summation))
}

fun testLambdaRangeInt2(range: IntRange) {
    /**
     *  *                  n     Primes <= n
     *  ---------------------------------
     *                 10               4
     *                100              25
     *              1,000             168
     *             10,000           1,229
     *            100,000           9,592
     *          1,000,000          78,498
     *         10,000,000         664,579
     *        100,000,000       5,761,455
     *      1,000,000,000      50,847,534
     * */

    val _list = (range).toList()
    /**
     * O compilador consegue inferir o tipo de retorno da funcao
     * se a funcao lambda fornecer uma quantidade de informacao suficiente
     * */
    val isPrime = {
        i: Int ->
        val limit = sqrt(i * 1.0).roundToInt()
        var flag = i > 1
        for (k in 2..limit) {
            if (i % k == 0) {
                flag = false
                break
            }
        }
        flag
    }
    println(_list.count(isPrime))
    println(_list.findLast(isPrime))
    println(_list.map(isPrime))
    println(_list.filter(isPrime))
}


fun testLambda() {
    /**
     * Escrevendo uma funcao lambda que nao recebe argumento
     * */
    val test: () -> Unit = {
        println(0xf xor 0x01)
    }

    val test2 = {
        println(0xff and 0x12)
    }

    val test3 = {
        a: Int, b: Int -> a and  b
    }

    val test4 = {
        a: Int, b: Int -> a +  b
    }

    test()
    test2()
    println(test3(15, 14))
}

fun main(args: Array<String>) {
    //testLambdaRangeInt2( (0..100000))
    testLambda()
}