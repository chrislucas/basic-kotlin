import java.math.BigInteger

typealias MatrixBigInt = Array<Array<BigInteger>>
typealias BigInt = BigInteger

inline fun <reified T> matrix(n: Int, m: Int, fn: () -> T): Array<Array<T>> =
    Array(n) { _ -> Array(m) { fn() } }