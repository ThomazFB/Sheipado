package com.thomazfb.transform

import com.thomazfb.encounter.ExternalRoom
import com.thomazfb.encounter.StatuePosition
import com.thomazfb.shapes.TwoDimensionalShape

/**
 * An incomplete 3D shape == both 2D shapes are incorrect
 * A half complete 3D shape == one 2D shape is correct
 * A complete 3D shape == both 2D shapes are correct
 */
fun dissect(
    current: ExternalRoom,
    target: ExternalRoom
) : DissectStep {
    val leftDissectOptions = current.leftShape generateDissectOptionsToBecome target.leftShape
    val middleDissectOptions = current.middleShape generateDissectOptionsToBecome target.middleShape
    val rightDissectOptions = current.rightShape generateDissectOptionsToBecome target.rightShape

    var incompleteShapesCount = 0
    var halfCompleteShapesCount = 0
    var completeShapesCount = 0

    listOf(leftDissectOptions, middleDissectOptions, rightDissectOptions).forEach {
        when {
            it.isIncomplete -> incompleteShapesCount++
            it.isHalfComplete -> halfCompleteShapesCount++
            it.isComplete -> completeShapesCount++
        }
    }

    return when {
        incompleteShapesCount == 3 -> simplify(current)
        (incompleteShapesCount == 1 && halfCompleteShapesCount == 2) ||
                (incompleteShapesCount == 2 && halfCompleteShapesCount == 1) -> prioritize(
            current,
            leftDissectOptions,
            middleDissectOptions,
            rightDissectOptions
        )
        halfCompleteShapesCount == 3 -> purify(
            current,
            leftDissectOptions,
            middleDissectOptions,
            rightDissectOptions
        )
        else -> finish(
            current,
            leftDissectOptions,
            middleDissectOptions,
            rightDissectOptions
        )
    }
}

/**
 * All statues are incomplete, simplify by always switching left with middle
 */
private fun simplify(
    currentRoom: ExternalRoom
): DissectStep {
    val middleToLeft = currentRoom.middleShape.twoDimensionalShapes.first
    val leftToMiddle = currentRoom.leftShape.twoDimensionalShapes.first
    return leftWithMiddle(currentRoom, middleToLeft, leftToMiddle)
}

/**
 * One statue has two incorrect shapes, and the others have only one
 *
 * Switch the statue with two incorrect shapes with a statue with only one incorrect shape
 *
 * Since there are two statues with just one incorrect shape, the selected one is the one that will
 * become correct after the switch
 */
private fun prioritize(
    current: ExternalRoom,
    leftDissectOptions: DissectOptions,
    middleDissectOptions: DissectOptions,
    rightDissectOptions: DissectOptions
): DissectStep {
    when {
        leftDissectOptions.isIncomplete -> {
            val leftShape = current.leftShape.twoDimensionalShapes.first

            middleDissectOptions.requiredShapes.find { it == leftShape }?.let {
                val middleToLeft = middleDissectOptions.unwantedShapes.first()
                return leftWithMiddle(current, middleToLeft, leftShape)
            }

            rightDissectOptions.requiredShapes.find { it == leftShape }?.let {
                val rightToLeft = rightDissectOptions.unwantedShapes.first()
                return leftWithRight(current, rightToLeft, leftShape)
            }

            throw IllegalArgumentException("Impossible operation")
        }

        middleDissectOptions.isIncomplete -> {
            val middleShape = current.middleShape.twoDimensionalShapes.first

            leftDissectOptions.requiredShapes.find { it == middleShape }?.let {
                val leftToMiddle = leftDissectOptions.unwantedShapes.first()
                return leftWithMiddle(current, middleShape, leftToMiddle)
            }

            rightDissectOptions.requiredShapes.find { it == middleShape }?.let {
                val rightToMiddle = rightDissectOptions.unwantedShapes.first()
                return middleWithRight(current, rightToMiddle, middleShape)
            }

            throw IllegalArgumentException("Impossible operation")
        }

        rightDissectOptions.isIncomplete -> {
            val rightShape = current.rightShape.twoDimensionalShapes.first

            leftDissectOptions.requiredShapes.find { it == rightShape }?.let {
                val leftToRight = leftDissectOptions.unwantedShapes.first()
                return leftWithRight(current, rightShape, leftToRight)
            }

            middleDissectOptions.requiredShapes.find { it == rightShape }?.let {
                val middleToRight = middleDissectOptions.unwantedShapes.first()
                return middleWithRight(current, middleToRight, rightShape)
            }

            throw IllegalArgumentException("Impossible operation")
        }

        else -> throw IllegalArgumentException("Impossible operation")
    }
}

