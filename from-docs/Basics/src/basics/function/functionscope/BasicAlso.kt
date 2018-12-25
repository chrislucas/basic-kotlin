package basics.function.functionscope

/**
 * https://kotlinexpertise.com/coping-with-kotlins-scope-functions/
 *
 * inline fun T.also(block: (T) -> Unit): T
 *
 * Funcao 'also' e 'let' sao parececidas, elas passam por parametro
 * a referencia do objeto que as esta chamando. 'also' executa a funcao que
 * eh passado por parametro e retorna a propria referencia de quem a executou.
 * diferente de 'let' que executa uma funcao e permite retornar o que o desenvolvedor
 * quiser.
 *
 * */


/**
 * Sobre classes e atributos em kotlin
 * https://www.programiz.com/kotlin-programming/class-objects
 *
 * Em kotlin getters e setters sao automaticamente gerados,
 * mas podemos sobrescreve-los
 * */
class Point2D {
    var y: Double? = null
    set(value) { field = value ?:  0.0 }

    var x: Double? = null
    set(value) { field = value ?:  0.0 }

    override fun toString(): String {
        return "$x, $y"
    }
}


fun simpleTestAlsoFn() {
    val test = "Um texto qualquer para o test1"
    /**
     * a funcao 'also' eh executada atraves de uma instancia de um objeto 'T' () e
     * toma como argumento uma funcao 'F'. A funcao 'F' por sua vez toma como
     * argumento um objeto 'T'. a funcao also retorna 'this', que eh a referencia
     * a instancia que a chamou
     * */

    val op: (it: String) -> CharSequence = { it.subSequence(0..2) }
    val rsTest = test.also { op(it) }
    // rsTest == test uma vez que also retorna 'this' o valor
    // passado para funcao op(String) pode ate mudar, mas isso
    // nao sera retornado por 'also'
    println("$test, $rsTest, ${test == rsTest}")


    val test2 = "Um texto qualquer maroto"
    /**
     * a funcao 'let' eh executada a partir de uma instancia de um objeto T
     * e recebe uma funcao por argumento F. 'F 'toma como argumento 'T' e retorna
     * um valor do tipo 'T'
     * */

    val op1 : (i: String) -> String = { it.substring(0..1) }
    val rsTest2 = test2.let { op1(it) }


    println("$test2, $rsTest2")
}


fun testAssignClassPropertiesWithAlso() {
    /**
     * Usar a funcao also de inicializador de objetos
     * */
    val p = Point2D().also {
        it.x = 10.0
        it.y = null
    }
    println(p)
}

fun main(args: Array<String>) {
    simpleTestAlsoFn()
    //testAssignmentWithAlsoFun()
}

fun testAssignmentWithAlsoFun() {
    val fb: (n: Int) -> Int = {
        n ->
        var p = 0
        var q = 1
        for (i in 0 .. n) {
            p += q
            q = p - q
        }
        q
    };
    val op: (i: Int) -> Int = { it -> it and 1 }
    // aqui a funcao 'also' eh aplicada no retorno da funcao fb
    // porem also retorna o valor de fb.
    val fn = fb(10).also { op(it) }
    println(fn)
    //fun getP() = fb(10).also {  }
    //println( getP() )
}