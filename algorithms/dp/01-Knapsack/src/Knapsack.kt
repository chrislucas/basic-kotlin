/**
 * https://www.youtube.com/watch?v=Ti780_7y6T4
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 *
 * */


open class Item(val w: Int, val v: Int) {

    override fun toString(): String {
        return String.format("[w: %d, v: %d]", w, v)
    }
}

val data = arrayOf(
    arrayOf(Item(10, 60), Item(20, 100), Item(30, 120))
    , arrayOf(Item(10, 60), Item(20, 100), Item(30, 120), Item(30, 121))
    , arrayOf(Item(1, 60), Item(1, 100), Item(1, 120), Item(1, 121))
)



fun topDown(i: Int, w: Int, items: Array<Item>) : Int {
    return if (w == 0 || i == items.size)
        0
    else if (items[i].w > w)
        topDown(i+1, w, items)
    else {
        val a = items[i].v + topDown(i+1, w - items[i].w, items)
        val b = topDown(i+1, w, items)
        if (a > b) a else b
    }
}

fun testTopDownSolution() {
    println(topDown(0, 50, data[0]))
    println(topDown(0, 50, data[1]))
    println(topDown(0, 1, data[2]))
}

fun memoization(i: Int, w: Int, memo: Array<Array<Int>>, items: Array<Item>): Int {
    return if (w == 0 || i == items.size)
        0
    else if (items[i].w > w)
        memoization(i+1, w, memo, items)
    else if(memo[i][w] > -1)
        memo[i][w]
    else {
        val a = items[i].v + memoization(i+1, w - items[i].w, memo, items)
        val b = memoization(i+1, w, memo, items)
        memo[i][w] = if (a > b) a else b
        memo[i][w]
    }
}

fun bottomUp(w: Int, items: Array<Item>): Int {
    val n = items.size
    val memo = Array(n+1) { it -> Array(w+1) {0}}

    for(qi in 0 .. n) {
        for (wi in 0 .. w) {
            // caso base se
            if(qi == 0 || wi == 0)
                memo[qi][wi] = 0

            // o i-esimmo item da lista tem o peso menor que a capacidade da mochila
            else if(items[qi-1].w <= wi ) {
                // valor ao adicionar o i-esimo item
                val p = items[qi-1].v + memo[qi-1][wi - items[qi-1].w]
                // valor sem adicionar o i-esimo item
                val q = memo[qi-1][wi]
                // maximo (adicionando i, nao adicionando i)
                memo[qi][wi] = if(p > q) p else q
            }
            else {
                // se nao tiver o resultado do i-esimo item e o mesmo
                // do item anterior pois ele nao foi adicionado
                memo[qi][wi] = memo[qi-1][wi]
            }
        }
    }

    return memo[n][w]
}


fun testMemoizationSolution() {
    val items = data[0]
    val w = 50
    val memo = Array(items.size) { it -> Array(w+1) {-1}}
    println(memoization(0, w, memo, items))
}

fun testBottomUp() {
    println(bottomUp(50, data[0]))
    println(bottomUp(50, data[1]))
}


fun main(args: Array<String>) {
    testTopDownSolution()
    testMemoizationSolution()
}