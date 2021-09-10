package com.br.sample

import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

fun String.getLines(): StringBuilder {
    val buffer = BufferedReader(InputStreamReader(FileInputStream(this)))
    return StringBuilder().run {
        do {
            val line: String? = buffer.readLine()
            if (line == null || line.isEmpty())
                break
            this.append(line)
        } while (true)
        this
    }
}


fun readFile(fileName: String): List<String> = File(fileName).bufferedReader().readLines()