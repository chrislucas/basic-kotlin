package com.br.algorithms.problems.sudoku.s3

import com.br.algorithms.problems.sudoku.ext.Board
import com.br.algorithms.problems.sudoku.ext.generateRandomicBoard
import com.br.algorithms.problems.sudoku.ext.print
import com.br.algorithms.problems.sudoku.ext.string

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
    var (lin, col) = (p to q)
    lin -= (lin % 3)
    col -= (col % 3)
    for (i in lin..lin + 2) {
        for (j in col..col + 2) {
            if (board[i][j] == value) {
                return false
            }
        }
    }
    return true
}

private fun add(board: Array<Array<Int>>, lin: Int, col: Int, value: Int): Boolean {
    return if (canIAddNumber(board, lin, col, value)) {
        board[lin][col] = value
        true
    } else {
        false
    }
}


/**
 * https://www.geeksforgeeks.org/sudoku-backtracking-7/
 * */

private fun isSolvable(board: Array<Array<Int>>) = solver(board, 0, 0)

private fun solver(board: Array<Array<Int>>, i: Int, j: Int): Boolean {
    return when {
        //  fim da matriz
        board.size == i -> {
            true
        }
        // fim da ith linha
        board[i].size == j -> {
            solver(board, i + 1, 0)
        }

        else -> {
            if (board[i][j] != 0) {
                return solver(board, i, j + 1)
            }

            for (k in 1..9) {
                if (add(board, i, j, k)) {
                    println(String.format("add %d p(%d, %d)\n%s", board[i][j], i, j, board.string()))
                    if (solver(board, i, j + 1))
                        return true
                    println(String.format("backtrack:%d p(%d, %d)\n%s", board[i][j], i, j, board.string()))
                    board[i][j] = 0
                }
            }
            false
        }
    }
}

private fun testRandomicBoard(sizeBoard: Int = 31) = run(generateRandomicBoard(n = sizeBoard))

private fun testStaticBoard(whichBoard: Int = 0) = run(Board[whichBoard])

private fun run(board: Array<Array<Int>>) {
    board.print()
    val message = if (isSolvable(board)) {
        "Is solvable"
    } else {
        "Is Unsolvable"
    }
    println(String.format("%s\n%s", message, board.string()))
}

fun main() {
    //testRandomicBoard(15)
    testStaticBoard(1)
}