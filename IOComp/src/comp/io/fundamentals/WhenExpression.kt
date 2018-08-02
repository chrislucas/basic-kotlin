package comp.io.fundamentals


/**
 * A expressao When substitui o switch-case
 * https://kotlinlang.org/docs/reference/control-flow.html
 * */


fun whenAsStatement(a: Int) {
    when(a) {
        1 -> println("Mensagem 1")
        2 -> println("Mensagem 2")
        in 3 .. 10 -> println("a esta entre 3 e 10 (inclusive)")
        else -> {
            println("Mensagem padrao")
        }
    }
}
fun whenAsExpression(a: Int) {
    val hex = when (a) {
        1 -> 0xff1234
        2 -> 0xff03dd
        else -> {
            0x0f
        }
    }
    println(hex)
}

fun main(args: Array<String>) {
    whenAsStatement(10);
    whenAsExpression(3)
}