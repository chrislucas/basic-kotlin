package comp.io.loops


fun test1() {
    for (i in 1 .. 15 step 2) {
        print(i)
    }
    println("")

    /**
     * https://kotlinlang.org/docs/reference/basic-types.html
     * */
    val ints = Array(5) { i -> i};
    for (i in ints) {
        print(i)
    }

    println("")
    val ints2 = intArrayOf(1,2,3,4,5,6)
    for (i in ints2) {
        print(i)
    }
}

fun test2() {
    for (i in 15 downTo 1 step 2) {
        println(i)
    }
}

fun test3() {
    val strings = arrayOf<String>("Teste 1", "Teste 2", "Teste 3", "Teste 4")
    for ( (idx, _val) in strings.withIndex()) {
        println("$idx, $_val")
    }
}

fun main(args: Array<String>) {

    test3()
}