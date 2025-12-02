package twentytwentythree.Dec3.ProblemOne

import java.io.BufferedReader
import java.io.File
import kotlin.math.max
import kotlin.math.min

fun main() {
    val bufferedReader: BufferedReader = File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/Dec3/input.txt").bufferedReader()
    val inputString: String = bufferedReader.use { it.readText() }

    val engineSchematic: List<String> = inputString.split("\n")

    var result: Int = 0
    engineSchematic.forEachIndexed { lineIndex, schematicLine ->
        var numString = ""
        val charIndices: MutableList<Int> = mutableListOf()

        val trimmedSchematic = schematicLine.trim()
        trimmedSchematic.forEachIndexed { charIndex, char ->
            if (char.isDigit().not() && numString.isNotBlank()) {
                // start search here
                val isPartNumber = isAPartNumber(engineSchematic, lineIndex, charIndices)
                val number = numString.toIntOrNull() ?: 0

                if (isPartNumber) {
                    println("FOUND: $number is a part number")
                    result += number
                } else {
                    println("NOT FOUND: $number is a not a part number")

                }
                numString = ""
                charIndices.clear()
            } else if (char.isDigit() && charIndex == trimmedSchematic.length-1) {
                numString += char
                charIndices.add(charIndex)

                val isPartNumber = isAPartNumber(engineSchematic, lineIndex, charIndices)
                val number = numString.toIntOrNull() ?: 0

                if (isPartNumber) {
                    println("End line FOUND: $number is a part number")
                    result += number
                } else {
                    println("End line NOT FOUND: $number is a not a part number")

                }
                numString = ""
                charIndices.clear()
            } else if (char.isDigit()) {
                numString += char
                charIndices.add(charIndex)
            }
        }

    }


    println("Result == $result")
}


fun getGearForStarOrNull(
    engineSchematic: List<String>,

    )  {

}
fun isAPartNumber(
    engineSchematic: List<String>,
    lineIndex: Int,
    charIndices: List<Int>,
) : Boolean {
    val rowMaxIndex = engineSchematic.size - 1
    val colMaxIndex = (engineSchematic.getOrNull(0)?.length ?: 0) - 1

    val startLineIndex: Int = max( lineIndex - 1, 0)
    val endLineIndex: Int = min(lineIndex + 1, rowMaxIndex)

    val startColumnIndex = max((charIndices.getOrNull(0) ?: 0) - 1, 0)
    val endColumnIndex = min((charIndices.lastOrNull() ?: 0) + 1, colMaxIndex)

    for (i in startLineIndex..endLineIndex) {
        for (x in startColumnIndex..endColumnIndex) {
            val char: Char = engineSchematic[i][x]
            if (!char.isDigit() && char != '.') {
                return true
            }
        }
    }
    return false
}
