package operators

data class Point(val x: Int, val y: Int) {
    operator fun unaryMinus() = Point(-x, -y)
    operator fun unaryPlus() = Point(x, y)
    operator fun not() = isOrigin

    val isOrigin
        get() = x == 0 && y == 0
}

fun main() {
    val p1 = Point(10,50)

    val p2 = -p1
    println(p2)

    val p3 = +p1
    println(p3)

    if (p3.isOrigin)
        println("p1 is false")
    else
        println("p1 is not false")
}
