package com.br.sample.feature.datasource.decorator

import com.br.sample.feature.datasource.decorator.models.DataSourceComponent

class CompressionBaseDecorator(private val wrapper: DataSourceComponent): DataSourceComponentBaseDecorator(wrapper) {

    override fun writeData(data: ByteArray) {
        println("Write Data Decorator: ${javaClass.name}")
        wrapper.writeData(data)
    }

    override fun readData(): ByteArray {
        println("Read Data Decorator: ${javaClass.name}")
        return wrapper.readData()
    }
}