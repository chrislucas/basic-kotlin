package oop
/**
 * https://kotlinlang.org/docs/reference/classes.html#inheritance
 * As classes em Kotlin tem como super classe comum a classe Any. Essa eh a super
 * classe padrao para as classes que nao tem supertypes declarados
 * */



/**
 * A keyword open em kotlin tem o efeito contrario da keywird final em java, classes 'open'
 * permitem que outras classes sejam especializacoes dela. Por padrao classes em kotlin sao
 * final
 * */
open class Point3f(open val x: Double, open val y: Double, open val z: Double)  {

    override fun toString(): String {
        return "$x, $y, $z"
    }

    /**
     * Para tornar um metodo de uma classe publica precisamos marcar o metodo com
     * a keyword 'open'
     * */
    open fun fn() {
        println("FN() Point 3D")
    }

    open fun fx() {
        println("FX() Point3D")
    }
}

/**
 * Se a super classe possui primary constructor a classe base deve
 * iniciar a super classe logo apos a declaracao do seu primary constructor,
 * como implementado a baixo
 *
 * Classe sem a anotacao 'open' nao podem ter metodos com essa anotacao
 *
 * */
class Point4f(override val x: Double, override val y: Double
              , override val z: Double, private val t : Long) : Point3f(x, y, z) {

    override fun toString(): String {
        return "$x, $y, $z, $t"
    }
    /**
     *
     * Sobreescrevendo metodo da super classe
     * */
    override fun fn() {
        println("FN() Point 4D")
    }

    /**
     * usando a keyword 'final' impedimos de um metodo sobrescrito
     * se sobreescrito novamente em outra subclasse.
     * Entretanto como essa classe (oop.Point4f) eh implicitamente 'final' esse metodo
     * por padrao tambem o eh
     * */
    final override fun fx() {
        println("FX() Point 4D")
    }
}





open class ClazzWithoutPConstructor {
    constructor(name: String) {
        val name = name
    }
}

/**
 * Se a super classe não possuir 'primary constructor' a classe base
 * pode iniciarlizar a super classe apos o 'secondary constructor'
 * */
class AnotherClazzWithoutPConstructor : ClazzWithoutPConstructor {
    constructor(name: String) : super(name)
}


/**
 * Classes abstratas nao necessita da keyword 'open'
 * */
abstract class AccessToken {
    abstract fun getToken() : String

}

class AccessTokenFacebookAcount() : AccessToken() {
    override fun getToken(): String {
        return "0xff:toke_facebook_account"
    }
}

fun main(args: Array<String>) {
    val p: Point3f = Point4f(1.0, 2.0, 3.0, 1)
    println((p as Point3f).toString())
    (p as Point3f).fn()
    (p as Point3f).fx()
}