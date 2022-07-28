package com.br.sample.deserializesubtype

import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File
import java.net.URL

/*
    https://mkyong.com/java/jackson-how-to-parse-json/
 */
fun <T> String.toObject(obj: Class<T>): T =
    with(ObjectMapper()) mapper@{
        readValue(File(this@toObject), obj)
    }


fun <T> String.toObject(url: URL, obj: Class<T>) {
    with(ObjectMapper()) mapper@{
        readValue(url, obj)
    }
}

fun <T> String.fromJson(obj: Class<T>): T =
    with(ObjectMapper()) {
        readValue(this@fromJson, obj)
    }


fun <T> T.toJson(): String =
    with(ObjectMapper()) {
        writeValueAsString(this@toJson)
    }


private fun getRSA() {
    val rsa = "sample-jacksonlib/src/main/resources/rsa.json".toObject(RSA::class.java)
    println(rsa.apply())
}

private fun getMD5() {
    val md5 = "sample-jacksonlib/src/main/resources/md5.json".toObject(MD5::class.java)
}


private fun checkToJson() {
    val rsaJson = RSA("algorithm").toJson()
    println(rsaJson)
    println(rsaJson.fromJson(RSA::class.java))
    println("************************************************************")

    val md5Json = MD5("algorithm", "345&&**Ass!@").toJson()
    println(md5Json)
    println(md5Json.fromJson(MD5::class.java))

}

private fun check() {
    println("{\"data\":\"algorithm\",\"key\":\"345&&**Ass!@\"}".fromJson(MD5::class.java))
    println("{\"data\":\"algorithm\"}".fromJson(RSA::class.java))
}

fun main() {
    checkToJson()
    //check()
    //getRSA()
}