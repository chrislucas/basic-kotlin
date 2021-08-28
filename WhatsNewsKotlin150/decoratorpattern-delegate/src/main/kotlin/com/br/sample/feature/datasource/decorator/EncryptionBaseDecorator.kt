package com.br.sample.feature.datasource.decorator

import com.br.sample.feature.datasource.decorator.models.DataSourceComponent
import com.br.sample.feature.datasource.decorator.models.log

class EncryptionBaseDecorator(private val wrapperComponent: DataSourceComponent) :
    DataSourceComponentBaseDecorator(wrapperComponent) {

    override fun writeData(data: ByteArray) {
        println("Write Data Decorator: ${javaClass.name} - ${data.log()}")
        wrapperComponent.writeData(data)
    }

    override fun readData(): ByteArray {
        println("Read Data Decorator: ${javaClass.name}")
        return wrapperComponent.readData()
    }
}