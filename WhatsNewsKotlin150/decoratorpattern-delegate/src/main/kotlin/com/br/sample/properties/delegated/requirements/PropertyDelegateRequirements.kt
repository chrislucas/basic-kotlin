package com.br.sample.properties.delegated.requirements

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * https://kotlinlang.org/docs/delegated-properties.html#property-delegate-requirements
 *
 * Requisitos
 *
 * 1) para propriedades read-only (val) um delegate deve prover um operator function getValue() com os seguintes parametros
 *      - thisFRef: Deve ser do mesmo tipo do dono da propriedade ou um Supertipo dele
 *          - Para extensoes de propriedades, esse deve ser do tipo sendo extendido
 *
 *     - property: Deve ser do tipo KProerty<*> ou um Supertipo
 *
 *     - getValue deve retornar o mesmo tipo da propriedade ou um subtipo
 * */


class Resource

class Owner {
    val resource: Resource by ResourceDelegate() // ResourceDelegateObj
}

object ResourceDelegateObj : ReadOnlyProperty<Owner, Resource> {
    override fun getValue(thisRef: Owner, property: KProperty<*>): Resource = Resource()
}

class ResourceDelegate {
    operator fun getValue(ref: Owner, property: KProperty<*>): Resource = Resource()
}


fun main() {

}
