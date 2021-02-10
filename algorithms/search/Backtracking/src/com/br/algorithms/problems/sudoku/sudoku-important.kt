package com.br.algorithms.problems.sudoku

/**
 * Uma forma diferente de verificar se uma submatriz no sudoku esta correta
 *


    usedInBox(matrix, row - (row % 3), col - (col % 3), num)

    function usedInBox(matrix, boxStartRow, boxStartCol, num) {
        for (let row = 0; row < 3; row++) {
            for (let col = 0; col < 3; col++) {
                if (matrix[row + boxStartRow][col + boxStartCol] === num) {
                    return true;
                }
            }
        }
        return false;
    }
 * */