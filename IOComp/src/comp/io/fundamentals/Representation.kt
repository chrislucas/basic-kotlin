package comp.io.fundamentals

fun main(args: Array<String>) {
    val a: Int = 10000

    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    //println(a === a) // Prints 'true'
    // comparando valor
    println(boxedA == anotherBoxedA)
    // comparando referencia e valor
    println(boxedA === anotherBoxedA)

    var boxedB = boxedA
    //boxedB = 10
    println(boxedA === boxedB)
    println("$boxedA, $boxedB")
    println("%x %x %x".format(boxedA, boxedB, anotherBoxedA))


    val b: Int? = 1000
    val c: Long? = 1000L
    // nao eh possivel comparar Int com Long
    //println(b == c)

}