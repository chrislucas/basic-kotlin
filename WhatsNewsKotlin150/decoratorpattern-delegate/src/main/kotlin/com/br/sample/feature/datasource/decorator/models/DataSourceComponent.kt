package com.br.sample.feature.datasource.decorator.models

interface DataSourceComponent {
    fun writeData(data: ByteArray)
    fun readData(): ByteArray
}