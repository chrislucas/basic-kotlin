package inline

import functions.BoolBinaryOp

/**
 * @agrawalsuneet: https://medium.com/@agrawalsuneet/inline-function-kotlin-3f05d2ea1b59
 *
 * Inlining function: Basicamente e uma solicitacao ao compilador
 * para copiar o corpo da funcao e colar no local da sua chamada.
 *
 * https://kotlinlang.org/docs/reference/inline-functions.html
 * O uso de higher-order functions acarreta em uma penalidade em tempo de execucao.
 * Em kotlin uma funcao eh um objeto e quando chamadas eh solicitado uma alocação de memoria
 * para ela (Explicacao detalhada no link @agrawalsuneet), aumentando o uso de recursos de maquina.
 *
 *
 * */


/**
 * Usar 'inline' numa funcao que nao possui 'lambdas' como argumento
 * nao tem efeito nenhum apos a compilação;
 *
 * Link com uma explicacao interessante de como inline evita a criacao
 * de Instancias anonimas, econimizando alocacao de memoria
 * https://stackoverflow.com/questions/44471284/when-to-use-an-inline-function-in-kotlin
 *
 * */


private fun isMultipleOf(n: Int, multiple: Int) : Boolean = n % multiple == 0

private inline fun <T> inliningAssert(p: T, q: T, predicate: (T, T) -> Boolean) : Boolean = predicate(p, q)

// Uma funcao publica que seja inline nao pode acessar uma funcao nao publica
// Testando typealias no argumento 'operation'
private inline fun <reified T> Collection<T>.filterBy(q: T, operation: BoolBinaryOp<T>) : Collection<T>
        = this.filter { inliningAssert(it, q, operation) }


fun test1() {
    val op1 =  { p: Int, q: Int -> p % q == 0 }
    (1 .. 100).toList().toTypedArray().filter { op1(it, 5) }
}

fun test2() {
    val op2 = {p: Int -> p%5 == 0}
    (1 .. 100).toList().toTypedArray().filter { op2(it) }
}

fun test3() {
    val array = (1 .. 100).toList().filterBy(5) { v, q -> isMultipleOf(v, q) }
            .toTypedArray()
    println(array)
}


fun main(args: Array<String>) {
    test3()
}