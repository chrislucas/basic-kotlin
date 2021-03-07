package br.com.sample

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

suspend fun wait(time: Long) {
    /**
     * withContext:
     *
     * Dispatchers:
     * */
    // withContext eh uma extension que pode retornar um valor. A yltima
    // instrucao declarada na lambda determina o valor que essa funcao retorna
    withContext(Dispatchers.Default) {
        delay(time)
    }
}