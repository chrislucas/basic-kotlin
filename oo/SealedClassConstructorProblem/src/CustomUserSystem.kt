/**
 * Essa eh uma subclasse de uma subclasse de uma sealead class
 *
 * */

interface MonitoringOperation {
    fun after()
    fun before(result: StateOp)
}

data class ResultOp<T>(val dataResult: T)

sealed class StateOp(val id: Int, date: Long, message: String) {
    data class Success<T, R : ResultOp<T>>(
        val _id: Int,
        val _date: Long,
        val _message: String,
        val wrapperResult : R
    ) : StateOp(_id, _date, _message)

    data class Error(
        val _id: Int,
        val _date: Long,
        val _message: String,
        val exception: Throwable
    ) : StateOp(_id, _date, _message)
}

class CustomUserSystem(
    id: Int,
    name: String,
    val callback: MonitoringOperation
) :
    UserSystem.Full(id, name)


// a linha abaixo nao compila, nao eh possivel criar uma subclasse de uma sealead class
//class CustomUserSystem : UserSystem()