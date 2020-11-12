package ru.randomsoftware.java2d.rules

class EqualityRule: Rule<Boolean> {
    override fun calculate(a: Boolean, b: Boolean, c: Boolean): Boolean {
        return b
    }
}