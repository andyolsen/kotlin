package ex3

abstract class Shape(var x0: Double, var y0: Double, var x1: Double, var y1: Double) {

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
