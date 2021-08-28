package com.br.sample.upperlowerbound

import kotlin.math.abs


fun almostEquals(p: Double, q: Double, e: Double = 1e-6): Int {
    return when {
        abs(p - q) < e -> {
            0
        }
        p - q < 0 -> {
            -1
        }
        else -> {
            1
        }
    }
}

class PrinceInfo(val value: Double) : Comparable<PrinceInfo> {
    override fun compareTo(other: PrinceInfo): Int = almostEquals(value, other.value)
}

private fun upperBound() {

}

private fun lowerBound() {

}

fun main() {
    upperBound()
    lowerBound()
}