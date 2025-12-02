package twentytwentythree.Dec4.ProblemOne

import java.io.BufferedReader
import java.io.File
import kotlin.math.pow

fun main() {
    val bufferedReader: BufferedReader = File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/Dec4/input.txt").bufferedReader()
    val result = bufferedReader.use { it.readText() }
        .split("\n")
        .asSequence()
        .map {
            val cardNumToValues = it.drop(4)
                .split(":")

            val num = cardNumToValues.get(0).trim().toInt()

            val winningVsDrawn = cardNumToValues.get(1)
                .split("|")
                .map { it.trim() }

            println("number $num")
            val winning = winningVsDrawn.get(0).trim().split(" ").mapNotNull { it.toIntOrNull() }
            val nums = winningVsDrawn.get(1).trim().split(" ").mapNotNull { it.toIntOrNull() }
            num to (winning to nums)
        }
        .map { card ->
            val drawingSet = card.second.second.toSet()
            val value = card
                .second
                .first
                .filter { drawingSet.contains(it) }
                .size

            if (value > 0) {
                val cardResult = 2.0.pow(value - 1)
                println("Card Result: $cardResult")
                cardResult
            } else {
                0.0
            }
        }
        .sum()

    println("result $result")
}

