package com.br.samples.ktutorials

typealias IntTransformationOp = (Int) -> Int

inline fun applyOpToValue(target: Int, transform: IntTransformationOp) = transform(target)

// functional programming
// https://kotlinlang.org/docs/tutorials/kotlin-for-py/functional-programming.html
class XorOperation : (Int, Int) -> Int {
    override fun invoke(p: Int, q: Int): Int = p xor q
}

// O compilador informa que nao a ganho algum nesse caso
// ao usar o modificador inline
fun applyXor(p: Int, q: Int, transform: XorOperation) = transform(p, q)

/*
Nao podemos aplicar o modificador inline em funcoes que recebem lambdas como
argumentos e essas funcoes sao armazenadas em variaveis

Se um argument

inline fun <T, R>applyOp(data: T, op: (T) -> R) : R {
    // ainda nao achei um bom motivo para atribuit uma lambda a uma variavel
    val copyOp = op
    return copyOp(data)
}
 */





fun main() {

    val rs = applyOpToValue(10) {
        it xor 0x0f
    }
    println(rs)

    applyXor(12, 5, XorOperation())
}