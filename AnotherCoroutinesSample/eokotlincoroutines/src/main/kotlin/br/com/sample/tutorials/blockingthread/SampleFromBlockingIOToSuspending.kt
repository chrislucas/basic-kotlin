package br.com.sample.tutorials.blockingthread

import kotlinx.coroutines.*
import java.io.*


data class Message(private val source: String)

fun String.parseMessage() = Message(this)


@Throws(IOException::class)
suspend fun BufferedReader.parse(): Message? =
    // Quando usamos a funcao async
    // Function returning Deferred with a name that does not end with Async

    /**
     * Sobre o uso de Dispatchers.IO
     *
     * "IO-bound code does not actually consume CPU resources"
     *
     * Dispatcher.IO x Dispatacher.Default
     * "Se utilizarmos Dispatcher.Default numa operacao de IO terminanod
     * numa situacao onde por exemplo, numa maquina com um processador de 8-cores
     * com 8-threads alocadas para um Dispatcher.Default, essas threads sao Bloqueadas
     * para operacoes de IO mas nao consomem CPU, assim temos 8 nucleos alocados desnecessariamente."
     *
     * "IO Dispatacher aloca threads adicionaisn sobre aquelas alocadas para Default Dispacher, permitindo
     * realizar operacoes de IO e utilizar recursos da CPU ao mesmo tempo"
     * */
    withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
        val message = buildString {
            readLine()?.parseMessage()
        }
        message.parseMessage()
    }

private suspend fun sample() {

    withContext(Dispatchers.IO) {
        readLine()?.parseMessage()
    }
}


fun main() {
    runBlocking {
        val message = BufferedReader(InputStreamReader(FileInputStream("/raw/ref"))).parse()
        println(message.toString())
    }

}