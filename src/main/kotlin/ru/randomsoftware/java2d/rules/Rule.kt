package ru.randomsoftware.java2d.rules

interface Rule<T> {

    fun calculate(a: T, b: T, c: T): T
}