package ru.randomsoftware.java2d.simulations

interface Automate<T> {

    fun buildGenerations(n: Int): List<List<T>>

}