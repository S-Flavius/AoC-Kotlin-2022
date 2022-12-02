package day02

import readInput

fun main() {



    fun part1(input: List<String>): Int {
        var curScore = 0
        for (line in input) {
            val values = line.split(" ")
            when {
                values[1] == "X" -> {
                    curScore += 1
                    when {
                        values[0] == "A" -> curScore += 3
                        values[0] == "C" -> curScore += 6
                    }
                }

                values[1] == "Y" -> {
                    curScore += 2
                    when {
                        values[0] == "A" -> curScore += 6
                        values[0] == "B" -> curScore += 3
                    }
                }

                values[1] == "Z" -> {
                    curScore += 3
                    when {
                        values[0] == "B" -> curScore += 6
                        values[0] == "C" -> curScore += 3
                    }
                }
            }
        }


        return curScore
    }


    fun part2(input: List<String>): Int {
        var curScore = 0
        for (line in input) {
            val values = line.split(" ")
            when {
                values[1] == "X" -> {
                    when {
                        values[0] == "A" -> curScore += 3
                        values[0] == "B" -> curScore += 1
                        values[0] == "C" -> curScore += 2
                    }
                }

                values[1] == "Y" -> {
                    when {
                        values[0] == "A" -> curScore += 4
                        values[0] == "B" -> curScore += 5
                        values[0] == "C" -> curScore += 6
                    }
                }

                values[1] == "Z" -> {
                    when {
                        values[0] == "A" -> curScore += 8
                        values[0] == "B" -> curScore += 9
                        values[0] == "C" -> curScore += 7
                    }
                }
            }
        }


        return curScore
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day02/Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("day02/Day02")
    println("Part 1: " + part1(input))
    println("Part 2: " + part2(input))
}
