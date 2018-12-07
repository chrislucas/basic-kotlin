package basics.function.functionscope


/**
 * inline fun T.apply(block: T.() -> Unit): T
 *
 * inline fun T.also(block: (T) -> Unit): T
 * */

fun testApplyFunScope() {
    val op: (i: Int) -> Int = {
        it ->
            it xor 0xf
    }

    val value = 10

    /**
     * Existe uma relacao entre apply e also
     * da mesma forma que let e run
     * */

    val rs = value.apply { println( -(this xor 1)) }
    println("Apply: $rs")

    /**
     * O objeto que executa a funcao 'also' tera
     * o seu valor usado numa operacao executada pela funcao 'also'
     * e essa funcao retorna
     * */
    val rs2 = value.also { println( op(it)) }
    println("Also: $rs2")
}

fun main(args: Array<String>) {
    testApplyFunScope()
}