package com.br.sample

/**
 * https://kotlinlang.org/docs/fun-interfaces.html#sam-conversions
 * */
fun interface Observer {
    fun call()
}

class Observable(private var mObserver: Observer? = null) {
    var observer: Observer = Observer {
        println("default implementation")
    }
        get() {
            if (mObserver == null) {
                mObserver = field
            }
            return mObserver ?: throw Exception("")
        }

}

/**
 * https://proandroiddev.com/backing-properties-in-kotlin-cb78dfebfd90
 * */
class Data {
    private val mValue = 30
    val value: Int
        get() {
            return mValue
        }

    val print = {
        println(mValue)
    }
}

fun main() {
}
