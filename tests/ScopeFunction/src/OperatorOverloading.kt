import java.awt.Point
import kotlin.math.sqrt

// https://kotlinlang.org/docs/reference/operator-overloading.html


class Point2D (var x: Double, var y: Double) {
    override fun toString(): String = "P($x, $y)"
    fun eDistance(q: Point2D) : Double  {
        val d = (q-this)
        return sqrt(d.x*d.x + d.y*d.y)
    }

    // Single expression function e Infix notation
    // https://kotlinlang.org/docs/reference/functions.html#single-expression-functions
    // https://kotlinlang.org/docs/reference/functions.html#infix-notation
    /**
     * Restricoes
     * They must be member functions or extension functions;
     * They must have a single parameter;
     * The parameter must not accept variable number of arguments and must have no default value.
     * */
    infix fun distance(q: Point2D) = sqrt( (x - q.x) * (x - q.x) + (y - q.y) * (y - q.y) )
}

//operator fun Point2D.plus (q: Point2D) = Point2D(x + q.x, y + q.y)
operator fun Point2D.minus (q: Point2D) = Point2D(x - q.x, y - q.y)

operator fun Point2D.plusAssign(q: Point2D) {
    this.x += q.x
    this.y += q.y
}

operator fun Point2D.minusAssign(q: Point2D) {
    this.x -= q.x
    this.y -= q.y
}



operator fun Point2D.inc() = Point2D(x+1, y+1)
operator fun Point2D.dec() = Point2D(x-1, y-1)
operator fun Point2D.unaryMinus() = Point2D(-x, -y)

fun testOverloadingOperatorInPointClass() {
    //println(Point2D(10.0, 15.0) + Point2D(15.7, -10.3))
    //println(-Point2D(10.0, 15.0))

    var q = Point2D(10.0, -15.0)
    println("Value of q: $q")
    println("Value of ++q ${++q}")
    /**
     * Abaixo o que acontece primeiro e o valor de que
     * e inserido em r depois q sera incrementado
     * */
    val r = q++
    println("Value of r: $r")
    println("Value of q: $q")
    println("Value of --q ${--q}")
}

/**
 * Teste 'in' operator
 * https://kotlinlang.org/docs/reference/operator-overloading.html#in
 * a in b	b.contains(a)
 * a !in b	!b.contains(a)
 * */


fun <T : Comparable<T>> testInOperator(range: ClosedRange<T>, p: T)  = p in range
fun <T : Comparable<T>> testNotInOperator(range: ClosedRange<T>, p: T)  = p !in range

fun testInAndNotInOp() {
    println(testInOperator(10 .. 15, 16))
    println(testInOperator(IntRange(10, 15), 15))
    println(testInOperator(CharRange('a', 'c'), 'c'))
    println(testNotInOperator(CharRange('a', 'c'), 'd'))
}

fun testPlusAssignedPoint2D() {
    val p = Point2D(1.0, 1.0)
    val q = Point2D(1.0, -2.0)
    p += q
    println(p)
    println(p distance q)
}

fun main(args: Array<String>) {

    testPlusAssignedPoint2D()

}