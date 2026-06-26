package ru.randomsoftware.java2d.rules

import org.junit.Assert.*
import org.junit.Test

class NumericRuleTest {

    // Rule 110 = 0b01101110: bits 6,5,3,2,1 set
    private val rule110 = NumericRule(110)

    @Test
    fun `constructor accepts boundary values`() {
        NumericRule(0)
        NumericRule(255)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `constructor rejects negative base`() {
        NumericRule(-1)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `constructor rejects base above 255`() {
        NumericRule(256)
    }

    @Test
    fun `intToBooleanList zero produces all false`() {
        assertEquals(List(8) { false }, NumericRule.intToBooleanList(0))
    }

    @Test
    fun `intToBooleanList 255 produces all true`() {
        assertEquals(List(8) { true }, NumericRule.intToBooleanList(255))
    }

    @Test
    fun `intToBooleanList 110 maps bits correctly`() {
        // 110 = 0b01101110
        assertEquals(
            listOf(false, true, true, false, true, true, true, false),
            NumericRule.intToBooleanList(110)
        )
    }

    @Test
    fun `calculate TTT uses bit 7`() {
        // bit 7 of 110 = 0
        assertFalse(rule110.calculate(true, true, true))
    }

    @Test
    fun `calculate TTF uses bit 6`() {
        // bit 6 of 110 = 1
        assertTrue(rule110.calculate(true, true, false))
    }

    @Test
    fun `calculate TFT uses bit 5`() {
        // bit 5 of 110 = 1
        assertTrue(rule110.calculate(true, false, true))
    }

    @Test
    fun `calculate TFF uses bit 4`() {
        // bit 4 of 110 = 0
        assertFalse(rule110.calculate(true, false, false))
    }

    @Test
    fun `calculate FTT uses bit 3`() {
        // bit 3 of 110 = 1
        assertTrue(rule110.calculate(false, true, true))
    }

    @Test
    fun `calculate FTF uses bit 2`() {
        // bit 2 of 110 = 1
        assertTrue(rule110.calculate(false, true, false))
    }

    @Test
    fun `calculate FFT uses bit 1`() {
        // bit 1 of 110 = 1
        assertTrue(rule110.calculate(false, false, true))
    }

    @Test
    fun `calculate FFF uses bit 0`() {
        // bit 0 of 110 = 0
        assertFalse(rule110.calculate(false, false, false))
    }

    @Test
    fun `rule 0 always returns false`() {
        val rule = NumericRule(0)
        val inputs = listOf(true, false)
        for (a in inputs) for (b in inputs) for (c in inputs) {
            assertFalse(rule.calculate(a, b, c))
        }
    }

    @Test
    fun `rule 255 always returns true`() {
        val rule = NumericRule(255)
        val inputs = listOf(true, false)
        for (a in inputs) for (b in inputs) for (c in inputs) {
            assertTrue(rule.calculate(a, b, c))
        }
    }
}