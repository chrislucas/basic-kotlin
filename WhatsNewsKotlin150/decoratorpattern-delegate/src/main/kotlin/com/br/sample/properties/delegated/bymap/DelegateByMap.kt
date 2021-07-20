package com.br.sample.properties.delegated.bymap

data class User(private val data: Map<String, Any?>) {
    val name: String by data
    val id: Long by data
    //override fun toString(): String = "$data: [$name, $id]"
}

private fun testImmutableMapAsDelegate() {
    val user = User(mapOf("name" to "chris", "id" to 100L))
    println(user)
}


data class MutableUser(private val map: MutableMap<String, Any?>) {
    var name: String by map
    var id: Long by map

    //override fun toString(): String = "($map: [$name, $id])"
}


private fun testMutableMapAsDelegate() {
    var user = MutableUser(mutableMapOf("name" to "chris", "id" to 100L))
    println(user)
    user.id = 10
    println(user)
}

fun main() {
    testMutableMapAsDelegate()
}

