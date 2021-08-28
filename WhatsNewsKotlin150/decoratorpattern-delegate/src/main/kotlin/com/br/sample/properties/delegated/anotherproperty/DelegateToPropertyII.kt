package com.br.sample.properties.delegated.anotherproperty

import kotlin.reflect.KProperty
import kotlin.reflect.KProperty0

const val CONSTANT_INT = 0

class DelegateToMemberClass {
    var value: Int = 0
    var newValue: Int by this::value
}

private fun sampleDelegateToMemberClass() {
    val delegate = DelegateToMemberClass()
    delegate.value = 12
    println(delegate.newValue)
}

fun main() {
    sampleDelegateToMemberClass()
}