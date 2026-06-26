package ru.randomsoftware.java2d.rules

import org.junit.Assert.*
import org.junit.Test

class EqualityRuleTest {

    private val rule = EqualityRule()

    @Test
    fun `returns true when b is true regardless of a and c`() {
        assertTrue(rule.calculate(true, true, true))
        assertTrue(rule.calculate(true, true, false))
        assertTrue(rule.calculate(false, true, true))
        assertTrue(rule.calculate(false, true, false))
    }

    @Test
    fun `returns false when b is false regardless of a and c`() {
        assertFalse(rule.calculate(true, false, true))
        assertFalse(rule.calculate(true, false, false))
        assertFalse(rule.calculate(false, false, true))
        assertFalse(rule.calculate(false, false, false))
    }
}