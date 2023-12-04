package Dec4.ProblemTwo

import java.io.BufferedReader
import java.io.File

fun main() {
    val bufferedReader: BufferedReader = File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/Dec4/input.txt").bufferedReader()
    val cards: MutableList<Pair<Pair<Int, Int>, Pair<List<Int>, List<Int>>>> = bufferedReader.use { it.readText() }
        .split("\n")
        .map {
            val cardNumToValues = it.drop(4)
                .split(":")
            val num = cardNumToValues.get(0).trim().toInt()
            val winningVsDrawn = cardNumToValues.get(1)
                .split("|")
                .map { it.trim() }
            val winning = winningVsDrawn.get(0).trim().split(" ").mapNotNull { it.toIntOrNull() }
            val nums = winningVsDrawn.get(1).trim().split(" ").mapNotNull { it.toIntOrNull() }
            (num to 1) to (winning to nums)
        }.toMutableList()

    val result = cards.mapIndexed { index, card ->
        val numTimesToProcessCard = card.first.second
        val numWinsOnCard = card.getNumWinsFromDrawing()
        println("Card ${card.first.first} Num Wins $numWinsOnCard ")
        val nextCard = index+1
        (nextCard..(nextCard+(numWinsOnCard-1))).forEach { updateCardIndex ->
            val cardToUpdate = cards.get(updateCardIndex)
            val numTimesToProcessThisCard = cardToUpdate.first.second + numTimesToProcessCard
            println("Updating Card at Index $updateCardIndex Num times to process $numTimesToProcessThisCard")
            cards[updateCardIndex] = cardToUpdate.copy(first = cardToUpdate.first.copy(second = numTimesToProcessThisCard))
        }
        val numCopies = card.first.second
        println("Card ${card.first.first} Num copies $numCopies")
        card.first.second
    }.sum()

    println("result $result")
}

fun Pair<Pair<Int, Int>, Pair<List<Int>, List<Int>>>.getNumWinsFromDrawing(): Int {
    val drawingSet = this.second.second.toSet()
    return this
        .second
        .first
        .filter { drawingSet.contains(it) }
        .size
}


