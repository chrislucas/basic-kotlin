

/**
 * Testando primary constructor em classes
 *
 * Usando a kyeword 'val' para criar/iniciar as propriedades da classe
 * Point2f
 * */
class Point2f constructor(private val x: Double, private val y: Double) {
    init {
        println("Init $this.")
    }

    override fun toString(): String {
        return "P($x, $y)"
    }
}

/**
 * Se usarmos keywords de modificacao de acesso a keyword 'constructor' eh obrigatorio
 * */
open class Node  constructor(private val value: String) {
    constructor() : this("*", null, null)
    protected constructor(value: String, l: Node?,  r: Node?) : this(value)
    override fun toString(): String {
        return "Value: $value"
    }
}


fun main(args: Array<String>) {
    println(Point2f(2.3, -5.7))
    println(Node())
    println(Node("Teste"))
}