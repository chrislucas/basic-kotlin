package sample

val transformWithBinaryOperator: (Int, Int.(Int) -> Int, (Int) -> Int) -> Int = {
    value, op, fn -> value.op(fn(value))
}

fun test() {
    println(transformWithBinaryOperator(10, Int::xor, Int::countBits))
    println(transformWithBinaryOperator(10, Int::and, Int::countBits))
    println(transformWithBinaryOperator(10, Int::or, Int::countBits))
}

fun main() {
    test()
}