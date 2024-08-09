package com.thomazfb.transform

import com.thomazfb.shapes.TwoDimensionalShape

data class DissectOptions(
    val requiredShapes: List<TwoDimensionalShape>,
    val unwantedShapes: List<TwoDimensionalShape>
) {
    val isIncomplete = unwantedShapes.size == 2
    val isHalfComplete = unwantedShapes.size == 1
    val isComplete = unwantedShapes.isEmpty()
}
