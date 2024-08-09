package com.thomazfb.transform

import com.thomazfb.encounter.ExternalRoom
import com.thomazfb.encounter.StatuePosition
import com.thomazfb.shapes.TwoDimensionalShape

data class DissectStep(
    val firstStatue: Pair<TwoDimensionalShape, StatuePosition>,
    val secondStatue: Pair<TwoDimensionalShape, StatuePosition>,
    val expectedRoom: ExternalRoom
)