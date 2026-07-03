package ru.randomsoftware.java2d.renderers

import java.awt.Color
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import kotlin.system.exitProcess

class RendererBW(frameWidth: Int, frameHeight: Int) :
    AbstractRenderer<Boolean>(frameWidth, frameHeight) {

  init {
    setSize(frameWidth, frameHeight + OFFSET)
    addWindowListener(
        object : WindowAdapter() {
          override fun windowClosing(e: WindowEvent?) {
            exitProcess(0)
          }
        })
  }

  override fun getColor(color: Boolean): Color {
    return if (color) Color.BLACK else Color.WHITE
  }

  companion object {
    const val OFFSET = 22
  }
}
