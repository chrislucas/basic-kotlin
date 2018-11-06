package basics.sintax.range


fun inRange(intRange: IntRange, i: Int) = i in intRange

// Unit corresponde ao valor void no Java
fun testLoopInCollections() : Unit {
    val list = listOf<Int>(1,3,5,7,9,2,0)
    val range: IntRange = list.indices
    println(range)
    for (i in  list) {
        // String template
        //println("$i in range $range ? ${inRange(range, i)}")
        //println( if ( inRange(range, i) ) "$i in range $range" else "$i not in range $range")
        // dava pra fazer com String.format e ainda usar o parametro %s ao inves de inserir a expressao
        // inteira no argumento "format" como esta o codigoabaixo
        val  s = String.format("%d ${if (inRange(range, i)) "in range" else "not in range"} %s"
                , i
                , range)
        println(s)
    }
}

/**
 * https://kotlinlang.org/docs/reference/ranges.html
 * */
fun testLoopWithRange() {
    for (i in 0..10) {
        print(String.format(" %d", i))
    }
    println()
    for (i in 0..10 step 3) {
        print(String.format(" %d", i))
    }
    println()
    val p = (0..30).step(5)
    for (i in p) {
        print(String.format(" %d", i))
    }
    println()
    // CharRange
    val c = 'a' .. 'z'
    for (c in c.filter { it.toString().matches("[aeiou]".toRegex()) }) {
        print(String.format(" %s", c))
    }
    println()
    // IntProgression
    for (i in 4.downTo(1)) {
        print(String.format(" %d", i))
    }
    println()
    // IntProgression
    val ip = 32.downTo(1).step(2)
    for (i in ip) {
        print(String.format(" %d", i))
    }
    println()
    // Notacao de intervalo
    // https://www.infoescola.com/matematica/intervalo/
    // https://pt.wikipedia.org/wiki/Intervalo_(matem%C3%A1tica)
    // Um intervalo [a, b)
    val q = 1 until 10
    for (i in q) {
        print(String.format(" %d", i))
    }
    println()
    val ch = ('a'..'z').step(3)

    for (i in ch) {
        print(String.format(" %c", i))
    }
    println()

    /**
     * Ranges implementam a interface ClosedRange<T> que denota um
     * intervalo fechado como descrito na matemática definido para
     * tipos que implementam a interface Comparable
     *
     *
     * Integral type Progression (IntProgression, LongProgression, CharProgression)
     *  denotam uma progressao aritmetica, Sao definidos pelos atributos first, last e um
     *  valor diferente de zero denominado step
     *
     *  Para tipos integrais o operador '..' cria um objeto que implementa as classes ClosedRange<T>
     *      e Progressions
     *      Exemplo: a classe IntRange extende a classe IntProgression e implementa a interface ClosedRange<Int>
     *          Todos os metodos implementados em IntProgression sao acessiveis em IntRange como (contains que esta definido
     *          em Collection como um operador de Iterable, isEmpty definido em IntRange)
     * */
}

fun testProgression() {
    /**
     * Retorna uma progressao de rangeStart ao valor mais proximo de rangeEnd em 's' passos(steps)
     *
     * Para calcular o ultimo elemento da progressao
     *
     * rangeEnd - (rangeEnd - rangeStart) % step
     * */

    val rangeStart = 1
    val rangeEnd = 10
    val step = 2

    val last = rangeEnd - (rangeEnd - rangeStart) % step
    println("$last, ${(last - rangeStart) % step}")

    val ip = IntProgression.fromClosedRange(rangeStart, rangeEnd, step)
    println(ip)
}

fun main(args: Array<String>) {
    testProgression()
}