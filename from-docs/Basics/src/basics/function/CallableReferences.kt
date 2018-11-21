package basics.function

/**
 * https://kotlinlang.org/docs/reference/reflection.html
 * */

fun testCallableReferenceRegex() {
    val isNumberRegex = "\\d+".toRegex()
    println(isNumberRegex)
    val numbers = listOf<String>("abc", "123"
            , "123asd", "78987979797987").filter (isNumberRegex::matches)
    println(numbers)
}


/**
 * Function reference
 * */
fun isPowerOf2(x: Long) = x.and(x-1) == 0L


fun testCallableReferencePowerOf2() {
    val p = listOf<Long>(123, 15, 12, 8, 321, 1024).filter (::isPowerOf2)
    println(p)
}


fun main(args: Array<String>) {
    testCallableReferenceRegex()
    testCallableReferencePowerOf2()
}