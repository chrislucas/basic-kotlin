/**
 * https://kotlinlang.org/docs/reference/lambdas.html#lambda-expressions-and-anonymous-functions
 * */


fun <T, R> operating(p: T, q: T, fn: (T, T) -> R) : R = fn(p, q)


fun testOperating(p: Int, q: Int) {
    val rs = operating(p, q) {
        a, b ->
        var p = a
        var q = b
        while (p % q > 0) {
            val aux = p % q
            p = q
            q = aux
        }
        q
    }
    println("GCD($p, $q) = $rs")
}


fun main(args: Array<String>) {
    testOperating(128, 12)
}