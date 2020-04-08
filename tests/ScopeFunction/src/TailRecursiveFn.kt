
/**
 * https://kotlinlang.org/docs/reference/functions.html#tail-recursive-functions
 * To be eligible for the tailrec modifier, a function must call itself as the last
 * operation it performs. You cannot use tail recursion when there is more code after
 * the recursive call, and you cannot use it within
 * try/catch/finally blocks. Currently tail recursion is only supported in the JVM backend.
 * */

tailrec fun gcd(p: Long, q: Long) : Long = if (p % q  == 0L) q else gcd(q, p%q)

fun main(args: Array<String>) {
    println(gcd(54, 9))
}