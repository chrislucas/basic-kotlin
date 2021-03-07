package com.br.algebra

tailrec fun gdcc(a: Int, b: Int) : Int =
         if (a%b==0) {
            b
        } else {
            gdcc(b, a%b)
        }

fun main() {
    println(gdcc(15, 20))
}