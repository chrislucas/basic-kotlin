package com.br.sample


/**
 * Exemplo baseado de: https://medium.com/@nomanr/backing-field-in-kotlin-explained-9f903f27946c
 * */

class SimpleTable {
    private var mTable: MutableMap<Any, Any>? = null
    val table: MutableMap<Any, Any>
        get() {
            if (mTable == null) {
                mTable = mutableMapOf()
            }
            return mTable ?: throw Exception("Tabela nula")
        }
}