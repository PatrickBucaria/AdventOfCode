package twentytwentyfive.dec03

import java.io.File

fun main() {
    val result = File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/twentytwentyfive/dec03/input.txt")
        .bufferedReader()
        .readLines()
        .sumOf { bank ->
            var y = bank.length - 1
            var x = 0

            var largestLeftIndex = 0
            var largestRightIndex = bank.length - 1

            while (x < bank.length - 1 ) {
                val leftDigit = bank[x].digitToInt()
                if (leftDigit > bank[largestLeftIndex].digitToInt()) {
                    largestLeftIndex = x
                }
                x++
            }
            while (y > largestLeftIndex) {
                val rightDigit = bank[y].digitToInt()
                if (rightDigit > bank[largestRightIndex].digitToInt()) {
                    largestRightIndex = y
                }
                y--
            }
            val value = "${bank[largestLeftIndex]}${bank[largestRightIndex]}"
            value.toInt()
        }

    println("Result is: $result")
}
