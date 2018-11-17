package design

fun main(args: Array<String>) {
    val accessToken : AccessToken = AdapterAccessToken(AccessTokenFirebase())
    print(accessToken.getToken())
}