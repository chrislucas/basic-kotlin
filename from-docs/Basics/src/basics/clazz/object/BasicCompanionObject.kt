package basics.clazz.`object`

/**
 * https://kotlinlang.org/docs/reference/object-declarations.html#companion-objects
 *  Kotlin nao permite a criacao de metodos estaticos, para obter um recurso parecido com
 *  o que temos em Java foi disponibilizado o Companion Object.
 *
 *  Embora parece que os membros em Companion Object sao estaticos na realidade eles sao
 *  membros de instancia de objetos. Companion Object podem implementar interfaces
 *
 * */

/**
 * Semantica relacionada Object expressions e declarations
 *
 *  -> Object expressions sao executadas no momento de sua chamada
 *  -> Object declaration sao inicializadas com atraso na primeira vez que sao chamadas
 *  -> Um Companion Object eh inicializado apos o carregamento da classe que o comporta, correspondedo
 *  com o comportamento do inicializador estatico em Java
 *
 * */


class MyClass {
    companion object FactoryReference {
        fun getInstance() : MyClass = MyClass()
    }
}

class SimpleClass {
    companion object : Factory<SimpleClass> {
        override fun create(): SimpleClass = SimpleClass()
    }
}


interface Factory<T> {
    fun create() : T
}

fun main(args: Array<String>) {
    val myClass = MyClass.getInstance()
    println(myClass)

    val refMyClass = MyClass
    println(refMyClass)

    val refSimpleClass = SimpleClass
    println(refSimpleClass)

    val factory: Factory<SimpleClass> = SimpleClass
    println("$factory, ${factory.create()}")
}