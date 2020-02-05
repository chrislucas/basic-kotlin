package sample

import models.Point2D
import kotlin.reflect.KProperty

/**
 * @see [kotlin.lazy]
 * Uma funcao que recebe um lambda e retorna uma instancia de [Lazy] que serve como delegate,
 * veja a implementacao [Lazy.getValue] e a implementacao de estudos de um 'custom delegate' para estudos em
 * @see [SampleDelegateProperties.kt].
 *
 * @see [https://kotlinlang.org/docs/reference/delegated-properties.html#lazy]
 *
 * Por padrao a avalicao de proprie
 *
 * */

// como a interface Lazy nao possui sample.setValue a expressao 'by lazy' so funciona com
// variaveis read-only (val)
val p : Point2D by lazy {
    println("Criando ponto na origem")
    Point2D(0, 0)
}

// solucao dada pelo compilador
inline operator fun <reified T> Lazy<T>.setValue(nothing: Nothing?, property: KProperty<*>, value: T) {
    println("valor de ${property.name}=$value")
}
var q : Point2D by lazy { Point2D(0, 0) }

fun sampleExtFunSetValue() {
    q = Point2D(15, 15)
    //
    println(q)
}

fun testPrintValP() {
    println(p)
    // Primeira execucao do metodo get() a expressao lambda eh executada e o resultado dela
    // eh memorizado, as demais execucoes somente obtemos o resultado da expressao
    println(p)
}

fun main() {
    //
    sampleExtFunSetValue()
    testPrintValP()
}