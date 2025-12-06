package twentytwentyfive.dec04

import java.io.File

fun main() {
    val diagram: List<String> = File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/twentytwentyfive/dec04/input.txt")
        .bufferedReader()
        .readLines()

    var count = 0

    diagram
        .forEachIndexed { x, row ->
            row.forEachIndexed { y, char ->
                if (diagram.positionHasLessThanFour(x, y)) {
                    count++
                }
            }
        }

    println("Result is $count")

}

fun List<String>.positionHasLessThanFour(x: Int, y: Int): Boolean  {
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

fun List<String>.checkLeft(x: Int, y: Int): Int {
    val left = y - 1
    return if (left < 0) {
        0
    } else {
        if (this[x][left] == '@') 1 else 0
    }
}

fun List<String>.checkRight(x: Int, y: Int): Int {
    val right = y + 1
    return if (right > (this[x].length - 1)) {
        0
    } else {
        if (this[x][right] == '@') 1 else 0
    }
}

fun List<String>.checkUp(x: Int, y: Int): Int {
    val up = x - 1
    return if (up < 0) {
        0
    } else {
        if (this[up][y] == '@') 1 else 0
    }
}

fun List<String>.checkDown(x: Int, y: Int): Int {
    val down = x + 1
    return if (down > (this.size - 1) ) {
        0
    } else {
        if (this[down][y] == '@') 1 else 0
    }
}

fun List<String>.checkDiagUpLeft(x: Int, y: Int): Int {
    val up = x - 1
    val left = y - 1
    return if (up < 0 || left < 0 ) {
        0
    } else {
        if (this[up][left] == '@') 1 else 0
    }
}

fun List<String>.checkDiagDownLeft(x: Int, y: Int): Int {
    val down = x + 1
    val left = y - 1
    return if (down > (this.size - 1) || left < 0 ) {
        0
    } else {
        if (this[down][left] == '@') 1 else 0
    }
}

fun List<String>.checkDiagUpRight(x: Int, y: Int): Int {
    val up = x - 1
    val right = y + 1
    return if (up < 0 || right > (this[x].length - 1) ) {
        0
    } else {
        if (this[up][right] == '@') 1 else 0
    }
}

fun List<String>.checkDiagDownRight(x: Int, y: Int): Int {
    val down = x + 1
    val right = y + 1
    return if (down > (this.size - 1) || right > (this[x].length - 1) ) {
        0
    } else {
        if (this[down][right] == '@') 1 else 0
    }
}