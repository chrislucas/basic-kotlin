import java.lang.reflect.Method
import kotlin.reflect.jvm.kotlinFunction

/**
 * https://kotlinlang.org/docs/reference/classes.html#overriding-properties
 * */
// classes abstratas sao open
abstract class A {
    open fun f() { println("f(): A")}
    open fun b() { println("f(): B")}
    fun fx() { println("fx(): A") }

    abstract fun abstractFn()
}

interface I {
    fun f() { println("f(): I")}
    fun b()
}

interface Q {
    fun f()
    fun b()
    fun t()
}

class B: I, A() {
    /**
     * O metodo f() eh implementado na interface I e na classe
     * A, assim precisamos implementar esse metodo em B para
     * que não haja ambiguidade
     * */
    override fun f() {
        super<A>.f()
        super<I>.f()
        super<A>.fx()
        println("f(): B")
    }
    override fun b() {
        super<A>.b()
        println("b(): B")
    }

    override fun abstractFn() {
        // DO NOTHIN
    }
}

class C: I, A() {
    override fun f() { super<A>.f() }
    override fun b() {
        super.b()
        println("b(): C")
    }

    override fun abstractFn() {
        // DO NOTHING
    }
}

class D: Q, A() {
    /**
     * na classe a implementacao do metodo
     * f e b nao eh obrigatorio pois eles ja sao implemetnados
     * na classe A
     * */

    // porem o metodo 't' precisa ser sobrescrito, pois
    // esse comportamento nao existe nas super classes de 'D'
    override fun t() {
        println("t(): D")
    }

    override fun abstractFn() {
        // DO NOTHING
    }
}

fun main(args: Array<String>) {
    //val b = B()
    //b.f()
    val c = C()
    c.f()

    val d = D()
    d.f()
    d.t()

    val op = {
        method: Method ->
            println("Method name: ${method.name}" +
                    ", ClazzName: ${method.declaringClass.canonicalName}")

    }
    d.javaClass.methods.forEach { op(it) }

}