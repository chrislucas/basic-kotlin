package com.br.app.models.violation

sealed class ViolationLevel(val weight: Double) {
    object High : ViolationLevel(.55)
    object Medium : ViolationLevel(.25)
    object Low : ViolationLevel(.20)
}

private val LEVELS = listOf(ViolationLevel.High, ViolationLevel.Medium, ViolationLevel.Low)

fun valide(): Boolean = LEVELS.sumByDouble { it.weight } == 1.0
