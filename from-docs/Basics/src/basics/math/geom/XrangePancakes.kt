
/**
 * https://www.hackerrank.com/challenges/xrange-and-pizza/problem
 * */

fun angleBetweenAxis(n: Int) = 360 / (2*n)

fun rotator(k: Int, n: Int) = (360*k) / n


fun execute(n: Int, m: Int) {
    val size = if (n and 1 == 1) n else (2 * n)

    val original =  Array<Int>(size) { i -> angleBetweenAxis(i) }
    val copy = original.copyOf()


    for ( i in 0 until m) {
        val values = readLine()?.split(" ")?.map { it.toInt() }?.toTypedArray()
        val type = values?.get(0) ?: 0
        val k = values?.get(1) ?: 0

        when (type) {
            // rotation
            1 -> {
                for (idx in 0 until  n){
                    copy[idx] = (copy[idx] + rotator(k, n)) % 360
                }
            }
            // flipping
            else -> {
                // verificar se n eh par ou impar
                /**
                 * Se n for impar, ao flipar o k-eixo temos que verificar
                 * se k tambem eh impar, pois ele comeca no meio de uma aresta
                 * e termina no eixo do lado oposto do poligono, assim vale pensar
                 * que estamos invertendo o poligono pelo vertice onde esse eixo termina
                 * */
                if ( n % 2 == 1) {
                    if ( k % 2 == 1) {

                    }
                    else {

                    }
                }
                else {

                }
            }
        }
    }
}

fun main(args: Array<String>) {

}