package basics.sintax


/**
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html
 * */

fun testIterableInt() {
    val it: Iterable<Int> = 10..125

    val itIndexed = it.withIndex()

    val action = {
        i: IndexedValue<Int> -> "${i.index}, ${i.value}"
    }

    itIndexed.forEach { action(it) }

}

fun main(args: Array<String>) {



}