package twentytwentyfive.dec05

import java.io.File

fun main() {
    val ranges: MutableList<LongRange> = File("/Users/patrickbucaria/IdeaProjects/AdventOfCode/src/main/kotlin/twentytwentyfive/dec05/input.txt")
        .bufferedReader()
        .readLines()
        .map {
            val (x, y) = it.split("-")
            x.toLong().. y.toLong()
        }
        .sortedBy { it.first }
        .toMutableList()

    var a = 0
    var b = 1

    while (b < ranges.size) {
        val newRanges = mergeOrKeep(ranges[a], ranges[b])
        if (newRanges.size == 1) {
            ranges.removeAt(b)
            ranges.removeAt(a)
            ranges.add(a, newRanges[0])
        } else {
            a++
            b++
        }
    }
    val result = ranges.sumOf {
        it.last - it.first + 1
    }

   println("Result is $result")
}

fun mergeOrKeep(a: LongRange, b: LongRange): List<LongRange> {
    if (a.last < b.first - 1 || b.last < a.first - 1) {
        return listOf(a, b)
    }

    val start = minOf(a.first, b.first)
    val end = maxOf(a.last, b.last)
    return listOf(start..end)
}