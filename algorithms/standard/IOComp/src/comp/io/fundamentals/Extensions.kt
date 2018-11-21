package comp.io.fundamentals

/**
 * https://kotlinlang.org/docs/reference/extensions.html
 * */

fun Number.isOdd(): Boolean {
    return when {
        this is Long -> this.and(1) == 1L
        this is Int -> this.and(1) == 1
        this is Double -> this.toLong().isOdd()
        else -> false
    }
}

fun main(args: Array<String>) {

    // for (i in 0L .. 100L) { println(i.isOdd()) }

    println(Math.PI.isOdd())

}