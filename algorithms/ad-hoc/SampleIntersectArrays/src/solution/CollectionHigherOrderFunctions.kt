package solution

typealias IndexArray = MutableList<Int>


inline fun <T> T?.safeLet(block: (T) -> Unit) : T?   {
    if(this != null) {
        block(this)
    }
    return this
}

inline fun <T> T?.orElse(block: () -> Unit) {
    if (this == null) {
        block()
    }
}

