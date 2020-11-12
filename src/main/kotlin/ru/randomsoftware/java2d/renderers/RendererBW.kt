package ru.randomsoftware.java2d.renderers

import java.awt.Color
import java.awt.Frame
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import java.awt.image.BufferedImage
import kotlin.system.exitProcess

class RendererBW(
        private val frameWidth: Int,
        private val frameHeight: Int
): Frame(), Renderer<Boolean> {

    private lateinit var matrix: List<List<Boolean>>

    init {
        setSize(frameWidth, frameHeight + OFFSET)
        addWindowListener(object : WindowAdapter() {
            override fun windowClosing(e: WindowEvent?) {
                exitProcess(0)
            }
        })
    }

    override fun render(matrix: List<List<Boolean>>) {
        this.matrix = matrix
        isVisible = true
    }

    override fun paint(g: Graphics?) {
        val g2d = g as Graphics2D
        val img = BufferedImage(frameWidth, frameHeight, BufferedImage.TYPE_INT_RGB)

        matrix.forEachIndexed {index, row -> drawRow(img, row, index) }
        g2d.drawImage(img, 0, OFFSET, null)
    }

    private fun drawRow(img: BufferedImage, row: List<Boolean>, y: Int) {
        row.forEachIndexed { index, value -> drawPixel(img, index, y, value) }
    }

    private fun drawPixel(img: BufferedImage, x: Int, y: Int, color: Boolean) {
        img.setRGB(x, y, if (color) Color.BLACK.rgb else Color.WHITE.rgb)
    }

    companion object {
        const val OFFSET = 22
    }

}