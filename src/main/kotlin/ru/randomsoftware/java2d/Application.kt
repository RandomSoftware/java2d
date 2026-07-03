package ru.randomsoftware.java2d

import ru.randomsoftware.java2d.automata.LineCellularAutomata
import ru.randomsoftware.java2d.generators.MiddlePointLineGenerator
import ru.randomsoftware.java2d.renderers.RendererBW
import ru.randomsoftware.java2d.rules.NumericRule
import ru.randomsoftware.java2d.simulation.StaticSimulation

class Application {

  fun run() {
    val simulation =
        StaticSimulation(
            LineCellularAutomata(MiddlePointLineGenerator(), NumericRule(18), WIDTH),
            RendererBW(WIDTH, HEIGHT))
    simulation.run()
  }

  companion object {
    const val WIDTH = 1400
    const val HEIGHT = 800
  }
}

fun main() {
  val application = Application()
  application.run()
}
