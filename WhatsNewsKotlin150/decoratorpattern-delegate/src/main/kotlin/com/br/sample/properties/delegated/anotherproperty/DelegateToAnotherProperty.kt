package com.br.sample.properties.delegated.anotherproperty

import kotlin.reflect.KProperty
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

/**
 * https://kotlinlang.org/docs/delegated-properties.html#delegating-to-another-property
 *
 * Uma propriedade pode delegar seu getter e setter a outra propriedade
 * */

class Provider<R>(val builder: () -> R)

class WrapperGenericValue<R>(provider: Provider<R>) {
    val delegatedToAnotherClass: R by provider::builder
}

private operator fun <R> KProperty0<() -> R>.getValue(nothing: WrapperGenericValue<R>, property: KProperty<*>): R =
    this.get().invoke()

private fun genericSample() {
    val creator = Provider { 100 }

    val wrapperInt = WrapperGenericValue(creator)

    println(wrapperInt.delegatedToAnotherClass)
}

fun main() {
    genericSample()
}