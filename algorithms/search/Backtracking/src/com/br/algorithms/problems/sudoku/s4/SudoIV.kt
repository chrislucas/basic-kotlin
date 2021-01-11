package com.br.algorithms.problems.sudoku.s4

import com.br.algorithms.problems.sudoku.ext.Board
import com.br.algorithms.problems.sudoku.ext.generateRandomicBoard
import com.br.algorithms.problems.sudoku.ext.print
import com.br.algorithms.problems.sudoku.ext.string

/**
 * ;; solucao influencia pela implemetnacao do link abaixo
 *  https://dev.to/christinamcmahon/use-backtracking-algorithm-to-solve-sudoku-270
 * */

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

private fun isSolved(board: Array<Array<Int>>): Boolean {
    // verificar se a noma das linhas = 49
    for (i in 0..board.size) {
        for (j in 0..board[i].size) {
            if (board[i][j] == 0)
                return false
        }
    }
    // verificar se a noma das colunas = 45
    // verificar se os numeros em cada submatriz
    return true
}

private fun backtracking(board: Array<Array<Int>>): Boolean {
    for (i in board.indices) {
        for (j in board[i].indices) {
            if (board[i][j] == 0) {
                for (k in 1..9) {
                    if (add(board, i, j, k)) {
                        println(String.format("add %d p(%d, %d)\n%s", board[i][j], i, j, board.string()))
                        if (backtracking(board))
                            return true
                        println(String.format("backtrack:%d p(%d, %d)\n%s", board[i][j], i, j, board.string()))
                        board[i][j] = 0
                    }
                }
                return false
            }
        }
    }
    return true
}

private fun testRandomicBoard(sizeBoard: Int = 31) = run(generateRandomicBoard(n = sizeBoard))

private fun testStaticBoard(whichBoard: Int = 0) = run(Board[whichBoard])

private fun run(board: Array<Array<Int>>) {
    board.print()
    val message = if (backtracking(board)) {
        "Is solvable"
    } else {
        "Is Unsolvable"
    }
    println(String.format("%s\n%s", message, board.string()))
}

/**
 * https://www.sudoku-solutions.com/
 * */
fun main() {
    //testRandomicBoard(31)
    testStaticBoard(1)
}