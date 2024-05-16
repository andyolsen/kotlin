package ex3

class Rectangle(x0: Double, y0: Double, x1: Double, y1: Double) : Shape(x0, y0, x1, y1) {

    override val numPoints = 4

    override val area
        get() = width * height

    override val perimeter
        get() = 2 * width + 2 * height

    override fun toString() = "Rectangle details: ${super.toString()}"
}
