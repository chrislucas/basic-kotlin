package basics.function

/**
 * https://kotlinlang.org/docs/reference/inline-functions.html#reified-type-parameters
 *
 * Funcoes de primeira/alta ordem impoem certas penalidades em tempo de execucao: Cada funcao
 * tambem pe um objeto. Alocacao de meoria seja para funcos ou classes e chamadas virtuais
 * introduzem um consumo de memoria (overhead) em tempo de execucao
 *
 * Segundo a documentacao da linguagem, podemos em muitos casos eliminar esse overhead transformando
 * funcoes em 'inline lambda expressions'
 *
 * Quem aplica essa transformacao eh o compilador, mas para que isso ocorra precisamos definir
 * nossa funcao com o modificador 'inline' e escreve-la na forma de lambda
 *
 * O modificador inline afeta a propria funcao e a funcao lambda passada por parametro
 * inline fun <T> lock(lock: Lock, body: () -> T): T { ... })
 *
 * Existe o modificador no inline, para o caso que nao queremos que uma funcao lambda sofra a modificacao
 *
 * inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) { ... }
 *
 * https://blog.kotlin-academy.com/kotlin-programmer-dictionary-function-type-vs-function-literal-vs-lambda-expression-vs-anonymous-edc97e8873e
 * */

inline  fun <T> fn(k: T, v: T,  op1 : (T, T) -> T, noinline op2: (T, T) -> T) {
    println(op1(k, v))
    println(op2(k, v))
}

fun main(args: Array<String>) {
    val k =1024
    val v = 128
    val op1 : (Int, Int) -> Int = { p, q -> p xor q}
    val op2 : (Int, Int) -> Int = { p, q -> p + q}
    fn(k, v, op1, op2)
}