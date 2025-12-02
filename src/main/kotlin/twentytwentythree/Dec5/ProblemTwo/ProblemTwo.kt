package twentytwentythree.Dec5.ProblemTwo

import java.io.BufferedReader
import java.io.File

fun main() {
    val bufferedReader: BufferedReader = File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/Dec5/input.txt").bufferedReader()
    val seedsAndMaps: List<String> = bufferedReader.use { it.readText() }.split("\n\n")

    val seeds: List<Long> = seedsAndMaps.get(0).drop(6).trim().split(" ").map { it.toLong() }

    val mapOne = seedsAndMaps.get(1).toValueMap()
    val mapTwo = seedsAndMaps.get(2).toValueMap()
    val mapThree= seedsAndMaps.get(3).toValueMap()
    val mapFour = seedsAndMaps.get(4).toValueMap()
    val mapFive = seedsAndMaps.get(5).toValueMap()
    val mapSix = seedsAndMaps.get(6).toValueMap()
    val mapSeven = seedsAndMaps.get(7).toValueMap()

    val lowestLocation: Long = seeds
        .asSequence()
        .map { mapOne.getDestForInt(it) }
        .map { mapTwo.getDestForInt(it) }
        .map { mapThree.getDestForInt(it) }
        .map { mapFour.getDestForInt(it) }
        .map { mapFive.getDestForInt(it) }
        .map { mapSix.getDestForInt(it) }
        .map { mapSeven.getDestForInt(it) }
        .sorted()
        .first()

    println("Result: $lowestLocation")

}


data class MatrixValue(
    val sourceStart: Long,
    val sourceEnd: Long,
    val destStart: Long,
    val destEnd: Long
)
fun MatrixValue.getDestForIntOrNull(value: Long): Long? {
    return if (value in (sourceStart..sourceEnd)) {
        val diff = value-sourceStart
        destStart+diff
    } else {
        null
    }
}

fun List<MatrixValue>.getDestForInt(value: Long): Long {
    this.forEach {
        val dest = it.getDestForIntOrNull(value)
        if (dest != null) {
            return dest
        }
    }
    return value
}

fun String.toValueMap(): List<MatrixValue> = this.split("\n")
    .drop(1)
    .map {
        val ranges = it.trim().split(" ")
        val range = ranges.get(2).toLong()-1
        val sourceStart = ranges.get(1).toLong()
        val destStart = ranges.get(0).toLong()
        MatrixValue(
            sourceStart = sourceStart,
            sourceEnd = sourceStart+range,
            destStart = destStart,
            destEnd = destStart+range)
    }
