package basics.clazz

/**
 *
 * Ao utilizar a a keyword 'val' ou 'var' no construtor da classe estamos
 * definindo os argumentos passados a ele com propriedades dessa classe, imutaveis
 * ou mutaveis respectivamente.
 * */
class P(val x: Int, val y: Int) {
    override fun toString(): String {
        return "$x, $y"
    }
    /**
     * Classes em kotlin nao possuem metodos estaticos. Se
     * quisermos ter metodos que possam ser executados sem instanciar
     * uma classe podemos utilizar os 'companions objects'
     * */
    companion object Operations {
        fun create(x: Int, y: Int) : P = P(x, y)
    }
}

val obj = object {
    var x: Int = 0
    var y: Int = 0
}

/**
 * Companion object
 * https://kotlinlang.org/docs/reference/classes.html#companion-objects
 *
 * Object Expression/Declaration
 * https://kotlinlang.org/docs/reference/object-declarations.html
 * https://kotlinlang.org/docs/reference/object-declarations.html#companion-objects
 * */

fun testCompanionObject() {
    val p = P.create(10, 20)
    println(p)
}

fun testObject() {
    val obj = object {
        var x: Int? = 0
        var y: Int? = 0
        override fun toString(): String {
            return "$x, ${y?:0}"
        }
    }
    obj.x = 10
    obj.y = null
    println(obj)
}


fun main(args: Array<String>) {
    testCompanionObject()
    testObject()
}