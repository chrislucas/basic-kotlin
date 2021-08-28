package com.br.sample.cf.ktheroes.pb

// https://codeforces.com/contest/1533/problem/B

fun readInt() = readLine()!!.toInt()

fun readInts(delimiter: String = " ") = readLine()!!.split(delimiter).map { it.toInt() }

fun main() {
    var cases = readInt()
    while (cases > 0) {
        val sizeOfArray = readInt()

        val numbers = readInts().toTypedArray()

        cases -= 1
    }
}