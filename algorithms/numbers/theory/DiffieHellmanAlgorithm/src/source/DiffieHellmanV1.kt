package source

import kotlin.random.Random

/**
 * https://www.geeksforgeeks.org/implementation-diffie-hellman-algorithm/
 * https://www.freecodecamp.org/news/diffie-hellman-key-exchange/?utm_source=Morning+Cup+of+Coding&utm_campaign=9b37430ab0-EMAIL_CAMPAIGN_2020_05_20_01_45&utm_medium=email&utm_term=0_56b5f64c5f-9b37430ab0-63218701&fbclid=IwAR1S9osOCsTkJfaCSLOOOBmoQSvO9DvFJba2GMXdJZfWXZvGipBEWkKIcCU
 *
 * Calculadoras exp modular
 * https://www.boxentriq.com/code-breaking/modular-exponentiation
 * https://www.dcode.fr/modular-exponentiation
 *
 * Artigos sobre o algoritmo,usos e limitacoes
 * https://www.geeksforgeeks.org/applications-and-limitations-of-diffie-hellman-algorithm/
 *
 * */
object DiffieHellmanV1 {

    private const val LIMIT = 1000000
    private val  validate: MutableList<Boolean> = MutableList(LIMIT+1) {true}
    val primes = mutableListOf<Int>()
    init {
        validate[0] = false
        validate[1] = false
        var i = 2
        while (i*i <= LIMIT) {
            if (validate[i]) {
                var j = i
                while (j*i <= LIMIT) {
                    validate[j*i] = false
                    j++
                }
            }
            i++
        }
        (0 .. LIMIT).forEach {
            if (validate[it]) { primes.add(it) }
        }
    }

    @JvmStatic
    private fun multiplication(a: Long, b: Long, m: Int) = ((a%m)*(b%m))%m

    @JvmStatic
    fun exp(base: Long, e: Long, m: Int) : Long {
        var acc = 1L
        var copyE = e
        var copyBase = base
        while(copyE > 0) {
            if (copyE and 1L == 1L)
                acc = multiplication(acc, copyBase, m)
            copyBase = multiplication(copyBase, copyBase, m)
            copyE = copyE shr 1
        }
        return acc
    }

    @JvmStatic
    private fun generateRandomPrime() : Int = primes[Random.nextInt(0, primes.size - 1)]

    @JvmStatic
    private fun randomNumber(seed: Long) : Long = Random.nextLong(seed)

    /**
     * O algoritmo:
     *
     * 1) Escolha um numerp 'p' primo GRANDE
     * 2) Escolha um numero randomicamente menor que p, denominaremos ele de 'base'
     * 3) Randomicamente escolha 2 numerois 'a' e 'b'
     *
     * Realize o seguinte calculo
     *
     * A = base ^ a mod p
     * B = base ^ b mod p
     *
     * */
    fun solver() {
        val p = generateRandomPrime()
        val base = randomNumber((p-1) * 1L)
        val a = randomNumber(System.currentTimeMillis() shr  4)
        val encryptA = exp(base, a, p)
        println("Valores do emissor: $p ^ $a mod $base = $encryptA")

        val b =  randomNumber(System.currentTimeMillis() shr  8)
        val encryptB = exp(base, b, p)
        println("Valores do emissor: $p ^ $b mod $base = $encryptB")

        /**
         * os resultados encryptA e encryptB sao trocados entre os participantes e o calculo
         * de exponenciacao modular eh refeito
         * eA = g ^ a mod p; eB = g ^ b mod p
         * dA = eB ^ a mod p
         * dB = eA ^ b mod p
         *
         * dA = (g ^ b mod p) ^ a mod p = g ^ (ba) mod p
         * dB = (g ^ a mod p) ^ b mod p = g ^ (ab) mod p
         * dA == dB
         *
         * */
        // aqui o lado A recebe o calculo do lado B e executa a operacao
        val decryptA = exp(encryptB, a, p)
        // aqui o lado B recebe o calculo do lado A e executa a operacao
        val decryptB = exp(encryptA, b, p)
        // A nao conhece o valor de b e vice versa

        /**
         * Para esclarecer: p, g sao publicos, g^a%p e g^b%p sao trocados
         * porem a e b sao numeros conhecidos somente pelas partes que trocam mensagem
         * */
        println("$decryptA => $encryptB, $decryptB => $encryptA")
    }
}

fun question() {
    /*
    * Agora uma pergunta interessante
    *  p e base sao publicos (conhecidos pelos participantes da troca de mensagem), o recepetor
    * recebe o resultado de  eA = base ^ a mod p
    * Sabendo eA, base e p, quais sao os possiveis valores de 'a que satisfazem essa equacao ?
    *
    * Exemplo simples
    * p = 23, base = 5, a = 4
    * base ^ a mod p = 4
    * QUantos valores de 'a' chegam ao mesmo resultado
    * */

    val (p, base) = 23 to 5L
    val a = 4L
    val eA = DiffieHellmanV1.exp(base, a , p)
    println( "p = 23, g|base = 5, a = $a = $eA\n")

    /**
     * Vamos fazer a seguinte racicinio
     * Sabemos eA, p e g e queremos saber quais sao os possiveis valores
     * de 'a' que satisfazem a equacao eA = g ^ a mod p
     *
     * De i=0 .. N  se i % p == eA entao i
     * eh um possivel candidato a ser o valor de 'a'
     * */
    val possibleAs = mutableListOf<Long>()
    (0L .. 10000L).forEach {
        if (it % p == eA) {
            possibleAs.add(it)
        }
    }
    println("Qtde de candidatos a 'a': ${possibleAs.size}\n$possibleAs\n")

    val numbers = mutableListOf<Long>()
    (0L .. 10000L).forEach {
        if (DiffieHellmanV1.exp(base, it, p) == eA) {
            numbers.add(it)
        }
    }
    println("Qtde de 'as' que satisfazem a equacao, podendo ser qualquer um:  ${numbers.size}\n$numbers\n")

    val intersect = mutableListOf<Pair<Int, Long>>()
    possibleAs.forEach {
        val idx = numbers.binarySearch(it)
        if (idx > -1) {
            intersect.add(idx to it)
        }
    }
    println("Interseccao entre canditatos e possiveis 'as': ${intersect.size}\n$intersect")

}


fun main() {
    question()
}