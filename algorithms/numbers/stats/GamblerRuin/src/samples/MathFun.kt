package samples


object MathFun {
    @JvmStatic
    fun exp(b: Double, e: Long) : Double {
        return when (e) {
            0L -> { 1.0 }
            1L -> { b * 1.0 }
            else -> {
                var _e = e
                var _b = b * 1.0
                if (e < 0) {
                    _e = -_e
                    _b = 1.0/ _b
                }
                var acc = 1.0
                while (_e > 0) {
                    if (_e and 1L == 1L) {
                        acc *= _b
                    }
                    _b *= _b
                    _e = _e shr 1
                }
                acc
            }
        }
    }
}

