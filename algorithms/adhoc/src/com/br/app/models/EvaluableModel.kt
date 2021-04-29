package com.br.app.models

import com.br.app.models.violation.ViolationLevel

class EvaluableModel(private val items: List<ItemEvaluableModel>) {

    companion object {
        const val MAX_EVALUATION_VALUE = 5.0
    }

    private val qItemsWithViolation = items.filter { it.violation != null }.count()

    private val proportionalItemsWithViolation: Double =
        if (qItemsWithViolation == 0 || items.count() == 0) {
            0.0
        } else {
            qItemsWithViolation / (items.count() * 1.0)
        }

    private val violationDistribution: Map<ViolationLevel?, Int> =
        items.fold(mutableMapOf()) { map: MutableMap<ViolationLevel?, Int>, item: ItemEvaluableModel ->
            map.apply {
                this[item.violation?.violationLevel] = this[item.violation?.violationLevel]?.plus(1) ?: 0
            }
        }

    private val high = violationDistribution[ViolationLevel.High] ?: 0
    private val highProportional = if (high <= 0) {
        0.0
    } else {
        proportionalItemsWithViolation / (high * 1.0)
    }

    private val medium = violationDistribution[ViolationLevel.Medium] ?: 0
    private val mediumProportional = if (medium <= 0) {
        0.0
    } else {
        proportionalItemsWithViolation / (medium * 1.0)
    }

    private val low = violationDistribution[ViolationLevel.Medium] ?: 0
    private val lowProportional = if (low <= 0) {
        0.0
    } else {
        proportionalItemsWithViolation / (low * 1.0)
    }


    fun calculate(): Double {
        val highEvalution = highProportional * ViolationLevel.High.weight
        val mediumEvaluation = mediumProportional * ViolationLevel.Medium.weight
        val lowEvalutation = lowProportional * ViolationLevel.Low.weight
        return 1.0 - ((1.0 * highEvalution) + (1.0 * mediumEvaluation) + (1.0 * lowEvalutation))
    }
}