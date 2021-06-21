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
         * no codigo mas quando precisamos acessa-lo a linguagem fornece um recurso, o identificador
         * "field"
         * https://medium.com/@nomanr/backing-field-in-kotlin-explained-9f903f27946c
         * Esse recurso foi criado para evitar que o programa lance uma StackOverflow
         *
         * Exemplo:
         *
         * class A {
         *  val name: String
         *      get() = name
         *      set(value: String) {
         *          name = value
         *      }
         *      // os metodos de acesso utilizam a propria propriedade, o problema
         *      esta que ao acessar a propriedade, nas entrelinhas o que está sendo chamado
         *      e o proprio metodo de acesso
         *
         *      val a = A()
         *      a.name == a.getName()
         *      a.name = "chris" == a.setName("chris""
         *
         *      Logo isso causa uma chama recursiva infinita causando o StackOverflow.
         *      Para corrigir isso temos a keyword 'field' denominada de backingfield
         * }
         *
         * O Exemplo abaixo mostra uma implementacao de um setter com um condicional. Se a condicao
         * for verdadeira, definimos o valor de field com o valor passado para a propriedade em questao, do
         * contrario lancamos uma excecao
         *
         * O field de uma propriedade so pode ser acessado atraves dos metodos de acesso get/set.
         *
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