package sample.com.br.addbehavior

import java.io.IOException


/**
 * Essa classe encapsula a logica de acesso remoto e implementa um recurso de
 * */
class RemoteAccessImpl(private val remoteAccess: RemoteAccess, private val attemptsRemoteAccess: Int = 3) :
    RemoteAccess {


    override fun findResourceByUrl(url: String):Array<Byte> {
        var cAttempts = 0
        while (cAttempts < attemptsRemoteAccess) {
            try {
                return remoteAccess.findResourceByUrl(url)
            } catch (e: IOException) {
                println(e.message)
            }
            cAttempts++
        }
        return arrayOf()
    }
}