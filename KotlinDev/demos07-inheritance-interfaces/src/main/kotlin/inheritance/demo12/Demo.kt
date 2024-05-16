package inheritance.demo12

data class Point(val x: Int, val y: Int)

interface Shape {

    // Abstract function.
    fun draw()

    // Abstract property.
    val numSides: Int

    // Function with default implementation.
    fun sumOfInteriorAngles() : Double {
        return 180.0 * (numSides - 2)
    }

    // Property with default accessor(s) implementation.
    val description: String
        get() = "I'm a ${this::class.simpleName}"
}

interface SolidShape : Shape {
    fun paint(color: String)
}

class Triangle(val p1: Point, val p2: Point, val p3: Point) : SolidShape {

    override fun paint(color: String) {
        println("Painting a Triangle in $color with points $p1, $p2, $p3")
    }

    override fun draw() {
        println("Drawing a Triangle with points $p1, $p2, $p3")
    }

    override val numSides: Int = 3
}

class Quadrilateral(
        val p1: Point,
        val p2: Point,
        val p3: Point,
        val p4: Point,
        override val numSides: Int = 4) : SolidShape {

    override fun paint(color: String) {
        println("Painting a Quadrilateral in $color with points $p1, $p2, $p3, $p4")
    }

    override fun draw() {
        println("Drawing a Quadrilateral with points $p1, $p2, $p3, $p4")
    }
}

fun main() {
    val shape1 = Triangle(Point(0,0), Point(5, 0), Point(5, 5))
    processSolidShape(shape1)

    val shape2 = Quadrilateral(Point(0,0), Point(5, 0), Point(5, 5), Point(0, 5))
    processSolidShape(shape2)
}

fun processSolidShape(shape: SolidShape) {

    println("\nIn processSolidShape() with ${shape::class.simpleName}")

    shape.paint("red")
    shape.draw()
    println("Number of sides: ${shape.numSides}")
    println("Sum of interior angles: ${shape.sumOfInteriorAngles()}")
    println("Description: ${shape.description}")
}