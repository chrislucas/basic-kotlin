package sample

import SimpleDelegate
import models.Plane

class User {
    var name: String by SimpleDelegate<String>()
}

fun testSimpleDelegate() {
    val user = User()
    println(user.name)
    user.name = "chrisluccas"
    println(user.name)
}

fun testGenericDelegate() {
    val plane1 = Plane()
    println(plane1.list)
}

fun main() {
    testGenericDelegate()
}