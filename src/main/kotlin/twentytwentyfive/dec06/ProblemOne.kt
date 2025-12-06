package twentytwentyfive.dec06

import java.io.File

fun main() {

    val problems: List<List<String>> = File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/twentytwentyfive/dec06/input.txt")
        .bufferedReader()
        .readLines()
        .map { it.split(Regex(" +")) }

    var results = 0L
    for (x in 0..< problems[0].size) {
        val numOne: Long = problems[0][x].toLong()
        val numTwo: Long = problems[1][x].toLong()
        val numThree: Long = problems[2][x].toLong()
        val numFour: Long = problems[3][x].toLong()
        val operator: String = problems[4][x]

        val intermediate = if (operator == "+") {
            numOne + numTwo + numThree + numFour
        } else {
            numOne * numTwo * numThree * numFour
        }

        results += intermediate
    }

    println("Result is $results")
}
