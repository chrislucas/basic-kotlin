package basics.clazz.`object`

import basics.clazz.obj
import basics.function.isPrime
import basics.function.power
import kotlin.math.sqrt


/**
 * https://kotlinlang.org/docs/reference/object-declarations.html
 * */

/**
 * Companion Object
 * https://kotlinlang.org/docs/reference/extensions.html#companion-object-extensions
 * */


class Point2f(val x: Double, val y: Double) {
    companion object {}
}
// adicionando uma extension function  na Companion Object da classe Point2f
fun Point2f.Companion.euclideanDistance(p: Point2f, q: Point2f) : Double = sqrt( ((p.x - q.x) * (p.x - q.x)) + ((p.y - q.y) * (p.y - q.y)) )

fun testEuclideanDistanceExtension() {
    println(Point2f.euclideanDistance( Point2f(-10.5, -15.5), Point2f(10.5, 15.5)))
    println(Point2f.euclideanDistance( Point2f(-1.5, -1.5), Point2f(1.5, 1.5)))
}

fun testExtensionInOtherFile() {
    println(127.isPrime())
    println(12.0 power -3)
}

fun testSyntaxObjectExpression () {
    val p = object {}
}

fun testObjectComparator() {
    val comparator = Comparator<Int> { p, q ->
        val p = p ?: 0
        val q = q ?: 0
        p - q
    }
    

    println(comparator.compare(null, null))
    println(comparator.compare(10, 15))
}

fun main(args: Array<String>) {
    testObjectComparator()
}