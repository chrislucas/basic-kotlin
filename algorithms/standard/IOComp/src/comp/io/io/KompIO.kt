package comp.io.io


/**
 * https://kotlinlang.org/docs/reference/null-safety.html
 * https://medium.com/@igorwojda/kotlin-combating-non-null-assertions-5282d7b97205
 * https://medium.com/@agrawalsuneet/safe-calls-vs-null-checks-in-kotlin-f7c56623ab30
 * */
fun readInt(): Int {
    return read().toInt()
}

fun read(): String {
    return readLine()!!;
}

fun readValues(del: String): List<String> {
    return read().split(del)
}

fun readInts(del: String): List<Int> {
    return readValues(del).mapTo(arrayListOf()) { it.toInt() }
}

fun main(args: Array<String>) {
    val p = readInt()
    println(p)
    val  ps = readInts(" ")
    for ( (idx, _val) in ps.withIndex()) {
        println("$idx, $_val")
    }
}