/**
 * All statues have only one incorrect shape
 *
 * Select a switch where one statue will become a pure shape and the other will become correct
 */
private fun purify(
    current: ExternalRoom,
    leftDissectOptions: DissectOptions,
    middleDissectOptions: DissectOptions,
    rightDissectOptions: DissectOptions
): DissectStep {
    val leftUnwantedShape = leftDissectOptions.unwantedShapes.first()

    current.middleShape.twoDimensionalShapes.toList().find { it == leftUnwantedShape }?.let {
        val middleToLeft = middleDissectOptions.unwantedShapes.first()
        return leftWithMiddle(current, middleToLeft, leftUnwantedShape)
    }

    current.rightShape.twoDimensionalShapes.toList().find { it == leftUnwantedShape }?.let {
        val rightToLeft = rightDissectOptions.unwantedShapes.first()
        return leftWithRight(current, rightToLeft, leftUnwantedShape)
    }

    throw IllegalArgumentException("Impossible operation")
}

/**
 * One statue is fully correct, and the other two have only one incorrect shape each
 *
 * The only possible switch to finish the sequence
 */
private fun finish(
    current: ExternalRoom,
    leftDissectOptions: DissectOptions,
    middleDissectOptions: DissectOptions,
    rightDissectOptions: DissectOptions
): DissectStep {
    when {
        leftDissectOptions.isComplete -> {
            val middleToRight = middleDissectOptions.unwantedShapes.first()
            val rightToMiddle = rightDissectOptions.unwantedShapes.first()
            return middleWithRight(current, rightToMiddle, middleToRight)
        }

        middleDissectOptions.isComplete -> {
            val leftToRight = leftDissectOptions.unwantedShapes.first()
            val rightToLeft = rightDissectOptions.unwantedShapes.first()
            return leftWithRight(current, rightToLeft, leftToRight)
        }

        rightDissectOptions.isComplete -> {
            val leftToMiddle = leftDissectOptions.unwantedShapes.first()
            val middleToLeft = middleDissectOptions.unwantedShapes.first()
            return leftWithMiddle(current, middleToLeft, leftToMiddle)
        }

        else -> throw IllegalArgumentException("Impossible operation")
    }
}

private fun leftWithMiddle(
    currentRoom: ExternalRoom,
    middleToLeft: TwoDimensionalShape,
    leftToMiddle: TwoDimensionalShape
): DissectStep {
    val transformedLeft = currentRoom.leftShape.transform(
        receiving = middleToLeft,
        removing = leftToMiddle
    )

    val transformedMiddle = currentRoom.middleShape.transform(
        receiving = leftToMiddle,
        removing = middleToLeft
    )

    return DissectStep(
        firstStatue = Pair(middleToLeft, StatuePosition.MIDDLE),
        secondStatue = Pair(leftToMiddle, StatuePosition.LEFT),
        expectedRoom = currentRoom.copy(
            leftShape = transformedLeft,
            middleShape = transformedMiddle
        )
    )
}

private fun leftWithRight(
    currentRoom: ExternalRoom,
    rightToLeft: TwoDimensionalShape,
    leftToRight: TwoDimensionalShape
): DissectStep {
    val transformedLeft = currentRoom.leftShape.transform(
        receiving = rightToLeft,
        removing = leftToRight
    )

    val transformedRight = currentRoom.rightShape.transform(
        receiving = leftToRight,
        removing = rightToLeft
    )

    return DissectStep(
        firstStatue = Pair(rightToLeft, StatuePosition.RIGHT),
        secondStatue = Pair(leftToRight, StatuePosition.LEFT),
        expectedRoom = currentRoom.copy(
            leftShape = transformedLeft,
            rightShape = transformedRight
        )
    )
}

private fun middleWithRight(
    currentRoom: ExternalRoom,
    rightToMiddle: TwoDimensionalShape,
    middleToRight: TwoDimensionalShape
): DissectStep {
    val transformedMiddle = currentRoom.middleShape.transform(
        receiving = rightToMiddle,
        removing = middleToRight
    )

    val transformedRight = currentRoom.rightShape.transform(
        receiving = middleToRight,
        removing = rightToMiddle
    )

    return DissectStep(
        firstStatue = Pair(rightToMiddle, StatuePosition.RIGHT),
        secondStatue = Pair(middleToRight, StatuePosition.MIDDLE),
        expectedRoom = currentRoom.copy(
            middleShape = transformedMiddle,
            rightShape = transformedRight
        )
    )
}