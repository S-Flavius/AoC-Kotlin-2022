package day01

import readInput
import kotlin.math.max

fun main() {

    fun part1(input: List<String>): Int {
        var curMax = -1
        var curElf = 0

        for (line in input) when {
            line.isNotEmpty() -> curElf += line.toInt()
            else -> {
                curMax = max(curMax, curElf)
                curElf = 0
            }
        }

        return curMax
    }


    fun part2(input: List<String>): Int {
        val topThree = arrayOf(-1, -1, -1)
        var curElf = 0

        for (line in input)
            if (line.isNotEmpty()) {
                curElf += line.toInt()
            } else {
                when {
                    curElf > topThree[2] -> {
                        topThree[0] = topThree[1]
                        topThree[1] = topThree[2]
                        topThree[2] = curElf
                    }

                    curElf > topThree[1] -> {
                        topThree[0] = topThree[1]
                        topThree[1] = curElf
                    }

                    curElf > topThree[0] -> {
                        topThree[0] = curElf
                    }
                }

                curElf = 0
            }

        when {
            curElf > topThree[2] -> {
                topThree[0] = topThree[1]
                topThree[1] = topThree[2]
                topThree[2] = curElf
            }

            curElf > topThree[1] -> {
                topThree[0] = topThree[1]
                topThree[1] = curElf
            }

            curElf > topThree[0] -> {
                topThree[0] = curElf
            }
        }

        return topThree.reduce { x, y -> x + y }
    }


// test if implementation meets criteria from the description, like:
    val testInput = readInput("day01/Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("day01/Day01")
    println("Part 1: " + part1(input))
    println("Part 2: " + part2(input))
}
