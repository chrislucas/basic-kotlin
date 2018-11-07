
fun nCr(n: Long, p: Long): Long {
    val p = if (n < n-p) p-n else p
    var r = 1L
    /**
     * (n-1) * (n-2) * ... * (n-p+1) / (p-1) * (p-2) * ... * 1
     * */
    for (i in 0 until p) {
        r *= (n-i)
        r /= (i+1)
    }
    return r
}

fun main(args: Array<String>) {
    println(nCr(8,0))
    println(nCr(8,1))
    println(nCr(8,2))
    println(nCr(8,3))
    println(nCr(8,4))
    println(nCr(8,5))
    println(nCr(8,6))
    println(nCr(8,7))
    println(nCr(8,8))
}