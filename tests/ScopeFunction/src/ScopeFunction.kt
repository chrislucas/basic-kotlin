/**
 *
 * Fontes
 * https://medium.com/luizalabs/kotlin-let-run-with-also-ou-apply-24e8745f12fd
 * https://medium.com/androiddevelopers/kotlin-demystified-scope-functions-57ca522895b1
 * */


class User(val register: String, val name: String, var old: Int? = 0) {
    override fun toString(): String = "Register: $register, Name: $name, Years: $old"
}

/**
 * As funcoes let, run e with sao bem uteis para instanciar modelos ou classes de um dominio
 * */

fun testLet(pair: Pair<String, String>) {
    /**
     * A funcao let permite acessar os valores do objeto do qual de escopo
     * que ela se originou  a partir do objeto 'it' e permite retornar qualquer valor
     * */
    val user = pair.let {
        User(it.first, it.second)
    }
    println(user)
}

/**
 * Similar a funcao Let porem o acesso aos valores do objeto que origina a funcao
 * run sao acessados atraves da keyword this
 * */

fun testRun(pair: Pair<String, String>) {
    val user = pair.run {
        User(this.first, this.second)
    }
    println(user)
}

fun testWith(pair: Pair<String, String>)  {
    val user = with(pair) {
        User(this.first, this.second)
    }
    println(user)
}

/**
 * Also e Apply
 * */


fun testAlso(user: User) {
    /**
     * Funcao que acessa o objeto que de escopo que deu origem a ela
     * atraves da variavel 'it' ou outra definida pelo programador (v -> ...)
     * Retorna a referencia do proprio objeto que originou a chamada da funcao
     * Uma boa forma de modificar uma instancia caso ela tenha atributos mutaveis
     * */
    println(user)
    val user2 = user.also {
        u ->
        u.old = 15
    }
    println(user)
    println(user2)
}


/**
 * Similar a funcao also, porem o acesso aos atributos e feito atraves da keyword 'this'
 * */
fun testApply(user: User) {
    println(user)
    val user2 = user.apply {
        this.old = 25
    }

    println(user)
    println(user2)
}

/**
 * Apply, run e with acessam os atributos de um objeto atraves do this
 * Also, let usam o it ou nome definido pelo programador
 * */

fun main(args: Array<String>) {
    //testWith(Pair("028367", "Christoffer Lucas"))

    testApply(User("028333", "Jose Almeida"))
}