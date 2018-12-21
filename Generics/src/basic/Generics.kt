package basic

/**
 * https://kotlinlang.org/docs/reference/generics.html
 *
 * invariate, covariant, contravariamt e bivariant
 * https://www.logicbig.com/tutorials/core-java-tutorial/java-language/java-subtyping-rules.html
 *
 * */



/**
 *
 * <? extends T> -> out
 *     Producer-Extends -> nao nos permite fazer adicoes
 *     List<? extends Integer> ints = new ArrayList<>
 *         ints.add() -> nao compilarad
 *
 * <? super T> -> in
 *     Consumer-super -> permite adicionar quaisquer tipos que sao
 *     especializacao de T, porem so recuperamos instancias da classe Object
 *
 * */


/**
 *  declaration-site variance
 *
 *  Suponha que temos uma interface que possua assinatura de metodos
 *  que so retornem 'T' , nao exista nenhum metodo que tenha 'T' como argumento.
 *  Se esse for o caso, e perfeitamente plausivel escrever>
 *      interface NomeDaInterface<out T>
 *
 * */

// Consumer
interface Inbox<in T> {
    fun process(value: T)
    // uma vez definido o tipo generico como 'in', nao eh
    // permitido declarar um metodo que retorno T (out)
    //fun writer(): T
}

//

/**
 *  Producer
 *
 *
 * */

interface Outbox<out T> {
    fun writer() : T
    // Definido o tipo generico T como 'out', nao eh permitido
    // delcarar um metodo cujo argumento seja T (in)
    //fun process(value: T)
}


fun testOutArray() {
    val ns1 = (15..85).toList().toTypedArray()
    val ns2: Array<out Int> = Array(100) { i: Int -> if (i < ns1.size) ns1[i] else 0 }
    // Como o array foi definido como <out Int> o compilador nao me permite
    // usar o metodo set(index, value) da classe Array
    //ns2[0] = -15
    //ns2.set(0, 15)
    println(ns2)
}

fun testinList() {
    /**
     * A classe lista esta escrita como: List<out T>
     *     assim toda lista so aceita que seja recuperado os T elementos
     *     nao permitindo o uso do operador [] para modificar o que ja foi inserido
     * */
    val ns3 = listOf(1, 2, 3, 4, 5, 6)
    // ns3[0] = 10
    println(ns3[0])
}

fun testMutableIN() {
    // transformando MutableList em
    // Usar o in eh desnecessario
    val ns4 : MutableList<in Int> = mutableListOf(1,2,3,4,5,6,7,9)
    println(ns4)
    ns4.add(0, 15)
    println(ns4)
    //ns4.forEachIndexed { idx, value -> print(String.format(if (idx>0)" %d" else "%d", value)) }
}

fun main(args: Array<String>) {
    testMutableIN()
}