package ru.randomsoftware.java2d.rules

class Rule3(
    private val rule1: Rule<Boolean>,
    private val rule2: Rule<Boolean>,
    private val rule3: Rule<Boolean>
) : Rule<Triple<Boolean, Boolean, Boolean>> {

    override fun calculate(
        a: Triple<Boolean, Boolean, Boolean>,
        b: Triple<Boolean, Boolean, Boolean>,
        c: Triple<Boolean, Boolean, Boolean>
    ): Triple<Boolean, Boolean, Boolean> {
        return Triple(
            rule1.calculate(a.first, b.first, c.first),
            rule2.calculate(a.second, b.second, c.second),
            rule3.calculate(a.third, b.third, c.third),
        )
    }
}