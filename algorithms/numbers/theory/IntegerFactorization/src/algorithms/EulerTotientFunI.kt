package algorithms


import java.lang.StringBuilder
import kotlin.math.sqrt

/**
 * Calculadora online phi euler
 * https://www.dcode.fr/euler-totient
 *
 *
 * Totient Function
 * https://en.wikipedia.org/wiki/Euler%27s_totient_function
 * https://cp-algorithms.com/algebra/phi-function.html
 * https://www.geeksforgeeks.org/eulers-totient-function/
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
 * 2) se p eh primo os unicos numeros que satisfazem a igualdade gdc(p^k, m) == 1 sao
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
    var p = 2
    while(p*p <= cN) {
        if (cN % p == 0L) {
            /**
             * Fato interessante: Esse condicional so sera verdadeiro para um p primo
             * pq como p eh usado para fatorar cN e assim todos os numeros compostos P^2 ... p^n
             * cujo cN eh divisivel ja foram usados na fatoracao
             * */
            // fatorando cN por p ate que cN e eliminando todos os numeros compostos que dividem cN
            while (cN % p == 0L) {
                cN/=p
            }
            /**
             * n * (1 - (1/p)) -> Produto de Euler
             * n - (n/p) ou (np - n) / p
             *
             * */
            //result -= (result / p)
            result = (result * p - result) / p
        }
        p++
    }
    // caso N (cN eh a copia que foi processada), tiver um fator primo maior que sqrt(n)
    // um caso eh quando N eh primo e o unico numero fator dividivel e ele mesmo
    // outro exemplo eh o numero 513 (3 ^ 3 * 19), 19 um numero primo
    if (cN>1) {
        // euler product - veja comentario no loop acima
        //result -= (result/cN)
        result = (result * cN - result) / cN
    }

    return result
}

fun anotherPHIImpl(n: Long): Long {
    var cN = n
    var p = 2
    var result = n * 1.0
    while (p*p<=cN) {
        if (cN%p==0L) {
            while (cN%p==0L)
                cN/=p
            // euler`s product
            result *= (1.0 - (1.0/(p*1.0)))
        }
        p++
    }
    if (cN>1) {
        result *= (1.0 - (1.0/(cN*1.0)))
    }
    return result.toLong()
}

fun testPHIFunctionWithNumbers() {
    val buffer = StringBuilder()
    (529 .. 2000L).forEach {
        val r1 = phi(it)
        val r2 = anotherPHIImpl(it)
        if (r1 != r2) {
            buffer.append(String.format("phi(%d) = %d and anotherFun(%d) = %d %s\n"
                , it, r1, it, r2, r1 == r2))
        }
    }
    IO.writeFile(buffer.toString(), "raw/output.txt")
}

fun testPHIFunctionWithPrimeNumbers() {
    var counter = 0
    (81 .. 1000L).forEach {
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
    //testPHIFunctionWithPrimeNumbers()
    //println()
    testPHIFunctionWithNumbers()
}