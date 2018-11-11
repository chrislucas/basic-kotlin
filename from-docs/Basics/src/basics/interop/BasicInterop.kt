package basics.interop

import java.util.*


/**
 * https://kotlinlang.org/docs/reference/java-interop.html
 * */

fun accessPriorityQueue() {
    val pq = PriorityQueue<Int>(listOf(30,20,15,10,5,45))
    println(pq)
}

fun main(args: Array<String>) {
    accessPriorityQueue()
}