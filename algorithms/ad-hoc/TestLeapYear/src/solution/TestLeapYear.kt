package solution


fun isLeapYear(year: Long) : Boolean {
    if (((year % 400L) == 0L || year % 100L != 0L ) && (year % 4L) == 0L)
        return true
    return false
}

fun main(args: Array<String>) {
    var acc = 0
    for (i in 1800 .. 2020L) {
        if (isLeapYear(i)) {
            println(i)
            acc++;
        }
        //println("$i: %s".format(if (isLeapYear(i)) "Leap Year" else "Not Leap Yar"))
    }
    println("$acc %s".format(if (acc > 1) "leap years" else "leap year"))
}