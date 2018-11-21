package comp.io.fundamentals

/**
 * https://kotlinlang.org/docs/reference/classes.html
 *
 * classes opodem possuir propriedades em Kotlin.
 * Essas propriedades podem ser mutável ou não (imutáveis "Dahn!!" ou somente leitura), usando respectivametne
 * as keywords 'var' ou 'val'
 * */

class Point2D constructor(x: Double?, y: Double) {
    // Type? indica que o numero pode ser Null
    var x: Double? = x

    val getX: Double
        get() = this.x!!

    var y: Double = y

    val getY: Double
        get() = this.y


    override fun toString(): String {
        return "$x. $y"
    }
}

fun main(args: Array<String>) {

    val a = Point2D(2.0, -3.0)
    println(a)
    val b = Point2D(null, -3.0)
    println(b)

}