package basic.ext.mutablelist

operator fun <T> MutableList<in T>.set(range: IntRange, collection: MutableList<T>) {
    for (i in range.first until range.last) {
        this[i] = collection[i]
    }
}
