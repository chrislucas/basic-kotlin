package samples

/**
 * https://www.youtube.com/watch?v=wAQCs8-a6mg
 * */



fun <T, R> T.caller(fn: (T) -> R) = fn(this)

inline fun <T, R> T.inlineFunCaller(fn: (T) -> R) = fn(this)

fun <T> T.transform(fn: T.() -> T) : T {
    fn(this)
    return this
}

inline fun <T> T.anotherTransform(fn: T.() -> T) : T {
    fn(this)
    return this
}

fun Int.isOdd() = this and 1 == 1

class Test<T> (var attr: T)  {


    fun testCaller() {
        // quando uma funca A que recebe uma funcao B como parametro  nao eh definida como inline
        // o compilador passa como argumento dessa funcao  A uma instancia
        // anonima de FunctionN. Veja no bytecode Kotlin atraves da IDE e no codigo Decompiliado
        // Essa instancia anonima gera um overhead em tempo de execucao por cnta do alocamento extra de memoria
        attr.caller { println(this) }
    }

    fun <R> testCaller(fn: (T) -> R): R = attr.caller(fn)

    fun testInlineCaller() {
        // como 'anotherCaller' foi definido como inline, o compilador
        // copia a HighOder function passada para funcao inline e insere
        // diretamente na funcao final compialda. Existe contra indicacoes
        // caso a High Order function seja muito grande (argumento um pouco subjetivo)
        attr.inlineFunCaller {
            println(it)
        }
    }

    fun testInlineCaller(fn: (Test<T>) -> Unit) = this.inlineFunCaller(fn)

    fun testTransform(fn: Test<T>.() -> Test<T>) : Test<T> = this.transform {
       fn(this)
    }

    fun testTransformOtherWayToCall(fn: (Test<T>) -> Test<T>) : Test<T> = this.transform(fn)

    fun testAnotherTransform(fn: Test<T>.() -> Test<T>) : Test<T> = this.anotherTransform(fn)

    fun testExtensionFun() {
        10.isOdd()
    }

    override fun toString(): String = "Attr $attr"
}

fun main(args: Array<String>) {
    val test = Test(10)
    test.testCaller()

    test.testCaller { it and 1 == 0 }
    println(test)

    test.testInlineCaller {
        it.attr = it.attr shl 10
    }
    println(test)

    test.testTransform {
        this.attr = this.attr shl 1
        this
    }

    println(test)

    test.testAnotherTransform {
        this.attr = this.attr shl 3
        this
    }

    println(test)

}


