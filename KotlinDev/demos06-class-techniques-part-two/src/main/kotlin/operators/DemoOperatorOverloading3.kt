package operators

operator fun Money.inc() = Money(d + 1, c)

operator fun Money.dec() = Money(d - 1, c)

fun main() {
    var m1 = Money(10,50)

    val m2 = m1++
    println("m1=$m1 m2=$m2")

    val m3 = ++m1
    println("m1=$m1 m3=$m3")

    val m4 = m1--
    println("m1=$m1 m4=$m4")

    val m5 = --m1
    println("m1=$m1 m5=$m5")
}
