package comp.io.loops

/**
 * https://kotlinlang.org/docs/reference/control-flow.html
 * https://kotlinlang.org/docs/reference/returns.html
 * */

fun gdc(a: Long, b: Long) : Long {
    var aa = a;
    var bb = b;
    while (aa%bb>0) {
        val aux = aa % bb;
        aa = b;
        bb = aux
    }
    return bb;
}


fun factorial(a: Long) : Long {
    var aa = a
    var bb = a - 1
    do {
        aa *= bb;
        bb--;
    } while (bb > 1)

    return aa;
}

fun main(args: Array<String>) {
    println(gdc(54, 4))
    println(factorial(25))
}