package solution


interface  Delegate<T> {
    fun response(result: T)
}


class WindowRequestUser : Delegate<String> {
    override fun response(result: String) {
        println(result)
    }
}


class  AsyncRequestUser(private val delegate: Delegate<String>) {
    fun asyncRequest() {
        println("Executanto a requisicao do usuario")
        delegate.response("Requisicao enviada com sucesso")
    }
}

fun testDelegate() {
    val asyncRequestUser = AsyncRequestUser(WindowRequestUser())
    asyncRequestUser.asyncRequest()
}


fun main(args: Array<String>) {
    testDelegate()
}