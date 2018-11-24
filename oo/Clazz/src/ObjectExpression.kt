/**
 * https://kotlinlang.org/docs/reference/object-declarations.html#object-declarations
 *
 * */



// Object Declaration
object Triangle {

    fun getId(): String {
        return "Triangle"
    }
}

/**
 * Companion Object
 * */


class Clazz {
    companion object {
        const val T = 0.12f
        fun instance() : Clazz =  Clazz()
        override fun toString(): String {
            return "${this.javaClass}"
        }
    }
}


abstract class Polygon {
    abstract fun area() : Double
}

interface Geom {
    fun rotate()
}


class Square {

     val l: Double

    constructor(l: Double) {
        this.l = l
    }


    /**
     * Companion Object podem implementar interfaces ou ser especializacoes
     * de outras classes
     * */
    companion object : Geom, Polygon() {

        override fun area(): Double {
            return 0.0
        }

        override fun rotate() {

        }
    }
}


fun main(args: Array<String>) {
    println(Triangle.getId())

    println(Clazz.Companion.instance())

    // Podemos usar o nome da classe como referencia ao objeto companion dela mesma
    val refCompanio = Clazz
    println(refCompanio.instance())




}