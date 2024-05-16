package operators

data class Money(val d: Int, val c: Int) {
    constructor(total: Int) : this(total / 100, total % 100) {}
}

operator fun Money.unaryMinus() = Money(-d, c)

operator fun Money.unaryPlus() = Money(d, c)

operator fun Money.not() = (d == 0 && c == 0)

fun main() {
    val m1 = Money(10,50)

    val m2 = -m1
    println(m2)

    val m3 = +m1
    println(m3)

    if (!m1)
        println("m1 is not false")
    else
        println("m1 is false")
}
