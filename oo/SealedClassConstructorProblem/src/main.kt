fun main() {
    val op = object : MonitoringOperation {
        override fun after() {
            println("configurando alguma coisa !!!")
        }

        override fun before(result: StateOp)  {
           when(result) {
               is StateOp.Success<*, *> -> {
                   val wrapperData = result.wrapperResult
                   println("Deu bom !!! ${result.id}" +
                           ", ${result._date}" +
                           ", ${wrapperData.dataResult}")
               }
               else -> {
                   println("Deu ruim !!!")
               }
           }
        }
    }
    val customUserSystem = CustomUserSystem(1, "chrislucccas", op)
    println(customUserSystem)
}