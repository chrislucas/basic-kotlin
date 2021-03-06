package com.br.algorithms.problems.sudoku.ext


import kotlin.math.sqrt
import kotlin.random.Random

/**
 * https://en.wikipedia.org/wiki/Sudoku_solving_algorithms
 * https://en.wikipedia.org/wiki/Mathematics_of_Sudoku
 * https://www.geeksforgeeks.org/sudoku-backtracking-7/
 * */

typealias Int2DMat = Array<Array<Int>>
typealias IntPair = Pair<Int, Int>

fun Int2DMat.print() = println(this.string())


fun Int2DMat.string(): String {
    val message = StringBuilder()
    for (i in this.indices) {
        for (j in this[i].indices) {
            message.append(String.format(if (j == 0) "$i: %s" else " ,%s", this[i][j]))
        }
        message.append("\n")
    }
    return message.toString()
}

private fun add(board: Array<Array<Int>>, lin: Int, col: Int, value: Int): Boolean {
    return if (canIAddNumber(board, lin, col, value)) {
        board[lin][col] = value
        true
    } else {
        false
    }
}

private fun canIAddNumber(board: Array<Array<Int>>, lin: Int, col: Int, value: Int): Boolean {
    return when {
        lin < 0 || lin > 8 || col < 0 || col > 8 || board[lin][col] != 0 -> {
            false
        }
        else -> {
            checkLinesAndColumns(board, lin, col, value) && checkQuandrant3X3(board, lin, col, value)
        }
    }
}


private fun checkLinesAndColumns(board: Array<Array<Int>>, lin: Int, col: Int, value: Int): Boolean {
    for (i in 0 until 9) {
        if (board[lin][i] == value || board[i][col] == value) {
            return false
        }
    }
    return true
}

private fun checkQuandrant3X3(board: Array<Array<Int>>, p: Int, q: Int, value: Int): Boolean {
    var pp = p
    var qq = q
    var t = sqrt(board.size * 1.0).toInt()
    pp -= (pp % t)
    qq -= (pp % t)
    t -= 1
    for (i in pp..pp + t) {
        for (j in qq..qq + 2) {
            if (board[i][j] == value) {
                return false
            }
        }
    }
    return true
}

fun generateRandomicBoard(s: Int = 9, n: Int = 0): Array<Array<Int>> {
    return if (n == 0) {
        Array(s) { Array(s) { 0 } }
    } else {
        val mat = Array(s) { Array(s) { 0 } }
        // preencher com um algoritmo randomico
        // verificar se pode colocar o valor na posicao i,j randomica
        for (i in 0 until n) {
            do {
                val p = Random.nextInt(0, s + 1)
                val q = Random.nextInt(0, s + 1)
                val v = Random.nextInt(1, s + 1)
            } while (add(mat, p, q, v))
        }
        mat
    }
}


/**
 * https://dev.to/christinamcmahon/use-backtracking-algorithm-to-solve-sudoku-270
 * https://www.geeksforgeeks.org/sudoku-backtracking-7/
 * */

object Board {
    private val INCOMPLETE_BOARD: List<Array<Array<Int>>> = listOf(
        listOf(
            arrayOf(5, 3, 0, 0, 7, 0, 0, 0, 0),
            arrayOf(6, 0, 0, 1, 9, 5, 0, 0, 0),
            arrayOf(0, 9, 8, 0, 0, 0, 0, 6, 0),
            arrayOf(8, 0, 0, 0, 6, 0, 0, 0, 3),
            arrayOf(4, 0, 0, 8, 0, 3, 0, 0, 1),
            arrayOf(7, 0, 0, 0, 2, 0, 0, 0, 6),
            arrayOf(0, 6, 0, 0, 0, 0, 2, 8, 0),
            arrayOf(0, 0, 0, 4, 1, 9, 0, 0, 5),
            arrayOf(0, 0, 0, 0, 8, 0, 0, 7, 9)
        ).toTypedArray(), listOf(
            arrayOf(3, 0, 6, 5, 0, 8, 4, 0, 0),
            arrayOf(5, 2, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 8, 7, 0, 0, 0, 0, 3, 1),
            arrayOf(0, 0, 3, 0, 1, 0, 0, 8, 0),
            arrayOf(9, 0, 0, 8, 6, 3, 0, 0, 5),
            arrayOf(0, 5, 0, 0, 9, 0, 6, 0, 0),
            arrayOf(1, 3, 0, 0, 0, 0, 2, 5, 0),
            arrayOf(0, 0, 0, 0, 0, 0, 0, 7, 4),
            arrayOf(0, 0, 5, 2, 0, 6, 3, 0, 0)
        ).toTypedArray(), listOf(
            arrayOf(4, 0, 0, 0, 0, 0, 8, 0, 5),
            arrayOf(0, 3, 0, 0, 0, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 7, 0, 0, 0, 0, 0),
            arrayOf(0, 2, 0, 0, 0, 0, 0, 6, 0),
            arrayOf(0, 0, 0, 0, 8, 0, 4, 0, 0),
            arrayOf(0, 0, 0, 0, 1, 0, 0, 0, 0),
            arrayOf(0, 0, 0, 6, 0, 3, 0, 7, 0),
            arrayOf(5, 0, 0, 2, 0, 0, 0, 0, 0),
            arrayOf(1, 0, 4, 0, 0, 0, 0, 0, 0)
        ).toTypedArray()
    )

    // https://kotlinlang.org/docs/reference/operator-overloading.html
    operator fun get(i: Int = 0) =
        if (i < 0 && i > INCOMPLETE_BOARD.size - 1) {
            Array(1) { Array(1) { 0 } }
        } else {
            INCOMPLETE_BOARD[i]
        }
}