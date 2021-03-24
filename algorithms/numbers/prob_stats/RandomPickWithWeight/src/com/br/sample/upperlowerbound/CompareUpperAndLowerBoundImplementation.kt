package com.br.sample.upperlowerbound

import com.br.sample.helpers.lowerBound
import com.br.sample.helpers.lowerBoundBinSearch
import com.br.sample.helpers.upperBound
import com.br.sample.helpers.upperBoundBinSearch

fun fnUpperBound() {
    val values = arrayOf(10, 20, 30, 40, 50)
    println(values.upperBoundBinSearch(0, values.size, 35))
    println(values.upperBound(0, values.size, 35))
    println(values.upperBoundBinSearch(0, values.size, 45))
    println(values.upperBound(0, values.size, 45))
}

fun fnLowerBound() {
    var values = arrayOf(10, 20, 30, 40, 50)
    println(values.lowerBoundBinSearch(0, values.size, 30))
    println(values.lowerBound(0, values.size, 30))
    println(values.lowerBoundBinSearch(0, values.size, 35))
    println(values.lowerBound(0, values.size, 35))
    println(values.lowerBoundBinSearch(0, values.size, 45))
    println(values.lowerBound(0, values.size, 45))
    println(values.lowerBoundBinSearch(0, values.size, 55))
    println(values.lowerBound(0, values.size, 55))
    println(values.lowerBoundBinSearch(0, values.size, 60))
    println(values.lowerBound(0, values.size, 60))

    values = arrayOf(10, 20, 30, 30, 30, 45, 60, 70)
    println(values.lowerBoundBinSearch(0, values.size, 30))
    println(values.lowerBound(0, values.size, 30))
}


fun main() {

}