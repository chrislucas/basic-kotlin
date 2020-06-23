package algorithms

import java.math.BigInteger

typealias BigInt = BigInteger

/**
 * Calculadora exp modular
 * https://www.boxentriq.com/code-breaking/modular-exponentiation
 *
 * Diffie Hellman wiki
 * https://pt.wikipedia.org/wiki/Diffie-Hellman
 * */

private fun multiply(a: BigInt, b: BigInt, m: BigInt) = ((a % m) * (b % m)) % m

private fun exp(base: BigInt, e: BigInt, m: BigInt): BigInt {
    return if (e == BigInt.ZERO) {
        BigInt.ONE
    } else {
        var _base = base
        var _e = e
        var acc = BigInt.ONE
        while (_e > BigInt.ZERO) {
            if (_e.and(BigInt.ONE) == BigInt.ONE)
                acc = multiply(_base, acc, m)
            _base = multiply(_base, _base, m)
            _e = _e.shiftRight(1)
        }
        acc
    }
}

fun testExp() {
    println(exp(BigInt("23555"), BigInt("100000"), BigInt("230")))
}

fun main() {
    testExp()
}