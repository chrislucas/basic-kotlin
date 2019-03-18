/**
 * https://kotlinlang.org/docs/reference/lambdas.html#function-literals-with-receiver
 * https://kotlinlang.org/docs/reference/lambdas.html#function-types
 * */


class Point3D(var x: Double, var y: Double, var z: Double) {
    override fun toString(): String {
        return "$x, $y,¨$z"
    }
}

// fun literal with receiver
val sum : Point3D.(Point3D) -> Point3D = { q ->  Point3D(x + q.x, y + q.y, z + q.z) }

// anonymous function with receiver
val aSum = fun Point3D.(q : Point3D) : Point3D = Point3D(x + q.x, y + q.y, z + q.z)

//
val applyOpInPoint3D : Point3D.(op: (Point3D) -> Unit) -> Point3D = {
    p -> p(this)
    this
}

// extension funcion
fun Int.isOdd() : Boolean = this and 1 == 1

// uma funcao que recebe uma funcao como argumento
fun <R> applyOp(p : () -> R)  : R = p()

// Function literals with receiverType
// uma copia mal feita da funcao run. Recebe uma Function literals with receiver como argumento

/**
 * Function literals with receiver tem a seguinte caracteristica
 * A.(B) -> C - onde A, B e C sao tipos definidos (Da linguagem ou pelo programador)
 * */
fun <O, R> O.applyOpWithReceiver(p : O.() -> R)  : R = p()

fun testAnonymoysFun() {

    /**
     * https://kotlinlang.org/docs/reference/lambdas.html#invoking-a-function-type-instance
     * Kotlin fornece um modo de executar uma instancia de uma 'fun literal with receiver'
     * */
    println("Sum invoke ${sum.invoke(Point3D(1.0,2.0,3.5), Point3D(-1.0,2.3,3.5))}")

    val o = Point3D(1.0,2.0,3.5)
    applyOpInPoint3D.invoke(o) {
        it ->
        it.x += 10
        it.y += 10
        it.z += 10

    }

    println("Apply op invoke in 'o': $o")


    println(Point3D(1.0,2.3,3.5).sum(Point3D(1.0,2.3,3.5)))
    println(Point3D(1.0,2.3,3.5).aSum(Point3D(1.0,2.3,3.5)))
}

fun main(args: Array<String>) {
    testAnonymoysFun()

    // teste de extension function
    println(    applyOp { 10.isOdd() } )

    // Usando uma funcao que possui um receiver
    println(10.applyOpWithReceiver { this.isOdd() } )



}