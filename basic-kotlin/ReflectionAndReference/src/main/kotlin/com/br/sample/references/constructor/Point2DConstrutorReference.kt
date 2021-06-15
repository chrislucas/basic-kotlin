package com.br.sample.references.constructor


// https://kotlinlang.org/docs/reflection.html#constructor-references

data class Point2D(val x: Double, val y: Double)

fun builder(x: Double, y: Double, fn: (Double, Double) -> Point2D) = fn(x, y)

fun main() {
    println(builder(1.0, 2.0, ::Point2D))
}