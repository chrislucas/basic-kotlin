

data class Point2D(val x: Int, val  y: Int)

data class Point3D(val x: Double, val  y: Double, val z: Double)

data class Point4D(val p: Point3D, val time: Double)


fun sampleCustomClass() {
    val (x, y) = Point2D(2, 3)
    println("$x, $y")

    val(p, time) = Point4D(Point3D(1.0, .34, 3.14)
        , Double.MAX_VALUE)

    println("$p, $time")

    // como ignorar um atributo usando destructuring
    val(x1, _, z1) = Point3D(1.0, 2.0, 3.0)
    println("$x1, $z1")

    val points3D = arrayOf(Point3D(1.3, 23.23, 312.22))
    for ( (x, y, z) in points3D) {
        // interessante observar o resultado em bytecode nas 2 formas de print
        println("$x, $y, $z")
        println(String.format("%f, %f, %f", x, y, z))
    }
}

fun sampleWithPair() {
    val (p, q) = 123 to 33
    println("$p, $q")
}

fun main() {
    sampleWithPair()
}