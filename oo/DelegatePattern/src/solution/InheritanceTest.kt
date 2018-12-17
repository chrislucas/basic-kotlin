package solution


open class DelegateClass<T> {
    open fun response(res: T) {
        println("Response DelegateClass: $res")
    }

    fun test() {
        println("test() em DelegateClass")
    }
}


class ExecuteClass : DelegateClass<String>() {

    override fun response(res: String) {
        println("Response ExecuteClass: $res")
    }

    fun test2() {
        super.test()
    }
}

fun main(args: Array<String>) {
    val executeClass = ExecuteClass()
    executeClass.test2()
}