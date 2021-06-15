package com.br.chp.covariance

/**
 *  <out T> em List<out T>
 *      Essa forma de parametrizar um tipo generico e definida como Declaration-site Variance
 *
 * */

// Declaration-site Variance
class WrapperType<out T>(val value: T)


fun <T> MutableList<T>.copyRef(origin: List<T>) {
   origin.forEachIndexed { idx, value -> this[idx] = value }
    //origin.forEach { value -> this.add(value) }
}

fun <T> copy(fisrt: MutableList<T>, second: MutableList<T>) {
    fisrt.forEachIndexed { index, value -> second[index] = value }
}

fun <T> cpy(fisrt: MutableList<out T>, second: MutableList<T>) {
    fisrt.forEachIndexed { index, value -> second[index] = value }
}

fun sample1() {
    val list = listOf(WrapperType(1), WrapperType(2), WrapperType(3))
    val cooy = MutableList<WrapperType<Int>>(list.size) {
            it -> WrapperType(0)
    }
    cooy.copyRef(list)

    println(list)
    println(cooy)
    cooy[0] = WrapperType(19)
    println(list)
    println(cooy)
}

fun sample2() {
    val fList = mutableListOf(A(), A(), A())
    //val sList = mutableListOf<Base>(B(), B())
    val sList : MutableList<Base> = mutableListOf(B(), B(), A())

    // as duas primeiras linhas compilam a terceira nao, pq p compilador nao permite
    // inserir instancias de A numa lista que so aceita tipos B, Ambos sao subclasses
    //  da classe Base, mas as semelhancas acabam por ai
    //
    // O compilador nao consegue inferir se o tipo parametrizado eh do tipo A ou B, por conta
    // da ambiguidade. Mas se parametrizarmos as variaveis o compilador ja consegue resolver
    // val sList = mutableListOf(B(), B())

    sList.copyRef(fList)

    println(fList)
    println(sList)

    // compilador nao consegue inferiror o tipo parametrizado
    //copy(fList, sList)
}


fun sample3() {
    val fList = mutableListOf(A(), A(), A())
    val sList = mutableListOf<Base>(B(), B(), B())
    println(fList)
    println(sList)
    cpy(fList,sList)
}

fun main() {
    sample2()
}