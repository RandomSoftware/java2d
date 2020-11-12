package ru.randomsoftware.java2d.generators

interface LineGenerator<T> {

    fun generate(size: Int): List<T>

}