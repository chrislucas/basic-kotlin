
/**
 * Programacao Dinamica e o classico problema das moedas
 *
 * https://www.youtube.com/watch?v=Ti780_7y6T4
 * https://www.geeksforgeeks.org/understanding-the-coin-change-problem-with-dynamic-programming/
 * http://www.algorithmist.com/index.php/Coin_Change
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 * */

inline fun <reified T> array2D(i: Int, j: Int, noinline op: (Int) -> T): Array<Array<T>> = Array(i) { Array(j, op) }

val setOfCoins = arrayOf(
        arrayOf(1,2,3)
        , arrayOf(1,2,3)
        , arrayOf(1,2,3)
        , arrayOf(1,2,5)
        , arrayOf(2, 5, 3, 6)
        , arrayOf(1, 2, 5)
        , arrayOf(1,4))

val ks = arrayOf(0, 4, 5, 5, 10, 10, 8)

const val idx = 6

fun memoization(i: Int, k: Int, memo: Array<Array<Int>>, s: Array<Int>): Int {
    return when {
        k < 0 -> 0
        k == 0 -> 1
        i == s.size -> 0
        memo[i][k] > -1 -> memo[i][k]
        else -> {
            // usando a i-esima moeda
            val p = memoization(i, k - s[i], memo, s)
            // passando para a proxima moeda do conjunto s
            val q = memoization(i + 1, k, memo, s)
            memo[i][k] = p + q
            memo[i][k]
        }
    }
}

fun topDown(i: Int, k: Int, s: Array<Int>) : Int {
    return when {
        k < 0 -> 0
        k == 0 -> 1
        i == s.size -> 0
        else -> {
            val p = topDown(i, k - s[i], s)
            val q = topDown(i+1, k, s)
            p+q
        }
    }
}

fun bottomUp1(k: Int, s: Array<Int>): Int {
    val coins = s.size
    /**
     * usando uma tabela para abordagem bottomUp
     * memo[sub-problemas 0..k][modeas do conjunto S]
     * */
    val memo = array2D(k+1, i) { 0 }
    // para k == 0 a resposta sera 1 independete do conjunto de moedas
    // a resposta eh 1 pq nao usamos nenhuma moeda, ou seja conjunto vazio de S
    for (idx in 0 until coins)
        memo[0][idx] = 1

    // v-esima valor de k de 1..k
    for(v in 1 .. k) {
        // c-esima moeda do conjunto S
        for(c in 0 until coins) {
            // verificando se a c-esima moeda cabe na v-esima sub solucao do problema
            val p = if (v - s[c] >= 0) memo[v-s[c]][c] else 0
            // contando a quantidade de moedas sem incluir a c-esima moeda
            val q = if (c > 0) memo[v][c-1] else 0
            memo[v][c] = p + q
        }
    }
    return memo[k][coins-1]
}



fun bottomUp2(k: Int, s: Array<Int>): Int {
    /**
     * array 0..k para contar as formas de combinar
     * s[i] moedas para gerar o valor ways[i]
     * */
    val ways = Array(k+1) {0}
    // oara k == 0 precisamos de 0 moedas - conkunto vazio {}
    ways[0] = 1
    for (c in 0 until s.size) {
        for (v in 1..k) {
            if (s[c] <= v) {
                /**
                 * Usando os subproblemas anteriores conseguemos contar quantas
                 * solucoes temos para o problema atual usando a c-esima moeda
                 */
                ways[v] += ways[v - s[c]]
            }
        }
    }
    return ways[k]
}

fun bottomUp3(k: Int, s: Array<Int>): Int {
    val ways = Array(k+1) {0}
    ways[0] = 1
    for( c in 0 until s.size) {
        for(v in s[c]..k) {
            ways[v] += ways[v - s[c]]
        }
    }
    return ways[k]
}


fun testRec() {
    val m = setOfCoins[idx].size
    /**
     * memo[i-esima moeda][valor de total]
     * */
    val memo = array2D(m, ks[idx]+1) { i -> if (i == 0) 0 else -1 }
    println(memoization(0, ks[idx], memo, setOfCoins[idx]))
}


fun testRec2() {
    val m = setOfCoins[idx].size
    /**
     * memo[i-esima moeda][valor de total]
     * */
    val memo = array2D(m, ks[idx]+1) {
        i -> if (i == 0) 0 else -1
    }
    println(topDown(0, ks[idx], setOfCoins[idx]))
}


fun testBottomUp1() {
    println(bottomUp1(ks[idx], setOfCoins[idx]))
}

fun testBottomUp2() {
    println(bottomUp2(ks[idx], setOfCoins[idx]))
}

fun testBottomUp3() {
    println(bottomUp3(ks[idx], setOfCoins[idx]))
}


fun main(args: Array<String>) {
    testRec()
    testRec2()
    testBottomUp1()
    testBottomUp2()
    testBottomUp3()
}