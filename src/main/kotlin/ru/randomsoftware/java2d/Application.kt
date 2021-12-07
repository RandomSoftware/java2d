package ru.randomsoftware.java2d

import ru.randomsoftware.java2d.generators.RandomLineGenerator
import ru.randomsoftware.java2d.renderers.RendererBW
import ru.randomsoftware.java2d.rules.NumericRule
import ru.randomsoftware.java2d.simulations.LineCellularAutomate

class Application {

    fun run() {
        val renderer = RendererBW(WIDTH, HEIGHT)
        val matrix = AUTOMATE.buildGenerations(HEIGHT)
        renderer.render(matrix)
    }

    companion object {
        const val WIDTH = 1400
        const val HEIGHT = 800
        val AUTOMATE = LineCellularAutomate(
                RandomLineGenerator(),
                NumericRule(184),
                WIDTH
        )
    }

}


fun main() {
    val application = Application()
    application.run()
}