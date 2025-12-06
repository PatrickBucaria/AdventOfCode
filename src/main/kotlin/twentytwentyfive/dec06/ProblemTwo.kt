import java.io.File

fun main() {

    val problems: List<CharArray> = File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/twentytwentyfive/dec06/input.txt")
        .bufferedReader()
        .readLines()
        .map { line -> line.toCharArray() }

    val endIndex: Int = problems[0].size - 1
    var currentIndex = endIndex
    var results = 0L

    while (currentIndex >= 0) {
        var inProblem = true
        val problemNumbers = mutableListOf<Long>()
        while (inProblem) {
            val newNumberString = if (currentIndex >= 0 ) {
                "${problems[0][currentIndex]}${problems[1][currentIndex]}${problems[2][currentIndex]}${problems[3][currentIndex]}".replace(" ", "")
            } else {
                ""
            }
            if (newNumberString.isNotEmpty()) {
                problemNumbers.add(newNumberString.toLong())
                currentIndex--
            } else {
                inProblem = false
                val operator = problems[4][currentIndex+1]
                if (operator == '*') {
                    var inter = 1L
                    problemNumbers.forEach { inter*=it }
                    results+=inter
                } else {
                    var inter = 0L
                    problemNumbers.forEach { inter+=it }
                    results+=inter
                }
                currentIndex--
            }
        }
    }

    println("Result is $results")
}
