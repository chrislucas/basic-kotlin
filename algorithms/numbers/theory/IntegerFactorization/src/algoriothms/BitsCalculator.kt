package algoriothms

import kotlin.math.log10
import kotlin.math.log2
import kotlin.math.roundToLong
import kotlin.math.sqrt

/**
 * https://courses.lumenlearning.com/waymakercollegealgebra/chapter/logarithm-rules/
 * https://www.rapidtables.com/calc/math/Log_Calculator.html
 *
 * Propriedades interessantes
 * Recordar e viver
 *
 * log a ^ x base b  = x * log a base b
 *
 * Troca de bases
 *
 * Caso tenhamos log a base b e quisermos trocar para c devemos fazer o seguinte
 *
 * log a base c / log b base c
 *
 * Exemplo
 *
 * log 1024 base 40 eh mais dificil de calcular que log 1024 base 2
 *
 * entao calculamos
 *
 * log 1024 base 2 / log 40 base 2
 *
 * */

/**
 * Essa funcao me diz quantos digitos um numero decimal de 'b' bits possui
 *
 * (converer em bytes) *
 *
 * */
fun qDecDigits(bits: Long)  = (bits * log10(2.0)).roundToLong()

// essa funcao diz quantos bits um numero possui
fun qBitsDecNumber(number: Long) =  if(number > 0) log2(number * 1.0).toLong() + 1 else 1

fun testQQDigits() {
    (0L .. (1 shl 12)).forEach {
        val bits = qBitsDecNumber(it)
        println("Decimal $it = Q Bits: $bits = Q Dec-Digits: ${qDecDigits(bits)}~ " +
                "if Q bits = $it -> digits = ${qDecDigits(it)}~")
    }
}

/** *
 *                  n     Primes <= n
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
 *
 * */

fun isPrime(n: Long) : Boolean {
    return if (n < 2) {
         false
    }
    else {
        val limit = sqrt(n * 1.0).roundToLong()
        for( i in 2 .. limit) {
            if (n % i == 0L) {
                return false
            }
        }
        return true
    }
}

fun testIsPrime() {
    var c = 0
    (0 .. 10000000L).forEach {
        if (isPrime(it))
            c++
    }
    println(c)
}

fun naivePrimeFactorization() {
    val factors = mutableMapOf<Long, Long>()
    var c = 88L
    val cc = c
    var p = 2L
    while (c > 1) {
        if (c % p == 0L) {
            factors[p] = factors[p]?.plus(1) ?: 1L
            c /= p
        }
        else {
            p++
            while (!isPrime(p))
                p++
        }
    }
    val bits = qBitsDecNumber(cc)
    println("$cc possui ${if(bits > 1) "$bits bits" else "$bits bit"}~")
    println(factors)
}

fun main() {
    naivePrimeFactorization()
}