package typeSafeEnums

import java.lang.IllegalArgumentException
import java.util.*

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED    (255, 0,0),
    YELLOW (255, 255,0),
    MAGENTA(255, 0, 255),
    GREEN  (0, 255, 0),
    CYAN   (0, 255, 255),
    BLUE   (0, 0, 255)
}

fun main() {
    demoEnumUsage()
    demoEnumComparison()
}

fun demoEnumUsage() {
    val c = Color.CYAN
    println("The color is $c")
    println("The r component is ${c.r}")
    println("The g component is ${c.g}")
    println("The b component is ${c.b}")
}

fun demoEnumComparison() {
    val c1 = Color.GREEN
    val c2 = Color.RED
    val c3 = Color.BLUE

    // Enums implement the Comparable interface. Comparison uses ordinal positions.
    println("c1 compared to c2: ${c1.compareTo(c2)}")
    println("c1 compared to c3: ${c1.compareTo(c3)}")
}