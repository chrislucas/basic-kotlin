package comp.io.fundamentals

fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f", this)!!

fun main(args: Array<String>) {
    val pi = Math.PI;
    println(pi.format(2))
}