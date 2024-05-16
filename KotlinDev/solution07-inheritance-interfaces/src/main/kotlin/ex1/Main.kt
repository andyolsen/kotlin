package ex1

fun main() {

    var shape1 = Shape(10.0, 20.0, 110.0, 420.0)
    println(shape1)
    println("width=${shape1.width}, height=${shape1.height}")

    shape1.moveX(10.0)
    shape1.moveY(20.0)
    shape1.scale(1.5, 1.8)

    println(shape1)
}
