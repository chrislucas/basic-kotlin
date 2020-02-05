import kotlin.reflect.KProperty

class AnotherDelegate<T> (private val builder: (Any?, KProperty<*>) -> T) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T = builder(thisRef, property)
}

fun <T> create(builder: (ref: Any?, property: KProperty<*>) -> T) : AnotherDelegate<T> = AnotherDelegate(builder)