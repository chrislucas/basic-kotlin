package basic

/**
 * https://kotlinlang.org/docs/reference/generics.html
 *
 * invariate, covariant, contravariamt e bivariant
 * https://www.logicbig.com/tutorials/core-java-tutorial/java-language/java-subtyping-rules.html
 *
 * */



/**
 *  declaration-site variance
 * */
interface Source<out T> {
    fun get() : T
}

fun main(args: Array<String>) {
    val root = Node<Int>()
}