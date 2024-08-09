package encounter

import com.thomazfb.encounter.EncounterCycle
import com.thomazfb.encounter.ExternalRoom
import com.thomazfb.encounter.InternalRoom
import com.thomazfb.shapes.ThreeDimensionalShape.*
import com.thomazfb.shapes.TwoDimensionalShape.*
import com.thomazfb.transform.DissectStep
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class EncounterCycleTest {
    @Test
    fun `test three steps encounter cycle`() {
        val cycle = EncounterCycle(
            internalRoom = InternalRoom(
                leftShape = TRIANGLE,
                middleShape = CIRCLE,
                rightShape = SQUARE
            ),
            initialExternalRoom = ExternalRoom(
                leftShape = PYRAMID,
                middleShape = SPHERE,
                rightShape = CUBE
            )
        )

        val result = cycle.start()

        printResult(result)

        assert(result.size == 3)
        assertThat(result.last().expectedRoom).isEqualTo(
            ExternalRoom(
                leftShape = CYLINDER,
                middleShape = PRISM,
                rightShape = CONE
            )
        )
    }

    @Test
    fun `test one step encounter cycle`() {
        val cycle = EncounterCycle(
            internalRoom = InternalRoom(
                leftShape = SQUARE,
                middleShape = CIRCLE,
                rightShape = TRIANGLE
            ),
            initialExternalRoom = ExternalRoom(
                leftShape = CONE,
                middleShape = CUBE,
                rightShape = CONE
            )
        )

        val result = cycle.start()

        printResult(result)

        assert(result.size == 1)
        assertThat(result.last().expectedRoom).isEqualTo(
            ExternalRoom(
                leftShape = CONE,
                middleShape = PRISM,
                rightShape = CYLINDER
            )
        )
    }

    @Test
    fun `test two steps encounter cycle`() {
        val cycle = EncounterCycle(
            internalRoom = InternalRoom(
                leftShape = SQUARE,
                middleShape = CIRCLE,
                rightShape = TRIANGLE
            ),
            initialExternalRoom = ExternalRoom(
                leftShape = PRISM,
                middleShape = CYLINDER,
                rightShape = CONE
            )
        )

        val result = cycle.start()

        printResult(result)

        assert(result.size == 2)
        assertThat(result.last().expectedRoom).isEqualTo(
            ExternalRoom(
                leftShape = CONE,
                middleShape = PRISM,
                rightShape = CYLINDER
            )
        )
    }

    @Test
    fun `test pure shape encounter cycle`() {
        val cycle = EncounterCycle(
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
        )

        val result = cycle.start()
        printResult(result)
        assertThat(result).isNotEmpty
    }

    private fun printResult(result: List<DissectStep>) {
        result.forEachIndexed { index, step ->
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
    }
}