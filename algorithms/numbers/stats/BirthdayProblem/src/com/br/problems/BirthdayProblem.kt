package com.br.problems

import java.io.File
import java.io.FileOutputStream
import java.lang.StringBuilder
import kotlin.math.sqrt
import kotlin.random.Random


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
fun calculateProbabilitySameBirthday(qPeoples: Long, qDaysOfYear: Long): Double {
    var acc = 1.0
    var cqTotal = qDaysOfYear - 1.0
    while (cqTotal > (qDaysOfYear - qPeoples)) {
        acc *= (cqTotal / qDaysOfYear)
        cqTotal -= 1
    }
    return 1.0 - acc
}

/**
 * https://www.mathsisfun.com/data/probability-shared-birthday.html
 * */

data class ResultProbSimulation(val qSample: Int, val upperBound: Int, val pResults: Int, val qSimulation: Int) {
    val result: Double = pResults * 1.0 / qSimulation
    override fun toString(): String {
        return "[Sample: $qSample, Simulations: $qSimulation, Limit: $upperBound, Positive Results: $result]"
    }
}

fun MutableList<ResultProbSimulation>.mean(): Double = this.map { it.result }.sum() / this.size

fun MutableList<ResultProbSimulation>.variance(mean: Double): Double =
        this.map { (it.result - mean) * (it.result - mean) }.sum() * (1.0 / this.size)

fun MutableList<ResultProbSimulation>.populationStddev(mean: Double) =
        sqrt(this.map { (it.result - mean) * (it.result - mean) }.sum() * (1.0 / (this.size)))

fun MutableList<ResultProbSimulation>.sampleStddev(mean: Double) =
        sqrt(this.map { (it.result - mean) * (it.result - mean) }.sum() * (1.0 / (this.size - 1)))

fun stddev(variance: Double) = sqrt(variance)

fun <T> MutableList<T>.log(fn: MutableList<T>.() -> Unit) = fn()

/**
 * Para investigar a veracidade dos resultados probabilisticos do problema
 * do aniversário, o método executa uma simulacao X vezes de escolher N numeros
 * randomicos (espaco amostral) e verificar nesse conjunto, quantas repeticoes
 * existem
 *
 * Exemplo: A quantidade de numeros randomicos escolhidos sera limitada por uma
 * variavel denominada "upperBound". A quantidade de numeros repetidos que se espera encontrar
 * nesse conjunto de numeros aleatórios é dado pela variavel "sample"
 *
 * Assim como no problema do aniversários, temos um metodo que executara a simulacoes
 * com upperBound de 365, e o valor de sample será alguns valores cujo resultado no
 * problema do aniversario e bem conhecido como: 23; 57 e assim por diante
 *
 * Espera-se que a quantidade de numeros repetidos num conjunto de tamanho S
 * seja proporcional (muito proximo) da probabilidade de M pessoas terem as
 * datas de nascimento coincidente
 *
 * */

fun simulationChooseRandomicNumberNTimes(sample: Int, upperBound: Int): ResultProbSimulation {
    var s = 0
    val random = Random(System.currentTimeMillis())
    var acc = 0
    val simulations = 500
    while (s <= simulations) {
        val numbers = Array(sample) { random.nextInt(1, upperBound) }.sortedArray()
        for (i in 0 until numbers.size - 1) {
            if (numbers[i + 1] == numbers[i]) {
                acc += 1
                break
            }
        }
        s += 1
    }

    return ResultProbSimulation(sample, upperBound, acc, simulations)
}

fun Double.format(format: String) = String.format(format, this)

fun sampleBirthdayProblem() {
    for (i in 1L..366L) {
        println("P($i), ${
            calculateProbabilitySameBirthday(i, 365).format("%.18f")
        }")
    }
}

