package functions

// https://kotlinlang.org/docs/reference/functions.html

// lambda
val modI = {p: Int, q: Int -> p % q}

// anonymous fun com single expression
val anounModI = fun(p: Int, q: Int) =  p % q

val modAlias : Mod = {p: Int, q: Int -> p % q}

fun main(args: Array<String>) {
    println(modI(10, 7))
    println(anounModI(10, 7))
    println(modAlias(10, 7))
}