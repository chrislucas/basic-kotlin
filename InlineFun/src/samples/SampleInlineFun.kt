package sample

import sample.Caller.anotherCaller
import sample.Caller.caller

/**
 * https://www.youtube.com/watch?v=wAQCs8-a6mg
 * */



object Caller {
    fun <T, R> T.caller(fn: (T) -> R) = fn(this)

    inline fun <T, R> T.anotherCaller(fn: (T) -> R) = fn(this)
}

fun Int.isOdd() = this and 1 == 1

fun main() {
    1.caller {
        it and 1 == 0
    }

    1.anotherCaller {  it and 1 == 0 }

    10.isOdd()
}


