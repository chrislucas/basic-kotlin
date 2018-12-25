package basics.ds.collections

import kotlin.math.sqrt

/**
 * https://grokonez.com/kotlin/kotlin-transform-list-map-methods-example
 *
 * */

fun isPrime(i: Int) : Boolean {
    if (i < 2)
        return false
    else if((i > 2 && i % 2 == 0) || (i > 3 && i % 3 == 0))
        return false
    val lim = sqrt(i * 1.0).toInt()
    for (value in 5 .. lim) {
        if (i % value == 0)
            return false
    }
   return true
}
fun main(args: Array<String>) {
    val list = (0..100).toList()
    //val filtered = list.filter { i -> isPrime(i) }

    /**
     * Aplica uma funcao de transformacao nos elementos da lista
     * */
    val mappedList = list.map { it -> isPrime(it) }
    println(mappedList)

    val mappedToList = mutableListOf<Boolean>()
    list.mapTo(mappedToList) {it -> isPrime(it)}
    println(mappedToList)


    val cName = "Christoffer Lucas Fernandes Santos"
            .split(" ")
            .map { it -> it.toLowerCase() }

    val  fn = {
        v: CharSequence ->
        val t = v.toString()
        t.substring(0, t.lastIndex) + t.last().toString().toUpperCase()

    }

    println(cName.joinToString("*", limit = 3, truncated = "...", transform = fn))

    val appendable = StringBuilder()
    cName.joinTo(appendable, "|")
    println(appendable)

}