package twentytwentyfive.dec03

import java.io.File
import kotlin.text.digitToInt

fun main() {
    val result = File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/twentytwentyfive/dec03/input.txt")
        .bufferedReader()
        .readLines()
        .sumOf { bank ->
            var startIndex = 0
            var result = ""
            var batteriesRemaining = 12

            while (batteriesRemaining > 0) {
                val nextDigitIndex = findLargestLeftIndex(bank, startIndex, batteriesRemaining)
                result += "${bank[nextDigitIndex]}"
                startIndex = nextDigitIndex + 1
                batteriesRemaining--
            }
            println("Intermediate result is $result")
            result.toLong()
        }

    println("Result is: $result")
}

fun findLargestLeftIndex(bank: String, startIndex: Int, remainingChars: Int): Int  {
    var x = startIndex
    val max = bank.length - remainingChars

    var largestLeftIndex = startIndex
    while (x <= max) {
        val value = bank[x].digitToInt()
        if (value > bank[largestLeftIndex].digitToInt()) {
            largestLeftIndex = x
        }
        x++
    }
    return largestLeftIndex
}

