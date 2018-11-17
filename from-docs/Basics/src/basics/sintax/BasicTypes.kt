package basics.sintax

fun main(args: Array<String>) {
    // binary representation
    println(0b0001 shl 1)
    println(0b0001 shl 2)
    println(0b11111111_11111111_11111111_11111111)
    println(0b11010010_01101001_10010100_10010010)

    // hexadecimal representation
    println(0x7ffffffff_fffffff)
    println(Long.MAX_VALUE)
    println( (1000).inv())

    // Unicode
    println('\uFF33')
}