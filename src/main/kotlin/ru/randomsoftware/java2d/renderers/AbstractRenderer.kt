package ru.randomsoftware.java2d.renderers

import java.awt.Color
import java.awt.Frame
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.image.BufferedImage

abstract class AbstractRenderer<T>(
    private val frameWidth: Int,
    private val frameHeight: Int
) : Frame(), Renderer<T> {

    private lateinit var matrix: List<List<T>>

    override fun render(matrix: List<List<T>>) {
        this.matrix = matrix
        isVisible = true
    }

    override fun paint(g: Graphics?) {
        val g2d = g as Graphics2D
        val img = BufferedImage(frameWidth, frameHeight, BufferedImage.TYPE_INT_RGB)

        matrix.forEachIndexed { index, row -> drawRow(img, row, index) }
        g2d.drawImage(img, 0, OFFSET, null)
    }

    private fun drawRow(img: BufferedImage, row: List<T>, y: Int) {
        row.forEachIndexed { index, value -> drawPixel(img, index, y, value) }
    }

    private fun drawPixel(img: BufferedImage, x: Int, y: Int, color: T) {
        img.setRGB(x, y, getColor(color).rgb)
    }

    protected abstract fun getColor(color: T): Color

    companion object {
        const val OFFSET = 22
    }

}