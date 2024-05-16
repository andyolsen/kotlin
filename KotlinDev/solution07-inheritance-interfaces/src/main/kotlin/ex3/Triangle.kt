package ex3

class Triangle(x0: Double, y0: Double, x1: Double, y1: Double) : Shape(x0, y0, x1, y1) {

    override val numPoints = 3

    override val area
        get() = width * height / 2

    override val perimeter
        get() = width + height + Math.sqrt(width * width + height * height)

    override fun toString() = "Triangle details: ${super.toString()}"
}


