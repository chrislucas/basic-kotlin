package basics.function.functionscope

import basics.sintax.range.matches
import java.text.SimpleDateFormat
import java.util.*

/**
 * Calls the specified function block with this value as its receiver and returns its result.
 * inline fun <T, R> T.run(block: T.() -> R): R
 *
 * a funcao run recebe por parametro uma funcao literal com receiver.
 * Essa funcao na pratica eh uma funcao de extensao do tipo generico T
 * o que possibilita por exemplo chamar metodos de T dentro dela sem
 * usar a variavel de contexto 'it'.
 *
 * Essa assinatura diferencia a funcao de escopo run de let, uma vez
 * que a ultima recebe uma funcao por parametro "block(T)", e block
 * recebe por parametro a variavel de contexto 'it'
 *
 *
 * Calls the specified function block and returns its result.
 * inline fun <R> run(block: () -> R): R
 *
 *
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/run.html
 * */


fun runLowerCase(value: String?) {
    /**
     *
     * */
    val p = value?.run { toLowerCase() } ?: "null"
    println(p)
}

fun showMatches(str: String, r: Regex) {
    val p = str.run { return@run this::matches } (r)
    println(p)
}

fun runIsOdd(value: LongRange) {
    // nao que precise do run para fazer isso, mas eu quero testar mesmo assim :)
    println(value.filter { it.run { this and 1L == 1L } })
}

fun test() {
    val p = Calendar.getInstance().run { SimpleDateFormat().format(Date(timeInMillis)) }
    print(p)
}

fun main(args: Array<String>) {
    runLowerCase("CHRISTOFFER")
    runIsOdd(10L..1234L)
    showMatches("12345", Regex("\\d+"))
    test()
}