package algorithms

import java.lang.StringBuilder

/**
 * https://cp-algorithms.com/algebra/phi-function.html
 * Euler totient function from 1 to n in O(nloglogn)
 * */

// ETF from 1 to n in O(n log log n)
fun phiNumbers(n: Int) : MutableList<Int> {
    val numbers = mutableListOf<Int>()

    for(i in 0 .. n) {
        numbers.add(i, i)
    }

    for(i in 2 .. n) {
        if (numbers[i] == i) {
            for (j in i .. n step i) {
                /**
                 * Produto de euler. subtraindo de numbers[i .. n] seus divisores de i
                 * Exemplo
                 * Comecamos dizendo que numbers[i] = i ou seja partimos do principio que todos
                 * os numerops entre i e n (inclusive) sao coprimos  de i, entao removemos dessa quantidade
                 * aqueles numeros divisiveis por i
                 *
                 * Exemplo
                 * i = 2 n = 100
                 * Para number[2 ate 100] subtrair da quantidade arma todos os numeros que sao diviviveis por i
                 * */

                numbers[j] = numbers[j] - numbers[j] / i
            }
        }
    }

    return numbers
}

// https://www.geeksforgeeks.org/eulers-totient-function-for-all-numbers-smaller-than-or-equal-to-n/

fun phiNumbersII() {

}

fun <E> MutableList<E>.log() : String {
    val buffer = StringBuilder()
    buffer.append("[")
    this.forEachIndexed {
        i, e ->
        buffer.append(String.format(if (i == 0) "%s" else ", %s", e.toString()))
    }
    buffer.append("]")
    return buffer.toString()
}

fun test() {
    val buffer = StringBuilder()
    (0 .. 12).forEach {
        val list = phiNumbers(it)
        buffer.append(String.format("%d: COUNT(%d), SUM(%d)\n", it, list.size, list.sum()))
        buffer.append(String.format("list: %s\n", list.log()))
    }

    println(buffer)
}

fun main(args: Array<String>) {
    test()
}