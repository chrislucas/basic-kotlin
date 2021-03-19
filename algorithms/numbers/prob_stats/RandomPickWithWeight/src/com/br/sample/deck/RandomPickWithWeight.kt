package com.br.sample.deck

import com.br.sample.shuffle
import com.br.sample.string
import com.br.sample.toArray


// Probabilidade MAXIMA de uma carta e um Naiper serem escolhidas
const val MAX_PROBABILITY_CARD = .75
const val MAX_PROBABILITY_SUIT = .95

//  distribuicao randomica da probabiliadde da i-esima carta ser escolhida
// sendo i = 0 Az .. 1 = 12 Rei
val maxWeightCars: (Array<Int>, Double) -> Array<Pair<Int, Double>> = {
    // embaralha as posicacoes de um array
        weights, maxProbability ->
    // Array<Peso, Porbabilidade Proporcional ao peso
    weights.map { value ->
        /**
         * A ideia aqui eh: o i-esimo valor do array de pesos
         * diz o peso que a i-esima carta do baralho tem de ser escolhida
         * A probabilidade maxima de uma carta ser retirada eh dada pela
         * constante MAX_PROBABILITY. Usamos esse valor para calcular proporcionalmente
         * a probabilidade de uma carta ser retirada com o seguinte calculo
         *
         *  peso / quantidade de cartas de um naipe * PROBABILIDADE_MAXIMA
         *
         *  se uma carta tem peso 1 num baralho onde cada naipe tem 13 cartas
         *  a probabilidade dela ser escolhida eh uma 1 / 13. Sendo MAX_PROBABILITY
         *  a probabilidade maxima, calculamos 1 / 13 * MAX_PROBABILITY e teremos
         *  um valor proporcional a aquele peso. Se uma carta tem peso 13, ela tem 13 vezes
         *  mais chaces, 13/13 * MAX_PROB = MAX_PROB
         * */
        value to (value * 1.0) / weights.size * maxProbability
    }
        .toTypedArray()

}

private val cards = (1..13).toArray().shuffle()
private val suits = (1..4).toArray().shuffle()

private fun sample() {
    println(maxWeightCars(cards, MAX_PROBABILITY_CARD).string())
    println(maxWeightCars(suits, MAX_PROBABILITY_SUIT).string())
}

fun main() {
    sample()
}