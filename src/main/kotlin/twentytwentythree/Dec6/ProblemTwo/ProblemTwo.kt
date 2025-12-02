package twentytwentythree.Dec6.ProblemTwo

import java.io.BufferedReader
import java.io.File

fun main() {
    val bufferedReader: BufferedReader = File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/Dec6/input.txt").bufferedReader()
    val lines: List<String> = bufferedReader.readLines()
    val time = lines
        .get(0)
        .drop(5)
        .filterNot { it == ' ' }
        .toLong()


    val distance = lines
        .get(1)
        .drop(9)
        .filterNot { it == ' '}
        .toLong()

    println("Max Time: $time")
    println("Max Distance: $distance")

    val result = (time to distance).getNumPossibleHoldTimes()

    println("Result: $result")

}

fun Pair<Long, Long>.getNumPossibleHoldTimes(): Int {
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


