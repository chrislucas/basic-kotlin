
/**
 * https://kotlinlang.org/docs/reference/sealed-classes.html
 * https://discuss.kotlinlang.org/t/sealed-class-inheritance-and-constructors/2283/5
 *
 * A sealed class is abstract, it cannot be instantiated directly
 * Sealead classes are not allowed to have  non private constructor (Seus construtores sao private por padrão)
 *
 * */
sealed class Point3D {

    abstract val x: Double
    abstract val y: Double
    abstract val z: Double

    override fun toString(): String = "$x, $y, $z"

    class Point4D(override val x: Double
                  , override val y: Double
                  , override val z: Double, private val t: Double) : Point3D() {

        override fun toString() = "$x, $y, $z, $t"
    }
}