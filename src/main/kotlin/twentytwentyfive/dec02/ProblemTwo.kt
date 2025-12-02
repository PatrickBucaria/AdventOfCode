package twentytwentyfive.dec02


import java.io.File

fun main() {
    val result: Long = File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/twentytwentyfive/dec02/input.txt")
        .bufferedReader()
        .readLine()
        .split(",")
        .map {
            val (minStr, maxStr) = it.split("-")
            minStr.toLong() to maxStr.toLong()
        }
        .asSequence()
        .map { pair ->
            var total = 0L
            for (x in pair.first..pair.second) {
                val value = x.toString()
                val midPoint: Int = value.length / 2

                for (i in 1..midPoint) {
                    val chunks = value.chunked(i)
                    val matcher = chunks[0]
                    if (chunks.all { it == matcher }) {
                        total += x
                        break
                    }
                }
            }
            total
        }.sum()

    println("The result is $result")
}