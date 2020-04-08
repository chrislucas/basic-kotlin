package models

import create

class Plane {
    val list : MutableList<Point2D> by create {
            ref, property ->
            println("$ref, $property")
            mutableListOf<Point2D>()
    }
}