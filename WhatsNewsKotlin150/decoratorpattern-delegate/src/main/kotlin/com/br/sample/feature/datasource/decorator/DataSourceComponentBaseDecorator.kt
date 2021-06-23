package com.br.sample.feature.datasource.decorator

import com.br.sample.feature.datasource.decorator.models.DataSourceComponent

abstract class DataSourceComponentBaseDecorator(private val wrappedDataSourceComponent: DataSourceComponent) :
    DataSourceComponent {
    override fun writeData(data: ByteArray) {
        wrappedDataSourceComponent.writeData(data)
    }

    override fun readData(): ByteArray {
        return wrappedDataSourceComponent.readData()
    }
}