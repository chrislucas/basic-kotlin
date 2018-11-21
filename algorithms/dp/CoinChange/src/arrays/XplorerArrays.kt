package arrays
// usar reified para que possamos usar o tipo generico T como uma classe
inline fun <reified T> array2D(i: Int, j: Int, noinline op: (Int) -> T): Array<Array<T>> = Array(i) { Array(j, op) }


inline fun <reified T> array1D(i: Int, noinline op: (Int) -> T): Array<T> = Array(i, op)


fun main(args: Array<String>) {
    // funcao anonima
    val op = fun(i: Int): Int = 0
    //val op = fun(i: Int): Int { return 0 }
    val mem2D = array2D(2, 3, op)
    println(mem2D)
    // funcao lambda
    val op2 : (Int) -> Int = { 0 }
    val mem1D = array1D(10, op2)
    println(mem1D)

    val strings = array1D(10) { " " }
    println(strings)

}