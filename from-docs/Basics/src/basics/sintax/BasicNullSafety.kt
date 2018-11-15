package basics.sintax

/**
 * https://kotlinlang.org/docs/reference/null-safety.html
 * */


fun safeConcat(a: String?, b: String) : String? {
    return a?.plus(b)
}

fun testNullableVar() {
    // uso de !! pois o metodo retorna null
    val data = readLine()!!
    println(data)

    // Operador ? indica que uma variavel pode aceitar null (nullable(

    var a: String? = null
    a = "teste"

    // a linha abaixo nao eh compilada pois para definir
    // uma variavel como null eh necessario definir seu tipo usando "?"
    //var b: String = null

    var b : String = "teste"
    // a linha abaixo nao eh compilada pois a variavel nao foi definida tal que sceitasse um valor null
    // b = null

    a = null
    println(a)
    // Safe calls
    println(safeConcat("teste: ", data)!!)
    println(safeConcat(a, data)!!)
}


/**
 *  Uma forma de executar uma operacao somente em valores nao nulos eh usando o operador
 *  let
 * */
fun testLetOperator() {

    listOf<String?>("Chris", "Lucas", "Fermamdes", "Santos", null)
            .forEach { it?.let { println("$it size: ${it.length}") } }
}

fun main(args: Array<String>) {
    testLetOperator()
}