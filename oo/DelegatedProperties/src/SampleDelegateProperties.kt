import kotlin.reflect.KProperty

class Delegate<T> {
    operator fun getValue(thisRef: Any?, property: KProperty<*>) : String = "$thisRef delegando a '${property.name}'"

    inline operator fun <reified T> setValue(thisRef: Any?, property: KProperty<*>, value: T) =
        println("Definindo o valr: $value a '${property.name}' da ref $thisRef")
}

class User {
    var name : String by Delegate<String>()
}

fun main() {
    val user = User()
    println(user.name)
    user.name = "chrisluccas"
    println(user.name)
}