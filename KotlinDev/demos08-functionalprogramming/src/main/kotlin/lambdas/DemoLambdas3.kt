package lambdas

fun evaluateAndDisplayV1(num1: Int, num2: Int, f: (Int, Int) -> Int) {
    val result = f(num1, num2)
    println("Result is $result")
}

fun evaluateAndDisplayV2(num1: Int, num2: Int, f: BinaryIntOperator) {
    val result = f(num1, num2)
    println("Result is $result")
}

fun main() {

    evaluateAndDisplayV1(10, 5, {a, b -> a * b})

    evaluateAndDisplayV1(10, 5){a, b -> a * b}

    evaluateAndDisplayV1(10, 5){
        a, b -> a * b
    }

    evaluateAndDisplayV2(10, 5){a, b -> a * b}
}
