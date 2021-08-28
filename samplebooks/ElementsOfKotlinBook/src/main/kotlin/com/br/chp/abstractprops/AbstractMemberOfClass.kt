package com.br.chp.abstractprops

import java.lang.IllegalArgumentException
import kotlin.math.abs

/**
 *
 * "An abstract function declares a function signature that subclasses must implement.
 * Similarly, an abstract property declares one or two function signatures tha subclasses
 * must implement
 * */


data class Point2D(val x: Double, val y: Double)

abstract class Obj2D<T> {
    // a val declares a getter
    abstract val area: Double

    // a var declares a getter and a setter
    abstract var position: List<Point2D>

    abstract val type: T?

    open fun calculateArea(): Double {
        // https://www.mathopenref.com/coordpolygonareacalc.html
        // https://www.mathopenref.com/coordpolygonarea.html
        var valueArea = 0.0
        val sz = position.size
        for (i in 0 until sz - 1) {
            val p = position[i]
            val q = position[i + 1]
            valueArea += (p.x * q.y - p.y * q.x) / 2.0
        }
        valueArea += (position[sz - 1].x * position[0].y - position[sz - 1].y * position[0].x) / 2.0
        return abs(valueArea)
    }
}

sealed class TriangleType {
    object Isosceles : TriangleType()
    object Scalene : TriangleType()
    object Equilateral : TriangleType()
}

class Triangle : Obj2D<TriangleType>() {

    private var mArea: Double = 0.0

    override val area: Double
        /**
         * Toda vez que esse atributo for acessado, o metodo get sera executado,
         * assim nao compensa colocar o algoritmo para calcular a area aqui, eh
         * melhor por questao de desempenho calcular a area somente quando a posicao
         * mudar
         * */
        get() = mArea

    override var position: List<Point2D> = emptyList()
        set(value) {
            if (value.size == 3) {
                field = value
                mArea = calculateArea()
            } else {
                throw IllegalArgumentException("Necessário 3 pontos para formar um triangulo")
            }
        }

    override val type: TriangleType?
        get() {
            return TriangleType.Equilateral
        }
}

private fun sample() {
    val triangleA = Triangle()
    println(triangleA.area)
    triangleA.position = listOf(Point2D(2.0, 4.0), Point2D(0.0, 1.2), Point2D(2.3, 4.5))
    println(triangleA.area)
    println(triangleA.area)
}

fun main() {
    sample()
}