import kotlin.properties.Delegates

// https://kotlinlang.org/docs/reference/delegated-properties.html#observable

//https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-delegates/observable.html

abstract class Observable<T>(open val value: T, var hasObservable: Boolean = true)

data class IntValueObservable(override var value: Int) : Observable<Int>(value, false)

var intValue : IntValueObservable by Delegates.observable(IntValueObservable(0)) {
        property, oldValue, newValue ->
    println("${property.name} $oldValue, $newValue")
    intValue.hasObservable = true
}


fun main() {
    println(intValue)
    intValue = IntValueObservable(15)
    println(intValue)

}