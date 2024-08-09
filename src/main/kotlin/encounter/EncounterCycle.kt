package com.thomazfb.encounter

import com.thomazfb.shapes.ThreeDimensionalShape
import com.thomazfb.shapes.TwoDimensionalShape
import com.thomazfb.transform.DissectStep
import com.thomazfb.transform.dissect

class EncounterCycle(
    private val internalRoom: InternalRoom,
    private val initialExternalRoom: ExternalRoom,
    private val shouldTargetPureShapes: Boolean = false
) {
    fun start(): List<DissectStep> {
        val leftShapeKey = generateTarget3DShape(internalRoom.leftShape)
        val middleShapeKey = generateTarget3DShape(internalRoom.middleShape)
        val rightShapeKey = generateTarget3DShape(internalRoom.rightShape)
        return generateSteps(ExternalRoom(leftShapeKey, middleShapeKey, rightShapeKey))
    }

    private fun generateTarget3DShape(twoDShape: TwoDimensionalShape): ThreeDimensionalShape {
        return when (shouldTargetPureShapes) {
            true -> twoDShape.pureThreeShapeTarget()
            else -> twoDShape.mixedThreeShapeTarget()
        }
    }

    private fun generateSteps(
        targetExternalRoom: ExternalRoom
    ): List<DissectStep> {
        val dissectSteps = mutableListOf<DissectStep>()
        var operatingExternalRoom = initialExternalRoom

        while (operatingExternalRoom != targetExternalRoom) {
            dissect(operatingExternalRoom, targetExternalRoom).let {
                dissectSteps.add(it)
                operatingExternalRoom = it.expectedRoom
            }
        }

        return dissectSteps
    }
}