package inheritance.demo13

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

interface Loggable {
    fun log()
}

interface Serializable {
    fun serialize()
}

class Triangle(val p1: Point, val p2: Point, val p3: Point)
    : Shape, Loggable, Serializable {

    override fun log() {
        println("Logging a Triangle")
    }

    override fun serialize() {
        println("Serializing a Triangle")
    }

    override fun draw() {
        println("Drawing a Triangle with points $p1, $p2, $p3")
    }

    override val numSides: Int = 3
}

fun main() {
    val loggable = Triangle(Point(0, 0), Point(5, 0), Point(5, 5))
    processLoggableWithCrossCast(loggable)
}

fun processLoggableWithCrossCast(loggable: Loggable) {
    println("\nIn processLoggableWithCrossCast() with ${loggable::class.simpleName}")
    loggable.log()

    if (loggable is Serializable) {
        println("The loggable object also implements Serializable!")
        loggable.serialize()
    }
}