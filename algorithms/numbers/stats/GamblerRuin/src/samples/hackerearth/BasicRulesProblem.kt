package samples.hackerearth

/**
 * https://www.hackerearth.com/pt-br/practice/machine-learning/prerequisites-of-machine-learning/basic-probability-models-and-rules/tutorial/
 * DONE
 * */


/**
 * Mike e Alice vao passar o FDS no mesmo local, existe duas formas de chegar nesse local, uma delas eh de onibus.
 *
 * Existe uma probabilidade R de chover, uma probabilidade MB de mike ir de onibus e uma probabilidade AB de Alice ir de
 * onibus.
 * QUeremos saber qual a probabilidade de Mike e Alice SOMENTE SE ENCONTRAREM NO LOCAL (nao durante o transporte)
 * e ESTAR CHOVENDO ?
 *
 * */
fun solver(pRain: Double, pMikeOnBus: Double, pAliceOnBus: Double) : Double =
    pRain * ((pMikeOnBus * (1.0 - pAliceOnBus)) + (pAliceOnBus * (1.0 - pMikeOnBus)))

fun readDouble() = readLine()?.toDouble() ?: 0.0

fun main(args: Array<String>) {
    val pMikeOnBus = readDouble()
    val pAliceOnBus = readDouble()
    val pRain = readDouble()
    println(String.format("%.6f", solver(pRain, pMikeOnBus, pAliceOnBus)))
}