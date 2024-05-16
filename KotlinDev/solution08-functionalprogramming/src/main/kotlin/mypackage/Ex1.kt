package mypackage

fun main() {

    val isEven = {n: Int -> n % 2 == 0}

    println(isEven(42))
    println(isEven(43))
}