


fun test(list: List<Int>, takeOdd : (Int) -> Boolean) {
    //val oddList = list.filter(takeOdd)
    val oddNumbers = list.filter {
        it -> takeOdd(it)
    }

    var first = true
    list.forEach {
        it ->
        val rs = it.takeIf(takeOdd) ?: "*"
        print(if (first) "$rs" else " $rs")
        first = false
    }
    println("")

    println(oddNumbers)

}


fun main(args: Array<String>) {
    test((1..1000).toList() ) { i: Int -> i and 1 == 1}
}