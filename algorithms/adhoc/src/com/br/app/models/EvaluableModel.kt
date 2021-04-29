package com.br.app.models

import com.br.app.models.violation.ViolationLevel

data class EvaluableModel(private val items: List<ItemEvaluableModel>) {

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
        items.filter { it.violation != null }
            .fold(mutableMapOf()) { map: MutableMap<ViolationLevel?, Int>, item: ItemEvaluableModel ->
                map.apply {
                    this[item.violation?.violationLevel] = this[item.violation?.violationLevel]?.plus(1) ?: 1
                }
            }

    private val high = violationDistribution[ViolationLevel.High] ?: 0
    private val highProportional = if (high <= 0) {
        0.0
    } else {
        high * 1.0 / proportionalItemsWithViolation
    }

    private val medium = violationDistribution[ViolationLevel.Medium] ?: 0
    private val mediumProportional = if (medium <= 0) {
        0.0
    } else {
        medium * 1.0 / proportionalItemsWithViolation
    }

    private val low = violationDistribution[ViolationLevel.Medium] ?: 0
    private val lowProportional = if (low <= 0) {
        0.0
    } else {
        low * 1.0 / proportionalItemsWithViolation
    }


    /**
     * Calculo de punicao
     *
     * 1) Calcular a proporcao de items com violacoes em relacao ao total de items
     *      proportionalItemsWithViolation = items.filter {withViolation}.size / items.size
     *
     * 2) Distribuir as violacoes num histograma <TiposViolacoes, Quantidade> (violationDistribution)
     *
     * 3) Calcular a proporcao Quantidade de tipo de violacao / Quantidade de violacao
     *            (high|mediu|low Proportional)
     *
     * 4) multiplicar cada proporcao pelo seu peso de violacao (ViolationLevel) e assim obter uma nota
     * proporcional ao peso (high|medium|low Evaluation)
     *
     * 5) multiplicar cada peso pelo valor proporcional:
     * quantidade de items por quantidade de items com violacao.
     * Assim aplicamos a punicao somente a parte do "modelo avaliavel" (EvaluableModel) que possui
     * violacoes
     *
     * 6) Somamos os valores de punicao
     *
     * 7) Subtrair do valor maximo o percentual de violacao proporcional calculado
     *
     * */
    fun calculate(): Double {
        val highEvalution = highProportional * ViolationLevel.High.weight
        val proportionalDiscountHighEvaluation = proportionalItemsWithViolation * highEvalution

        val mediumEvaluation = mediumProportional * ViolationLevel.Medium.weight
        val proportionalDiscountMediumvaluation = proportionalItemsWithViolation * mediumEvaluation

        val lowEvalutation = lowProportional * ViolationLevel.Low.weight
        val proportionalDiscountLowEvaluation = proportionalItemsWithViolation * lowEvalutation

        val percentDiscount =
            proportionalDiscountHighEvaluation + proportionalDiscountMediumvaluation + proportionalDiscountLowEvaluation
        return MAX_EVALUATION_VALUE - (MAX_EVALUATION_VALUE * percentDiscount)
    }
}