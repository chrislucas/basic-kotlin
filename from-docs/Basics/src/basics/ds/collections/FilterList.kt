package basics.ds.collections

/**
 *
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/filter.html
 * */

fun main(args: Array<String>) {
    var data = listOf<String>("123", "teste", "abc", "christoffus")
            .filter {
        it.matches("\\d+".toRegex())
    }
    println(data);
}