package com.br.sample.feature.datasource.decorator.models

import java.io.*
import java.lang.StringBuilder

class FileDataSourceComponent(private val filename: String) : DataSourceComponent {

    override fun writeData(data: ByteArray) {
        println("Write Data: $data")
    }

    override fun readData(): ByteArray {
        val buffer = BufferedReader(FileReader(File(filename)))
        val content = buffer.readLines().fold(StringBuilder()) { builder, string ->
            builder.append(string)
        }

        val bytes = content.toString().toCharArray().map { it.code.toByte() }.toByteArray()
        println("Bytes: ${bytes.joinTo(StringBuilder(), "|")}")
        return bytes
    }
}