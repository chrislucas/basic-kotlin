package com.br.algebra
// least common multiple - minimo multiplo comum
fun lcm(a: Int, b: Int) = a * b / gdc(a, b)

fun gdc(a: Int, b: Int): Int {
    var (ca, cb) = arrayOf(a, b)
    while (ca%cb>0) {
        val m = ca%cb
        ca = cb
        cb = m
    }
    return cb
}

fun main() {
    println(lcm(15, 20))
    println(lcm(15, 25))
}