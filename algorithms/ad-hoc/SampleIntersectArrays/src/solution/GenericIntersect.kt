package solution

abstract class Element<K, V>(val key: K, val value: V) : Comparable<Element<K, V>>
object GenericIntersect {
    @JvmStatic
    fun <K, V : Comparable<V>> intersect(arrA: MutableList<Element<K, V>>, arrB: MutableList<Element<K, V>>
                                         , op: (a: Element<K, V>, b: Element<K, V>) -> Unit) {

        val grouping = mutableMapOf<K, IndexArray>()

        /**
         * armazena os elementos do Array A em um mapa<Elemento, Indices[0, 1, n ...]>
         * cuja a chave e eh uma chave decidida por um elemento e o valor
         * */
        arrA.forEachIndexed { index, e ->
            val k = e.key
            grouping[k]?.safeLet {
                it.add(index)
            }.orElse {
                grouping[k] = mutableListOf(index)
            }
        }

        arrB.forEach { elementB ->
            val idxArrayA = grouping[elementB.key]
            if (idxArrayA != null) {
                val elementA = arrA[idxArrayA[0]]
                if (elementA.compareTo(elementB) == 0) {
                    op(elementA, elementB)
                    idxArrayA.removeAt(0)
                }
            }
        }
    }
}

