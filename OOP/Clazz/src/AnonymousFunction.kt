import kotlin.math.sqrt

interface Run {
    fun execute(s: String)
}


open class Point(val x: Double, val y: Double) {
    open fun distance(q: Point) : Double {
        return sqrt((this.x - q.x) * (this.x - q.x) + (this.y - q.y) * (this.y - q.y))
    }
}

fun main(args: Array<String>) {
    // https://kotlinlang.org/docs/reference/object-declarations.html#object-expressions
    val run = object : Run {
        override fun execute(s: String) {
           println(s)
        }
    }

    /**
     * Criando uma instancia da classe Point com uma pequena modificacao
     * */
    val modifiedPoint = object : Point(2.0, 3.0) {
        override fun distance(q: Point): Double {
            return -sqrt((this.x - q.x) * (this.x - q.x) + (this.y - q.y) * (this.y - q.y))
        }
    }

    run.execute("Teste")

    println(modifiedPoint.distance(Point(3.0, 15.0)))

    /**
     * Criando objetos simples
     * */

    val p4d = object {
        var x = 0.0
        var y = 0.0
        var z = 0.0
        var t = 0.0
        // isso nao eh possivel :)
        override fun toString(): String {
            return "$x, $y, $z, $t"
        }
    }

    p4d.x = 2.0
    p4d.y = -3.0
    p4d.z = -13.0
    p4d.t = 3600.0 * 24.0
    println(p4d)


}