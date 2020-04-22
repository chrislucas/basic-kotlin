package solution


data class Data<T>(val id: Int, var value: T)

fun <T> intersect(cA: Array<Data<T>>, cB: Array<Data<T>>
                  , comp: (a: Data<T>, b: Data<T>) -> Boolean, op: (a: Data<T>, b: Data<T>) -> Unit) {


    val grouping = mutableMapOf<Int, IndexArray>()

    cA.forEachIndexed() { index, element ->
        grouping[element.id]?.let { arrIndex ->
            arrIndex.add(index)
        }.orElse {
            grouping[element.id] = mutableListOf(index)
        }
    }

    cB.forEach { elementInB ->
        // existe um elemento de A
        if (grouping[elementInB.id] != null) {
            grouping[elementInB.id]?.let {
                if (it.size > 0) {
                    val idx = it.get(0)
                    val elementInA = cA[idx]
                    if (comp(elementInA, elementInB)) {
                        op(elementInA, elementInB)
                        it.removeAt(0)
                    }
                }
            }
        }
    }
}


fun testSample1() {
    val l1 = arrayOf(Data(1, "a")
            , Data(2, "b")
            , Data(3, "c")
            , Data(4, "e")
    )

    val l2 = arrayOf(Data(1, "a2")
            , Data(1, "a3")
            , Data(2, "b2")
            , Data(2, "b3")
            , Data(3, "c2")
            , Data(4, "e2")
    )

    val comp :  (Data<String>, Data<String>) -> Boolean = {
        a, b -> a.id == b.id
    }

    val op: (Data<String>, Data<String>) -> Unit = {
        a, b -> a.value = "old:${a.value}|new:${b.value}"
    }

    intersect(l1, l2, comp, op)

    l1.forEach { println(it) }
}


fun main() {
    testSample1()
}