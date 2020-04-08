package hof

fun String.capitalize() = this.substring(0, 1).toUpperCase() + this.substring(1)

fun <T> Collection<T>.combine(initial: String = "", separator: String = ""
                              , op: (String, String, String, T) -> String) : String {
    return this.fold(initial) {
        acc: String, data: T ->
            op(initial, separator, acc, data)
    }
}

fun combineExt() {
    val string = listOf("christoffer", "lucas", "fernandes", "santos")
    var first = true
    val rs = string.combine ("", "*") {
        ini, sep, acc, data ->
        val comb = "${if (first) ini else sep}${data.capitalize()}"
        first = false
        acc + comb
    }
    println(rs)
}

fun test1() {
    val string = listOf("christoffer", "lucas", "fernandes", "santos")
    var first = true
    val combined = string.fold("") {
        acc: String, s : String ->
        val comb = "${if (first) "" else " "}${s.capitalize()}"
        first = false
        acc + comb
    }
    println(combined)
}

fun main(args: Array<String>) {
    combineExt()
}