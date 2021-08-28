package com.br.sample.helpers

import java.lang.StrictMath.abs
import kotlin.random.Random


private fun <T> Array<T>.swap(p: Int, q: Int) {
    val value = this[p]
    this[p] = this[q]
    this[q] = value
}

fun <T> Array<T>.shuffle(): Array<T> {
    for (i in indices) {
        val idx = Random.nextInt(0, i + 1)
        this.swap(i, idx)
    }
    return this
}

fun <T> Array<T>.string(d: String = ",") = this.run {
    val string = StringBuilder()
    this.forEachIndexed { i, v ->
        string.append(if (i == 0) v else (", $v"))
    }
    string
}


// inspiracao da funcao do cpp
// https://www.geeksforgeeks.org/upper_bound-in-cpp/
// funcao deve devolver o indice do primeiro elemento maior que o valor value
// dentro do intervalo  [startIndex:endIndex) ou o valor do tamanho do arrat
fun <T : Comparable<T>> Array<T>.upperBoundBinSearch(startIndex: Int, endIndex: Int, vTarget: T): Int {
    var lf = startIndex
    var ri = endIndex - 1
    var idx = endIndex
    while (lf <= ri) {
        val mi = (ri - lf) / 2 + lf
        when {
            vTarget < this[mi] -> {
                idx = mi
                ri = mi - 1
            }
            else -> {
                lf = mi + 1
            }
        }
    }
    return idx
}

fun <T : Comparable<T>> Array<T>.upperBoundBinSearch(vTarget: T) = upperBoundBinSearch(0, size, vTarget)

// algoritmo baseado na possivel implementacao do cpp:
// https://en.cppreference.com/w/cpp/algorithm/upper_bound
// funcao deve devolver o indice do primeiro elemento maior que o valor value
// dentro do intervalo  [startIndex:endIndex), senao deve retornar endIndex
fun <T : Comparable<T>> Array<T>.upperBound(startIndex: Int, endIndex: Int, vTarget: T): Int {
    var s = startIndex
    var dist = abs(startIndex - (endIndex))
    while (dist != 0) {
        val mid = dist / 2
        // se o value for menor que o mid-esimo elemento, verificar os valores a esquerda de mid
        dist = if (vTarget < this[s + mid]) {
            mid
        } else {
            s += 1
            dist - (mid + 1)
        }
    }
    return s
}

fun <T : Comparable<T>> Array<T>.upperBound(vTarget: T) = upperBound(0, this.size, vTarget)


// funcao deve devolver o indice do primeiro elemento que nao eh menor que o valor value
// no intervalo [start:end) ou end caso o valor nao seja encontrado
fun <T : Comparable<T>> Array<T>.lowerBoundBinSearch(startIndex: Int, endIndex: Int, vTarget: T): Int {
    var lf = startIndex
    var ri = endIndex - 1
    var idx = endIndex
    while (lf <= ri) {
        val mi = (ri - lf) / 2 + lf
        when {
            vTarget > this[mi] -> {
                lf = mi + 1
            }
            else -> {
                idx = mi
                ri = mi - 1
            }
        }
    }
    return idx
}

fun <T : Comparable<T>> Array<T>.lowerBoundBinSearch(vTarget: T) = lowerBoundBinSearch(0, size, vTarget)

// algoritmo baseado na possivel implementacao do cpp: https://en.cppreference.com/w/cpp/algorithm/lower_bound
fun <T : Comparable<T>> Array<T>.lowerBound(startIndex: Int, endIndex: Int, vTarget: T): Int {
    var s = startIndex
    var dist = abs(startIndex - (endIndex))
    while (dist != 0) {
        val mid = dist / 2
        dist = if (vTarget > this[s + mid]) {
            s += 1
            dist - (mid + 1)
        } else {
            mid
        }
    }
    return s
}

fun <T : Comparable<T>> Array<T>.lowerBound(vTarget: T) = lowerBound(0, this.size, vTarget)
