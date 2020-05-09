package math.algorithm.geom

import kotlin.math.sqrt

data class Point2f(val x: Double, val y: Double) {

    private fun dX(p: Point2f, q: Point2f) : Double = p.x - q.x

    private fun dY(p: Point2f, q: Point2f) : Double = p.y - q.y

    fun euclideanDistance(that: Point2f) : Double {
        return sqrt(dX(this, that) * dX(this, that)
                + dY(this, that) * dY(this, that) )
    }

    fun translate(x: Double, y: Double) : Point2f = Point2f(this.x + x, this.y + y)
}