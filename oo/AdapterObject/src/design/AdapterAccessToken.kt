package design

/**
 * Classe AdapterAccessToken que cria uma forma de
 *
 * */

class AdapterAccessToken(accessToken: AccessTokenFirebase) : AccessToken {

    private val accessToken = accessToken

    override fun getToken(): String {
        return accessToken.getToken()
    }
}