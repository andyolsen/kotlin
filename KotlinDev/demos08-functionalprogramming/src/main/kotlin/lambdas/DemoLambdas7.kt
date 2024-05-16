package lambdas

fun factorial(n: Int): Int {
    if (n == 1)
        return 1
    else
        return n * factorial(n - 1)
}

tailrec fun factorialV2(n: Int, accumulator: Int = 1): Int {
    if (n == 1)
        return accumulator
    else
        return factorialV2(n - 1, n * accumulator)
}

tailrec fun factorialV3(n: Int, accumulator: Int = 1): Int = when(n) {
    1    -> accumulator
    else -> factorialV3(n - 1, n * accumulator)
}

fun main() {
    val res1 = factorial(4)    // See what happens when you pass in 100_000
    println(res1)

    val res2 = factorialV2(4)  // See what happens when you pass in 100_000
    println(res2)

    val res3 = factorialV3(4)  // See what happens when you pass in 100_000
    println(res3)
}