package br.com.samples.news.kotlin13

/**
 * https://kotlinlang.org/docs/reference/whatsnew13.html#unsigned-integers
 * */


private fun testUnsignedIntegers() {
    // unsigned 8-bit integer
    val uByte: UByte = 255u //  an unsigned 8-bit integer, ranges from 0 to 255

    // unsigned int an unsigned 32-bit integer, ranges from 0 to 2^32 - 1
    val uint : UInt = ((1u shl 31)-2u)
    val MAX_UINT = UInt.MAX_VALUE


    val MAX_UBYTE = UByte.MAX_VALUE
    val MIN_UINT = UByte.MIN_VALUE
    // signed 8-bit integer
    val PSING_INT: Byte = Byte.MAX_VALUE // se eu tentar adicionar mais do 127
    val NSING_INT: Byte = Byte.MIN_VALUE // se eu tentar adicionar menos do que -128

    println("$uByte, $MAX_UBYTE, $MIN_UINT, $PSING_INT, $NSING_INT, $uint, $MAX_UINT")


}

fun printMinMaxInteger() {
    println(String.format("MinMaxInt(%d, %d)\nMinMaxUInt(%d, %d)\nMinMaxULong(%d, %d)" +
            "\nMinMaxLong(%d, %d)"
        , Int.MAX_VALUE, Int.MIN_VALUE
        , UInt.MAX_VALUE, UInt.MIN_VALUE
        , ULong.MAX_VALUE, ULong.MIN_VALUE
        , Long.MAX_VALUE, Long.MIN_VALUE
    ))

    print(String.format(""
        , UByte.MAX_VALUE, UByte.MIN_VALUE
        , Byte.MAX_VALUE, Byte.MIN_VALUE
        , UShort.MAX_VALUE, UShort.MIN_VALUE
        , Short.MAX_VALUE, Short.MIN_VALUE
    ))
}

fun main() {
    testUnsignedIntegers()
}


