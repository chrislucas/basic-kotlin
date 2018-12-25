package chp1


fun testRangeChar() {
    val aToZ = "a".."z"
    println("C in 'a' to 'z': ${"c" in aToZ}")
    println(listOf(aToZ))
}

fun testReverseRangeChar() {
    val zToP  = "z".rangeTo("p")
    println("n between 'z' and 'p': ${"n" in zToP} ")
    println("q between 'z' and 'p': ${"q" in zToP} ")
    println("z between 'z' and 'p': ${"z" in zToP} ")
}


fun testRangeInt() {

}

fun main(args: Array<String>) {







}