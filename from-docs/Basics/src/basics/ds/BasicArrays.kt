package basics.ds

/**
 * https://kotlinlang.org/docs/reference/basic-types.html#arrays
 * */


fun testArray2D() {
    // 2D array
    val mat = Array(5) { IntArray(5) }
    for (i in 0 until mat.size)
        mat[i][i] = 1

    for(i in 0 until mat.size) {
        for (j in 0 until mat[i].size)
            print(String.format("%d ", mat[i][j]))
        println()
    }
}

fun testCreateArray() {
    val values = Array(5) { i -> i }
    values.forEach { print(String.format(" %d", it))}
}

fun testTypedArrayFromRange() {
    (1..100).toList().toTypedArray().forEach { print(" $it") }
}


fun main(args: Array<String>) {
    testTypedArrayFromRange()
}

