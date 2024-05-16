package inheritance.demo1

class Car            // Implicitly inherits from Any

class Boat : Any()   // Implicitly inherits from Any and calls its primary constructor.

fun main() {
    testCar()
    testBoat()
}

fun testCar() {

    println("\ntestCar()-----------------------------------------------------------------")

    val c1 = Car()
    val c2 = Car()

    println("${c1.equals(c2)}")
    println("${c1 == c2}")  // Implicitly calls equals()

    println("${c1.hashCode().toString(16)} ${c2.hashCode().toString(16)}")
    println("${c1.toString()} ${c2.toString()}")
    println("$c1 $c2")  // Implicitly calls toString()
}

fun testBoat() {

    println("\ntestCar()-----------------------------------------------------------------")

    val b1 = Boat()
    val b2 = Boat()

    println("${b1.equals(b2)}")
    println("${b1 == b2}")  // Implicitly calls equals()

    println("${b1.hashCode().toString(16)} ${b2.hashCode().toString(16)}")
    println("${b1.toString()} ${b2.toString()}")
    println("$b1 $b2")  // Implicitly calls toString()
}
