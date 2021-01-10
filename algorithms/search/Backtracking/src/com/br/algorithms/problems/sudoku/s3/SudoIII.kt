package com.br.algorithms.problems.sudoku.s3

import com.br.algorithms.problems.sudoku.ext.Board
import com.br.algorithms.problems.sudoku.ext.generateRandomicBoard
import com.br.algorithms.problems.sudoku.ext.print
import com.br.algorithms.problems.sudoku.ext.string
import com.br.algorithms.problems.sudoku.s4.backtracking
import kotlin.random.Random

fun isFullFill(mat: Array<Array<Int>>): Boolean {
    for (i in mat.indices) {
        for (element in mat[i]) {
            if (element == 0)
                return false
        }
    }
    return true
}

fun canIAddNumber(board: Array<Array<Int>>, lin: Int, col: Int, value: Int): Boolean {
    return when {
        lin < 0 || lin > 8 || col < 0 || col > 8 || board[lin][col] != 0 -> {
            false
        }
        else -> {
            checkLinesAndColumns(board, lin, col, value) && checkQuandrant3X3(board, lin, col, value)
        }
    }
}


fun checkLinesAndColumns(board: Array<Array<Int>>, lin: Int, col: Int, value: Int): Boolean {
    for (i in 0 until 9) {
        if (board[lin][i] == value || board[i][col] == value) {
            return false
        }
    }
    return true
}

fun checkQuandrant3X3(board: Array<Array<Int>>, p: Int, q: Int, value: Int): Boolean {
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

fun add(board: Array<Array<Int>>, lin: Int, col: Int, value: Int): Boolean {
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

fun isSolvable(board: Array<Array<Int>>) = solver(board, 0, 0)

fun solver(board: Array<Array<Int>>, i: Int, j: Int): Boolean {
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
                solver(board, i, j + 1)
            }

            for (k in 1..9) {
                if (add(board, i, j, k)) {
                    println(String.format("add %d, %d\n%s", i, j, board.string()))
                    if (solver(board, i, j + 1))
                        return true
                    else {
                        board[i][j] = 0
                        println(String.format("backtrack %d, %d\n%s", i, j, board.string()))
                    }
                }
            }
            false
        }
    }
}

fun testRandomicBoard(sizeBoard: Int = 31) = run(generateRandomicBoard(n = sizeBoard))

fun testStaticBoard(whichBoard: Int = 0) = run(Board[whichBoard])

fun run(board: Array<Array<Int>>) {
    board.print()
    if (isSolvable(board)) {
        println(String.format("Is Solvable\n%s", board.string()))
    } else {
        println("Unsolvable")
    }
}

fun main() {

    testRandomicBoard(15)
}