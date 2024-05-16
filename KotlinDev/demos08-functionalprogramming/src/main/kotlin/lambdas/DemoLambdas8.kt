package lambdas

class BreakException : Exception()

fun breakIf(test: Boolean) {
    if (test) {
        println("BREAK BREAK BREAK!")
        throw BreakException()
    }
}

fun breakableBlock(f: () -> Unit) {
    try {
        f()
    }
    catch (ex: BreakException) {}
}


fun main() {

    breakableBlock {
        for (i in 1..5) {
            val nums = arrayOf(10, 20, 30, 40, 42, 50, 60, 70)
            for (n in nums) {
                println(i * n)
                breakIf(i * n == 84)
            }
        }
    }
    println("That's all folks!")
}
