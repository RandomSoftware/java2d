package ru.randomsoftware.java2d.simulation

import ru.randomsoftware.java2d.Application
import ru.randomsoftware.java2d.automata.Automata
import ru.randomsoftware.java2d.renderers.Renderer

class StaticSimulation<T>(
    private val automata: Automata<T>,
    private val renderer: Renderer<T>
): Runnable {
    override fun run() {
        val matrix = automata.buildGenerations(Application.HEIGHT)
        renderer.render(matrix)
    }
}