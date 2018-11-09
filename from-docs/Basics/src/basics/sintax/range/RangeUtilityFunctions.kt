package basics.sintax.range

/**
 *
 * https://kotlinlang.org/docs/reference/ranges.html#rangeto
 *
 * Metodo executa o construtor da classe que implementa a interface
 * ClosedRange (atraves de inferencia o kotlin sabe qual construtor deve
 * ser executado (IntRange, LongRange, ComparableRange))
 *
 * */

fun testRangeTo() {
    println('c'.rangeTo('z'))
    println(0xff.rangeTo(0x1ff))
    /**
     * o metodo rangeTo para String e Double/Float tem um comportamento
     * diferente dos outros tipos primitivos. Tais classes nao definem um operador
     * rangeTo que retorna um *Range, o metodo rangeTo dessas classes retorna
     * uma instancia de uma classe especifica que extende de ClosedRange
     * ClosedDoubleRange, ClosedFloatRange e o metodo rangeTo da classe String
     * retorna uma instancia de ComparableRange
     *
     * */
    println("10".rangeTo("30").contains("20"))
    println(10.5f.rangeTo(11.5f).contains(10.5f))
    println(10.5f.rangeTo(11.5f).contains(11.49999999999999f))
    println(10.3.rangeTo(10.7))
}


fun matches (c: Char, reg: Regex) = c.toString().matches(reg)

/**
 * Extension function definida para pares de tipos integrais
 * */
fun testDownTo() {
    for ( i in 10.downTo(10)) {
        print(String.format(" %d", i))
    }
    println()
    for (i  in 'z'.downTo('a').filter { matches(it, "[^aeiou]".toRegex()) }) {
        print(String.format(" %c", i) )
    }
    println()
}



// https://kotlinlang.org/docs/reference/ranges.html#reversed
fun testReversed() {
    println((10..20).reversed())
    println((0b0101..10).reversed())
}

// https://kotlinlang.org/docs/reference/ranges.html#step
fun testStep() {
    val s =(10..20).step(2)
    s.iterator().forEachRemaining {
        i: Int -> print(String.format(" %d", i))
    }
}

fun main(args: Array<String>) {
    testReversed()
}