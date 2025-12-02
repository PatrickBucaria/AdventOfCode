package twentytwentyfive.dec01

import java.io.File

fun main() {
    var currentValue = 50
    var count = 0
    File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/twentytwentyfive/dec01/input.txt")
        .bufferedReader()
        .readLines()
        .asSequence()
        .forEach {
            val ticks = it.drop(1).toInt()
            val turnResult = if (it.take(1) == "R"){
                currentValue.addRightWithRotations(ticks)
            } else {
                currentValue.subtractLeftWithRotations(ticks)
            }
            currentValue = turnResult.first
            count += turnResult.second
        }

    println("Final Count: $count")
}

fun Int.addRightWithRotations(addition: Int): Pair<Int, Int> {
    val additionSingleRotation = addition % 100
    val numFullRotations: Int = addition / 100

    val newValue = this.plus(additionSingleRotation)

    return if (newValue <= 99) {
        newValue to numFullRotations
    } else  {
        val overFlow = newValue - 99
        return (-1).plus(overFlow) to (numFullRotations + 1)
    }
}

fun Int.subtractLeftWithRotations(subtraction: Int): Pair<Int, Int> {
    val subtractionSingleRotation = subtraction % 100
    val numFullRotations: Int = subtraction / 100

    val newValue = this.minus(subtractionSingleRotation)

    val numRotations = if (newValue > 0) {
        numFullRotations
    } else if (newValue == 0 && this == 0) {
        numFullRotations
    } else if (this == 0) {
        numFullRotations
    } else {
        numFullRotations + 1
    }

    return if (newValue >= 0) {
        newValue to numRotations
    } else {
        100.plus(newValue) to numRotations
    }
}

