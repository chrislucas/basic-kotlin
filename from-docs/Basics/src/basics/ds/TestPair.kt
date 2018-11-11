package basics.ds


/**
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html
 * https://dzone.com/articles/kotlin-the-tuple-type
 * */

fun main(args: Array<String>) {
    //
    val p1 = 10 to 'c'
    val (a, b) = p1
    println("$a, $b, $p1")


    val p2 = Pair(10, 20)
    println(p2.toList())
}