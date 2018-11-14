package comp.io.overflow

/**
 * https://www.codewars.com/kata/a-plus-b-equals-equals-123/train/kotlin
 * */

fun int123(a: Int): Long {
    if (a <= 123)
        return (123L - a);
    else {
        val m: Long = (Int.MAX_VALUE).toLong() * 2 + 2
        return ( m + (123L - a));
    }
}

fun main(args: Array<String>) {
    val a: Int = 500
    val t: Long = int123(a)
    println(t)
    println(a + t)
    println((a + t).toInt())
}