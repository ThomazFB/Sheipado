package shapes

import com.thomazfb.shapes.ThreeDimensionalShape.*
import com.thomazfb.shapes.TwoDimensionalShape.*
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class ThreeDimensionalShapeTransformTest {

    /** Cube transformations */

    @Test
    fun `test transform CUBE receiving CIRCLE and removing SQUARE`() {
        val transformed = CUBE.transform(
            receiving = CIRCLE,
            removing = SQUARE
        )

        assertEquals(CYLINDER, transformed)
    }

    @Test
    fun `test transform CUBE receiving TRIANGLE and removing SQUARE`() {
        val transformed = CUBE.transform(
            receiving = TRIANGLE,
            removing = SQUARE
        )

        assertEquals(PRISM, transformed)
    }

    @Test
    fun `test transform CUBE receiving SQUARE and removing SQUARE`() {
        val transformed = CUBE.transform(
            receiving = SQUARE,
            removing = SQUARE
        )

        assertEquals(CUBE, transformed)
    }

    /** Sphere transformations */

    @Test
    fun `test transform SPHERE receiving TRIANGLE and removing CIRCLE`() {
        val transformed = SPHERE.transform(
            receiving = TRIANGLE,
            removing = CIRCLE
        )

        assertEquals(CONE, transformed)
    }

    @Test
    fun `test transform SPHERE receiving SQUARE and removing CIRCLE`() {
        val transformed = SPHERE.transform(
            receiving = SQUARE,
            removing = CIRCLE
        )

        assertEquals(CYLINDER, transformed)
    }

    @Test
    fun `test transform SPHERE receiving CIRCLE and removing CIRCLE`() {
        val transformed = SPHERE.transform(
            receiving = CIRCLE,
            removing = CIRCLE
        )

        assertEquals(SPHERE, transformed)
    }

    /** Pyramid transformations */

    @Test
    fun `test transform PYRAMID receiving CIRCLE and removing TRIANGLE`() {
        val transformed = PYRAMID.transform(
            receiving = CIRCLE,
            removing = TRIANGLE
        )

        assertEquals(CONE, transformed)
    }

    @Test
    fun `test transform PYRAMID receiving SQUARE and removing TRIANGLE`() {
        val transformed = PYRAMID.transform(
            receiving = SQUARE,
            removing = TRIANGLE
        )

        assertEquals(PRISM, transformed)
    }

    @Test
    fun `test transform PYRAMID receiving TRIANGLE and removing TRIANGLE`() {
        val transformed = PYRAMID.transform(
            receiving = TRIANGLE,
            removing = TRIANGLE
        )

        assertEquals(PYRAMID, transformed)
    }

    /** Cylinder transformations */

    @Test
    fun `test transform CYLINDER receiving CIRCLE and removing SQUARE`() {
        val transformed = CYLINDER.transform(
            receiving = CIRCLE,
            removing = SQUARE
        )

        assertEquals(SPHERE, transformed)
    }

    @Test
    fun `test transform CYLINDER receiving TRIANGLE and removing SQUARE`() {
        val transformed = CYLINDER.transform(
            receiving = TRIANGLE,
            removing = SQUARE
        )

        assertEquals(CONE, transformed)
    }

    @Test
    fun `test transform CYLINDER receiving SQUARE and removing CIRCLE`() {
        val transformed = CYLINDER.transform(
            receiving = SQUARE,
            removing = CIRCLE
        )

        assertEquals(CUBE, transformed)
    }

    @Test
    fun `test transform CYLINDER receiving TRIANGLE and removing CIRCLE`() {
        val transformed = CYLINDER.transform(
            receiving = TRIANGLE,
            removing = CIRCLE
        )

        assertEquals(PRISM, transformed)
    }

    /** Cone transformations */

    @Test
    fun `test transform CONE receiving CIRCLE and removing TRIANGLE`() {
        val transformed = CONE.transform(
            receiving = CIRCLE,
            removing = TRIANGLE
        )

        assertEquals(SPHERE, transformed)
    }

    @Test
    fun `test transform CONE receiving TRIANGLE and removing CIRCLE`() {
        val transformed = CONE.transform(
            receiving = TRIANGLE,
            removing = CIRCLE
        )

        assertEquals(PYRAMID, transformed)
    }

    @Test
    fun `test transform CONE receiving SQUARE and removing TRIANGLE`() {
        val transformed = CONE.transform(
            receiving = SQUARE,
            removing = TRIANGLE
        )

        assertEquals(CYLINDER, transformed)
    }

    @Test
    fun `test transform CONE receiving SQUARE and removing CIRCLE`() {
        val transformed = CONE.transform(
            receiving = SQUARE,
            removing = CIRCLE
        )

        assertEquals(PRISM, transformed)
    }

    /** Prism transformations */

    @Test
    fun `test transform PRISM receiving CIRCLE and removing SQUARE`() {
        val transformed = PRISM.transform(
            receiving = CIRCLE,
            removing = SQUARE
        )

        assertEquals(CONE, transformed)
    }

    @Test
    fun `test transform PRISM receiving TRIANGLE and removing SQUARE`() {
        val transformed = PRISM.transform(
            receiving = TRIANGLE,
            removing = SQUARE
        )

        assertEquals(PYRAMID, transformed)
    }

    @Test
    fun `test transform PRISM receiving CIRCLE and removing TRIANGLE`() {
        val transformed = PRISM.transform(
            receiving = CIRCLE,
            removing = TRIANGLE
        )

        assertEquals(CYLINDER, transformed)
    }

    @Test
    fun `test transform PRISM receiving SQUARE and removing TRIANGLE`() {
        val transformed = PRISM.transform(
            receiving = SQUARE,
            removing = TRIANGLE
        )

        assertEquals(CUBE, transformed)
    }
}