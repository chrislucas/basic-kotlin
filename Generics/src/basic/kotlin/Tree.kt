package basic.kotlin

class Node<T> () {
    var left: Node<*>? = null
    var right: Node<*>? = null
    var value: T? = null

    private constructor(left: Node<T>, right: Node<T>) : this() {
        this.left = left
        this.right = right
    }

    override fun toString(): String {
        return "$left, $right"
    }
}


class Tree<T>() {
    var root: Node<T>? = null

    fun insert(node: Node<T>) {
        if (root == null)
            root = node
        else {

        }
    }
}

fun main(args: Array<String>) {

}