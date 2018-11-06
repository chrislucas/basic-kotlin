package basics.ds

/**
 * https://kotlinlang.org/docs/reference/basic-types.html#arrays
 * */

fun main(args: Array<String>) {
    val values = Array(5) { i -> i }
    values.forEach { print(String.format(" %d", it))}


    println()

    // 2D array
    val mat = Array(5) { IntArray(5) }
    for (i in 0 until mat.size) {
        mat[i][i] = 1
    }

    for(i in 0 until mat.size) {
        for (j in 0 until mat[i].size)
            print(String.format("%d ", mat[i][j]))
        println()
    }

}

