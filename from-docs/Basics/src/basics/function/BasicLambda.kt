package basics.function

/**
 * https://kotlinlang.org/docs/reference/lambdas.html#lambda-expressions-and-anonymous-functions
 * */

val sum = {a: Int, b: Int -> a + b}

fun main(args: Array<String>) {
    println(sum(10, -15))
}