package samples.hackerearth

import kotlin.math.sqrt


fun Array<Double>.mean() = this.run { sum() / size }

fun Array<Double>.variance() : Double {
    val vMean = this.mean()
    return this.run {
        var acc = 0.0
        forEach {
            acc += (it - vMean) * (it - vMean)
        }
        1.0 / size * acc
    }
}

fun Array<Double>.stddev(): Double = sqrt(variance())


fun main() {

}