package mypackage

fun main() {

    val not = { origTest: Predicate<Int> -> {n:Int -> !origTest(n)} }

    // We're using Predicate<T> from Ex3.kt
    // typealias Predicate<T> = (T) -> Boolean

    val isShortMonth: Predicate<Int> = {it in listOf(2, 4, 6, 9, 11)}
    val isLongMonth:  Predicate<Int> = not(isShortMonth)

    println(isShortMonth(2))
    println(isShortMonth(3))

    println(not(isLongMonth)(2))
    println(not(isLongMonth)(3))
}
