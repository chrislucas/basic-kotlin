package com.br.sample.cf

fun readInt() = readLine()!!.toInt()

fun readInts(delimiter: String = " ") = readLine()!!.split(delimiter).map { it.toInt() }