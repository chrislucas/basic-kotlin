package basics.function

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
        return "${x},${y}";
    }
}



/**
 * https://kotlinlang.org/docs/reference/functions.html#infix-notation
 * */




fun testInfixNotation() {

}

fun main(args: Array<String>) {

}