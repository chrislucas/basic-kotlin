package com.br.app.models.violation

abstract class Violation(val violationLevel: ViolationLevel) {
    override fun toString(): String {
        return "$violationLevel"
    }
}