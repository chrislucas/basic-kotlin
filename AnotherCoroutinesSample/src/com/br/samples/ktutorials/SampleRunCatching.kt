package com.br.samples.ktutorials

import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileReader
import java.lang.StringBuilder

fun main() {
    val result = File("raw/ref").runCatching {
        val buffer = BufferedReader(FileReader(this))
        buffer.readLines().map { it + "\n" }.toString()
    }

    if (result.isFailure) {
        result.exceptionOrNull()?.let {
            println(it.message)
        }
    } else {
        result.onSuccess {
            println(it)
        }
    }
}