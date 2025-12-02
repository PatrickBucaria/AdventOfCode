package twentytwentythree.Dec1.ProblemOne

import java.io.BufferedReader
import java.io.File

fun main() {
    val bufferedReader: BufferedReader = File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/Dec1/input.txt").bufferedReader()
    val inputString: String = bufferedReader.use { it.readText() }
    val lines: List<String> = inputString.split("\n")

    var result = 0
    lines.forEach { line ->
        val configValue = line.findConfigurationValue()
        if (configValue != null) {
            println("Config Value for line $line is $configValue")
            result += configValue
        } else {
            println("Finding Null for line $line")
        }
    }

    println("Result == $result")
}

/**
 * O(N) to find the config value from the string
 */
fun String.findConfigurationValue(): Int? {
    var firstNum: Char? = null
    var lastNum: Char? = null

    this.forEach { char ->
        if (firstNum == null && char.isDigit()) {
            firstNum = char
        }

        if (char.isDigit()) {
            lastNum = char
        }
    }

    val intString: String = "${firstNum ?: ""}${lastNum ?: ""}"

    return intString.toIntOrNull()
}

