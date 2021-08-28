package com.br.sample

/**
 * https://medium.com/@nomanr/backing-field-in-kotlin-explained-9f903f27946c
 * Uma alternativa ao backing field e o uso de uma backing property. Trata-se basicamente
 * de uma propriedade publica que retorna o valor de uma propriedade privada
 * */

class StrangeTable<K, V>(private var pTable: MutableMap<K, V>? = null) {
    /**
     * Backing property: Uma propriedade da classe que serve de auxilio para uma outra pripriedade
     * */
    val table: MutableMap<K, V>
        get() {
            if (pTable == null) {
                pTable = mutableMapOf()
            }
            return pTable ?: throw Exception("")
        }


    operator fun set(k: K, v: V) {
        table[k] = v
    }
}

private fun sample() {
    val table = StrangeTable<Any, Any>()
    table["teste"] = 1
    table["q"] = 12
    table[1] = "teste"
    table[2] = mapOf(1 to 'a', 2 to 'c', 3 to 'd')
    println(table.table)
}

fun main() {
    sample()
}