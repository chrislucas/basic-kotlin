package com.br.sample.feature.datasource.decorator

import com.br.sample.feature.datasource.decorator.models.DataSourceComponent
import com.br.sample.feature.datasource.decorator.models.log

abstract class DataSourceComponentBaseDecorator(private val wrappedDataSourceComponent: DataSourceComponent) :
    DataSourceComponent {
    override fun writeData(data: ByteArray) {
        println("Write Data Decorator: ${javaClass.name} - ${data.log()}")
        wrappedDataSourceComponent.writeData(data)
    }

    override fun readData(): ByteArray {
        println("Read Data Decorator: ${javaClass.name}")
        return wrappedDataSourceComponent.readData()
    }
}