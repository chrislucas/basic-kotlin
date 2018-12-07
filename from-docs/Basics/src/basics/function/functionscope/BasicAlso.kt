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
    val rsTest = test.also { it.subSequence(0..2) }
    val test2 = "Um texto qualquer maroto"
    val rsTest2 = test2.let { it.subSequence(0..1) }

    println("$test, $rsTest, ${test == rsTest}")
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
    testAssignmentWithAlsoFun()
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
    var p: Int
    fun getP () = fb(10).also { p = it }
    println( getP() )
}