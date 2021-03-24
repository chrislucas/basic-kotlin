package com.br.sample.deck

class Deck {
    companion object {
        val SUITS = arrayOf(Suit.Diamond, Suit.Cups, Suit.Clubs, Suit.Spades)
    }

    private val deck: Map<Suit, ArrayList<Card>>

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

sealed class CardValue(private val value: Int) : Comparable<CardValue> {

    override fun compareTo(other: CardValue): Int =
        this.value - other.value

    companion object {
        private val map = mapOf(1 to Ace(), 11 to Jack(), 12 to Queen(), 13 to King())
        operator fun get(value: Int) = map[value] ?: Number(value)
    }


    class Ace() : CardValue(1) {
        override fun toString(): String = "ACE"
    }

    class Number(number: Int) : CardValue(number)

    class Jack() : CardValue(11) {
        override fun toString(): String = "Jack"
    }

    class Queen() : CardValue(12) {
        override fun toString(): String = "Queen"
    }

    class King() : CardValue(13) {
        override fun toString(): String = "King"
    }
}

sealed class Suit(private val name: String) {

    override fun toString() = name

    object Diamond : Suit("\u2666")
    object Cups : Suit("\u2665")
    object Clubs : Suit("\u2663")
    object Spades : Suit("\u2660")
}

private fun provideCardValue(value: Int) = CardValue[value]


fun provideCard(value: Int, suit: Int): Card {
    if (value < 0 || value > 13 || suit < 0 || suit > 3)
        throw IllegalArgumentException("Valores fora da capacidade permitida")
    return Card(provideCardValue(value), Deck.SUITS[suit])
}

