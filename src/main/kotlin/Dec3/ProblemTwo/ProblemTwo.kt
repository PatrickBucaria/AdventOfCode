package Dec3.ProblemTwo

import Dec3.GridPosition
import java.io.BufferedReader
import java.io.File
import kotlin.math.max
import kotlin.math.min

fun main() {
    val bufferedReader: BufferedReader = File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/Dec3/input.txt").bufferedReader()
    val inputString: String = bufferedReader.use { it.readText() }

    val engineSchematic: List<String> = inputString.split("\n")

    val engineGrid: MutableList<MutableList<GridPosition>> = mutableListOf()

    engineSchematic.forEachIndexed { rowIndex, schematicLine ->
        val gridLine: MutableList<GridPosition> = mutableListOf()

        var numString = ""
        val charNumIndexes: MutableList<Int> = mutableListOf()

        val trimmedSchematic = schematicLine.trim()
        trimmedSchematic.forEachIndexed { charIndex, char ->
            if (char.isDigit().not() && numString.isNotBlank()) {
                val number = numString.toIntOrNull() ?: 0
                for (colIndex in charNumIndexes) {
                    println("Add Number: $number at Row $rowIndex and Col $colIndex")
                    gridLine.add(GridPosition.NumberAndIndices(number, rowIndex, colIndex, charNumIndexes.last()))
                }

                if (char == '*') {
                    println("Add Star: Row $rowIndex and Col $charIndex")
                    gridLine.add(GridPosition.Star(rowIndex, charIndex))
                } else {
                    println("Add Nothing: Row $rowIndex and Col $charIndex")
                    gridLine.add(GridPosition.Nothing(rowIndex, charIndex))
                }

                numString = ""
                charNumIndexes.clear()
            } else if (char.isDigit() && charIndex == trimmedSchematic.length-1) {
                numString += char
                charNumIndexes.add(charIndex)
                val number = numString.toIntOrNull() ?: 0
                for (colIndex in charNumIndexes) {
                    println("Add Number at End Line: $number at Row $rowIndex and Col $colIndex")
                    gridLine.add(GridPosition.NumberAndIndices(number, rowIndex, colIndex, charNumIndexes.last()))
                }

                numString = ""
                charNumIndexes.clear()
            } else if (char.isDigit()) {
                numString += char
                charNumIndexes.add(charIndex)
            } else if (char == '*') {
                println("Add Star: Row $rowIndex and Col $charIndex")
                gridLine.add(GridPosition.Star(rowIndex, charIndex))
            } else {
                println("Add Nothing: Row $rowIndex and Col $charIndex")
                gridLine.add(GridPosition.Nothing(rowIndex, charIndex))
            }
        }

        engineGrid.add(gridLine)
    }

    println("Length of engine grid ${engineGrid.get(0).size}")
    val result = findGearRatios(engineGrid)
    println("Result == $result")
}
fun findGearRatios(
    engineGrid: List<List<GridPosition>>
): Int {
    val rowMaxIndex = engineGrid.size -1
    val colMaxIndex = (engineGrid.getOrNull(0)?.size ?: 0) - 1
    var result = 0
    for (i in 0..rowMaxIndex) {
        for (x in 0..colMaxIndex) {
            if (engineGrid[i][x] is GridPosition.Star) {
                val gearRatio = findGearRatioForPosition(engineGrid, i, x)
                result += gearRatio
            }
        }
    }
    return result
}

fun findGearRatioForPosition(
    engineGrid: List<List<GridPosition>>,
    rowIndex: Int,
    colIndex: Int
) : Int {
    val rowMaxIndex = engineGrid.size - 1
    val colMaxIndex = (engineGrid.getOrNull(0)?.size ?: 0) - 1

    val startRowIndex: Int = max( rowIndex - 1, 0)
    val endRowIndex: Int = min(rowIndex + 1, rowMaxIndex)

    val startColumnIndex = max(colIndex - 1, 0)
    val endColumnIndex = min(colIndex + 1, colMaxIndex)

    val numbersSurroundingPoint: MutableMap<Int, GridPosition.NumberAndIndices> = mutableMapOf()

    for (i in startRowIndex..endRowIndex) {
        for (x in startColumnIndex..endColumnIndex) {
            val gridPosition: GridPosition = engineGrid[i][x]
            if (gridPosition is GridPosition.NumberAndIndices) {
                numbersSurroundingPoint[gridPosition.num * gridPosition.colEndIndex + gridPosition.rowIndex] = gridPosition
            }
        }
    }

    if (numbersSurroundingPoint.size == 2) {
        val nums = numbersSurroundingPoint.map { it.value }
        val numOne = nums.get(0).num
        val numTwo = nums.get(1).num

        if (numOne == numTwo) {
            println("Two nums together: $numOne")
        }
        val gearRatio = numOne * numTwo
        println("Gear Ratio $gearRatio for row $rowIndex and col $colIndex with num one $numOne and num two $numTwo")
        return gearRatio
    }

    if (numbersSurroundingPoint.size > 2) {
        println("Fucking edge case")
    }
    return 0
}
