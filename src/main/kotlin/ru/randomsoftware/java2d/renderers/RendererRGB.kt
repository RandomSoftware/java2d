package ru.randomsoftware.java2d.renderers

import java.awt.Color
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import kotlin.system.exitProcess

class RendererRGB(
    frameWidth: Int,
    frameHeight: Int
) : AbstractRenderer<Triple<Boolean, Boolean, Boolean>>(frameWidth, frameHeight) {

    init {
        setSize(frameWidth, frameHeight + OFFSET)
        addWindowListener(object : WindowAdapter() {
            override fun windowClosing(e: WindowEvent?) {
                exitProcess(0)
            }
        })
    }

    override fun getColor(color: Triple<Boolean, Boolean, Boolean>): Color {
        return Color(getColorComponent(color.first), getColorComponent(color.second), getColorComponent(color.third))
    }

    private fun getColorComponent(isBright: Boolean): Int {
        return if (isBright) 255 else 0
    }

    companion object {
        const val OFFSET = 22
    }

}