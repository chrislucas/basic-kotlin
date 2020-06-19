package algoriothms


import kotlin.math.roundToLong
import kotlin.math.sqrt

/**
 * Totient Function
 * https://en.wikipedia.org/wiki/Euler%27s_totient_function
 * https://cp-algorithms.com/algebra/phi-function.html
 *
 * Funcao Totient ou phi function conta quantos numeros entre [1 e n] sao coprimos com n
 *
 * 2 numeros a e b sao coprimos se MDC/GDC(a, b) == 1
 * Tabela de frequencia na funcao totient
 *
 * n - phi(n)
 * (1 - 1); (2 - 1); 3 - 2; 4 - 2; 5 - 4; 6 - 2; 7 - 6; 8 - 4; 9 - 6; 10 - 4; 11 - 10
 * 12 - 4; 13 - 12 ...
 * Propriedades
 *
 * 1) se p eh primo entao gdc(p. q) = 1 para todo 1 <= q < p
 * assim phi(p) = p - 1
 *
 * 2) se p eh primo e k >= 1 entao existem p^k / p ou p^k - p^(k-1) numeros entre
 * 1 e p^k diviveis por p
 *
 * p^k - p^(k-1) = p^k * (1 - 1/p)
 *
 * 3) Se a e b sao coprimos entao
 * phi(ab) = phi(a) * phi(b)
 *
 * Usando as 3 propriedades acima
 *
 * Outras propriedade
 *
 * 1) Para a e b nao coprimos temos a seguinte equacao
 *
 * phi(ab) = phi(a) * phi(b) * (gdc(a, b) / phi(gdc(a, b))
 *
 * ou  gdc(a, b) = d
 *
 * substituir por d na equacao
 *
 * 2) se p eh primo os unicos n~umeros que satisfazem a igualdade gdc(p^k, m) == 1 sao
 * 1, p, p^2, p^3 ... p^k (1 e qualquer potencia de p <= p^k)
 *
 *
 * */

/**
 * https://en.wikipedia.org/wiki/Euler%27s_totient_function
 * Teorema fundamental da aritmetica
 *
 * Na teoria dos numeros, o Teorema fundamental da aritmetica alega que todo inteiro maior que 1
 * ou eh um numero primo ou pode ser representado como o produto de numeros primos e que alem disso
 * essa representação eh unica para cada número
 *
 * Podemos representar um numero N > 1 atraves da multiplicacao de uma seq de numeros primos
 * O interessante dessa propriedade eh que para cada N temos uma seq distinta de numeros primos
 *
 * N = 36 = 2^2 * 3^2
 * N = 72 = 2^3 * 3^2
 * so on
 * n = p1 ^ k1 * p2 ^k2 ... pn ^ kn
 * Podemos computar a funcao phi de euler atraves da formula do produto de Euler
 *
 * https://en.wikipedia.org/wiki/Arithmetic_function#Notation
 * phi(n) = n * produtorio p|n (1 - 1/p)
 * onde p sao os primos que compoem n
 *
 * https://en.wikipedia.org/wiki/Euler%27s_totient_function
 * A demonstracao da formula do produto de Euler depende esta atrelada ao Teorema fundamental
 * da matematica, onde podemos representar um numero N qualquer como produtorio de numeros primos P.
 *
 * A prova de formula do produto de Euler depende de 2 fatores

 * 1) A funcao phi de euler eh multiplicativa
 *      Se gcd(a, b) = 1 entao phi(ab) = phi(a) * phi(b)
 * 2) Um numero primo elevado a um numero inteiro maior ou igual a 1 como argumento da funcao phi = phi(P^K)
 *      Seja P um numero primo e K um inteiro >= 1 entao
 *      phi(P^k) = p ^ (k-1) * (p-1)
 *      = p^k * (1-(1/p))
 * A prova desse segundo fator esta em que gcd(p^k, m) = 1 ou seja m sendo coprimo de p^k
 * os possiveis valores de m sao [1, p, p^2 ... p^k]
 *
 *
 * */

fun phi(n: Long) : Long {
    var cN = n
    var result = n
    var i = 2
    while(i*i <= cN) {
        if (cN % i == 0L) {
            // fatorando por i-esimo divivel por n
            while (cN % i == 0L) {
                cN/=i
            }
            result -= (result / i)
        }
        i++
    }
    if (cN>1)
        result -= (result/cN)
    return result
}

fun testPHIFunctionWithNumbers() {
    (100 .. 1000L).forEach {
        println(String.format("%d %d", it, phi(it)))
    }
}

fun testPHIFunctionWithPrimeNumbers() {
    var counter = 0
    (2 .. 1000L).forEach {
        i ->
        // a ideia aqui eh testar a propriedade 1)
        if (isPrimeNumber(i)) {
            println(String.format("%d -> %d:%d", ++counter, i, phi(i)))
        }
    }
}

private fun isPrimeNumber(i: Long) : Boolean {
    val limit = sqrt(i * 1.0).toLong()
    var isPrime = true
    for (p in 2 .. limit) {
        if (i % p == 0L) {
            isPrime = false
            break
        }
    }
    return isPrime
}

fun main() {
    testPHIFunctionWithPrimeNumbers()
    println()
    testPHIFunctionWithNumbers()
}