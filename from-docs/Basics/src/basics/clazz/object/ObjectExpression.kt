package basics.clazz.`object`

import basics.function.isPrime
import basics.function.power
import kotlin.math.sqrt

/**
 * https://kotlinlang.org/docs/reference/object-declarations.html
 * Companion Object
 * https://kotlinlang.org/docs/reference/extensions.html#companion-object-extensions
 * */


open class Point2f(var x: Double, var y: Double) {
    override fun toString(): String {
        return "P($x, $y)"
    }

    /**
     * Atribuindo para o retonno de uma funcao um objeto anonimo.
     *
     * Se nao definirmos um supertipo para o nosso objeto
     * anonimo, o kotlin definira que o o supertipo eh do tipo Any
     * */

    private fun returnSomeThing() = object { val x = "" }

    // exemplo abaixo o nosso objeto anonimo tem como supertipo a interface CharSequence
    // A titulo de teste :)
    private fun charSeqRepresentation() = object : CharSequence {
        /**
         * Como em java, objetos anonimos internos conseguem alcancar membros da classe
         * externa a eles, e diferente de Java, isso nao eh restrito somente a membros
         * marcados como final.
         * */
        val value: String = "Point2f($x, $y)"

        override val length: Int
            get() = value.length

        override fun get(index: Int): Char
                = if (index < length) value[index] else ' '

        override fun subSequence(startIndex: Int, endIndex: Int): CharSequence
                = value.subSequence(startIndex, endIndex)
    }

    /**
     * Objetos anonimos so podem ser usados em declaracoes locais e privadas.
     *
     * Membros criados dentro de objetos anonimos nao sao acessiveis do lado de fora
     *
     * Exemplo
     * val p = Point2f(10.0, 20.0)
     * p.getObject().value // isso nao funciona, causa um erro em tempo de compilacao
     *
     * */

    private fun privateCharSeqRepresentation() = object  {
        val value = "Public Rep: ($x, $y)"
    }

    fun getObject() = object {
        val value = "Teste"
    }

    // se as funcoes charSeqRepresentation e privateCharSeqRepresentation nao forem private
    // nao eh possivel acessar os membros criados dentro dos objetos anonimos retornados
    // por essas funcoes
    fun getStr() : String =  "${charSeqRepresentation().value} - ${privateCharSeqRepresentation().value}"

    companion object
}
// adicionando uma extension function  na Companion Object da classe Point2f
fun Point2f.Companion.euclideanDistance(p: Point2f, q: Point2f) : Double
        = sqrt( ((p.x - q.x) * (p.x - q.x)) + ((p.y - q.y) * (p.y - q.y)) )

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
    val comparator = Comparator<Int?> { p, q -> (p ?: 0) - (q ?: 0) }
    println(comparator.compare(null, null))
    println(comparator.compare(10, 15))
}

fun testObjectPoint() {
    val p = object : Point2f (10.0, 15.0) {
        fun euclidianDistance(q: Point2f) : Double {
            return sqrt( ((x - q.x) * (x - q.x)) + ((y - q.y) * (y - q.y)) )
        }
        // a funcao moveTo so existe nesse objeto anonimo
        fun moveTo(x: Double, y: Double) : Point2f {
            this.x += x
            this.y += y
            return this
        }
    }
    println(p.euclidianDistance(Point2f(15.0, 15.0)))
    println(p.moveTo(10.0, -15.0))
    val q = Point2f(15.3, 127.15)
    println(q.getStr())
}

fun main(args: Array<String>) {
    testObjectPoint()
}