package basics.function

import basics.sintax.between
import kotlin.math.max
import kotlin.math.min

/**
 * https://kotlinlang.org/docs/reference/functions.html
 *
 * */


open class Point2D(private val x: Double, private val y: Double) {

    infix fun Point2D.minus(p: Point2D): Point2D {
        return Point2D(x - p.x, y - p.y)
    }

    infix fun Point2D.plus(p: Point2D): Point2D{
        return Point2D(x + p.x, y + p.y)
    }

    override fun toString(): String {
        return "$x,$y";
    }
}



/**
 * https://kotlinlang.org/docs/reference/functions.html#infix-notation
 * */

// funcao de extensao na classe Int
infix fun Int.between(range: IntRange): Boolean = this in range


fun testInfixNotation() {
    println(10 between 0..10)
    println(10 between 10..12)
}

fun main(args: Array<String>) {
    testInfixNotation()
}