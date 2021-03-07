package com.br.algorithms.oj.spoj

import java.util.*


// https://br.spoj.com/problems/BSUDO/
// TLE

private fun solver(board: Array<Array<Int>>): Boolean{
    for (i in board.indices) {
        for (j in board[i].indices) {
            if (board[i][j] == 0) {
                for (k in 1..9) {
                    if (add(board, i, j, k)) {
                        if (solver(board))
                            return true
                        board[i][j] = 0
                    }
                }
                return false
            }
        }
    }
    return true
}

val variables = fun() = LinkedList(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9))

// TLE
private fun solver(board: Array<Array<Int>>, values: Queue<Int>): Boolean{
    for (i in board.indices) {
        for (j in board[i].indices) {
            if (board[i][j] == 0) {
                while (values.isNotEmpty()) {
                    val k = values.poll()
                    if (add(board, i, j, k)) {
                        if (solver(board, variables()))
                            return true
                        board[i][j] = 0
                    }
                }
                return false
            }
        }
    }
    return true
}

// TODO estudar uma solucao mais eficiente

private fun add(board: Array<Array<Int>>, lin: Int, col: Int, value: Int): Boolean {
    return if (check(board, lin, col, value)) {
        board[lin][col] = value
        true
    } else {
        false
    }
}

private fun check(board: Array<Array<Int>>, lin: Int, col: Int, value: Int): Boolean {
    return when {
        lin < 0 || lin > 8 || col < 0 || col > 8 || board[lin][col] != 0 -> {
            false
        }
        else -> {
            checkLinesAndColumns(board, lin, col, value) && checkQuandrant(board, lin, col, value)
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

private fun checkQuandrant(board: Array<Array<Int>>, p: Int, q: Int, value: Int): Boolean {
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


fun main() {
    var cases = readLine()?.trim()?.toInt() ?: 0
    while (cases > 0) {
        cases -= 1
        val board = Array(9) { Array(9) { 0 } }
        for (i in 0..8) {
            val input = readLine()?.trim()?.split("")?.filter { it.isNotEmpty() }
            board[i] = input?.map { it.toInt() }
                ?.toTypedArray() ?: Array(9) { 0 }
        }
        solver(board)

        val message = StringBuilder()
        for (i in board.indices) {
            message.append(if (i == 0) board[i].joinToString("") else "\n${board[i].joinToString("")}")
        }
        print(message)
    }
}