package basics.clazz

/**
 * https://kotlinlang.org/docs/reference/data-classes.html
 * */

data class Point(val x: Double = 0.0, val y: Double = 0.0)

fun main(args: Array<String>) {
    val original = Point(2.0, 3.0)
    val cp = original.copy()//original.copy(15.0, 32.0)
    println("${original.hashCode()}, ${cp.hashCode()}")
    // destructuring declaration
    val (x, y) = cp
    println("$x, $y")

}