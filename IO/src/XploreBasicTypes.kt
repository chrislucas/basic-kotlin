/**
 * https://kotlinlang.org/docs/reference/basic-types.html
 * https://kotlinlang.org/docs/reference/lambdas.html
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/map.html
 *
 * Pesquisar
 * function map kotlin
 *
 * */


fun Test() {
    var list = arrayOf(1,2,3,4,5)
    list.map( {
        i -> i * 2
    })
    list.map {
        println(it)
    }
}


fun main(args: Array<String>) {
    Test()
}