package algorithms.factorization

/**
 * https://cp-algorithms.com/algebra/factorization.html#toc-tgt-0
 * */

fun gcd(a: Long, b: Long) : Long {
    var (_a, _b) = arrayOf(a, b)
    while (_a % _b != 0L) {
        val c = _a % _b
        _a = _b
        _b = c
    }
    return _b
}

fun main() {

}