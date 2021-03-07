package sample.com.br.addbehavior

import java.io.IOException


/**
 * Imagine que uma empresa forneca uma biblioteca para acesso Remoto a Um recurso seu, para que o cliente consiga
 * fazer algum tipo de integracao.
 * */
interface RemoteAccess {
    @Throws(IOException::class)
    fun findResourceByUrl(url: String): Array<Byte>
}