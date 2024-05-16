package lambdas

typealias IntPredicate = (Int) -> Boolean

fun and(test1: IntPredicate, test2: IntPredicate) : IntPredicate {
    return {n -> test1(n) && test2(n)}
}

// Here's the equivalent to the above, without using type alias. EEK!
/*
fun and(test1: (Int)->Boolean, test2: (Int)->Boolean) : (Int)->Boolean {
    return {n -> test1(n) && test2(n)}
}
*/

fun main() {

    val isOdd = { n: Int -> n % 2 != 0 }
    val isNeg = { n: Int -> n < 0 }

    val isOddNeg = and(isOdd, isNeg)   // Returns a function.
    val result = isOddNeg(-12345)      // Invoke that function now.
    println("Is -12345 odd and negative? $result")
}

