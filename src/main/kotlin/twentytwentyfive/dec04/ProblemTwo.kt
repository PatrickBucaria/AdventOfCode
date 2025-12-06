package twentytwentyfive.dec04

import java.io.File

fun main() {
    val diagram: List<CharArray> = File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/twentytwentyfive/dec04/input.txt")
        .bufferedReader()
        .readLines()
        .map { it.toCharArray() }
        .toMutableList()

    var count = 0
    var resultsFound = true

    while (resultsFound) {
        resultsFound = false
        val rollsToRemove = mutableListOf<Pair<Int, Int>>()

        diagram
            .forEachIndexed { x, row ->
                row.forEachIndexed { y, char ->
                    if (diagram.positionHasLessThanFour(x, y)) {
                        rollsToRemove.add(x to y)
                        resultsFound = true
                        count++
                    }
                }
            }

        rollsToRemove.forEach {
            diagram.replaceAt(it.first, it.second)
        }
    }


    println("Result is $count")

}

fun List<CharArray>.positionHasLessThanFour(x: Int, y: Int): Boolean  {
    if (this[x][y] != '@') return false

    val results = this.checkLeft(x, y) +
            this.checkRight(x, y) +
            this.checkUp(x, y) +
            this.checkDown(x, y) +
            this.checkDiagUpLeft(x, y) +
            this.checkDiagDownLeft(x, y) +
            this.checkDiagUpRight(x, y) +
            this.checkDiagDownRight(x, y)

    return results < 4
}


fun List<CharArray>.replaceAt(x: Int, y: Int) {
    if (x in indices && y in this[x].indices) {
        if (this[x][y] == '@') {
            this[x][y] = '.'
        }
    }
}

fun List<CharArray>.checkLeft(x: Int, y: Int): Int {
    val left = y - 1
    return if (left < 0) {
        0
    } else {
        if (this[x][left] == '@') 1 else 0
    }
}

fun List<CharArray>.checkRight(x: Int, y: Int): Int {
    val right = y + 1
    return if (right > (this[x].size - 1)) {
        0
    } else {
        if (this[x][right] == '@') 1 else 0
    }
}

fun List<CharArray>.checkUp(x: Int, y: Int): Int {
    val up = x - 1
    return if (up < 0) {
        0
    } else {
        if (this[up][y] == '@') 1 else 0
    }
}

fun List<CharArray>.checkDown(x: Int, y: Int): Int {
    val down = x + 1
    return if (down > (this.size - 1)) {
        0
    } else {
        if (this[down][y] == '@') 1 else 0
    }
}

fun List<CharArray>.checkDiagUpLeft(x: Int, y: Int): Int {
    val up = x - 1
    val left = y - 1
    return if (up < 0 || left < 0) {
        0
    } else {
        if (this[up][left] == '@') 1 else 0
    }
}

fun List<CharArray>.checkDiagDownLeft(x: Int, y: Int): Int {
    val down = x + 1
    val left = y - 1
    return if (down > (this.size - 1) || left < 0) {
        0
    } else {
        if (this[down][left] == '@') 1 else 0
    }
}

fun List<CharArray>.checkDiagUpRight(x: Int, y: Int): Int {
    val up = x - 1
    val right = y + 1
    return if (up < 0 || right > (this[x].size - 1)) {
        0
    } else {
        if (this[up][right] == '@') 1 else 0
    }
}

fun List<CharArray>.checkDiagDownRight(x: Int, y: Int): Int {
    val down = x + 1
    val right = y + 1
    return if (down > (this.size - 1) || right > (this[x].size - 1)) {
        0
    } else {
        if (this[down][right] == '@') 1 else 0
    }
}
