package com.br.algorithms

// navegacao recursiva por uma matriz 2D
fun rec(board: Array<Array<Int>>, i: Int, j: Int) {
    when {
        board.size == i -> { return }
        j < board[i].size -> {
            print(String.format(if (j > 0) " ,%d" else "%d", board[i][j]))
            rec(board, i, j+1)
        }
        else -> {
            println()
            rec(board, i+1, 0)
        }
    }
}