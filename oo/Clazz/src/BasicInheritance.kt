/**
 * https://kotlinlang.org/docs/reference/classes.html
 * https://kotlinlang.org/docs/reference/properties.html
 * */

open class View(private val id: Int,  px: Int,   py: Int) {
    init {
        println("Initializer View Class")
    }

    open val maskedId: Int = (id and 0xff).also { println("Masking ID in View: $it") }
    /**
     * var <propertyName>[: <PropertyType>] [= <property_initializer>]
     * [<getter>]
     * [<setter>]
     * */
    private var px = px
    set(value) { field = if (value > -1) value else field }

    private var py = py
    set(value) { field = if (value > -1) value else field }

    fun moveTo(newPx: Int, newPy: Int) {
        px += newPx
        py += newPy
    }

    override fun toString(): String {
        return "$id, P($px, $py)"
    }
}

class TextView(id: Int, px: Int, py: Int) : View(id.also { println("Valor passado para classe Base $it") }, px, py) {
    init {
        println("Initializer TextView Class")
    }
}

fun main(args: Array<String>) {
    val textView = TextView(511, 1, 10)
    println(textView)
    textView.moveTo(15, -11)
    println(textView)

}