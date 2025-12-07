package twentytwentyfive.dec07

import java.io.File

fun main() {
    val diagram: MutableList<CharArray> = File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/twentytwentyfive/dec07/input.txt")
        .bufferedReader()
        .readLines()
        .map { line -> line.toCharArray() }
        .toMutableList()

    val startIndex = diagram[0].indexOfFirst { char -> char == 'S'}
    val tachyonIndexes = mutableSetOf(startIndex)
    var currentRow = 1
    val max = diagram.size - 1
    var splits = 0

    while (currentRow <= max) {
        val indices: List<Int> = tachyonIndexes.toList()

        indices.forEachIndexed { i, index ->
            val charAt = diagram[currentRow][index]

            if (charAt == '^') {
                // Remove this index
                tachyonIndexes.remove(index)

                // Add left and right
                val splitLeft = index-1
                val splitRight = index+1

                if (splitLeft >= 0) {
                    tachyonIndexes.add(splitLeft)
                }
                if (splitRight <= max) {
                    tachyonIndexes.add(splitRight)
                }
                splits++
            }
        }
        currentRow++
    }

    println("Num splits is: $splits")
}