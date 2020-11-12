package ru.randomsoftware.java2d.rules

class NumericRule(base: Int): Rule<Boolean> {

    private val bs: List<Boolean>

    init {
        if (base < 0 || base > 255) {
            throw IllegalArgumentException("Base must be between 0 and 255")
        }
        bs = intToBooleanList(base)
    }

    override fun calculate(a: Boolean, b: Boolean, c: Boolean): Boolean {
        if (a && b && c) {
            return bs[0]
        } else if (a && b) {
            return bs[1]
        } else if (a && c) {
            return bs[2]
        } else if (a) {
            return bs[3]
        } else if (b && c) {
            return bs[4]
        } else if (b) {
            return bs[5]
        } else if (c) {
            return bs[6]
        } else {
            return bs[7]
        }
    }

    companion object {
        fun intToBooleanList(number: Int): List<Boolean> {
            return (7 downTo 0).map { 1 shl it and number != 0}
        }
    }
}