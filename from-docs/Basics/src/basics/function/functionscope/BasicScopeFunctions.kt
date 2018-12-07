package basics.function.functionscope

/**
 * https://kotlinexpertise.com/coping-with-kotlins-scope-functions/
 * */

// simple example higher-order function
inline fun table(v: Int, action: (i: Int) -> Unit) = action(v)

fun testHigherOrderFunTable() {
    table(125) { i ->
        for (j in 0..10) {
            println("$i x $j = ${i * j}")
        }
    }
}

/**
 * function literal with receiver ou lambda with receiver
 *
 * Funcoes com receiver funcionam como extesion functions temporarrias na pratica
 * */

fun decToBin(value: Int, toBin: Int.() -> String) : String {
    return value.toBin()
}

fun binaryOpInteger(p: Int, q: Int, op : Int.(q: Int) -> Int) : Int {
    return p.op(q)
}

// lambda
// https://kotlinlang.org/docs/reference/lambdas.html
val decToBin2 = {
    v : Int ->
    var v = v
    val s = StringBuilder()
    while (v > 0) {
        s.append(if (v%2==0) "0" else "1")
        v = v shr 1
    }
    s.toString().reversed()
}

// extension function
fun Int.toBin() : String = decToBin2(this)
fun Int.isOdd() : Boolean = this and 1 > 0

fun testFnWithReceiver() {
    val bin = decToBin((1 shl 23) - 1) {
        var v = this
        val s = StringBuilder()
        while (v > 0) {
            s.append(if (v % 2 == 0) "0" else "1")
            v = v shr 1
        }
        s.toString().reversed()
    }
    println(bin)

    println(binaryOpInteger(127, 3) { q -> this.rem(q) })
}


fun testLetFun() {
    /**
     * Scope functions levam o mesmo conceito de high-order function.
     *
     * Sao funcoes que recebem como parametros outras funcoes
     * */
    // assinatura da funcao let: recebe como argumento uma funcao denominada block
    // que por sua vez recebe um generic T e retorna um generic R
    // public inline fun <T, R> T.let(block: (T) -> R): R

    println(10.let { it and 1 })

    // callable reference ou Feature Literals
    /**
     * https://try.kotlinlang.org/#/Examples/Callable%20references/Reference%20to%20a%20function/Reference%20to%20a%20function.kt
     * */

    // Pesquisar por KProperty
    val op = ::decToBin2
    // retorna uma funcao
    val rs = 10.let { op.call() }
    println(rs(127))
    // retorna o retultado da funcao decToBin2
    println(127.let { it::toBin.call()})
    //
    println(127.let { decToBin2(it) } )

    // KFunction<Boolean>
    val rs2= 10.let { return@let it::isOdd }
    println(rs2.call())

    println( 10.let { it::isOdd.call() } )
    println( 127.let { it::isOdd.call() } )

    println(10::toBin.call())
}

fun main(args: Array<String>) {
    //testHigherOrderFunTable()
    //testFnWithReceiver()
    testLetFun()
}