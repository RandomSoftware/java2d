package ru.randomsoftware.java2d.generators

import org.junit.Assert.*
import org.junit.Test

class MiddlePointLineGeneratorTest {

  private val generator = MiddlePointLineGenerator()

  @Test
  fun `returns list of correct size`() {
    assertEquals(5, generator.generate(5).size)
    assertEquals(6, generator.generate(6).size)
  }

  @Test
  fun `size 1 returns single true element`() {
    assertEquals(listOf(true), generator.generate(1))
  }

  @Test
  fun `even size has exactly one true at middle index`() {
    val result = generator.generate(6)
    assertEquals(1, result.count { it })
    assertTrue(result[2])
  }

  @Test
  fun `odd size has exactly one true`() {
    val result = generator.generate(5)
    assertEquals(1, result.count { it })
  }

  @Test
  fun `all other elements are false`() {
    val result = generator.generate(6)
    val trueIndex = result.indexOf(true)
    result.forEachIndexed { i, v -> if (i != trueIndex) assertFalse(v) }
  }
}
