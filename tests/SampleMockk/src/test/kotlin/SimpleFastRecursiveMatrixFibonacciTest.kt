
import math.algorithm.nb.SimpleFastRecursiveMatrixFibonacci.fbn
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SimpleFastRecursiveMatrixFibonacciTest {
    @Test
    fun test() {
        Assertions.assertEquals(BigInt("2"), fbn(BigInt.valueOf(3)))
        Assertions.assertEquals(BigInt("3"), fbn(BigInt.valueOf(4)))
        Assertions.assertEquals(
            BigInt("43466557686937456435688527675040625802564660517371780402481729089536555417949051890403879840079255169295922593080322634775209689623239873322471161642996440906533187938298969649928516003704476137795166849228875")
            , fbn(BigInt.valueOf(1000))
        )
    }
}