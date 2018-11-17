fun sum(a: Int, b: Int) = a + b

fun sumWithReturn(a:Int, b:Int): Int {
    return a + b
}
// https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html
// Unit corresponde ao tipo void em java

fun showMessage(msg: String): Unit {
    println(msg)
}


/**
 * Definindo variaveis
 *
 * */

val a : Int  = 1 // forma explicita
val b = 1 // por inferencia o kotlin definira `b` como int

fun test(): Unit {
    // quando a variavel nao precisar ser inicializada
    // so funciona dentro de funcoes
    val c: Int
    c = 3
    println("%d".format(c xor 1))
}



fun main(args: Array<String>) {
    showMessage(sum(100, 129).toString())
    showMessage(sumWithReturn(1203, -7).toString())
    test()
}