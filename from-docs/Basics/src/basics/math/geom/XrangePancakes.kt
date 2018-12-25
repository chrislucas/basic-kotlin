
/**
 * https://www.hackerrank.com/challenges/xrange-and-pizza/problem
 * */

fun angle(n: Int) = 360 / (2*n)

fun rotator(k: Int) = (360*k) / 2


fun execute(n: Int, m: Int) {
    val size = if (n and 1 == 1) n else (2 * n)

    val rotates =  Array<Int>(size) { 0 }
    val flips =  Array<Int>(size) { 0 }

    for ( i in 0 until m) {
        val values = readLine()?.split(" ")?.map { it.toInt() }?.toTypedArray()
        val type = values?.get(0) ?: 0
        val k = values?.get(1) ?: 0

        if (i == 1)
            rotates[k] += 1
        else
            flips[k] += 1
    }
}

fun main(args: Array<String>) {

}