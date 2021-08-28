package com.br.sample.feature.datasource

import com.br.sample.feature.datasource.decorator.CompressionBaseDecorator
import com.br.sample.feature.datasource.decorator.EncryptionBaseDecorator
import com.br.sample.feature.datasource.decorator.models.DataSourceComponent
import com.br.sample.feature.datasource.decorator.models.FileDataSourceComponent
import com.br.sample.feature.datasource.decorator.models.fromFileToByteArray


private fun sample() {
    val fileDataSourceComponent: DataSourceComponent = FileDataSourceComponent("raw/_compression_algorithms.txt")
    val fileDataEncryptedSourceComponent = EncryptionBaseDecorator(fileDataSourceComponent)
    val fileDataEncryptedCompressedSourceComponent = CompressionBaseDecorator(fileDataEncryptedSourceComponent)
    fileDataEncryptedCompressedSourceComponent.writeData(fromFileToByteArray("raw/_compression_algorithms.txt"))
    fileDataEncryptedCompressedSourceComponent.readData()
}


fun main() {
    sample()
}