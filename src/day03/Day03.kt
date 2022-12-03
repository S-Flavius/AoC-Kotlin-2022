package day03

import readInput
import kotlin.concurrent.fixedRateTimer

fun main() {


    fun part1(input: List<String>): Int {
        var prioSum = 0
        for (line in input) {
            var common = ' '
            val compOne = line.substring(0, line.length / 2)
            val compTwo = line.substring(line.length / 2)

            for (letter in compOne) {
                for (letterTwo in compTwo) {
                    if (letter == letterTwo)
                        common = letter
                }
            }

            prioSum += if (common.isUpperCase()) common.code - 38 else common.code - 96
        }
        return prioSum
    }


    fun part2(input: List<String>): Int {
        var currentLines = 0
        var prioSum = 0
        val lines = arrayOf("", "", "")
        for (line in input) {
            var common = ' '
            lines[currentLines++] = line
            if (currentLines == 3) {
                for (letter in lines[0]) {
                    for (letterOne in lines[1]) {
                        for (letterTwo in lines[2]) {
                            if (letter == letterOne && letter == letterTwo) {
                                common = letter
                            }
                        }
                    }
                }
                currentLines = 0
                prioSum += if (common.isUpperCase()) common.code - 38 else common.code - 96

            }
        }
        return prioSum
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day03/Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("day03/Day03")
    println("Part 1: " + part1(input))
    println("Part 2: " + part2(input))
}
