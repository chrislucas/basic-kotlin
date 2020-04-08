import java.util.*

/**
 * Explorando mais sobre scoping function
 * fonte : https://medium.com/androiddevelopers/kotlin-demystified-scope-functions-57ca522895b1
 *
 * Diferenca entre scope function applu, also, let, run e with em relacao a
 * outras funcoes que criam tambem seu proprio escopo como forEach, Filter, map entre outras:
 *
 * As ultimas sao aplicadas a elementos do tipo iterador, elas não são funções de escopo (scope functions)
 * Elas criam o seu proprio escopo de funcao e iteram por cada elemento de uma
 * colecao e aplicam ou nao uma operacao em cada elemento.
 *
 * As scope function also, let e etc simplesmente criam o seu proprio escopo de funcao e nada mais. Elas sao mais
 * simples do que as funcoes de iteracao
 *
 *
 * */


/**
 * funcao -- referencia -- retorno
 * apply        this        this
 * run          this        a ultima linha da funcao
 * with         this        a ultima linha da funcao
 *
 * also         it          this
 * let          it          a ultima linha da funcao
 *
 * Also esta para apply
 * Assim como run e with estao para let
 *
 *
 * Diferencas de Also e apply (analisando pq uma usa it e outra this)
 *
 * assinatura
 * public inline fun <T> T.also(block: (T) -> Unit): T
 *
 * assinatura
 * public inline fun <T> T.apply(block: T.() -> Unit): T
 *
 * As funcoes apply, run e with tem como elemento em comum
 * receber como argumento uma funcao T.(), isso e denominado
 * no linguagem kotlin uma "Function literals with receive"
 *
 * fonte: (https://kotlinlang.org/docs/reference/lambdas.html
 * , https://try.kotlinlang.org/#/Kotlin%20Koans/Builders/Function%20literals%20with%20receiver/Task.kt)
 * Elas tem o comportamento de funcoes de extensao, possibilitando o acesso dos atributos
 * publicos do objeto receptor (receiver) dentro do escopo da funcao.
 *
 * Exemplo simples -> Point().apply { this.x = 10, this.y = 10}
 *
 * */


class Person(val id: Long, val name: String, var age: Long) {
    override fun toString(): String {
        return "ID: $id, Name: $name, Age: $age"
    }
}


class Job {
    lateinit var description : String
    internal var id : Long = 0


    override fun toString(): String {
        return "Job id: $id, description: $description"
    }
}


fun testScopeFunUsingThisKeyWord() {
    /**
     * scope function que tem o 'this'
     * como referencia em seu escopo interno
     * run, apply, with
     *
     **/

    /**
     * A funcao run e with tem em comum que a sua ultima linha de execucao
     * determina o seu valor de retorna
     * */


    val person1 = Person(1,"Chris", 15)
    person1.run { this.age = 30 }
    println("$person1")
    with(person1) { this.age = 45 }
    println("$person1")
    //person1.apply {}
    //println("$person1")

    /**
     * run aplica uma funcao definida pelo programador e retorna o resultado dela
     * (a ultima linha do bloco de execucao sera o retorno)
     * */
    val intRand = run {
        Random().nextInt(1000) + 100
    }

    /**
     * funtion literal with receiver
     * https://kotlinlang.org/docs/reference/lambdas.html#function-types
     * https://kotlinlang.org/docs/reference/lambdas.html#function-literals-with-receiver
     * */
    val m = intRand.run { this and 1 }

    println("$intRand, $m")

    val p = 10
    // apply aplica uma funcao qualquer e retorna this
    p.apply {
        // aqui posso fazer qualquer coisa com o 'this'
        // que o seu valor nao sera m
        var ref = this
        ref %= 1
        print("this $ref")
    }
    println("p: $p")
}

fun testScopeFunUsingItKeyword() {
    val person1 = Person(1,"Chris", 15)

    /**
     * 'also' executa uma funcao cujo argumento e o proprio objeto que lhe chama e
     * retorna this
     *
     * Also e Apply tem o mesmo comportamento, a diferenca esta que o argumento da funcao
     * que passada como argumento para funcao also eh o 'it' nao o 'this' como visto no apply
     * Assim podemos usar o this quando queremos a refencia do escopo de fora da funcao 'also'
     *
     *
     * */
    val rs = person1.also {
        it.age = 30
    }
    println("$rs\n$person1\n${rs == person1}, ${rs === person1}")

    /**
     * Uma segunda vantagem em se utilizar o also e poder executar uma funcao que nao tem vinculo
     * semantico com outra funcao
     *
     * '
     *      But it’s also tremendously helpful when doing something along with an unrelated object or statement ...
     *      fonte: https://medium.com/androiddevelopers/kotlin-demystified-scope-functions-57ca522895b1
     * '
     * Exemplo.
     * Podemos construir uma instancia de uma classe e depois executar uma funcao que pode ou nao ter um vinculo
     * com a construcao do objeto, como por exemplo mudar valores dos atributos dessa instancia ou simplesmente
     * executar um log
     * */

     val jobTest =  Job()
            .also {
                it.description = "Job scheduler: Run image processing filters algorithm"
                it.id = 0xf3
                println("Definindo alguns parâmetros padrões")
            }

    println(jobTest)




    /**
     * o retorno a funcao 'let' eh definido na ultima linha de execucao de seu bloco
     * */
    val person2 = person1.let {
        Person(it.id + 1, it.name, it.age)
    }
    println(person2)

    val person3 = person2.let {
        p -> Person(p.id + 1, p.name, p.age + 30)
    }
    println(person3)
}


fun testCreateObject() {
    val engineering = Job().apply {
        id = 1
        description = "Software engineering"
    }

    println(engineering)

}



fun main(args: Array<String>) {
    //testScopeFunUsingThisKeyWord()
    testScopeFunUsingItKeyword()
    //testCreateObject()
}