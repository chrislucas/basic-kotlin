package com.br.sample.tutorial.adventofcode

import com.br.sample.readFile


/**
 * https://www.youtube.com/watch?v=XEFna3xyxeY
 * https://adventofcode.com/2020
 * https://adventofcode.com/2020/day/5
 * */
private fun CharSequence.parseEach(inf: Int, sup: Int, predicate: (Char) -> Boolean): Int {
    return run {
        var le = inf
        var ri = sup
        var mi = 0
        this.onEach {
            mi = (ri - le) / 2 + le
            if (predicate(it)) {
                ri = mi
            } else {
                le = mi + 1
            }
        }
        le
    }
}

private fun test1() {
    arrayOf(
        "FBFBBFFRLR",
        "BFFFBBFRRR",
        "FFFBBBFRRR",
        "BBFFBBFRLL",
        "FFFFFFFRRR",
        "FFFFFFFLLL",
        "BBBBBBBRRR",
        "BBBBBBBLLL",
        "BBBBBBBRRR",
    ).forEach { it ->
        val r1 = it.substring(0, 7).parseEach(0, 127) { it == 'F' } // F == LOWER HALF
        val r2 = it.substring(7, it.length).parseEach(0, 7) { it == 'L' } // L == LOWER HALF
        val id = r1 * 8 + r2
        println("$it : $id")
    }
}


private fun execute() {
    val data = readFile("raw/aoc_input_day5")
    val processed = data.map { content ->
        val p = content.substring(0, 7)
        val q = content.substring(7, content.length)
        val r1 = q.parseEach(0, 127) { it == 'F' }
        val r2 = p.parseEach(0, 7) { it == 'L' }
        r1 * 8 + r2
    }
    val max = processed.maxOrNull()
    println(max)
}

fun main() {
    //execute()
    test1()
}