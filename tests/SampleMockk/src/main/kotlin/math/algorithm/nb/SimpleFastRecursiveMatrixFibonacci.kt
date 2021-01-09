package math.algorithm.nb

import BigInt
import MatrixBigInt
import math.algorithm.nb.SimpleFastRecursiveMatrixFibonacci.fbn
import java.math.BigInteger

// https://www.dcode.fr/fibonacci-numbers

object SimpleFastRecursiveMatrixFibonacci{

    val mat = create()

    @JvmStatic
    private fun create() : MatrixBigInt  {
        val matrix : MatrixBigInt =
            Array(2) { _ -> Array(2) { BigInt.ONE } }
        matrix[1][1] = BigInt.ZERO
        return matrix
    }


    @JvmStatic
    fun fbn(nth: BigInt): BigInt {
        return if (nth == BigInt.ZERO) {
            BigInt.ZERO
        }
        else if (nth < BigInt.valueOf(3)) {
            BigInt.ONE
        }

        else {
            val matrix = create()
            exp(matrix, nth.minus(BigInt.ONE))
            matrix[0][0]
        }
    }


    @JvmStatic
    private fun exp(p: MatrixBigInt, n: BigInt) {
        val two = BigInt.valueOf(2)
        if (n < two)
            return
        exp(p, n.shiftRight(1))
        multiply(p, p)
        if (n.mod(two) != BigInt.ZERO) {
            multiply(p, mat)
        }
    }

    @JvmStatic
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
}

fun main() {
    for (i in 20000L .. 20100L) {
        val rs = fbn(BigInteger.valueOf(i))
        println(String.format("%d, %d, %d", i, rs.toString().length, rs))
    }
}