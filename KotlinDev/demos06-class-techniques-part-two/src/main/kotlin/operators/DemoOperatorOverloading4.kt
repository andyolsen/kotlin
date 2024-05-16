package operators

infix operator fun Money.plus(that: Money) : Money {
    val thisAmount = this.d * 100 + this.c
    val thatAmount = that.d * 100 + that.c
    return Money(thisAmount + thatAmount)
}

operator fun Money.plus(otherD: Int) = Money(this.d + otherD, this.c)

operator fun Money.minus(that: Money) : Money {
    val thisAmount = this.d * 100 + this.c
    val thatAmount = that.d * 100 + that.c
    return Money(thisAmount - thatAmount)
}

operator fun Money.minus(otherD: Int) = Money(this.d - otherD, c)

operator fun Money.times(n: Int) : Money {
    val thisAmount = d * 100 + c
    return Money(thisAmount * n)
}

operator fun Money.div(n: Int) : Money {
    val thisAmount = d * 100 + c
    return Money(thisAmount / n)
}

operator fun Money.rem(n: Int) : Money {
    val thisAmount = d * 100 + c
    return Money(thisAmount % n)
}

fun main() {

    val m1 = Money(10, 50)
    val m2 = Money(7, 20)

    val m3 = m1 + m2
    val m3b = m1.plus(m2)

    println("m3 is $m3")

    val m4 = m3 + 1
    println("m4 is $m4")

    val m5 = m1 - m2
    println("m5 is $m5")

    val m6 = m5 - 1
    println("m6 is $m6")

    val m7 = m6 * 4
    println("m7 is $m7")

    val m8 = m7 / 4
    println("m8 is $m8")

    val m9 = m8 % 100
    println("m9 is $m9")

    var m10 = Money(10,50)
    m10 += 4
    m10 -= 2
    m10 *= 3
    m10 /= 2
    println("m10 is $m10")
}
