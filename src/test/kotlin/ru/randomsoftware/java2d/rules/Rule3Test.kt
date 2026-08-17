package ru.randomsoftware.java2d.rules

import org.junit.Assert.*
import org.junit.Test

class Rule3Test {

  // alwaysTrue / alwaysFalse let us control each channel's output independently.
  private val alwaysTrue = NumericRule(255)
  private val alwaysFalse = NumericRule(0)

  private val t = Triple(true, true, true)
  private val f = Triple(false, false, false)

  @Test
  fun `each channel delegates to its own rule`() {
    val rule = Rule3(alwaysTrue, alwaysFalse, alwaysTrue)
    val result = rule.calculate(t, t, t)
    assertEquals(Triple(true, false, true), result)
  }

  @Test
  fun `all rules alwaysTrue produces all-true triple`() {
    val rule = Rule3(alwaysTrue, alwaysTrue, alwaysTrue)
    assertEquals(Triple(true, true, true), rule.calculate(f, f, f))
  }

  @Test
  fun `all rules alwaysFalse produces all-false triple`() {
    val rule = Rule3(alwaysFalse, alwaysFalse, alwaysFalse)
    assertEquals(Triple(false, false, false), rule.calculate(t, t, t))
  }

  @Test
  fun `each channel receives only its own component from the triples`() {
    // rule1 = NumericRule(110): result depends on the first components of a, b, c
    // rule2 and rule3 = alwaysTrue: their output is fixed regardless of input
    val rule110 = NumericRule(110)
    val rule = Rule3(rule110, alwaysTrue, alwaysFalse)

    // (false, true, false) for the first components → rule110.calculate(false, false, false) =
    // false (bit 0 of 110 = 0)
    val a = Triple(false, true, true)
    val b = Triple(false, true, true)
    val c = Triple(false, true, true)
    val result = rule.calculate(a, b, c)

    assertFalse("first channel follows rule110", result.first)
    assertTrue("second channel follows alwaysTrue", result.second)
    assertFalse("third channel follows alwaysFalse", result.third)
  }

  @Test
  fun `channel isolation - changing one channel input does not affect others`() {
    // rule2 = EqualityRule (returns b.second); rule1 and rule3 are fixed
    val rule = Rule3(alwaysTrue, EqualityRule(), alwaysFalse)

    val resultWhenBSecondTrue = rule.calculate(f, Triple(false, true, false), f)
    val resultWhenBSecondFalse = rule.calculate(f, Triple(false, false, false), f)

    assertTrue(resultWhenBSecondTrue.second)
    assertFalse(resultWhenBSecondFalse.second)
    // first and third channels are unaffected
    assertTrue(resultWhenBSecondTrue.first)
    assertTrue(resultWhenBSecondFalse.first)
    assertFalse(resultWhenBSecondTrue.third)
    assertFalse(resultWhenBSecondFalse.third)
  }
}
