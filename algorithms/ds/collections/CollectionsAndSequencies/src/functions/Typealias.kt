package functions

// https://kotlinlang.org/docs/reference/lambdas.html


typealias BinOpInt = (Int, Int) -> Int

typealias BoolBinaryOp<T> = (T, T) -> Boolean

typealias BinaryFun<T> = (T, T) -> T

typealias BinNumberOp<P, Q, R> = (P, Q) -> R

typealias CallBinaryFun<T> = (T, T, BinaryFun<T>) -> T

typealias CallBinNumberOp<P, Q, R> = (P, Q, BinNumberOp<P, Q, R>) -> R


val exp = fun(base: Int, e: Int) : Double {
    return when (e) {
        0 -> 1.0
        1 -> base * 1.0
        else -> 0.0
    }
}

object Test1 {

    @JvmStatic
    fun testBinaryFun() {
        val binaryFun : (Int, Int, BinaryFun<Int>) -> Int = {p, q, fn -> fn(p, q)}

        binaryFun(1, 3) { p, q -> p * q}
    }

    @JvmStatic
    fun testCallBinaryFun() {
        val binaryFun : CallBinaryFun<Int> = {p: Int, q: Int, call: BinaryFun<Int> -> call(p, q)}
        binaryFun(10, 15) { p, q -> p * q }
    }

    @JvmStatic fun testCallBinNumberOp() {
        val binNumberOp : CallBinNumberOp<Int, Int, Double> =
                {p: Int, q: Int, call: BinNumberOp<Int, Int, Double> -> call(p, q)}

        binNumberOp(15, 3, exp)
    }

}


fun main(args: Array<String>) {

}