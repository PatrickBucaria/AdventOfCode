package twentytwentythree.Dec2

import kotlin.math.min

data class Game(
    val id: Int,
    val drawings: List<Drawing>
) {

    fun isPossibleGivenValues(
        numRed: Int,
        numGreen: Int,
        numBlue: Int
    ): Boolean {
        drawings.forEach { drawing ->
            if (!drawing.isPossibleGivenValues(numRed, numGreen, numBlue)) {
                return false
            }
        }
        return true
    }

    fun getMinimumSetPossible() : MinSetPossible {
        var minGreenNeeded = 0
        var minRedNeeded = 0
        var minBlueNeeded = 0

        drawings.forEach { drawing ->
            if (minGreenNeeded < drawing.green) {
                minGreenNeeded = drawing.green
            }
            if (minRedNeeded < drawing.red) {
                minRedNeeded = drawing.red
            }
            if (minBlueNeeded < drawing.blue) {
                minBlueNeeded = drawing.blue
            }
        }

        return MinSetPossible(
            red = minRedNeeded,
            blue = minBlueNeeded,
            green = minGreenNeeded
        )
    }
}
