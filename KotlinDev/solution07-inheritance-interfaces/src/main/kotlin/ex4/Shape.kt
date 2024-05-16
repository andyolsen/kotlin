package ex4

sealed class Shape(var x0: Double, var y0: Double, var x1: Double, var y1: Double) {

    abstract val numPoints: Int
    abstract val area : Double
    abstract val perimeter : Double

    val width
        get() = x1 - x0

    val height
        get() = y1 - y0

    fun moveX(dx: Double) {
        x0 += dx
        x1 += dx
    }

    fun moveY(dy: Double) {
        y0 += dy
        y1 += dy
    }

    fun scale(sx: Double, sy:Double = sx) {
        x1 = x0 + width * sx
        y1 = y0 + height * sy
    }

    override fun toString() = "top-left=[$x0, $y0], bottom-right=[$x1, $y1], " +
                              "width=$width, height=$height, " +
                              "number of points=$numPoints, area=$area, perimeter=$perimeter"
}

class Rectangle(x0: Double, y0: Double, x1: Double, y1: Double) : Shape(x0, y0, x1, y1) {

    val isSquare
        get() = width == height

    override val numPoints = 4

    override val area
        get() = width * height

    override val perimeter
        get() = 2 * width + 2 * height

    override fun toString() = "Rectangle details: ${super.toString()}"
}

class Triangle(x0: Double, y0: Double, x1: Double, y1: Double) : Shape(x0, y0, x1, y1) {

    val hypotenuse
        get() = Math.sqrt(width * width + height * height)

    override val numPoints = 3

    override val area
        get() = width * height / 2

    override val perimeter
        get() = width + height + Math.sqrt(width * width + height * height)

    override fun toString() = "Triangle details: ${super.toString()}"
}

class Circle(x0: Double, y0: Double, d: Double) : Shape(x0, y0, x0+d, y0+d) {

    val radius
        get() = width / 2

    override val numPoints = 0

    override val area
        get() = Math.PI * radius * radius

    override val perimeter
        get() =  2 * Math.PI * radius

    override fun toString() = "Circle details: ${super.toString()}"
}
