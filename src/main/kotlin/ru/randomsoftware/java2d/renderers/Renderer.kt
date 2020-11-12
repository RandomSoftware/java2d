package ru.randomsoftware.java2d.renderers

interface Renderer<T> {

    fun render(matrix: List<List<T>>)

}