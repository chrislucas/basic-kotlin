package basics.ds.collections

/**
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html
 * */


fun testMutableMap() {
    // Mutable Map
    val lhm = LinkedHashMap<Char, Int>()
    val text = "Returns a list containing all elements of the original collection and then all elements of the given "
    for (c in text) {
        if (lhm[c] != null)
            lhm[c] = lhm[c]!!.plus(1)
        else
            lhm[c] = 1
    }

    println(lhm)
    val iterator = lhm.iterator()

    while (iterator.hasNext()) {
        val entry = iterator.next()
        println("${entry.key}, ${entry.value}")
    }
}


fun testFnHashMap() {
    val mMap = hashMapOf<Char, Int>()
    mMap.let {
        val text = "Returns a list containing all elements of the original collection and then all elements of the given "
        val lhm = it
        for (c in text) {
            if (lhm[c] != null)
                lhm[c] = lhm[c]!!.plus(1)
            else
                lhm[c] = 1
        }
    }
    println(mMap)
}


fun testMutableList() {
    val mutableList = MutableList(5) { it -> MutableList(5) { 0 } }

    mutableList[0].add(1)
    mutableList[0].add(2)
    mutableList[0].add(3)
    mutableList[1].add(4)
    mutableList[1].add(5)

    println(mutableList)
}

fun immutableList() {
    val imutableList = List(5) { i -> i }
    println(imutableList)
}


fun main(args: Array<String>) {
    testFnHashMap()
}