package basics.sintax.range


/**
 * https://kotlinlang.org/docs/reference/extensions.html
 *
 *
 * https://kotlinlang.org/docs/reference/inline-functions.html
 *
 * Reified type parameters
 * https://kotlinlang.org/docs/reference/inline-functions.html#reified-type-parameters
 * */

inline fun <reified T> rangeToArray(range: Iterable<T>): Array<T> = range.toList().toTypedArray()


fun main(args: Array<String>) {
    println(rangeToArray((0..100)))
}