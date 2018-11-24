package basics.sintax


fun main(args: Array<String>) {
    val cName = "Christoffer Lucas Fernandes Santos"
            .split(" ")
            .map { it -> it.toLowerCase() }

    val  fn = {
        v: CharSequence ->
        val t = v.toString()
        //
        t.substring(0, t.lastIndex) + t.last().toString().toUpperCase()

    }

    println(cName.joinToString("*", limit = 3, truncated = "...", transform = fn))

    val appendable = StringBuilder()
    cName.joinTo(appendable, "|", transform = fn)
    println(appendable)
}