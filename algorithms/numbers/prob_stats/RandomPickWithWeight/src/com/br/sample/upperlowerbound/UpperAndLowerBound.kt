package com.br.sample.upperlowerbound

import com.br.sample.helpers.*


// https://en.cppreference.com/w/cpp/algorithm/upper_bound
private fun sampleUpperBound() {
    val interval = (1..6).toArray()

    for (i in 0 until 7) {
        val idx1 = interval.upperBound(i)
        val idx2 = interval.upperBoundBinSearch(i)
        println("$idx1, $idx2")
        if (idx1 != interval.size) {
            println("O primeiro valor maior que $i encontra-se no indice $idx1 = ${interval[idx1]}")
        } else {
            println("Nao foi encontrado nenhum valor maior que $i")
        }
    }
}


private fun sampleUpperAndLower() {
    val intervals = arrayOf(
        arrayOf(5, 5, 5),
        arrayOf(4, 5, 6),
        arrayOf(5, 5, 5),
        arrayOf(4, 4, 4),
        arrayOf(1, 2, 4, 5, 5, 6),
        arrayOf(1, 2, 4, 5, 5, 6, 6, 6, 6, 7),
        arrayOf(0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5),
        arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8),
        arrayOf(0, 1, 1, 2, 2, 2, 3, 3, 3, 4, 5),
        arrayOf(1, 2, 4, 5, 5, 6)
    )
    var query = 4
    var r = intervals[0].upperBound(query)
    println("Int: ${intervals[0].string()} upper bound query $query rs = $r")
    query = 5
    r = intervals[1].upperBound(query)
    println("Int: ${intervals[1].string()} upper bound query $query rs = $r")
    r = intervals[0].upperBound(query)
    println("Int: ${intervals[0].string()} upper bound query $query rs = $r")
    println("\n")


    for (interval in intervals) {
        println("Intervalo: ${interval.string()}")
        for (value in 0 until 10) {
            // se o resultado for igual ao tamanho do array eh pq nao tem resposta
            val up2 = interval.upperBoundBinSearch(value)
            val up1 = interval.upperBound(value)
            val lo2 = interval.lowerBoundBinSearch(value)
            val lo1 = interval.lowerBound(value)
            println("Target: $value. LB: (fn: $lo1, bs: $lo2). UB: (fn: $up1, bs: $up2)")
        }
        println()
    }
}

fun main() {
    sampleUpperAndLower()
}