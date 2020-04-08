
class BST<T: Comparable<T>>() {

    var root: Node<*>? = null

    inner class Node<T : Comparable<T>>(
        val value: T
        , var left: Node<T>? = null
        , var right: Node<T>? = null
    ) {
        fun isLeaf() = left == null && right == null
        fun compare(node: Node<T>): Int = this.value.compareTo(node.value)
    }

    fun <T : Comparable<T>> insert(value: T) {
        if(root == null) {
            root = Node(value)
        }
        else {
            insert(root as Node<T>, Node(value))
        }
    }

    fun <T : Comparable<T>> insert(root: Node<T>, child: Node<T>) {
        val cmp = root.compare(child)
        when {
            (cmp > 0) -> {
                when (child.left) {
                    null -> root.left = child
                    else -> root.left?.let { insert(it, child)  }
                }
            }
            (cmp < 0) -> {
                when (child.right) {
                    null -> root.right = child
                    else -> root.right?.let { insert(it, child)  }
                }
            }
        }
    }
}


fun main() {
    val matrix = arrayOf(
        arrayOf(1,2,3,4,5,6,7)
        ,arrayOf(1,2,3,4,5,6,7)
    )
    val bst = BST<Int>()
    matrix[0].forEach { i -> bst.insert(i) }
}

