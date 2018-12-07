package basics.function.functionscope

/**
 * https://kotlinexpertise.com/coping-with-kotlins-scope-functions/
 * */

/**
 * assinatura da funcao Let
 * public inline fun <T, R> T.let(block: (T) -> R): R
 * Uma High order function que recebe uma outra funcao block(T) como parametro
 * */

fun testLet() {
    // bitwise para testar se N eh par
    println(10.let { it -> it and 1 == 0 })

    val transform = "teste123".let {
        println("Valor da variavel em let: $it")
        "${it.length}$it"
    }

    println(transform)

}

fun capitalize(value: String?) {
   println(value?.let { it.capitalize() } ?: "null")
}

fun main(args: Array<String>) {
    //testLet()
    capitalize("christoffer")
    capitalize(null)
}