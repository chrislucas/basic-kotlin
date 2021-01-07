package com.br.algorithms

import kotlin.math.sqrt

typealias Matrix2D<T> = Array<Array<T>>
typealias Index = Pair<Int, Int>
typealias Predicate<T> = (T) -> Boolean

fun <T> check(matrix: Matrix2D<T>, index: Index, fn: Predicate<T>) {
    var (p, q) = index
    var t = sqrt(matrix.size * 1.0).toInt()
    while (p % t != 0)
        p -= 1
    while (q % t != 0)
        q -= 1
    t -= 1
    val message = StringBuilder()
    println(String.format("%s", index))
    for (i in p..p + t) {
        if (i > p)
            message.append("\n")
        for (j in q..q + t) {
            fn(matrix[i][j])
            message.append(String.format(if (j == q) "(%d, %d)" else (" ,(%d, %d)"), i, j))
        }
    }
    println(String.format("%s\n", message))
}

fun main() {
    val values = arrayOf(
        Array(16) { Array(16) { 0 } } to (5 to 3),
        Array(16) { Array(16) { 0 } } to (9 to 1),
        Array(16) { Array(16) { 0 } } to (15 to 2),
        Array(9) { Array(9) { 0 } } to (0 to 0),
        Array(9) { Array(9) { 1 } } to (8 to 8),
        Array(25) { Array(25) { 1 } } to (8 to 8),
        Array(100) { Array(100) { 1 } } to (2 to 99)
    )

    values.forEach {
        val (matrix, pos) = it
        check(matrix, pos) { value ->
            value % 2 == 0
        }
    }
}