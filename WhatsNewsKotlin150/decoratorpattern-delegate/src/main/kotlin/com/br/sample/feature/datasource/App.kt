package com.br.sample.feature.datasource

import com.br.sample.feature.datasource.decorator.CompressionBaseDecorator
import com.br.sample.feature.datasource.decorator.EncryptionBaseDecorator
import com.br.sample.feature.datasource.decorator.models.DataSourceComponent
import com.br.sample.feature.datasource.decorator.models.FileDataSourceComponent

fun main() {

    var dataSourceComponent: DataSourceComponent = FileDataSourceComponent("raw/_compression_algorithms.txt")
    dataSourceComponent = EncryptionBaseDecorator(dataSourceComponent)
    dataSourceComponent = CompressionBaseDecorator(dataSourceComponent)

    dataSourceComponent.writeData(byteArrayOf(Byte.MIN_VALUE))
    dataSourceComponent.readData()

}