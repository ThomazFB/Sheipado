package com.thomazfb.shapes

import com.thomazfb.shapes.ThreeDimensionalShapeType.MIXED
import com.thomazfb.shapes.TwoDimensionalShape.*
import com.thomazfb.transform.DissectOptions

typealias TwoDimensionalShapes = Pair<TwoDimensionalShape, TwoDimensionalShape>

sealed class ThreeDimensionalShape(
    val twoDimensionalShapes: TwoDimensionalShapes
) {
    data object CUBE : ThreeDimensionalShape(SQUARE to SQUARE)
    data object PYRAMID : ThreeDimensionalShape(TRIANGLE to TRIANGLE)
    data object SPHERE : ThreeDimensionalShape(CIRCLE to CIRCLE)
    data object CONE : ThreeDimensionalShape(TRIANGLE to CIRCLE)
    data object CYLINDER : ThreeDimensionalShape(CIRCLE to SQUARE)
    data object PRISM : ThreeDimensionalShape(TRIANGLE to SQUARE)

    val type: ThreeDimensionalShapeType
        get() = when {
            twoDimensionalShapes.first == twoDimensionalShapes.second -> ThreeDimensionalShapeType.PURE
            else -> MIXED
        }

    infix fun generateDissectOptionsToBecome(targetShape: ThreeDimensionalShape): DissectOptions {
        if (this == targetShape) return DissectOptions(emptyList(), emptyList())

        return DissectOptions(
            requiredShapes = targetShape.twoDimensionalShapes dissectedFrom this.twoDimensionalShapes,
            unwantedShapes = this.twoDimensionalShapes dissectedFrom targetShape.twoDimensionalShapes
        )
    }

    fun transform(
        receiving: TwoDimensionalShape,
        removing: TwoDimensionalShape
    ): ThreeDimensionalShape {
        val transformingShapes = twoDimensionalShapes.toList()

        if (removing !in transformingShapes) {
            return this
        }

        return transformingShapes.toMutableList()
            .apply {
                remove(removing)
                add(receiving)
            }.let { Pair(it.first(), it.last()) }
            .let { fromTwoDimensionalShapes(it) }
    }

    private infix fun TwoDimensionalShapes.dissectedFrom(
        other: TwoDimensionalShapes
    ) = this.toList().let {
        it.minus(other.toList())
            .takeIf { it.isNotEmpty() }
            ?: listOf(it.random())
    }

    private fun fromTwoDimensionalShapes(
        shapes: TwoDimensionalShapes
    ): ThreeDimensionalShape = when (shapes) {
        SPHERE.twoDimensionalShapes -> SPHERE
        CUBE.twoDimensionalShapes -> CUBE
        PYRAMID.twoDimensionalShapes -> PYRAMID
        (SQUARE to CIRCLE), (CIRCLE to SQUARE) -> CYLINDER
        (TRIANGLE to CIRCLE), (CIRCLE to TRIANGLE) -> CONE
        (TRIANGLE to SQUARE), (SQUARE to TRIANGLE) -> PRISM
        else -> throw IllegalArgumentException("Impossible shape")
    }
}

enum class ThreeDimensionalShapeType {
    MIXED,
    PURE
}