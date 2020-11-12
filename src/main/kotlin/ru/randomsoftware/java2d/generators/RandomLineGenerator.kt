package ru.randomsoftware.java2d.generators

import kotlin.random.Random

class RandomLineGenerator: LineGenerator<Boolean> {
    override fun generate(size: Int): List<Boolean> {
        return (1 .. size).map { Random.nextBoolean() }
    }
}