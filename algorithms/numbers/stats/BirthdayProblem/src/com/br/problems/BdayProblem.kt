package com.br.problems


/**
 * Birthday problem
 * https://en.wikipedia.org/wiki/Birthday_problem#Approximations
 * Qual a probabilidade de encontrar 2 ou mais pessoas num conjunto de N pessoas
 * que fazem aniversario no mesmo dia num ano de D dias
 *
 * para o calculo. Sabemos que um ano tem 365 (quando nao bissexto).
 *
 * O metodo abaixo permite uma generalizacao para o calculo de probabilidade
 * com o parametro de quantidade de dias do ano variavel.
 *
 * O racícionio para se calcular a probabilidade de num conjunto de
 * S-pessoas existirem ao menos 2 cuja data de aniversario coincidem
 * (num ano t T-dias) eh: 1 - Calcular a probabilidade de nenhuma delas
 * fazerem aniversario no mesmo dia
 *
 * P(n) = a probabilidade de num conjunto de n pessoas ao menos 2 terem
 * a data do aniversario igual
 *
 * P(n)' = a probabilidade de nenhuma pessoa ter a data de aniversario coincidente
 *
 * P(n) = 1 - P(n)' - Podemos chegar a probabilidade 'p de um evento 'e' acontecer
 * calculando a 1 - 'np que eh a probabilidade desse evento nao acontecer, uma vez que sabemos
 * p + np = 1
 *
 * A ideia eh a seguinte, dado um numero N de pessoas num conjunto vamos calcular a probabilidade
 * de
 *      - 2 pessoas nao fazerem o aniversario no mesmo dia
 *      - 3 pessoas nao fazerem o aniversario no mesmo dia
 *      - 4 pessoas nao fazerem o aniversario no mesmo dia
 *      ate a n-esima pessoa do conjunto ser inserida no calculo
 *
 * Seja q a quantidade de pessoas e i um iterador r o numero de dias num ano
 * Para q = 5 e r = 365
 *
 * as chances de 2 pessoas fazerem aniversario no mesmo dia
 *
 * P(2) -> 1 / 365 = um unico dia dos 365 pode ser o mesmo para os 2 (obviamente)
 * ~P(2) -> 364/365  = sao as chances de 2 pessoas nascerem em dias dintintos
 * 3 pessoa -> P(3) = 2 / 365 : ~P(3) = 363 / 365
 * 4 pessoa -> P(4) = 3 / 365 : ~P(4) = 362 / 365
 * 5 pessoa -> P(5) = 4 / 365 : ~P(5) = 361 / 365
 *
 * Entao
 *
 * P(5) = 1 - (364/365*363/365*362/365*361/365) = 0.027
 *
 *
 * @param Long qSample: espaço amostral de pessoas no experimento
 * @param Long qTotal: espaco amostral do tamanho do "ano" que se quer usar
 * @return Double: probabilidade de num conjuto de qPeoples existirem pessoas
 * com a mesma data de aniversario
 *
 * */
fun calcProbability(qPeoples: Long, qDaysOfYear: Long): Double {
    var acc = 1.0
    var cqTotal = qDaysOfYear - 1.0
    while (cqTotal > (qDaysOfYear - qPeoples)) {
        acc *= (cqTotal / qDaysOfYear)
        cqTotal -= 1
    }
    return 1.0 - acc
}
fun simulationChooseRandomicNumberNTimes() {
    for (i in 1L..366L) {
        println("P($i), ${
            calcProbability(i, 365).format("%.18f")
        }")
    }
}

fun main() {
    simulationChooseRandomicNumberNTimes()
}