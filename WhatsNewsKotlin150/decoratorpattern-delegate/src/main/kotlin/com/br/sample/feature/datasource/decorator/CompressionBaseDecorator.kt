package com.br.sample.feature.datasource.decorator

import com.br.sample.feature.datasource.decorator.models.DataSourceComponent
import com.br.sample.feature.datasource.decorator.models.log

class CompressionBaseDecorator(private val wrapper: DataSourceComponent): DataSourceComponentBaseDecorator(wrapper) {

    override fun writeData(data: ByteArray) {
        println("Write Data Decorator: ${javaClass.name} - ${data.log()}")
        wrapper.writeData(data)
    }

    override fun readData(): ByteArray {
        println("Read Data Decorator: ${javaClass.name}")
        return wrapper.readData()
    }
}