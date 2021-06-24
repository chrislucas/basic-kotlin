package com.br.sample.feature.datasource.decorator.models

import java.io.*
import java.lang.StringBuilder


fun ByteArray.log(separator: String = "|")= this.joinTo(StringBuilder(), separator)

fun fromFileToByteArray(path: String): ByteArray {
    val buffer = BufferedReader(FileReader(File(path)))

    val content = buffer.readLines()
        .fold(StringBuilder()) { builder, string ->
            builder.append(string)
        }

    return content.toString().toCharArray().map { it.code.toByte() }.toByteArray()
}

class FileDataSourceComponent(private val filename: String) : DataSourceComponent {

    override fun writeData(data: ByteArray) {
        println("Write Data Decorator: ${javaClass.name} - ${data.log()}")
    }

    override fun readData(): ByteArray {
        val bytes = fromFileToByteArray(filename)
        println("Read Data Decorator: ${javaClass.name} - Bytes: ${bytes.log()}")
        return bytes
    }
}