package shapes

import com.thomazfb.shapes.ThreeDimensionalShape.*
import com.thomazfb.shapes.TwoDimensionalShape.*
import com.thomazfb.transform.DissectOptions
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

/**
 * Sphere == Circle + Circle
 * Cube == Square + Square
 * Pyramid == Triangle + Triangle
 * Cone == Circle + Triangle
 * Cylinder == Circle + Square
 * Prism == Triangle + Square
 */

class ThreeDimensionalShapeDissectOptionsTest {

    /** From cube */

    @Test
    fun `test dissect generation from CUBE to CONE`() {
        val actual = CUBE generateDissectOptionsToBecome CONE
        val expected = DissectOptions(
            requiredShapes = listOf(TRIANGLE, CIRCLE),
            unwantedShapes = listOf(SQUARE, SQUARE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from CUBE to CYLINDER`() {
        val actual = CUBE generateDissectOptionsToBecome CYLINDER
        val expected = DissectOptions(
            requiredShapes = listOf(CIRCLE),
            unwantedShapes = listOf(SQUARE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from CUBE to PRISM`() {
        val actual = CUBE generateDissectOptionsToBecome PRISM
        val expected = DissectOptions(
            requiredShapes = listOf(TRIANGLE),
            unwantedShapes = listOf(SQUARE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from CUBE to PYRAMID`() {
        val actual = CUBE generateDissectOptionsToBecome PYRAMID
        val expected = DissectOptions(
            requiredShapes = listOf(TRIANGLE, TRIANGLE),
            unwantedShapes = listOf(SQUARE, SQUARE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from CUBE to SPHERE`() {
        val actual = CUBE generateDissectOptionsToBecome SPHERE
        val expected = DissectOptions(
            requiredShapes = listOf(CIRCLE, CIRCLE),
            unwantedShapes = listOf(SQUARE, SQUARE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from CUBE to CUBE`() {
        val actual = CUBE generateDissectOptionsToBecome CUBE
        val expected = DissectOptions(
            requiredShapes = emptyList(),
            unwantedShapes = emptyList()
        )
        assertEquals(expected, actual)
    }

    /** From sphere */

    @Test
    fun `test dissect generation from SPHERE to CONE`() {
        val actual = SPHERE generateDissectOptionsToBecome CONE
        val expected = DissectOptions(
            requiredShapes = listOf(TRIANGLE),
            unwantedShapes = listOf(CIRCLE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from SPHERE to CYLINDER`() {
        val actual = SPHERE generateDissectOptionsToBecome CYLINDER
        val expected = DissectOptions(
            requiredShapes = listOf(SQUARE),
            unwantedShapes = listOf(CIRCLE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from SPHERE to PRISM`() {
        val actual = SPHERE generateDissectOptionsToBecome PRISM
        val expected = DissectOptions(
            requiredShapes = listOf(TRIANGLE, SQUARE),
            unwantedShapes = listOf(CIRCLE, CIRCLE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from SPHERE to PYRAMID`() {
        val actual = SPHERE generateDissectOptionsToBecome PYRAMID
        val expected = DissectOptions(
            requiredShapes = listOf(TRIANGLE, TRIANGLE),
            unwantedShapes = listOf(CIRCLE, CIRCLE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from SPHERE to CUBE`() {
        val actual = SPHERE generateDissectOptionsToBecome CUBE
        val expected = DissectOptions(
            requiredShapes = listOf(SQUARE, SQUARE),
            unwantedShapes = listOf(CIRCLE, CIRCLE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from SPHERE to SPHERE`() {
        val actual = SPHERE generateDissectOptionsToBecome SPHERE
        val expected = DissectOptions(
            requiredShapes = emptyList(),
            unwantedShapes = emptyList()
        )
        assertEquals(expected, actual)
    }

    /** From pyramid */

    @Test
    fun `test dissect generation from PYRAMID to CONE`() {
        val actual = PYRAMID generateDissectOptionsToBecome CONE
        val expected = DissectOptions(
            requiredShapes = listOf(CIRCLE),
            unwantedShapes = listOf(TRIANGLE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from PYRAMID to CYLINDER`() {
        val actual = PYRAMID generateDissectOptionsToBecome CYLINDER
        val expected = DissectOptions(
            requiredShapes = listOf(CIRCLE, SQUARE),
            unwantedShapes = listOf(TRIANGLE, TRIANGLE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from PYRAMID to PRISM`() {
        val actual = PYRAMID generateDissectOptionsToBecome PRISM
        val expected = DissectOptions(
            requiredShapes = listOf(SQUARE),
            unwantedShapes = listOf(TRIANGLE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from PYRAMID to SPHERE`() {
        val actual = PYRAMID generateDissectOptionsToBecome SPHERE
        val expected = DissectOptions(
            requiredShapes = listOf(CIRCLE, CIRCLE),
            unwantedShapes = listOf(TRIANGLE, TRIANGLE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from PYRAMID to CUBE`() {
        val actual = PYRAMID generateDissectOptionsToBecome CUBE
        val expected = DissectOptions(
            requiredShapes = listOf(SQUARE, SQUARE),
            unwantedShapes = listOf(TRIANGLE, TRIANGLE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from PYRAMID to PYRAMID`() {
        val actual = PYRAMID generateDissectOptionsToBecome PYRAMID
        val expected = DissectOptions(
            requiredShapes = emptyList(),
            unwantedShapes = emptyList()
        )
        assertEquals(expected, actual)
    }

    /** From cone */

    @Test
    fun `test dissect generation from CONE to CONE`() {
        val actual = CONE generateDissectOptionsToBecome CONE
        val expected = DissectOptions(
            requiredShapes = emptyList(),
            unwantedShapes = emptyList()
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from CONE to CYLINDER`() {
        val actual = CONE generateDissectOptionsToBecome CYLINDER
        val expected = DissectOptions(
            requiredShapes = listOf(SQUARE),
            unwantedShapes = listOf(TRIANGLE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from CONE to PRISM`() {
        val actual = CONE generateDissectOptionsToBecome PRISM
        val expected = DissectOptions(
            requiredShapes = listOf(SQUARE),
            unwantedShapes = listOf(CIRCLE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from CONE to SPHERE`() {
        val actual = CONE generateDissectOptionsToBecome SPHERE
        val expected = DissectOptions(
            requiredShapes = listOf(CIRCLE),
            unwantedShapes = listOf(TRIANGLE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from CONE to CUBE`() {
        val actual = CONE generateDissectOptionsToBecome CUBE
        val expected = DissectOptions(
            requiredShapes = listOf(SQUARE, SQUARE),
            unwantedShapes = listOf(TRIANGLE, CIRCLE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from CONE to PYRAMID`() {
        val actual = CONE generateDissectOptionsToBecome PYRAMID
        val expected = DissectOptions(
            requiredShapes = listOf(TRIANGLE),
            unwantedShapes = listOf(CIRCLE)
        )
        assertEquals(expected, actual)
    }

    /** From cylinder */

    @Test
    fun `test dissect generation from CYLINDER to CONE`() {
        val actual = CYLINDER generateDissectOptionsToBecome CONE
        val expected = DissectOptions(
            requiredShapes = listOf(TRIANGLE),
            unwantedShapes = listOf(SQUARE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from CYLINDER to CYLINDER`() {
        val actual = CYLINDER generateDissectOptionsToBecome CYLINDER
        val expected = DissectOptions(
            requiredShapes = emptyList(),
            unwantedShapes = emptyList()
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from CYLINDER to PRISM`() {
        val actual = CYLINDER generateDissectOptionsToBecome PRISM
        val expected = DissectOptions(
            requiredShapes = listOf(TRIANGLE),
            unwantedShapes = listOf(CIRCLE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from CYLINDER to SPHERE`() {
        val actual = CYLINDER generateDissectOptionsToBecome SPHERE
        val expected = DissectOptions(
            requiredShapes = listOf(CIRCLE),
            unwantedShapes = listOf(SQUARE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from CYLINDER to CUBE`() {
        val actual = CYLINDER generateDissectOptionsToBecome CUBE
        val expected = DissectOptions(
            requiredShapes = listOf(SQUARE),
            unwantedShapes = listOf(CIRCLE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from CYLINDER to PYRAMID`() {
        val actual = CYLINDER generateDissectOptionsToBecome PYRAMID
        val expected = DissectOptions(
            requiredShapes = listOf(TRIANGLE, TRIANGLE),
            unwantedShapes = listOf(CIRCLE, SQUARE)
        )
        assertEquals(expected, actual)
    }

    /** From prism */

    @Test
    fun `test dissect generation from PRISM to CONE`() {
        val actual = PRISM generateDissectOptionsToBecome CONE
        val expected = DissectOptions(
            requiredShapes = listOf(CIRCLE),
            unwantedShapes = listOf(SQUARE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from PRISM to CYLINDER`() {
        val actual = PRISM generateDissectOptionsToBecome CYLINDER
        val expected = DissectOptions(
            requiredShapes = listOf(CIRCLE),
            unwantedShapes = listOf(TRIANGLE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from PRISM to PRISM`() {
        val actual = PRISM generateDissectOptionsToBecome PRISM
        val expected = DissectOptions(
            requiredShapes = emptyList(),
            unwantedShapes = emptyList()
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from PRISM to SPHERE`() {
        val actual = PRISM generateDissectOptionsToBecome SPHERE
        val expected = DissectOptions(
            requiredShapes = listOf(CIRCLE, CIRCLE),
            unwantedShapes = listOf(TRIANGLE, SQUARE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from PRISM to CUBE`() {
        val actual = PRISM generateDissectOptionsToBecome CUBE
        val expected = DissectOptions(
            requiredShapes = listOf(SQUARE),
            unwantedShapes = listOf(TRIANGLE)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `test dissect generation from PRISM to PYRAMID`() {
        val actual = PRISM generateDissectOptionsToBecome PYRAMID
        val expected = DissectOptions(
            requiredShapes = listOf(TRIANGLE),
            unwantedShapes = listOf(SQUARE)
        )
        assertEquals(expected, actual)
    }
}
