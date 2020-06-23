package source

/**
 * https://cp-algorithms.com/algebra/sieve-of-eratosthenes.html#:~:text=Sieve%20of%20Eratosthenes%20is%20an,numbers%20between%202%20and%20n.&text=A%20proper%20multiple%20of%20a,x%20and%20divisible%20by%20x.
 * https://www.geeksforgeeks.org/sieve-of-eratosthenes/
 * https://introcs.cs.princeton.edu/java/14array/PrimeSieve.java.html
 * */

class EratosthenesSieve(n: Int) {
    private val  validate: MutableList<Boolean> = MutableList(n+1) {true}
    val primes = mutableListOf<Int>()
    init {
        validate[0] = false
        validate[1] = false
        var i = 2
        while (i*i <= n) {
            if (validate[i]) {
                var j = i*i
                while (j<=n) {
                    validate[j] = false
                    j+=i
                }
            }
            i++
        }

        (0 .. n).forEach {
            if (validate[it]) { primes.add(it) }
        }
    }
}

/**
 *  *                  n     Primes <= n
 *  ---------------------------------
 *                 10               4
 *                100              25
 *              1,000             168
 *             10,000           1,229
 *            100,000           9,592
 *          1,000,000          78,498
 *         10,000,000         664,579
 *        100,000,000       5,761,455
 *      1,000,000,000      50,847,534
 * */

fun test() {
    var i = 10
    while (i <= 1000000000) {
        val sieve = EratosthenesSieve(i)
        println("I: $i - Q: ${sieve.primes.size}")
        i *= 10
    }
}

fun main() {
    test()
}