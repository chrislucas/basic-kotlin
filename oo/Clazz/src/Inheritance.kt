
/**
 * https://kotlinlang.org/docs/reference/classes.html#inheritance
 * */

abstract class Vehicle(val p: Int) {
    init { println("Vehicle") }
    override fun toString(): String {
        return "Vehicle $p"
    }
}

class Car(p: Int) : Vehicle(p) {
    init { println("Car") }
    override fun toString(): String {
        return "Car $p"
    }
}

open class Point2F(val x: Double, val y: Double)

open class Point3F(x: Double, y: Double, var z: Double) : Point2F(x, y) {
    override fun toString(): String {
        return "P($x, $y, $z)"
    }
}

class Point4F :  Point3F {
    private var t: Double

    constructor(x: Double, y: Double, z: Double, t: Double) : super(x, y, z) {
        this.z = z
        this.t = t
    }

    override fun toString(): String {
        return "P($x, $y, $z, $t)"
    }
}

fun main(args: Array<String>) {
    println(Car(10))
    println(Point3F(0.0, -1.0, 2.5))
    println(Point4F(1.25, -1.0, 2.5, 3254.0))
}