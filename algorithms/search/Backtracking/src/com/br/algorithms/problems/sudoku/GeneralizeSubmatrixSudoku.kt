package com.br.algorithms.problems.sudoku


import com.br.algorithms.problems.sudoku.ext.Int2DMat
import com.br.algorithms.problems.sudoku.ext.IntPair
import kotlin.math.sqrt

/**
 * Projeto para analisar se a solucao de analise das submatrizes de um jogo de sudoky estao
 * preenchidas corretamente, independente do tamanho do tabuleiro
 * */

// Gera uma matriz SxS preenchida com 0
fun gen(s: Int = 9, n: Int = 0): Int2DMat {
    return if (n < 2) {
        Array(s) { Array(s) { 0 } }
    } else {
        val mat = Array(s) { Array(s) { 0 } }
        // preencher com um algoritmo randomico
        mat
    }
}

/**
 * Dada uma posicao i,j na matriz, encontramos o quadrante que ela pertence
 * e validamos se eh possivel adicionar um numero nesse quadrante
 * */

/**
 *
    while (p % t != 0)
        p -= 1
    while (q % t != 0)
        q -= 1
 */
fun checkQuandrant(board: Int2DMat, pos: IntPair, value: Int): Boolean {
    var (p, q) = pos
    var t = sqrt(board.size * 1.0).toInt()
    p -= (p % t)
    q -= (q % t)
    t -= 1
    for (i in p .. p+t) {
        for (j in q .. q+t) {
            if (board[i][j] == value) {
                return false
            }
        }
    }
    return true
}

fun main() {
    val matrix = gen(9)

    arrayOf( Pair(9, 0 to 6)
        , Pair(9, 1 to 6)
        , Pair(3, 5 to 6)
        , Pair(3, 3 to 5)
        , Pair(9, 8 to 8)
        , Pair(9, 4 to 4)
    ).forEach {
        println(checkQuandrant(matrix, it.second, it.first))
    }
}