package mypackage

typealias IntPredicate = (Int) -> Boolean

fun main() {

    // This is long-winded syntax.
    // val isNonNegative : IntPredicate = {n : Int -> n >= 0}

    // This syntax is a bit more concise, note we've omitted the type info for the lambda parameter.
    // val isNonNegative : IntPredicate = {n -> n >= 0}

    // This is the most concise syntax. If a lambda has 1 parameter, you can access teh param as "it".
    val isNonNegative : IntPredicate = {it >= 0}

    println(isNonNegative(-42))     // Should display false
    println(isNonNegative(0))       // Should display true
    println(isNonNegative(42))      // Should display true
}