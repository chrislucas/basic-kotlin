package br.com.sample.tutorials.blockingthread

import kotlinx.coroutines.*
import java.math.BigInteger
import java.util.*

// Blocking threads, suspending coroutines
// https://medium.com/@elizarov/blocking-threads-suspending-coroutines-d33e11bf4761

/**
 *  Suspendeing convention:
 *   "suspending functions do not block the caller thread"
 * */

const val BITS_4096 = 1 shl 12

fun sampleFindProbablePrime() {
    val s = System.currentTimeMillis()
    val p = BigInteger.probablePrime(BITS_4096, Random())
    println("Probable Prime: %d\nTime: %f".format(p, (System.currentTimeMillis() - s) / 1000.0))
}

fun probablePrimeNumber(bitLength: Int): suspend () -> BigInteger {
    return suspend {
        /**
         * "The proper way to turn this function in a suspend function is
         * wrapping it in a withContext function block or in a CoroutineScope instance"
         *
         * "Another convetion used here is the use of Default Dispatcher as a CoroutineContext
         * to execute CPU-Bound code. The Default dispatcher is optimized for it."
         *      - it is backed by a thread pool with many threads as there are CPU cores in the
         *      system.
         *      - The CPU-Bound code can  saturate all physical resources as needed
         * */
        withContext(Dispatchers.Default) {
            BigInteger.probablePrime(bitLength, Random())
        }
    }
}

private fun fn(): Deferred<Pair<BigInteger, Double>> {
    return CoroutineScope(Dispatchers.Default).async {
        val s = System.currentTimeMillis()
        val p = BigInteger.probablePrime(1 shl 12, Random()) // probablePrimeNumber(BITS_4096).invoke() //
        Pair(p, (System.currentTimeMillis() - s) / 1000.0)
    }
}

private fun listen() {
    val result = fn()
    while (true) {
        if (result.isCompleted) {
            runBlocking {
                val (prime, timeInSeconds) = result.await()
                println("Prime: $prime\nTime: $timeInSeconds")
            }
            break
        }
    }
}

fun main() {
    // How can I blocking a Thread ?
    // sampleFindProbablePrime()
    // No exemplo acima o calculo de um possivel primo de n bits consome recursos da CPU
    // Um outro exemplo eh executar um processo de IO, como uma requiscao remota que
    // nos devolve uma resposta. Ambos os casos sao considerados operacoes bloqueantes
    // pois ambas as Threads nao podem fazer mais nada apos chamar esses recursos

    listen()
}