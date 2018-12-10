package basics.function.functionscope

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
    // nao que precise da funcao 'run' para fazer isso, mas eu quero testar mesmo assim :)
    println(value.filter { it.run { this and 1L == 1L } })
}

fun test() {
    val p = Calendar.getInstance().run { SimpleDateFormat().format(Date(timeInMillis)) }
    print(p)
}

fun test0() {
    runLowerCase("CHRISTOFFER")
    runIsOdd(10L..1234L)
    showMatches("12345", Regex("\\d+"))
    test()
}

fun test2(value: Array<Int>) {
    println(value.run { this.map { it -> it * it } })
}


/**
 * Implementando um exemplo para entender a diferenca da function
 * Scope run e let.
 *
 * A funcao passada por argumento para a funcao run eh uma funcao
 * de extensao temporaria, funcionando como extensao somente dentro
 * do escopo da funcao run.
 *
 * No caso da funcao let, passamos uma funcao por argumento que por sua
 * vez recebe um argumento do mesmo tipo de classe de quem chamou 'let'
 * cujo valor eh o mesmo daquele que chamou 'let'
 *
 * Exemplo: "teste".let(str: String), 1.let(i: Int)
 * */

fun stringToCharArry(value: String) {
    /**
     * a funcao run recebe como argumento uma funcao que funciona
     * na pratica como uma funcao de extensao de classe para o objeto
     * de contexto que a chama (Object.run). Assim
     * */
    val op : String.() -> List<CharCategory> ={
        this.map { it.category }
    }
    println("Funcao op: $op")
    val p = value.run { op() }
    println(p)
    val op2: (i: String) -> List<CharCategory> = { it -> it.map { it.category } }
    println("Funcao op2: $op2")
    // let retorna o retorno da funcao que lhe foi passada por parametro
    val q = value.let { op2(it) }
    println(q)
    // funcao lambda de extensao para classe String (um teste maroto)
    val op3: String.() -> Pair<String, String> = { this.partition { it.isLetter() } }
    // run retorna o resultado da funcao que lhe eh passada por argumento
    val s = value.run { op3() }
    println(s)
}


fun main(args: Array<String>) {
    stringToCharArry("Chris Lucas 123456")
}