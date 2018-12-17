package basics.function.functionscope


/**
 * inline fun T.apply(block: T.() -> Unit): T
 *
 * inline fun T.also(block: (T) -> Unit): T
 * */

fun testApplyFunScope() {
    val value = 10
    /**
     * Existe uma relacao entre apply e also (as duas funcoes retornam this porem
     * apply recebe como argumento uma funcao de extensao de 'T' (uma instancia de uma classe qualquer)
     * enquanto also recebe uma funcao F cujo argumento eh 'T')
     * da mesma forma que let e run
     * */
    val extFunction: Int.() -> Int = { this xor 0xf }
    val rs = value.apply { print("Op-apply : ${extFunction()} ") }
    println("Apply: $rs")

    /**
     * O objeto 'T' que executa a funcao 'also' tera
     * o seu valor usado numa operacao executada pela funcao 'also'
     * e essa funcao retorna pode retornar qualquer valor, uma vez
     * que also retorna 'this' que eh a referecia ao objeto 'T'
     * */
    val parameterizedFunc: (i: Int) -> Int = { it xor 0xf }
    val rs2 = value.also { print("Op1-also: ${parameterizedFunc(it)} ") }
    println("Also: $rs2")

    /**
     * A relacao entre let e run eh a seguinte:
     * Ambas as funcoes recebem como argumento uma funcao 'F' que eh executada
     * ao final, assim o retorno de 'F' e o retorn de let e run.
     *
     * A diferenca eh que em 'let' a funcao 'F' eh uma funcao comum que recebe
     * como argumento um objeto do tipo 'T' e retorna uma valor do tipo 'R'
     * ja em 'run' a funcao 'F' eh uma funcao de extensao de 'T', ela nao recebe
     * argumentos pois tem acesso a variavel 'this' que representa o valor do objeto
     * que chamou 'run'. 'F' nesse caso retorna um valor do tipo 'R' que se torna o retorno da funcao 'run'
     * uma vez que 'F' eh executada no final de 'run'
     * */

    /**
     * A funcao let e run recebem como argumento uma funcao 'F' e o retorno de ambas
     * e o retorno de 'F'
     * */

    val q = value.let { parameterizedFunc(it) }
    // o interessante eh que a linha abaixo tambem eh possivel
    val q1 = value.let(extFunction)
    val q2 = value.let(parameterizedFunc)

    println("Let: $q, $q1, $q2")

    // 'run' recebendo uma funcao de extensao da classe Int
    val k   = value.run { extFunction() }
    val k1  = value.run(extFunction)
    val k2  = value.run(parameterizedFunc)
    println("Run: $k, $k1, $k2")
}

fun main(args: Array<String>) {
    testApplyFunScope()
}