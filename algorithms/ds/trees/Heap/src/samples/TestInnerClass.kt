package samples

import java.lang.reflect.Constructor

class Outer1 {
    private val inner1Data = mutableListOf<Inner1>()
    data class Inner1(val value: Int)
    fun insertInner1(data: Int) = inner1Data.add(Inner1(data))
}

class Outer2<T> {
    data class Inner2<T>(val value: T)
    val inner2Data = mutableListOf<Inner2<T>>()
    //inline fun <reified T> getInstance() : T? = T::class.objectInstance
    // inline fun <reified T> insertInner2(data: T) = inner2Data.add(Inner2(data))
}

// inline function nao podem ser recursivas
/*inline*/ fun rec(n: Int): Int {
    return if (n == 1) {
        n
    } else {
        n * rec(n-1)
    }
}

fun main() {


}