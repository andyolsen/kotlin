package ex4

fun main() {
    val r = Rectangle(0.0, 0.0, 30.0, 40.0)
    println(processShape(r))

    val t = Triangle(0.0, 0.0, 30.0, 40.0)
    println(processShape(t))

    val c = Circle(0.0, 0.0, 30.00)
    println(processShape(c))
}

fun processShape(shape: Shape) = when(shape) {
    is Rectangle -> "It's a ${if (shape.isSquare) "square" else "rectangle"}"
    is Triangle  -> "It's a triangle, hypotenuse=${shape.hypotenuse}"
    is Circle    -> "It's a circle, radius=${shape.radius}"
}
