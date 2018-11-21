package oop


/**
 * Testando a ordem em que construtores e inicializadores de classes Base e subclasses sao
 * executados quando instanciamos subclasses
 *
 * Inicializador da classe base eh executado primerio
 * */
open class A {

    init {
        println("Initialize class A")
    }

    open fun printClassName() {
        println(javaClass.name)
    }
}


open class B : A() {

    init {
        println("Initialize class B")
    }

    override fun printClassName() {
        println(javaClass.name)
    }
}


fun main(args: Array<String>) {

    val instance: A = B()

    instance.printClassName()


}