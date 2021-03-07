package br.com.samples

/**
 * https://kotlinlang.org/docs/reference/operator-overloading.html
 *
 * To implement an operator, provide a member function or an extension function with a fixed name,
 * for a corresponding type
 *
 *
 *      - LEFT-HAND SIDE TYPE for binary op
 *          - p += q plusAssign
 *          - p -= q minusAssign
 *      - ARGUMENT TYPE for unary op
 *
 * FUNCTION THAT OVERLOAD OPERATOR NEED TO BE MARKED WITH THE OPERATOR MODIFIER
 *
 * */

data class Point2DfAssignable(var x: Double, var y: Double) {
    operator fun plusAssign(q: Point2DfAssignable) {
        val newPoint =  Point2DfAssignable(x + q.x, y + q.y)
        with(this) {
            x = newPoint.x
            y = newPoint.y
        }
    }

    operator fun minusAssign(q: Point2DfAssignable) {
        val newPoint = Point2DfAssignable(x - q.x, y - q.y)
        with(this) {
            x = newPoint.x
            y = newPoint.y
        }
    }
}


data class Point2Df(val x: Double, val y: Double) {
    // overloading a binary op
    operator fun plus(q: Point2Df) = Point2Df(x + q.x, y + q.y)

    operator fun minus(q: Point2Df) = Point2Df(x - q.x, y - q.y)

    // unary op
    operator fun unaryMinus() = Point2Df(-x, -y)
    /**
     * inc e dec sao functions que retornam um valor, o qual sera usado para definir o valor
     * da variavel que utilizou o operador posfixado ++ ou -- (p++ for example)
     *
     * Essas funcoes nao devem mudar o valor do objeto que utilizou o operador
     *
     * # COMPORTAMENTO DO OPERADOR POSFIXADO
     *
     * O compilador executa as seguintes operacoes para resolver um operador posfixado (p++)
     *
     *  - Determinaa o tipo da variavel 'a', por exemplo:  seja 'a' do tipo 'T' quqlquer
     *  - Procura na classe que define o tipo 'T' uma funcao inc() sem argumentos
     *  com o modificador 'OPERATOR'
     *  - Checa se o retorno dessa funcao eh um subtipo de 'T'
     *
     *  Os resultados de computar a operacao posfixiada
     *      - armazena o valor original de 'a'  a uma variavel temporaria a0
     *      - defina o valor de a0.inc() a varriável 'a' (a e atualizado basicamente)
     *      - retorna o valor de a0 como resultado (retorno do valor antigo)
     *
     *
     *  # COMPORTAMENTO DO OPERADOR PREFIXADO
     *
     *  Para a operacao de decremento a-- ocorre a mesma coisa
     *
     *  Para a forma prefixada ++a ou --a o compilador executa as mesmas operacoes que na forma posfixada, porem
     *  os resultados sao os seguintes
     *      - a operacao a.inc() eh armazenada em a
     *      - a.inc() retorna o valor de a
     *
     * */
    operator fun inc() = Point2Df(x+1.0, y+1.0)
    operator fun dec() = Point2Df(x-1.0, y-1.0)

}

fun sampleOverloadingPlusOp() {
    println(Point2Df(2.0,3.5) + Point2Df(1.2, 3.5))
}

private fun sampleUnaryMinusOverloading() {
    println(-Point2Df(1.0, 2.0))
}

private fun sampleIncOpOverloading() {
    var p = Point2Df(1.0, 2.0)
    println("P: $p")
    var r = p++
    // a operacao r = p (assigning) eh feito primeiro e posteriormente a operacoa inc() incrementanto o valor de p
    println("R: $r, P after p++: $p")
    // aqui a operacoes de incremento e feito primeiro e depois a de assing s = p
    val s = ++p
    println("S: $s, P after ++p: $p")
    println("P: $p")

    r = Point2Df(1.0, 2.0)
    // a op inc() e feita antes do print
    println("Print ++r: ${++r}")
    println("R: $r")
    // a operacao inc() e feita depois do print
    println("Print r++: ${r++}")
    println("R: $r")

}

private fun sampleDecOpOverloading() {
    var p = Point2Df(2.0, 3.5)
    println("p: $p")
    val q = --p
    println("value q: $q, value --p: $p")
    // assign r e depois decrementa 1 de p
    val r = p--
    println("Value r: $r, value p--: $p")
}

private fun testIncOpAfterThatDecOp() {
    sampleIncOpOverloading()
    println("-------------------------------------")
    sampleDecOpOverloading()
}

private fun samplePlusAssign() {
    val p = Point2DfAssignable(1.0, 1.0)
    val q = Point2DfAssignable(2.0, 4.0)
    p += q
    println(p)
    p -= Point2DfAssignable(10.0,15.0)
    println(p)
}


fun main() {
    testIncOpAfterThatDecOp()
}