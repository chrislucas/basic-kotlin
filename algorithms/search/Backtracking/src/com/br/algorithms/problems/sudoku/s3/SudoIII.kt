package com.br.algorithms.problems.sudoku.s3

import com.br.algorithms.problems.sudoku.print
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
    while (lin % 3 != 0)
        lin -= 1
    while (col % 3 != 0)
        col -= 1
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

fun gen(s: Int = 9, n: Int = 0): Array<Array<Int>> {
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
                val v = Random.nextInt(0, s + 1)
            } while (add(mat, p, q, v))
        }
        mat
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
                    println(String.format("add %d, %d", i, j))
                    board.print()
                    if (solver(board, i, j + 1))
                        return true
                    else {
                        board[i][j] = 0
                        println(String.format("backtrack %d, %d\n%s", i, j))
                        board.print()
                    }
                }
            }
            false
        }
    }
}


fun main() {
    val board = gen(n = 31)
    board.print()
    if (isSolvable(board)) {
        println(String.format("Is Solvable\n%s", board))
    } else {
        println("Unsolvable")
    }
}