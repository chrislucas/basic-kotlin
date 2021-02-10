package samples

/**
 * https://math.stackexchange.com/questions/1205096/gamblers-ruin-formula
 *
 * Duas pessoas Ane e Carol decidiram jogar um jogo de probabilidade. COm 2 dados
 * o jogo eh o seguinte: Se ao lancar os dados a soma deles der 8 ou mais A ganha
 * senao ganha o C. Cada jogador inicia uma quantidade de moedas e a cada partida
 * o jogador vencedor ganha 1 moeda do outro.
 *
 * Por exemplo
 *
 * Ane comeca com 23 moedas
 * Carol comeca com 9 moedas
 *
 * Note que existem 36 combinacoes de posiveis resultados ao lancar 2 dados (6*6)
 * Para soma ser igual ou maior que 8
 * [2 e 6, 3 e 5, 3 e 6, 4 e 4, 4 e 5, 4 e 6, 5 e 6, 6 e 6] = 8 /36
 *  o restante a soma eh igual ou menor que  7 = 1 - (8/36)
 *
 * Para A ruir as economias de C ela tem q sair de 23 moedas e chagar a 23
 * C precisa partir de 9.
 *
 * */

private fun simulation() {

}

fun main() {
    simulation()
}