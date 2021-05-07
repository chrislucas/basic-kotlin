package com.br.sample

class CounterTime {
    // Estrutura de uma propriedade de uma classe Koltin
    // o que estiver entre cochetes eh opcional
    // val <propertyName>[: <PropertyType>][=<property_initializer>]
    //      [<getter>]
    //      [<setter>]
    //
    var value = 0
        /**
         * Backing Fields
         * Segundo a doc: Em kotlin um "field" eh usado como parte de uma propriedade
         * para armazenar o valor dela em memoria. Fields nao podem ser declarados explicitamente
         * no codigo. Mas quando precisamos acessa-lo a linguagem fornece um recurso, o identificador
         * "field"
         * O Exemplo abaixo mostra uma implementacao de um setter com um condicional. Se a condicao
         * for verdadeira, definimos o valor de field com o valor passado para a propriedade em questao, do
         * contrario lancamos uma excecao
         *
         * O field de uma propriedade so pode ser acessado atraves de um metodo
         * */
        set(value) {
            if (value > 0) {
                field = value
            } else {
                throw IllegalArgumentException("O valor nao pode ser < 0")
            }
        }

    operator fun plusAssign(v: Int) {
        value += v
    }


}

class Table<K, V> {
    var map: MutableMap<K, V>? = null
        get() {
            if (field == null)
                field = mutableMapOf()
            return field
        }

    operator fun set(key: K, value: V) {
        map?.set(key, value)
    }

    override fun toString(): String {
        return "$map"
    }
}

private fun sampleCountTime() {
    val counter = CounterTime()
    counter += 1
    counter.value = 10
    counter.value = -1
}


private fun sampleCreateTable() {
    val table = Table<Any, Any>()
    table["Chris"] = 1
    val map = table.map
    map?.let {
        it["chris"] = "lucas"
        it[1] = 123
    }
    println(table.map)
    println(map)
}

fun main() {
    sampleCreateTable()
}