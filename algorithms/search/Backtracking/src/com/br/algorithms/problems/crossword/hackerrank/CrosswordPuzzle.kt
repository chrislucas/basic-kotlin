package com.br.algorithms.problems.crossword.hackerrank

import kotlin.math.abs

// https://www.hackerrank.com/challenges/crossword-puzzle/problem
// https://www.hackerrank.com/challenges/crossword-puzzle/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=recursion-backtracking


// Representa um espaco em branco no caca palavras
class BlankSpace(private val initial: Pair<Int, Int>, private val final: Pair<Int, Int>) {
    val length: Int
        get() {
            return if (initial.first == final.first) {
                final.second - initial.second
            } else {
                final.first - initial.first
            }
        }
}


private fun findBlankSpacesHorizontal(board: Array<Array<Char>>, blank: Char) : List<BlankSpace> {

    for (i in board.indices) {
        for (j in board[i].indices) {
            if (board[i][j] == blank) {

            }
        }
    }
    return emptyList()
}


private fun findBlankSpacesVertical(board: Array<Array<Char>>, blank: Char) : List<BlankSpace> {

    for (i in board.indices) {
        for (j in board[i].indices) {
            if (board[i][j] == blank) {

            }
        }
    }
    return emptyList()
}

//fun main() {}