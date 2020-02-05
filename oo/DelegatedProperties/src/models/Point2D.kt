package models

/**
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/lazy.html
 *
 * lazy eh uma funcao que recebe um lambda como argumento e retornar uma
 * instancia da interface Lazy<T> que funciona como um 'delegate'
 *
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-lazy/index.html
 *  @see [kotlin.lazy]
 * Interface Lazy: representa um valor inicializado by lazy function
 * Por padrao 'lazy properties' eh 'synchronized'
 *
 * */

data class Point2D(val x: Int, val y: Int)