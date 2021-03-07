package com.br.samples.ktutorials

inline fun compose(fn: () -> Unit) = fn()


fun main() {
    compose {  }
}