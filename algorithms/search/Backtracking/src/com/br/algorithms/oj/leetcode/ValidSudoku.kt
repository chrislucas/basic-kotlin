package com.br.algorithms.oj.leetcode

import java.util.*

// https://leetcode.com/problems/valid-sudoku/

/**
 * Corrigir, ainda nao passa pelo Juiz online
 * */
class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        for (i in board.indices) {
            val setL = TreeSet<Char>()
            val setC = TreeSet<Char>()
            for (j in board[i].indices) {
                if (j % 3 == 0 && i % 3 == 0 && !isQuadrantsSafe(board, i, j)) {
                    return false
                }

                if (setL.contains(board[i][j]) || setC.contains(board[j][i]))
                    return false

                if (board[i][j] != '0') {
                    setL.add(board[i][j])
                }

                if (board[j][i] != '0') {
                    setC.add(board[j][i])
                }
            }
        }
        return true
    }

    private fun isQuadrantsSafe(board: Array<CharArray>, i: Int, j: Int): Boolean {
        for (ii in i..i + 2) {
            val set = TreeSet<Char>()
            for (jj in j..j + 2) {
                if (board[ii][jj] == '0')
                    continue
                else if (set.contains(board[ii][jj]))
                    return false
                set.add(board[ii][jj])
            }
        }
        return true
    }
}

fun main() {
    val s = Solution()

    while (true) {
        val input = readLine() ?: ""

        if (input.isEmpty())
            break
        val matrix = Array(9) { CharArray(9) { '0' } }

        input.run {
            val split = this.split("],")
            split.forEachIndexed { i, s ->
                matrix[i] = s.replace("\\.".toRegex(), "0")
                    .replace("\\W".toRegex(), "").toCharArray()
            }
        }
        println(s.isValidSudoku(matrix))
    }


}