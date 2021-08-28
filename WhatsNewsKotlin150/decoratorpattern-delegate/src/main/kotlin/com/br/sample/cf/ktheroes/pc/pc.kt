package com.br.sample.cf.ktheroes.pc

// https://codeforces.com/contest/1533/problem/C
fun readInt() = readLine()!!.toInt()

fun readInts(delimiter: String = " ") = readLine()!!.split(delimiter).map { it.toInt() }

fun solver(table: MutableList<String>, jump: Int): Int {
    var acc = 0
    table.removeAt(0)
    var k = 0
    while (table.any { it == "1" }) {
        k = (jump + k - 1) % table.size
        table.removeAt(k)
        acc+=1
    }

    return 0
}


fun main() {
    var cases = readInt()

    while (cases > 0) {
        val (sweets, jump) = readInts()
        val table = readLine()!!.split("").toTypedArray()
        val result = if (table.all { it == "0" }) {
            0
        } else {
            solver(table.toMutableList(), jump)
        }
        println(result)
        cases -= 1
    }
}