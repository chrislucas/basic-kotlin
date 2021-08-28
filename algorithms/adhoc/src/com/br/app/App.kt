package com.br.app

import com.br.app.models.EvaluableModel
import com.br.app.models.ItemEvaluableModel
import com.br.app.models.violation.AbsenceOfDescription
import com.br.app.models.violation.AbsenceOfAssignee
import com.br.app.models.violation.AbsenseOfClassTests
import com.br.app.models.violation.UseProhibitedAnnotation

private fun sampleWithEmptyList() {
    val evaluableModel = EvaluableModel(listOf())
    println(evaluableModel.calculate())
}

private fun sampleWithMixedList() {
    val models = listOf(
        ItemEvaluableModel(),
        ItemEvaluableModel(AbsenceOfDescription()),
        ItemEvaluableModel(UseProhibitedAnnotation()),
        ItemEvaluableModel(UseProhibitedAnnotation()),
        ItemEvaluableModel(UseProhibitedAnnotation()),
        ItemEvaluableModel(AbsenseOfClassTests()),
        ItemEvaluableModel(AbsenceOfAssignee()),
        ItemEvaluableModel(),
        ItemEvaluableModel(),
        ItemEvaluableModel(),
        ItemEvaluableModel(AbsenseOfClassTests()),
        ItemEvaluableModel(AbsenceOfAssignee()),
        ItemEvaluableModel(UseProhibitedAnnotation()),
    )
    val evaluableModel = EvaluableModel(models)
    println(evaluableModel.calculate())
}

private fun sampleWithoutViolations() {
    val models = listOf(
        ItemEvaluableModel(),
        ItemEvaluableModel(),
        ItemEvaluableModel(),
        ItemEvaluableModel(),
        ItemEvaluableModel(),
    )
    val evaluableModel = EvaluableModel(models)
    println(evaluableModel.calculate())
}

private fun sampleWithJustViolations() {
    val models = listOf(
        ItemEvaluableModel(AbsenceOfDescription()),
        ItemEvaluableModel(UseProhibitedAnnotation()),
        ItemEvaluableModel(AbsenseOfClassTests()),
        ItemEvaluableModel(AbsenceOfAssignee()),
        ItemEvaluableModel(UseProhibitedAnnotation()),
    )
    val evaluableModel = EvaluableModel(models)
    println(evaluableModel.calculate())
}


fun main() {
    sampleWithEmptyList()
    sampleWithMixedList()
    sampleWithoutViolations()
    sampleWithJustViolations()
}