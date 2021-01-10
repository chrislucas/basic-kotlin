package com.br.algorithms.problems.sudoku.s2

import com.br.algorithms.problems.sudoku.ext.print
import kotlin.random.Random

/**
 * https://en.wikipedia.org/wiki/Sudoku_solving_algorithms
 * https://en.wikipedia.org/wiki/Mathematics_of_Sudoku
 * https://www.geeksforgeeks.org/sudoku-backtracking-7/
 * */

typealias Int2DMat = Array<Array<Int>>

fun isSolvable(board: Int2DMat) = solver(board, 0, 0)


fun solver(board: Int2DMat, p: Int, q: Int): Boolean {
    when {
        // fim do board
        board.size == p -> {
            return true
        }
        // fim da linha da matriz
        board[p].size == q -> {
            return solver(board, p + 1, 0)
        }
        // da para navegar para direta na matriz/board
        else -> {
            // posicao preenchida
            if (board[p][q] != 0) {
                return solver(board, p, q + 1)
            }

            for (i in 1 .. 9) {
                if (canIAddNumber(board, p, q, i)) {
                    board[p][q] = i
                    println("add")
                    board.print()
                    if (solver(board, p, q + 1))
                        return true
                }
                //else { }
                board[p][q] = 0
                println("backtrack")
                board.print()
            }
            return false
        }
    }
}

fun add(board: Int2DMat, lin: Int, col: Int, value: Int): Boolean  {
    val r = canIAddNumber(board, lin, col, value)
    if (r)
        board[lin][col] = value
    return r
}


fun canIAddNumber(board: Int2DMat, lin: Int, col: Int, value: Int): Boolean {
    return when {
        lin < 0 || lin > 8 || col < 0 || col > 8 || board[lin][col] != 0 -> {
            false
        }
        else -> {
            checkLinesAndColumns(board, lin, col, value) && checkQuandrant3X3(board, lin, col, value)
        }
    }
}


fun checkLinesAndColumns(board: Int2DMat, lin: Int, col: Int, value: Int): Boolean {
    var response = true
    for (i in 0 until 9) {
        if (board[lin][i] == value || board[i][col] == value) {
            response = false
            break
        }
    }
    return response
}

fun checkQuandrant3X3(board: Int2DMat, p: Int, q: Int, value: Int): Boolean {
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

/**
 * Gera uma grade de sudoku por padrao 9x9 sem nenhum numero posicionado
 * */
fun gen(s: Int = 9, n: Int = 0): Int2DMat {
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
            } while (add(mat, p , q, v))
        }
        mat
    }
}
fun main() {
    val board = gen(n = 31) //
    board.print()
    if (isSolvable(board)) {
        println("")
        board.print()
    }
}