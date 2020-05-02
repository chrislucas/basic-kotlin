package solution.tests

import solution.Element
import solution.GenericIntersect


data class Sample(val id: Int, var description: String) : Element<Int, String>(id, "id:$id, description:$description") {
    override fun compareTo(other: Element<Int, String>) = this.key - other.key
}

fun main() {
    val sA = mutableListOf<Element<Int, String>>(
            Sample(1, "1_sA")
            , Sample(2, "2_sA")
            , Sample(2, "22_sA")
            , Sample(3, "3_sA")
            , Sample(4, "4_sA")
    )
    val sB = mutableListOf<Element<Int, String>>(
            Sample(1, "1_sB")
            , Sample(2, "b_sB")
            , Sample(4, "c_sB")
    )

    val op: (Element<Int, String>, Element<Int, String>) -> Unit = { a, b ->
        (a as Sample).description = "old:${a.description}|new:${(b as Sample).description}"
    }

    GenericIntersect.intersect(sA, sB, op)

    sA.forEach {
        println(it)
    }
}