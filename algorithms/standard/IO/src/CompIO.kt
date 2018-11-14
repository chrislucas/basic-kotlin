/**
 * https://stackoverflow.com/questions/41283393/reading-console-input-in-kotlin
 * */


fun readInt() : Int {
    return readLine()!!.toInt();
}

fun readStrings(delimiter: Char) : List<String> {
    return readLine()!!.split(delimiter);
}

fun simpleReadInts(delimiter: Char): List<Int> {
    return readStrings(delimiter).mapTo(arrayListOf()){ it.toInt() }
}

fun anotherReadInts(del: Char) = readLine()!!.split(del).map(String::toInt)

fun readInts(delimiter: Char) : List<Int> {
    var list = readStrings(delimiter);
    var rs : MutableList<Int> = arrayListOf()
    list.mapTo(rs) { it.toInt() }
    return rs;
}


fun write(fmt: String) {
    print(fmt);
}


fun test() {
    val x = 10;
    val y = 10;
    write("$x, $y")
    val i = readInt();
    val j = readInt();
    write("$i, $j");
}

fun reader() {
    var list = anotherReadInts(' ');
    list.mapTo(arrayListOf()) {
        println(it)
    }
    println(list.sum());
}

fun reader2() {
    var (a, b) = anotherReadInts(' ')
    print("$a, $b")
}

fun main(args: Array<String>) {
    reader2();
}