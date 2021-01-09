package math.algorithm.nb

import BigInt
import MatrixBigInt
import math.algorithm.nb.SimpleFastIterativeMatrixFibonacci.fb
import math.algorithm.nb.SimpleFastIterativeMatrixFibonacci.ffb
import java.math.BigInteger
import kotlin.math.log2


object SimpleFastIterativeMatrixFibonacci {

    private fun multiply(p: MatrixBigInt, q: MatrixBigInt) {
        val a = p[0][0] * q[0][0] + p[0][1] * q[1][0]
        val b = p[0][0] * q[0][1] + p[1][0] * q[1][1]
        val c = p[1][0] * q[0][0] + p[1][1] * q[1][0]
        val d = p[1][0] * q[0][1] + p[1][1] * q[1][1]
        p[0][0] = a
        p[0][1] = b
        p[1][0] = c
        p[1][1] = d
    }

    fun fb(nth: BigInt): BigInt {
        return when {
            nth == BigInt.ZERO -> {
                BigInt.ZERO
            }
            nth < BigInt.valueOf(3) -> {
                BigInt.ONE
            }
            else -> {
                val matrix: MatrixBigInt =
                    Array(2) { _ -> Array(2) { BigInt.ONE } }
                matrix[1][1] = BigInt.ZERO
                exp(matrix, nth.minus(BigInt.ONE))
                matrix[0][0]
            }
        }
    }

    private fun exp(p: MatrixBigInt, limit: BigInt) {
        val q: MatrixBigInt =
            Array(2) { _ -> Array(2) { BigInt.ONE } }
        q[1][1] = BigInt.ZERO

        val n = log2(limit.toDouble()).toInt()
        val values = Array(n) { 0 }
        var c = limit.toInt()
        var i = n - 1
        while (c > 1) {
            values[i--] = c
            c = c shr 1
        }

        for (value in values) {
            multiply(p, p)
            if (value % 2 != 0) {
                multiply(p, q)
            }
        }
    }

    // https://ronzii.wordpress.com/2011/07/09/using-matrix-exponentiation-to-calculated-nth-fibonacci-number/
    fun ffb(nth: BigInt): BigInt {
        return when {
            nth == BigInt.ZERO -> {
                BigInt.ZERO
            }
            nth < BigInt.valueOf(3) -> {
                BigInt.ONE
            }
            else -> {
                val p: MatrixBigInt =
                    Array(2) { _ -> Array(2) { BigInt.ONE } }
                p[1][1] = BigInt.ZERO

                val q: MatrixBigInt =
                    Array(2) { _ -> Array(2) { BigInt.ONE } }
                q[0][1] = BigInt.ZERO
                q[1][0] = BigInt.ZERO

                var limit = nth
                while (limit > BigInt.ZERO) {
                    if (limit.mod(BigInt.valueOf(2)) != BigInt.ZERO)
                        multiply(q, p)
                    multiply(p, p)
                    limit = limit shr 1
                }
                q[0][1]
            }
        }
    }
}

fun main() {
    for (i in 200000L .. 200100L) {
        val rs = ffb(BigInteger.valueOf(i))
        println(String.format("%d, %d, %d", i, rs.toString().length, rs))
    }
}