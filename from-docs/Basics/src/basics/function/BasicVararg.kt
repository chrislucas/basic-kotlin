package basics.function


fun testVarargs(vararg strings: String) {
    println(strings.toList())
}

fun testVarargs() {
    val v = arrayOf("3", "4", "5")
    // spread operator
    testVarargs("1", "2", *v)
}

fun main(args: Array<String>) {

}