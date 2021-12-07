package ru.randomsoftware.java2d.automata

import ru.randomsoftware.java2d.generators.LineGenerator
import ru.randomsoftware.java2d.rules.Rule

class LineCellularAutomata<T>(
        generator: LineGenerator<T>,
        private val rule: Rule<T>,
        size: Int
): Automata<T> {

    private val initialRow: List<T> = generator.generate(size)

    override fun buildGenerations(n: Int): List<List<T>> {
        return generateSequence(initialRow) { calculateNextRow(it) }.take(n).toList()
    }

    private fun calculateNextRow(row: List<T>): List<T> {
        return row.takeLast(1).plus(row.dropLast(1))
                .zip(row)
                .zip(row.drop(1).plus(row.take(1)))
                .map {
                    Triple(it.first.first, it.first.second, it.second)
                }.map {
                    rule.calculate(it.first, it.second, it.third)
                }
    }
}