package com.thomazfb.encounter

import com.thomazfb.shapes.ThreeDimensionalShape
import com.thomazfb.shapes.TwoDimensionalShape

data class ExternalRoom(
    val leftShape: ThreeDimensionalShape,
    val middleShape: ThreeDimensionalShape,
    val rightShape: ThreeDimensionalShape
)

data class InternalRoom(
    val leftShape: TwoDimensionalShape,
    val middleShape: TwoDimensionalShape,
    val rightShape: TwoDimensionalShape
)

enum class StatuePosition {
    LEFT,
    MIDDLE,
    RIGHT
}