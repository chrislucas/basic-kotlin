package solution

typealias IndexArray = MutableList<Int>


inline fun <T> T.safeLet(block: (T) -> Unit)  {
    if(this != null) {
        block(this)
    }
}

inline fun <T> T?.orElse(block: () -> Unit) = block()

data class Sample(val id: Int, val description: String) : Element<Int, String> (id, "id:$id, description:$description") {
    override fun compareTo(other: Element<Int, String>) = this.key - other.key
}