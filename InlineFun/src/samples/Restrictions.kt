package samples


/**
 * https://www.youtube.com/watch?v=wAQCs8-a6mg
 * */

 fun <R> execute(callback: () -> R) : R = callback()

/**
 * Quando usamos inline function nao eh possivel passar a funcao
 * recebida como argumento para outra funcao que nao seja inline tbm.
 * a nao ser que adicionemos o atributo 'noinline'ao argumento da funcao
 * */
inline fun <R> partial(fn: () -> R): R {
    /**
     * Nao eh permitido manter utilizar a funcao fn como argumento de outra funcao.
     * Illegal usage of inline-parameter
     * */
    //execute(fn)
    return fn()
}

inline fun <R> anotherPartialFun(noinline fn: () -> R) : R = execute(fn)


fun computer() {
    val p = partial {
        var q = 0xff and 0xfe
        q = q xor 0x123
        q = q shr 1
        q
    }

    println(p)
}


fun main() {
    computer()
}