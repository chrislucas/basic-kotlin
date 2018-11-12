package basics.function.bits

/**
 * Functions Literals
 *
 * Existem 2 tipos de funcoes literais em kotlin
 *
 * Anonymous Function e Lambda expression
 *
 * */

// lambda expression

val isPowerOf2 : (Int) -> Boolean  = { n -> n.and (n-1) == 0 }

val unsetBit : (Int, Int) -> Int = { n, ith -> (1 shl ith).inv() and n }

val setBit : (Int, Int) -> Int = { n, ith -> (1 shl ith) or n }

val toggleBit : (Int, Int) -> Int = { n, ith -> (1 shl ith) xor n }

val checkBit : (Int, Int) -> Int = { n, ith -> (n shr ith) and 1 }

infix fun Int.unset(ith: Int) : Int = (1 shl ith).inv() and this

infix fun Int.set(ith: Int) : Int = (1 shl ith) or this

infix fun Int.toggle(ith: Int) : Int = (1 shl ith) xor this


fun main(args: Array<String>) {

    println(setBit(10, 2))
    println(unsetBit(15, 3))
    println(unsetBit(255, 7))

    println(255 unset 7)
    println(200 set 7)

    println(toggleBit(128, 0))
    println(toggleBit(128, 1))
    println(checkBit(128, 6))
    println(isPowerOf2(120))
    println(isPowerOf2(128))

    println("${10 shr 3}, ${checkBit(10, 3)}")

}