/**
 * O método abaixo chama a simulacao que ira escolher X vezes uma sequencia
 * randomica de numeros. Pretende-se avaliar quantas vezes 2 os mais numeros
 * se repetem num conjunto randomico para comparar com a probabilidade
 * de 2 ou mais pessoas terem suas datas de nascimento coincidentes num
 * ano de D dias. Esse é um problema similar ao problema do aniversario
 * onde a quantidade de pessoas é representada variavel sample que é basicamente
 * quantas pessoas existem  no conjunto, e a quantidade de dias que se pode fazer
 * aniversario é representada pela variavel upperBound, entretanto na simulacao
 * a variavel upperbound é o limite superior para a escolha de uma variavel aleatoria
 *
 * Esse experimento será executado X vezes para eventual calculo de dispersão das variáveis.
 *
 * Note que a média dos resultados para cada sample S com upperBound U é bem próxima da probabilidade
 * de que S pessoas em U dias tenham sua data de nascimento coincidente, isso quanto executamos
 * o experimento milhares de vezes é claro
 * */
private fun executeSimulation(sample: Int, upperBound: Int, qExecutions: Int): MutableList<ResultProbSimulation> {
    val results: MutableList<ResultProbSimulation> = mutableListOf()
    for (i in 0 until qExecutions) {
        results.add(simulationChooseRandomicNumberNTimes(sample, upperBound))
    }
    return results
}

private fun executeSimulation() {
    val table: MutableList<MutableList<ResultProbSimulation>> = mutableListOf()
    table.add(executeSimulation(5, 365, 1000))
    table.add(executeSimulation(23, 365, 1000))
    table.add(executeSimulation(30, 365, 1000))
    table.add(executeSimulation(35, 365, 1000))
    table.add(executeSimulation(40, 365, 1000))
    table.add(executeSimulation(57, 365, 1000))
    table.add(executeSimulation(70, 365, 1000))
    table.add(executeSimulation(75, 365, 1000))
    table.add(executeSimulation(100, 365, 1000))

    table.forEach { simulations ->
        val mean = simulations.mean()
        val variance = simulations.variance(mean)
        val stddev = stddev(variance)
        val buffer = StringBuilder()
        simulations.forEach {
            buffer.append(it).append("\n")
        }
        val result = String.format("Simulation: %s - Mean: %.5f, Variance: %.5f, Stddev: %.5f"
                , simulations[0].qSample, mean, variance, stddev)
        appendResults(buffer.toString(), result)
        println(result)
    }
}


private fun rewriteResults(simulation: String, statsResults: String) {
    File("raw/output/simulation.txt").printWriter()
            .use {
                out ->
                out.println(simulation)
                out.printf("\n%s", statsResults)
            }
}

private fun appendResults(simulation: String, statsResults: String) {
    FileOutputStream(File("raw/output/simulation.txt"), true)
            .bufferedWriter()
            .use {
               out ->
                out.write(simulation)
                out.write(String.format("\n%s\n", statsResults))
                out.write("------------------------------------------------------")
                out.write("\n\n")
            }
}

private fun testMeanSimulation() {

    val simulations = mutableListOf(
        ResultProbSimulation(5, 100, 5, 5)
        , ResultProbSimulation(5, 100, 4, 5)
        , ResultProbSimulation(5, 100, 4, 5)
        , ResultProbSimulation(5, 100, 5, 5)
        , ResultProbSimulation(5, 100, 1, 5)
    )
    simulations.log {
        this.forEach { println(it) }
    }

    val mean = simulations.mean()
    val variance = simulations.variance(mean)
    val stddev = stddev(variance)

    println(String.format("Mean: %.5f, Variance: %.5f, Stddev: %.5f"
            , mean, variance, stddev))

    val pStddev = simulations.populationStddev(mean)
    val sStddev = simulations.sampleStddev(mean)

    println(String.format("Populational Stddev: %.5f, Sample Stddev: %.5f"
            , pStddev, sStddev))

    println(String.format("%.3f", simulations.mean()))
}

fun main() {
    //sampleBirthdayProblem()
    //testMeanSimulation()
    executeSimulation()
}