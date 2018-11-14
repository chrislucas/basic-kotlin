package oop

/**
 * https://kotlinlang.org/docs/reference/classes.html#overriding-properties
 * */

class Point2D(val x: Double, val y: Double) {
}

open class Polygon {
    protected open lateinit var name: String

    protected open val points: Array<Point2D> = arrayOf(Point2D(0.0, 0.0))

    open var getName: String
        get() {
            return this.name
        }
        set(name) {
            this.name = name
        }

    /**
     * Propriedades somente leitura nao tem metodo set
     * */
    open val getPoint: Array<Point2D>
        get() {
            return this.points
        }

}

class Quadrilater: Polygon() {

}


class Square: Polygon() {
    override var name: String = ""
    override var getName: String
        get() {
            return this.name
        }
        set(name) {
            this.name = name
        }
}



fun main(args: Array<String>) {
    val p: Polygon = Square()
    p.getName = "teste"
    println(p.getName)
}