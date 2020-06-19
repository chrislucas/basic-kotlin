package sample

/**
 * https://pt.wikipedia.org/wiki/Esquema_de_Horner
 *
 * Seja p(x) um polinomio = Soma(i=0, n) a(i)x^i =
 * a(0) + a(1)x + a(2)x^2 ... + a(n)x^n
 *
 * onde a(0) ... a(n) sendo os seus coeficientes e numeros reais
 *
 * O metodo de Horner consiste em reescrever um polinomio de forma a obter uma aproximacao
 * para um certo ponto (x0)
 *
 * Podemos reescrever o polinomio da seguinte forma
 *
 * P(x) = a(0) + x(a(1) + x(a(2) + a(3)^x + ... +  x(a(n-1) + a(n)^x))
 *
 * https://www.ime.usp.br/~pf/mac0122-2002/aulas/footnotes/horners-rule.html
 * https://www.geeksforgeeks.org/horners-method-polynomial-evaluation/
 * */


fun hornernMethod(poly: Array<Int>, x0: Int) {

}


fun main(args: Array<String>) {

}