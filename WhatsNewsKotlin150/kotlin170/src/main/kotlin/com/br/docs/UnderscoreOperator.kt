package com.br.docs

/*
    https://kotlinlang.org/docs/whatsnew17.html#underscore-operator-for-type-arguments
 */


interface StrategyCrypto<T> {
    fun execute(): T
}


class RSA : StrategyCrypto<Array<Int>> {
    override fun execute(): Array<Int> =
        arrayOf(1)
}

class CaesarCipher: StrategyCrypto<List<Int>> {
    override fun execute(): List<Int> = listOf(1)
}


object Runner {
    inline fun <reified C:StrategyCrypto<T>, T> run(): T =
        C::class.java.getDeclaredConstructor().newInstance().execute()
}


fun main() {
    val p = Runner.run<CaesarCipher, _>()
    println(p)
    val q = Runner.run<RSA, _>()
    println(q)
}
