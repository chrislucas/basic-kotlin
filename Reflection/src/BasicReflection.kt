import kotlin.reflect.full.memberExtensionProperties

/**
 * https://kotlinlang.org/docs/reference/extensions.html
 * Definir uma funcao de extensao nao adiciona um novo membro
 * a classe, meramente torna possivel chamar uma funcao atraves
 * da sintaxe de '.' a partir de uma variavel do tipo da classe
 * que recebeu a extensao
 * */
fun  Long.toBin() : String {
    val str = StringBuilder()
    var v = this
    while (v>0) {
        str.append(v and 1)
        v = v shr 1
    }
    return str.toString().reversed()
}

fun testExtesionFn() {
    println(15L.toBin())
    println(13L.toBin())
    println(((1L shl 40)-1).toBin())
}

/**
 * https://kotlinlang.org/docs/reference/reflection.html
 * */

fun testClassRef() {
    val refInt = Long::class
    refInt.members.forEach {
        val pair = it.name to it.parameters
        println(pair.second)
    }
    println("")
    refInt.memberExtensionProperties.forEach {
        println(it.name)
    }
}



fun main(args: Array<String>) {
    testClassRef()
}