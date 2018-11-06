package basics.sintax

/**
 * definicao de funcao
 * argumentos de metodos em kotlin nao imutaveis
 * https://kotlinlang.org/docs/reference/basic-syntax.html
 * */

fun gcd1(a: Long, b: Long): Long {
    // como os argumentos sao imutaveis, precisamos passar seus valores para variaveis mutaveis
    var a = a
    var b = b
    while (a%b>0L) {
        val aux = a%b;
        a = b;
        b = aux;
    }
    return b;
}


/**
 * Funcao usando if como expressao
 * */
fun gcd2(a: Long, b: Long): Long = if (a % b == 0L) b else gcd2(b, a % b)
// IDEM
fun max(a: Long, b: Long) = if (a > b) a else b

/**
 * funcao expression body
 * */
fun lessThan(a: Long, b: Long) = (a < b)

/**
 * Assigment
 * Read only variables: val
 * Mutable variable: var
 * argumentos de metodos em kotlin nao imutaveis
 * */

// Expressao range
fun between(s: Int, e: Int, t: Int) = (t in s..e)

fun notInRange(s: Int, e: Int, t: Int) = (t  !in s..e)

fun main(args: Array<String>) {
    println(gcd1(2048, 46))
    println(gcd2(2048, 46))
    println(lessThan(1000L, b = (1L shr  62)))
    println(between(0, 100, 99))
    println(between(0, 100, -99))
    println(notInRange(0, 100, -99))
}