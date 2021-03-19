package com.br.sample.deck

class Deck {
    companion object {
        val SUITS = arrayOf(Suit.Diamond, Suit.Cups, Suit.Clubs, Suit.Spades)
    }

    val deck: Map<Suit, ArrayList<Card>>

    init {
        val map = mutableMapOf<Suit, ArrayList<Card>>()
        for (suit in SUITS.indices) {
            val cards = arrayListOf<Card>()
            for (i in 0 until 13) {
                cards.add(provideCard(i, suit))
            }
            map[SUITS[suit]] = cards
        }
        deck = map
    }

    operator fun get(suit: Suit) = deck[suit]
}

data class Card(private val value: CardValue, private val suit: Suit)

sealed class CardValue(private val value: String) {
    override fun toString() = value
    class Ace() : CardValue("1")
    class Number(number: Int) : CardValue(number.toString())
    class Jack() : CardValue("jack")
    class Queen() : CardValue("queen")
    class King() : CardValue("king")
}

sealed class Suit(private val name: String) {

    override fun toString() = name

    object Diamond : Suit("\u2666")
    object Cups : Suit("\u2665")
    object Clubs : Suit("\u2663")
    object Spades : Suit("\u2660")
}

private fun provideCardValue(value: Int) =
    when {
        value < 11 -> {
            CardValue.Number(value)
        }
        value == 11 -> {
            CardValue.Jack()
        }
        value == 12 -> {
            CardValue.Queen()
        }
        else -> {
            CardValue.King()
        }
    }

fun provideCard(value: Int, suit: Int): Card {
    if (value < 0 || value > 13 || suit < 0 || suit > 3)
        throw IllegalArgumentException("Valores fora da capacidade permitida")
    return Card(provideCardValue(value), Deck.SUITS[suit])
}

