package com.br.sample.helpers

/**
 * Dado a probabilidade maxima de um evento acontecer (maxValue)
 * e a quantidade de eventos (events) retornar um array com valores
 * dessas probabilidades onde Array[i] contem um valor da probabilidade
 * maxima proporcional a quantidade (maxValue / events). Essa
 * probabilidade aumenta para conforme i torna-se maior.
 *
 * A ideia eh usar essa funcao para gerar um vetor de pesos para simulacao
 * de eventos probabilisticos onde o i-esimo evento tem probabilida Array[i]
 * de ocorrer. Para uma simulacao interessante, devesse embaralhar a entrada
 * */
fun distribution(maxValue: Double, events: Int): Array<Double> {
    if (maxValue < 0.1 && maxValue > .95)
        throw IllegalArgumentException("IllegalArgumentException")

    val sample = Array(events) { maxValue }
    val proportional = maxValue / events
    var copyValue = maxValue
    for (i in (events - 2) downTo  0 ) {
        copyValue -= proportional
        sample[i] = copyValue
    }

    return sample.shuffle()
}