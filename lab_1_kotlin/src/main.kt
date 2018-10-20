package lab1.kotlin

import java.awt.*
import java.awt.geom.Line2D
import java.lang.RuntimeException
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTextField

class CurveDisplay(title: String): JFrame() {
    private lateinit var drawer: Drawer
    private var depth = 2

    init {
        setTitle(title)

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(500, 500)
        setLocationRelativeTo(null)
        layout = FlowLayout()

        val field = JTextField(10)
        val button = JButton("Draw")
        val panel = JPanel()

        field.text = "2"
        button.addActionListener {
            try {
                depth = field.text.toInt()
            } catch (re: RuntimeException) {
                depth = 2
            }
            finally {
                repaint()
                depth = Math.max(0, depth)
                field.text = depth.toString()
            }
        }
        this.add(field)
        this.add(button)
        this.add(panel)
    }

    override fun paint(g: Graphics) {
        super.paint(g)
        val g2 = g as Graphics2D

        val width = 192f

        var step = width / 3
        for (i in 0 until depth)
            step /= 2
        //drawer = Drawer(450f, 70f, g2, step)
        drawer = Drawer(70f, 70f, g2, step)

        drawRight(depth=depth)
        drawer.moveAndDraw(drawer.step, drawer.step)

        drawDown(depth=depth)
        drawer.moveAndDraw(-drawer.step, drawer.step)
        drawLeft(depth=depth)
        drawer.moveAndDraw(-drawer.step, -drawer.step)
        drawUp(depth=depth)

        drawer.moveAndDraw(drawer.step, -drawer.step)
    }

    private fun drawRight(depth: Int) {
        if (depth == 0) {
            drawer.drawPartRight()
            return
        }
        drawRight(depth - 1)
        drawer.moveAndDraw(drawer.step, drawer.step)
        drawDown(depth - 1)
        drawer.moveAndDraw(drawer.step, 0f)
        drawUp(depth - 1)
        drawer.moveAndDraw(drawer.step, -drawer.step)
        drawRight(depth - 1)
    }

    private fun drawDown(depth: Int) {
        if (depth == 0) {
            drawer.drawPartDown()
            return
        }
        drawDown(depth - 1)
        drawer.moveAndDraw(-drawer.step, drawer.step)
        drawLeft(depth - 1)
        drawer.moveAndDraw(0f, drawer.step)
        drawRight(depth - 1)
        drawer.moveAndDraw(drawer.step, drawer.step)
        drawDown(depth - 1)
    }

    private fun drawLeft(depth: Int) {
        if (depth == 0) {
            drawer.drawPartLeft()
            return
        }
        drawLeft(depth - 1)
        drawer.moveAndDraw(-drawer.step, -drawer.step)
        drawUp(depth - 1)
        drawer.moveAndDraw(-drawer.step, 0f)
        drawDown(depth - 1)
        drawer.moveAndDraw(-drawer.step, drawer.step)
        drawLeft(depth - 1)
    }

    private fun drawUp(depth: Int) {
        if (depth == 0) {
            drawer.drawPartUp()
            return
        }
        drawUp(depth - 1)
        drawer.moveAndDraw(drawer.step, -drawer.step)
        drawRight(depth - 1)
        drawer.moveAndDraw(0f, -drawer.step)
        drawLeft(depth - 1)
        drawer.moveAndDraw(-drawer.step, -drawer.step)
        drawUp(depth - 1)
    }
}

class Drawer(var x: Float, var y: Float, val g2: Graphics2D, var step: Float) {
    val line = Line2D.Float()

    fun drawPartRight() {
        line.setLine(x, y, x + step, y + step)
        g2.draw(line)
        line.setLine(x + step, y + step, x + step * 2, y + step)
        g2.draw(line)
        line.setLine(x + step * 2, y + step, x + step * 3, y)
        g2.draw(line)
        x += step * 3
    }

    fun drawPartDown() {
        line.setLine(x, y, x - step, y + step)
        g2.draw(line)
        line.setLine(x - step, y + step, x - step, y + step * 2)
        g2.draw(line)
        line.setLine(x - step, y + step * 2, x, y + step * 3)
        g2.draw(line)
        this.y += step * 3
    }

    fun drawPartLeft() {
        line.setLine(x, y, x - step, y - step)
        g2.draw(line)
        line.setLine(x - step, y - step, x - step * 2, y - step)
        g2.draw(line)
        line.setLine(x - step * 2, y - step, x - step * 3, y)
        g2.draw(line)
        this.x -= step * 3
    }

    fun drawPartUp() {
        line.setLine(x, y, x + step, y - step)
        g2.draw(line)
        line.setLine(x + step, y - step, x + step, y - step * 2)
        g2.draw(line)
        line.setLine(x + step, y - step * 2, x, y - step * 3)
        g2.draw(line)
        this.y -= step * 3
    }

    fun moveAndDraw(dx: Float, dy: Float) {
        line.setLine(x, y, x + dx, y + dy)
        g2.draw(line)
        x += dx
        y += dy
    }
}

private fun createAndShowGUI() {
    val frame = CurveDisplay("Sierpinski curve")
    frame.isVisible = true
}

fun main(args: Array<String>) {
    EventQueue.invokeLater(::createAndShowGUI)
}