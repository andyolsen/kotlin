package inheritanceAndGenerics

class Measurement<T : Comparable<T>>(var amount: T, val unitName: String) {
    fun isInRange(lower: T, upper: T) = (amount >= lower && amount <= upper)
}

fun main() {
    val m1 = Measurement(2_500, "m")
    println(m1.isInRange(1_000, 2_000))
    println(m1.isInRange(2_000, 3_000))
}