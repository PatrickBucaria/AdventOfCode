package Dec6.ProblemOne

import java.io.BufferedReader
import java.io.File

fun main() {
    val bufferedReader: BufferedReader = File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/Dec6/input.txt").bufferedReader()
    val lines: List<String> = bufferedReader.readLines()
    val times: List<Int> = lines
        .get(0)
        .drop(5)
        .split(" ")
        .mapNotNull { it.toIntOrNull() }

    val distances: List<Int> = lines
        .get(1)
        .drop(9)
        .split(" ")
        .mapNotNull { it.toIntOrNull() }

    val result = times
        .mapIndexed { index, time -> (time to distances.get(index)).getNumPossibleHoldTimes() }
        .reduce { acc, i -> acc*i }

    println("Result: $result")

}

fun Pair<Int, Int>.getNumPossibleHoldTimes(): Int {
    var numPossibleWaysToWin = 0
    val (maxTime, distanceToBeat) = this

    for (speed in 1..maxTime) {
        val time = maxTime - speed
        val distanceGone = time*speed
        if (distanceGone > distanceToBeat) {
            numPossibleWaysToWin++
        }
    }

    return numPossibleWaysToWin
}


