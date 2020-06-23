import io.mockk.every
import io.mockk.mockk
import math.algorithm.geom.Point2f
import org.junit.jupiter.api.Assertions

import org.junit.jupiter.api.Test


class Point2fTest {

    @Test
    fun calculateAbsDiffXTwoPoints() {
        val p = mockk<Point2f>()

        every { p.x } returns 10.0
        every { p.y } returns 10.0

        /**
         * O metodo abaixo lanca essa exception: io.mockk.MockKException
         * Strict Mocks:
         * */
        Assertions.assertEquals(Point2f(20.0, 35.0), p.translate(10.0, 25.0))
    }
}