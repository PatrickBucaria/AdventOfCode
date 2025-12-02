package twentytwentythree.Dec7.ProblemTwo

import java.io.BufferedReader
import java.io.File

fun main() {
    val bufferedReader: BufferedReader = File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/Dec7/input.txt").bufferedReader()

    val result: Int = bufferedReader
        .readLines()
        .map {
            val split = it.trim().split(" ")
            val hand = split.get(0)
            Triple(hand.toCharArray(), hand.toHandMap().typeStrength(), split.get(1).toInt())
        }
        .sortedWith(handComparator())
        .map { it.third }
        .reduceIndexed { index, acc, hand ->
            acc+(hand*(index+1))
        }

    println("Result: $result")
}

val strengthMap: Map<Char, Int> = mapOf(
    'A' to 13,
    'K' to 12,
    'Q' to 11,
    'T' to 9,
    '9' to 8,
    '8' to 7,
    '7' to 6,
    '6' to 5,
    '5' to 4,
    '4' to 3,
    '3' to 2,
    '2' to 1,
    'J' to 0,
    )

fun handComparator() = Comparator<Triple<CharArray, Int, Int>> { handOne, handTwo ->
    if (handOne.second > handTwo.second) {
        return@Comparator 1
    } else if (handOne.second < handTwo.second) {
        return@Comparator -1
    } else {
        (0..< handOne.first.size).forEach { index ->
            val handOneCardStrength: Int = strengthMap[handOne.first[index]]!!
            val handTwoCardStrength: Int = strengthMap[handTwo.first[index]]!!

            if (handOneCardStrength > handTwoCardStrength) {
                return@Comparator 1
            } else if (handOneCardStrength < handTwoCardStrength) {
                return@Comparator -1
            }
        }
    }

    println("Same hand found")
    return@Comparator 0
}

/**
 * hand strength from 1-7
 */
fun String.toHandMap(): Map<String, Int> {
    val handMap: MutableMap<String, Int> = mutableMapOf()
    val jokerCount = this.count { it == 'J'}
    var highestValue = 0
    var highestKey = "J"

    this.filterNot { it == 'J' }
        .forEach {
            val newValue = handMap.getOrDefault("$it", 0) + 1
            if (newValue > highestValue) {
                highestValue = newValue
                highestKey = "$it"
            }

            handMap["$it"] = newValue
        }

    handMap[highestKey] = handMap.getOrDefault(highestKey, 0) + jokerCount

    return handMap
}

fun Map<String, Int>.typeStrength(): Int {
    this.forEach { (_, num) ->
        if (num == 5) {
            return 7
        } else if (num == 4) {
            return 6
        } else if (size == 2 && (num == 2 || num == 3)) {
            return 5
        } else if (num == 3) {
            return 4
        } else if (size == 3 && num == 2) {
            return 3
        } else if (size == 4 && num == 2) {
            return 2
        }
    }

    return 1
}