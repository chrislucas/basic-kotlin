package com.br.app

import com.br.app.models.EvaluableModel
import com.br.app.models.ItemEvaluableModel
import com.br.app.models.violation.AbsenceOfDescription
import com.br.app.models.violation.PullRequestWithoutAssignee
import com.br.app.models.violation.PullRequestWithoutTestClass
import com.br.app.models.violation.UseProhibitedAnnotation

private fun sampleWithEmptyList() {
    val evaluableModel = EvaluableModel(listOf())
    println(EvaluableModel.MAX_EVALUATION_VALUE * evaluableModel.calculate())
}

private fun sampleWithMixedList() {
    val models = listOf(
        ItemEvaluableModel(),
        ItemEvaluableModel(AbsenceOfDescription()),
        ItemEvaluableModel(UseProhibitedAnnotation()),
        ItemEvaluableModel(UseProhibitedAnnotation()),
        ItemEvaluableModel(UseProhibitedAnnotation()),
        ItemEvaluableModel(PullRequestWithoutTestClass()),
        ItemEvaluableModel(PullRequestWithoutAssignee()),
        ItemEvaluableModel(),
        ItemEvaluableModel(),
        ItemEvaluableModel(),
        ItemEvaluableModel(PullRequestWithoutTestClass()),
        ItemEvaluableModel(PullRequestWithoutAssignee()),
        ItemEvaluableModel(UseProhibitedAnnotation()),
    )
    val evaluableModel = EvaluableModel(models)
    println(EvaluableModel.MAX_EVALUATION_VALUE * evaluableModel.calculate())
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
    println(EvaluableModel.MAX_EVALUATION_VALUE * evaluableModel.calculate())
}

private fun sampleWithJustViolations() {
    val models = listOf(
        ItemEvaluableModel(AbsenceOfDescription()),
        ItemEvaluableModel(UseProhibitedAnnotation()),
        ItemEvaluableModel(PullRequestWithoutTestClass()),
        ItemEvaluableModel(PullRequestWithoutAssignee()),
        ItemEvaluableModel(UseProhibitedAnnotation()),
    )
    val evaluableModel = EvaluableModel(models)
    println(EvaluableModel.MAX_EVALUATION_VALUE * evaluableModel.calculate())
}


fun main() {

    sampleWithMixedList()
}