package com.br.algorithms.problems.sudoku.s1

import com.br.algorithms.extfun.computeBenchmark
import com.br.algorithms.problems.sudoku.ext.*
import java.util.*
import kotlin.random.Random

val values = fun() = LinkedList(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9))

fun navigation(board: Int2DMat, i: Int, j: Int, value: Int, pValues: Queue<Int>): Boolean {
    return when {
        board.size == i -> {
            true
        }
        j < board[i].size -> {
            if (board[i][j] != 0) {
                return navigation(board, i, j + 1, value, pValues)
            }
            while (pValues.isNotEmpty()) {
                var v = pValues.poll()
                if (add(board, i to j, v) != 0) {
                    v = if ((v + 1) % 10 == 0) 1 else v + 1
                    println(String.format("add:%d p(%d, %d)\n%s", board[i][j], i, j, board.string()))
                    if (navigation(board, i, j + 1, v, values()))
                        return true
                    println(String.format("backtrack:%d p(%d, %d)\n%s", board[i][j], i, j, board.string()))
                    board[i][j] = 0
                }
            }
            return false
        }
        else -> {
            navigation(board, i + 1, 0, 1, values())
        }
    }
}

fun add(board: Int2DMat, pos: IntPair, value: Int): Int {
    return if (canIAddNumber(board, pos, value)) {
        board[pos.first][pos.second] = value
        value
    } else {
        0
    }
}

fun isFullFill(mat: Int2DMat): Boolean {
    for (i in mat.indices) {
        for (element in mat[i]) {
            if (element == 0)
                return false
        }
    }
    return true
}

fun canIAddNumber(board: Int2DMat, pos: IntPair, value: Int): Boolean {
    val (lin, col) = pos
    return when {
        lin < 0 || lin > 8 || col < 0 || col > 8 || board[lin][col] != 0 -> {
            false
        }
        else -> {
            checkLinesAndColumns(board, pos, value) && checkQuandrant3X3(board, pos, value)
        }
    }
}

fun checkLinesAndColumns(board: Int2DMat, pos: IntPair, value: Int): Boolean {
    var response = true
    for (i in 0 until 9) {
        if (board[pos.first][i] == value || board[i][pos.second] == value) {
            response = false
            break
        }
    }
    return response
}

/**
 * board 9x9
 * 9 qyadrantes 3x3
 * q1 = 00 a 22; q2 = 03 a 25; q3 = 06 a 28
 * q4 = 30 a 52; q5 = 33 a 55; q6 = 36 a 58
 * q7 = 60 a 82; q8 = 63 a 85; q9 = 66 a 88
 *
 * 1) Linha e coluna do canto superior esquerdo de um quadrante so pode assumir os valores (0.3.6)
 * 2) Sabedo o canto superior esquerdo, soma-se aos valores o tamanho da submatriz que forma o quadrante
 *      - Uma matriz 9x9 tem submatrizes de tamanho 3. NxN tem uma submatriz sqrt(N)
 *
 *
 * */
fun checkQuandrant3X3(board: Int2DMat, pos: IntPair, value: Int): Boolean {
    var (p, q) = pos
    p -= (p % 3)
    q -= (q % 3)
    for (i in p..p + 2) {
        for (j in q..q + 2) {
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
fun generate(s: Int = 9, n: Int = 0): Int2DMat {
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
            } while (add(mat, p to q, v) == 0)
        }
        mat
    }
}

private fun testRandomicBoard(sizeBoard: Int = 31) = run(generateRandomicBoard(n = sizeBoard))

private fun testStaticBoard(whichBoard: Int = 0) = run(Board[whichBoard])

private fun run(board: Array<Array<Int>>) {
    board.print()
    val message = if (navigation(board, 0, 0, 1, values())) {
        "Is solvable"
    } else {
        "Is Unsolvable"
    }
    println(String.format("%s\n%s", message, board.string()))
}

fun main() {
    val s = computeBenchmark {
        testStaticBoard(1)
    }

    println(s)
}