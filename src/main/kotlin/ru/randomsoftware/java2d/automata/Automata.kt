package ru.randomsoftware.java2d.automata

interface Automata<T> {

    fun buildGenerations(n: Int): List<List<T>>

}