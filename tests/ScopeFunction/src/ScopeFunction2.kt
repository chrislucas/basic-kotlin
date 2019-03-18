import java.util.*

/**
 * Explorando mais sobre scoping function
 * fonte : https://medium.com/androiddevelopers/kotlin-demystified-scope-functions-57ca522895b1
 *
 * */



class Person(val id: Long, val name: String, var age: Long) {
    override fun toString(): String {
        return "ID: $id, Name: $name, Age: $age"
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
    val m = intRand.run {
        this and 1
    }

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
     * 'also' retorna this
     * */
    person1.also {
        it.age = 30
    }

    println(person1)

    /**
     * o retorno a funcao 'let' eh definido na ultima linha de execucao de seu bloco
     * */
    val person2 = person1.let {
        Person(it.id + 1, it.name, it.age)
    }
    println(person2)

    val person3 = person2.let { p -> Person(p.id + 1, p.name, p.age + 30)}
    println(person3)
}






fun main(args: Array<String>) {
    testScopeFunUsingItKeyword()
}