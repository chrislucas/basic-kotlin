package com.br.sample.properties.delegated

import kotlin.reflect.KProperty

operator fun <R> (() -> R).getValue(r: Nothing, property: KProperty<*>): R = this()

// Gemeric getValue com uma lambda que nao recebe argumento nenhum
operator fun <R> (() -> R).getValue(r: R?, property: KProperty<*>): R = this()

// getValue operator que recebe um parametro nullable
operator fun <A, R> ((A?) -> R).getValue(arg: A?, property: KProperty<*>): R = this(arg)


operator fun (() -> Int).getValue(not : Nothing?, property: KProperty<*>) = this()