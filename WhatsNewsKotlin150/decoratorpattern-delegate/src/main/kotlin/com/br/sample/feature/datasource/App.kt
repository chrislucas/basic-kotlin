package com.br.sample.feature.datasource

import com.br.sample.feature.datasource.decorator.CompressionBaseDecorator
import com.br.sample.feature.datasource.decorator.EncryptionBaseDecorator
import com.br.sample.feature.datasource.decorator.models.DataSourceComponent
import com.br.sample.feature.datasource.decorator.models.FileDataSourceComponent
import com.br.sample.feature.datasource.decorator.models.fromFileToByteArray

fun main() {

    var dataSourceComponent: DataSourceComponent = FileDataSourceComponent("raw/_compression_algorithms.txt")
    dataSourceComponent = EncryptionBaseDecorator(dataSourceComponent)
    dataSourceComponent = CompressionBaseDecorator(dataSourceComponent)

    dataSourceComponent.writeData(fromFileToByteArray("raw/_compression_algorithms.txt"))
    dataSourceComponent.readData()

}