package br.com.sample.contracts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

// https://kotlinlang.org/docs/reference/whatsnew13.html#contracts

@ExperimentalContracts
fun synchronizes(block: () -> Unit) {
    contract {
        callsInPlace(block, kotlin.contracts.InvocationKind.EXACTLY_ONCE)
    }
}

@ExperimentalContracts
fun main() {
    val x: Int
    synchronizes {
        x = 43
    }
    println(x)
}