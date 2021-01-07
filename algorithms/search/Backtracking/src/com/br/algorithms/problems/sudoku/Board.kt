package com.br.algorithms.problems.sudoku

import com.br.algorithms.problems.sudoku.s1.add
import kotlin.random.Random

/**
 * https://en.wikipedia.org/wiki/Sudoku_solving_algorithms
 * https://en.wikipedia.org/wiki/Mathematics_of_Sudoku
 * https://www.geeksforgeeks.org/sudoku-backtracking-7/
 * */

typealias Int2DMat = Array<Array<Int>>
typealias IntPair = Pair<Int, Int>

fun Int2DMat.print() {
    val message = StringBuilder()
    for (i in this.indices) {
        for (j in this[0].indices) {
            message.append(String.format(if (j == 0) "%s" else " ,%s", this[i][j]))
        }
        message.append("\n")
    }
    println(message)
}



object Board {
    private val INCOMPLETE_BOARD = Array(3) { Array(9) { Array(9) { 0 } } }

    fun get(i: Int = 0) = INCOMPLETE_BOARD[i]

    init {
        // https://en.wikipedia.org/wiki/Sudoku_solving_algorithms
        INCOMPLETE_BOARD[0][0][1] = 5
        INCOMPLETE_BOARD[0][0][2] = 3
    }
}