package com.br.sample.properties.delegated.requirements

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * https://kotlinlang.org/docs/delegated-properties.html#property-delegate-requirements
 *
 * Requisitos para criar um delegate de uma propriedade mutavel
 *
 *  - A Classe/Object delegate deve prover um operator function adicional denominado setValue com os seguintes parametro
 *      - ref: Deve ser do mesmo tipo ou um subtipo do atributo que se quer prover
 *      - property: deve ser do tipo KProperty<*> ou um supertipo
 *      - value: deve ser do tipo ou um supertipo da propriedade
 *
 *
 * */

class Data(val value: Int) {
    override fun toString(): String = "Data[$value]"
}

class User {
    var data: Data by ProvideMutableDataObj

    override fun toString(): String = "UserData: $data"
}

object ProvideMutableDataObj: ReadWriteProperty<User, Data> {

    private var data: Data = Data(0)

    override fun getValue(thisRef: User, property: KProperty<*>): Data = data

    override fun setValue(thisRef: User, property: KProperty<*>, value: Data) {
        ProvideMutableDataObj.data = value
    }
}

class ProvideMutableData(private var data: Data = Data(0)) {

    operator fun getValue(ref: User, property: KProperty<*>): Data = data

    operator fun setValue(ref: User, property: KProperty<*>, value: Data) {
        this.data = value
    }
}


fun main() {
    val user = User()
    println(user.data)

    user.data = Data(12)
    println(user)
}