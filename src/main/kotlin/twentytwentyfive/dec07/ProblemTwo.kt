package twentytwentyfive.dec07

import java.io.File

fun main() {
    val diagram: List<CharArray> = File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/twentytwentyfive/dec07/input.txt")
        .bufferedReader()
        .readLines()
        .map { line -> line.toCharArray() }

    val memoizer: MutableList<MutableList<Long>> = diagram.map { it.map { 0L }.toMutableList() }.toMutableList()

    fun tachyonPaths(x: Int, y: Int): Long {
        if (x >= diagram.size - 1) {
            return 1L
        }

        if (y < 0 || y >= diagram[0].size - 1) {
            return 1L
        }

        if (memoizer[x][y] > 0) {
            return memoizer[x][y]
        }

        var currentX = x
        var charAt = diagram[currentX][y]

        while (charAt != '^') {
            currentX++
            if (currentX >= diagram.size - 1) {
                return 1L
            }
            charAt = diagram[currentX][y]
        }

        // Add left and right
        val splitLeft = y-1
        val splitRight = y+1
        val nextX = currentX + 1

        val pathsLeft = tachyonPaths(nextX, splitLeft)

        if (nextX <= diagram.size - 1 && splitLeft >= 0) {
            memoizer[nextX][splitLeft] = pathsLeft
        }

        val pathsRight = tachyonPaths(nextX, splitRight)
        if (nextX <= diagram.size - 1 && pathsRight <= diagram[0].size - 1) {
            memoizer[nextX][splitRight] = pathsRight
        }

        return pathsLeft + pathsRight
    }

    val startIndex = diagram[0].indexOfFirst { char -> char == 'S'}
    val tachyonPaths = tachyonPaths(0, startIndex)

    println("Num paths is: $tachyonPaths")
}
