package samples

import samples.MathFun.exp

/**
 *
 * */
private fun unfairGame(p: Double, q: Double, initValue: Long, targetValue: Long) =
    (1 - exp(q/p, initValue)) / (1 - exp(q/p, targetValue))

/**
 *
 * */
private fun fairGame(pa: Double, pb: Double):Double = pb / (pa + pb)


private fun Double.print(format: String) = println(String.format(format, this))

private fun sampleUnfairGame() {

    val probabilities = mutableListOf(Pair(.49, .51))

    repeat(50) {
        val pair = probabilities[it]
        probabilities.add(Pair(pair.first + 0.01, pair.second - 0.01))
    }

    probabilities.forEach {
        pair ->
        val (p, q) = pair
        val targetValue = 100L
        for (initValue in 0 .. targetValue) {
            println(String.format("Valor Inicial: %d | Valor alvo: %d\nCada jogo[P(W): %.2f, P(L): %.2f]\nP(quebrar a banca): %.8f\n"
                , initValue
                , targetValue
                , p
                , q
                , unfairGame(p, q, initValue, targetValue))
            )
        }
    }


}


fun main() {
    sampleUnfairGame()
}