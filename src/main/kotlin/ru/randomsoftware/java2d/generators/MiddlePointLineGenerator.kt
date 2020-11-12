package ru.randomsoftware.java2d.generators

class MiddlePointLineGenerator: LineGenerator<Boolean> {
    override fun generate(size: Int): List<Boolean> {
        return (1 .. size).map { it == size / 2 }
    }
}