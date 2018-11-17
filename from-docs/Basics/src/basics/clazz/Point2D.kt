package basics.clazz

import kotlin.math.sqrt

open class Point2D(open val x: Double, open val y: Double) {

    /**
     * funcoes marcadas com a keyword infix podem ser chamadas usando
     * a infix notation 'a operation b'
     * */
    infix fun minus(p: Point2D): Point2D {
        return Point2D(x - p.x, y - p.y)
    }

    infix fun plus(p: Point2D): Point2D {
        return Point2D(x + p.x, y + p.y)
    }

    override fun toString(): String {
        return "$x, $y"
    }
}

/**
 * https://kotlinlang.org/docs/reference/functions.html#infix-notation
 * Podemos criar funcao infix como funcao de extensao
 * */
infix fun Point2D.distance(q: Point2D): Double = sqrt((x - q.x) * (x - q.x) + (y - q.y) * (y - q.y) )


fun main(args: Array<String>) {
    val p = Point2D(2.0, 3.0);
    val q = Point2D( 3.0, 4.0);
    // infix notation
    val s = p plus q
    println(s)
    println(p distance q)
}
