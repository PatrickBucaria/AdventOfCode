package Dec2.ProblemTwo

import Dec2.Drawing
import Dec2.Game
import java.io.BufferedReader
import java.io.File
import kotlin.math.min

const val RED = "red"
const val BLUE = "blue"
const val GREEN = "green"

const val NUM_RED_CUBES = 12
const val NUM_GREEN_CUBES = 13
const val NUM_BLUE_CUBES = 14

fun main() {
    val bufferedReader: BufferedReader = File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/Dec2/input.txt").bufferedReader()
    val inputString: String = bufferedReader.use { it.readText() }

    val games: List<Game> = inputString.split("\n").mapNotNull { gameString ->
        val trimmed: String = gameString.substring(5)

        // Separate Game ID from Drawing
        val gameIdsAndDrawings = trimmed.split(":")

        // Grabbing ID for the game
        val gameId = gameIdsAndDrawings.getOrNull(0)?.toIntOrNull()

        if (gameId == null) {
            println("Null for this trimmed gamestring: ${trimmed}")
            null
        } else {
            println("GameId = ${gameId}")

            val drawingStrings: List<List<String>>? = gameIdsAndDrawings
                .getOrNull(1)
                ?.split(";")
                ?.map { it
                    .split(",")
                    .map { it.trim() }
                }

            if (drawingStrings == null) {
                println("Null drawing strings for this trimmed gamestring: ${trimmed}")
                null

            } else {
                val drawings: List<Drawing> = drawingStrings.map { colorValues ->
                    var blue = 0
                    var red = 0
                    var green = 0

                    colorValues.forEach { colorValue ->
                        blue += colorValue.returnNumberOfColorFound(BLUE)
                        red += colorValue.returnNumberOfColorFound(RED)
                        green += colorValue.returnNumberOfColorFound(GREEN)
                    }

                    println("Drawing with values red$red blue$blue green$green")
                    Drawing(
                        red = red,
                        blue = blue,
                        green = green
                    )
                }
                Game(
                    id = gameId,
                    drawings = drawings
                )
            }
        }
    }

    var result = 0
    games.forEach { game ->
        val minSet = game.getMinimumSetPossible()

        println("Min Set for Game Id ${game.id} is red ${minSet.red}, green ${minSet.green}, blue ${minSet.blue}")

        result += minSet.getPower()
    }

    println("Result == $result")
}

fun String.returnNumberOfColorFound(color: String): Int {
    return if (this.contains(color)) {
        this.dropLast(color.length + 1).toIntOrNull() ?: 0
    } else {
        0
    }
}

