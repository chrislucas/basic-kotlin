package source

object ExpSquaring {

    @JvmStatic
    private fun mult(a: Long, b: Long, m: Long) = ((a % m) * (b % m)) % m

    fun exp(base: Long, e: Long, m: Long) : Long {
        return when (e) {
            0L -> {
                1
            }
            1L -> {
                base % m
            }
            else -> {
                var acc = 1L
                var cBase = base
                var cE = e
                while (cE>0) {
                    if (cE and 1 == 1L)
                        acc = mult(acc, cBase, m)
                    cBase = mult(cBase, cBase, m)
                    cE = cE shr 1
                }
                acc
            }
        }
    }

    @JvmStatic
    fun exp(base: Long, e: Long): Double {
        return if (e == 0L) {
            1.0
        } else if (e == 1L) {
            base * 1.0
        } else {
            var cBase = base * 1.0
            var cE = e
            if (e < 0) {
                cBase = 1.0 / cBase
            }
            var acc = 1.0
            while (cE > 0) {
                if (cE and 1 == 1L) {
                    acc *= cBase
                }
                cBase *= cBase
                cE = cE shr 1
            }
            return acc * 1.0
        }
    }

}


fun main() {

}