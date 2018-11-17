package comp.io.fundamentals


fun n(a: Int) {
    var a  = a
    a += 10;
}


fun test() {
    var a: Int = 10;
    n(a)
    val b: Long? = 100L
    println(a)
    println(b)
}

fun main(args: Array<String>) {

}