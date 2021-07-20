package com.br.sample.general

import java.lang.StringBuilder
import kotlin.reflect.KProperty

val KProperty<*>.string: String
    get() {
        return this.run {
            val buffer = StringBuilder()
            buffer.append("Name: ${this.name}\n")
            buffer.append("ClassName: '${this.javaClass.name}\n")
            buffer.append("Parameter: '${this.parameters.string}\n")
            buffer.append("Type Parameter: '${this.typeParameters.string}\n")
            buffer.append("Return Type: '${this.returnType}\n")
            buffer.append("Annotations: '${this.annotations}")
            buffer.toString()
        }
    }