package basics.function

import kotlin.math.roundToInt
import kotlin.math.sqrt

/**
 * https://kotlinlang.org/docs/reference/extensions.html
 * */
fun Int.isPrime(): Boolean{
    val i = this
    val limit = sqrt(i * 1.0).roundToInt()
    var flag = i > 1
    for (k in 2..limit) {
        if (i % k == 0) {
            flag = false
            break
        }
    }
    return flag
}

infix fun Double.power(e: Long) : Double {
    var b= this
    var e = e
    var acc = 1.0
    when {
        e < 0 -> {
            b = 1/b
            e = -e
        }
        e == 0L -> acc = 1.0
        e == 1L -> acc = this
    }
    while (e > 0) {
        if ((e and 1L) == 1L) {
            acc *= b
        }
        b *= b
        e = e shr 1
    }
    return acc
}




fun main(args: Array<String>) {

}