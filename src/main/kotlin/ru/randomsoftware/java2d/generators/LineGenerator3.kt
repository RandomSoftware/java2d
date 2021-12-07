package ru.randomsoftware.java2d.generators

class LineGenerator3(
    private val generator1: LineGenerator<Boolean>,
    private val generator2: LineGenerator<Boolean>,
    private val generator3: LineGenerator<Boolean>
) : LineGenerator<Triple<Boolean, Boolean, Boolean>> {

    override fun generate(size: Int): List<Triple<Boolean, Boolean, Boolean>> {
        return generator1.generate(size)
            .zip(generator2.generate(size))
            .zip(generator3.generate(size))
            .map { Triple(it.first.first, it.first.second, it.second) }
    }
}