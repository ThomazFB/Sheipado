package com.thomazfb.shapes

import com.thomazfb.shapes.ThreeDimensionalShape.*

enum class TwoDimensionalShape {
    TRIANGLE,
    SQUARE,
    CIRCLE;

    fun mixedThreeShapeTarget(): ThreeDimensionalShape {
        return when (this) {
            TRIANGLE -> CYLINDER
            SQUARE -> CONE
            CIRCLE -> PRISM
        }
    }

    fun pureThreeShapeTarget(): ThreeDimensionalShape {
        return when (this) {
            TRIANGLE -> CUBE
            SQUARE -> SPHERE
            CIRCLE -> PYRAMID
        }
    }
}