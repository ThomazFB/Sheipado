package com.thomazfb

import com.thomazfb.encounter.EncounterCycle
import com.thomazfb.encounter.ExternalRoom
import com.thomazfb.encounter.InternalRoom
import com.thomazfb.shapes.ThreeDimensionalShape.*
import com.thomazfb.shapes.TwoDimensionalShape.*
import com.thomazfb.transform.DissectStep

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/**
 * This is a Verity calculator created by [https://github.com/ThomazFB]
 *
 * * --------------------------------------------------------------------------
 *
 * For those who have no idea of what is Verity:
 *
 * Verity is an encounter inside the Destiny 2 game, and was created to help
 * our team to solve a specific challenge within the game.
 *
 * If you don't know anything regarding this game or its raids,
 * this code will have no use for you.
 *
 * ----------------------------------------------------------------------------
 *
 * For those who know about Destiny 2 and the Salvation's Edge raid:
 *
 * This calculator is focused to help the person taking care of the dissections during the Verity encounter.
 *
 * It's capable of not only generating the steps for the normal dissections,
 * but also for the Varied Geometry challenge. Simply create an [EncounterCycle] with the
 * [EncounterCycle.shouldTargetPureShapes] parameter as true,
 * and the steps will be generated targeting pure shapes.
 *
 * Be sure to sync with your raid team the following Internal Room strategy:
 *
 * The Internal Room holding a [TRIANGLE] will flee with a [CUBE] shape
 * The Internal Room holding a [SQUARE] will flee with a [SPHERE] shape
 * The Internal Room holding a [CIRCLE] will flee with a [PYRAMID] shape
 *
 */
fun main() {
    EncounterCycle(
        internalRoom = InternalRoom(
            leftShape = CIRCLE,
            middleShape = SQUARE,
            rightShape = TRIANGLE
        ),
        initialExternalRoom = ExternalRoom(
            leftShape = CONE,
            middleShape = CYLINDER,
            rightShape = PRISM
        ),
        shouldTargetPureShapes = true
    ).start().print()
}

fun List<DissectStep>.print() = forEachIndexed { index, step ->
    println("Step ${index + 1}")
    println("Dissect ${step.firstStatue.first} from ${step.firstStatue.second}")
    println("Dissect ${step.secondStatue.first} from ${step.secondStatue.second}")
    println()
    print("Left: ${step.expectedRoom.leftShape} | ")
    print("Middle: ${step.expectedRoom.middleShape} | ")
    println("Right: ${step.expectedRoom.rightShape}")
    println("========================")
    println(" ")
}
