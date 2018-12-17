package basics.safety


fun test(str: String? = null) {
    println("${str?:"null"}, ${str?.length}")
    // o operador !! forca o uso de uma referencia
    // isso pode causar problemas se a referencia a um objeto for nulo
}

/**
 * https://kotlinlang.org/docs/reference/null-safety.html
 * kotlin foi projetado para que o programador corra o minimo
 * de risco possivel de gerar um Null Pointer Exception.
 * As unicas formas de se gerar essa excecao sao:
 *  -> se chamarmos a excecao NullPointerException() (NPE) explicitamente
 *  -> usar o operador !!. Operador not null que permite usar uma referencia
 *  como se ela fosse nao nula, entretanto se a variavel for uma referencia
 *  nula, o programa vai lancar uma excecao NPE
 *
 *  -> tentar usar um 'open member' de uma 'classe BaseClass na 'classe Derivada'
 *  sem inicializado
 *
 *  -> Interoperalibidade com Java: Utilizar estruturas de dados em Java que permitem
 *  a adicao de nulos se usar o operador de segurancao ?. Por exemplo trazer uma lista
 *  de Integer e adicionar a uma MutableList<Int> ao inves de MutableList<Int?>
 *
 * */


open class BaseClass(open val str: String? = null){
    init {
        println("Valor de this no bloco de inicializacao da classe BaseClass: $this")
    }

    val str2: String? = null

    constructor() : this(null) {
        // Pesquisar sobre esse vazamento leaking 'this' in constructor of non-final class
        println("Valor de this no construtor da classe BaseClass: $this")
        println("Valor de str2 no construtor da classe BaseClass: $str2}")
    }
}


class DerivedClass(str: String? = null) : BaseClass(str) {
    init {
         /**
          *
          * */
         println("Valor de str2 dentro do inicializador da classe Derivada: ${super.str2?.length}")
    }
}

fun testNPERefThis() {
    val refDerived = DerivedClass()
    println(refDerived.str2)
}


/**
 * Em kotlin, uma variavel so pode receber o valor null se utilizarmos o
 * operador ?
 * */

fun testAllowNullAssign() {
    var str: String? = "teste"
    str = null
    var str2: String = "teste 2"
    // erro de compilacao
    // str2 = null
}



fun main(args: Array<String>) {
    //test("Christoffer")
    //test()
    testNPERefThis()
}