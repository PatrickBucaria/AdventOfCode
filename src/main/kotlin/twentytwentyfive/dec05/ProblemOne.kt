package twentytwentyfive.dec05

import java.io.File

fun main() {
    val ranges: List<LongRange> = File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/twentytwentyfive/dec05/input.txt")
        .bufferedReader()
        .readLines()
        .map {
            val (x, y) = it.split("-")
            x.toLong().. y.toLong()
        }


    val result = File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/twentytwentyfive/dec05/numbers.txt")
        .bufferedReader()
        .readLines()
        .map { it.toLong() }
        .sumOf { num ->
            ranges.forEach { range ->
                if (range.contains(num)) {
                    return@sumOf 1L
                }
            }
            0L
        }

    println("Result is $result")
}