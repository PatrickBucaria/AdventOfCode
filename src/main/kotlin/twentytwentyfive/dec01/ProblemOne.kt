package twentytwentyfive.dec01

import java.io.File

fun main() {
    var currentValue = 50
    var count = 0
    File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/twentytwentyfive/Dec01/input.txt")
        .bufferedReader()
        .readLines()
        .map { it.take(1) to it.drop(1).toInt() }
        .forEach { pair ->
            currentValue = if (pair.first == "R") {
                currentValue.addRight(pair.second)
            } else {
                currentValue.subtractLeft(pair.second)
            }

            if (currentValue == 0) count++
        }

    println("Final Count: $count")
}


fun Int.addRight(addition: Int): Int {
    val additionSingleRotation = addition % 100
    val newValue = this.plus(additionSingleRotation)

    return if (newValue <= 99) {
        newValue
    } else  {
        val overFlow = newValue - 99
        return (-1).plus(overFlow)
    }
}

fun Int.subtractLeft(subtraction: Int): Int {
    val subtractionSingleRotation = subtraction % 100
    val newValue = this.minus(subtractionSingleRotation)
    return if (newValue >= 0) {
        newValue
    } else {
        100.plus(newValue)
    }
}

