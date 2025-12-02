package twentytwentythree.Dec1.ProblemTwo

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

const val one = "one"
const val two = "two"
const val three = "three"
const val four = "four"
const val five = "five"
const val six = "six"
const val seven = "seven"
const val eight = "eight"
const val nine = "nine"

/**
 * O(N) to find the config value from the string
 */
fun String.findConfigurationValue(): Int? {
    var firstNum: String? = null
    var lastNum: String? = null

    var potentiallyNumberString = ""

    this.forEach { char ->
        val numChar: String? = if (char.isDigit()) {
            potentiallyNumberString = ""
            "$char"
        } else {
            // If it's not a digit, add it to the potential num string!
            // Check if it contains a number and if it does then return a
            // digit and delete the potential number string
            potentiallyNumberString += char

            if (potentiallyNumberString.contains(one)) {
                potentiallyNumberString = ""
                "1"
            } else if (potentiallyNumberString.contains(two)) {
                potentiallyNumberString = ""
                "2"
            } else if (potentiallyNumberString.contains(three)) {
                potentiallyNumberString = ""
                "3"
            } else if (potentiallyNumberString.contains(four)) {
                potentiallyNumberString = ""
                "4"
            } else if (potentiallyNumberString.contains(five)) {
                potentiallyNumberString = ""
                "5"
            } else if (potentiallyNumberString.contains(six)) {
                potentiallyNumberString = ""
                "6"
            } else if (potentiallyNumberString.contains(seven)) {
                potentiallyNumberString = ""
                "7"
            } else if (potentiallyNumberString.contains(eight)) {
                potentiallyNumberString = ""
                "8"
            } else if (potentiallyNumberString.contains(nine)) {
                potentiallyNumberString = ""
                "9"
            } else {
                null
            }
        }

        if (numChar != null ) {
            if (firstNum == null) {
                firstNum = numChar
            }

            lastNum = numChar
        }
    }

    return "${firstNum ?: ""}${lastNum ?: ""}".toIntOrNull()
}

