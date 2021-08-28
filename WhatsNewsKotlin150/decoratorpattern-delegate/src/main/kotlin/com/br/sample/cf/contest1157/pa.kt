package com.br.sample.cf.contest1157

// https://codeforces.com/contest/1157/problem/A

fun removeTrailingZeros(value: Int): Int {
    var mValue = value

    while (mValue % 10 == 0) {
        mValue /= 10
    }

    return mValue
}


fun function(value: Int, map: MutableMap<Int, Boolean>): Int {
    if (map[value] == true) {
        return 1
    }
    map[value] = true
    return function(removeTrailingZeros(value + 1), map) + 1
}


operator fun <T> HashSet<T>.get(value: T) = this.contains(value)

fun function1(value: Int, set: HashSet<Int>): Int {
    if (set[value]) {
        return 1
    }
    set.add(value)
    return function1(removeTrailingZeros(value + 1), set) + 1
}


private fun sample() {
    println(function1(10, hashSetOf()) - 1)
    println(function1(1098, hashSetOf()) - 1)
    println(function1(10098, hashSetOf()) - 1)
    println(function1(1000000000, hashSetOf()) - 1)
}

private fun solver() {
    sample()
    val p = readLine()?.toInt()
    p?.let {
        println(function(it, mutableMapOf()) - 1)
    }
}

fun main() {
    solver()
}