package com.br.sample.cf.ktheroes.pa

// https://codeforces.com/contest/1533/problem/A


fun readInt() = readLine()!!.toInt()

fun readInts(delimiter: String = " ") = readLine()!!.split(delimiter).map { it.toInt() }

fun main() {
    var cases = readInt()

    while (cases > 0) {
        val (numberOfFriends, daySheComes) = readInts()
        var max = 0
        for (i in 0 until numberOfFriends) {
            val (le, ri) = readInts()
            if (daySheComes in le .. ri) {
               val diff =  (ri - daySheComes) + 1
                if (diff > max)
                    max = diff
            }
        }
        cases -= 1
        println(max)
    }
}