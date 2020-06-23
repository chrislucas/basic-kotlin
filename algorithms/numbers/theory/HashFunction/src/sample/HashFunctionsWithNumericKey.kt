package sample

import jdk.jfr.Frequency
import kotlin.math.log2
import kotlin.math.roundToInt

/**
 * https://www.ime.usp.br/~pf/mac0122-2002/aulas/hashing.html
 * */

fun modularHashFunction(key: Int, mod: Int) = key % mod

fun xorHashFunction(key: Int, value: Int) = key xor value

// Log
fun showMaxFrequency(frequency: MutableMap<Int, Int>) {
    var maxCollision = 0
    var pairMaxCollision: Pair<Int, Int> = 0 to 0
    for ((hash, freq) in frequency) {
        if (freq > maxCollision) {
            maxCollision = freq
            pairMaxCollision = hash to freq
        }
    }
    println(pairMaxCollision)
}

fun testCollisionsModularHashFunction(mod: Int) {
    // seguindo o exemplo do site do IME vamos ver
    val frequency: MutableMap<Int, Int> = mutableMapOf()
    // espaco de chaves
    val range = 100001 .. 9999999
    for (key in range) {
        val hash = modularHashFunction(key, mod)
        frequency[hash]  = frequency[hash]?.let { it + 1 } ?: 1
    }
    showMaxFrequency(frequency)
}

fun Int.countBits() : Int = log2(this * 1.0).roundToInt() + 1

fun testCollisionsXorHashFunction() {
    val frequency: MutableMap<Int, Int> = mutableMapOf()
    // espaco de chaves
    val range = 100001 .. 9999999
    for (key in range) {
        // (2 ^ numeroDeBits(key)) - 1 = igual a um inteiro com todos os bits = 1
        val value = (1 shl key.countBits()) - 1
        val hash = xorHashFunction(key, value)
        frequency[hash]  = frequency[hash]?.let { it + 1 } ?: 1
    }
    showMaxFrequency(frequency)
}

fun collisionHashFunction(generateHashFunction: (valueToTransform: Int, Int.() ->  Int) -> Int
                          , partial:  (Int) ->  Int) {
    val frequency: MutableMap<Int, Int> = mutableMapOf()
    // espaco de chaves
    val range = 100001 .. 9999999
    for (key in range) {
        val hash = generateHashFunction(key, partial)
        frequency[hash]  = frequency[hash]?.let { it + 1 } ?: 1
    }
    showMaxFrequency(frequency)
}

fun testCollisionHashFunction() {
    val transformXorHash: (Int, (Int)-> Int) -> Int = {
        value, partial -> value xor partial(value)
    }
    collisionHashFunction(transformXorHash, Int::countBits) // { log2(it * 1.0).roundToInt() + 1 }
    println("*********************************************************")
    val transformModularHash: (Int, (Int)-> Int) -> Int = {
        value, partial -> modularHashFunction(value, partial(value))
    }
    collisionHashFunction(transformModularHash) { 1000000 }
}




fun main(array: Array<String>) {
    testCollisionHashFunction()
}