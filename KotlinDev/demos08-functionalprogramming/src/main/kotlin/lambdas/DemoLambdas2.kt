package lambdas

typealias UnaryIntOperator = (Int) -> Int
typealias BinaryDoubleOperator = (Double, Double) -> Double

fun main() {
    demoIt()
    demoUnderscore()
    demoTrailingLambdaParameter()
    demoMethodReferences()
}

fun demoIt() {

    val myLambda1: UnaryIntOperator = { n -> n * n }
    println(myLambda1(5))

    val myLambda2: UnaryIntOperator = { it * it }
    println(myLambda2(5))
}

fun demoUnderscore() {

    val myLambda1: BinaryDoubleOperator = {a, b -> a + b}
    println(myLambda1(2.0, 3.0))

    val myLambda2: BinaryDoubleOperator = {_, b -> 1000 + b}
    println(myLambda2(2.0, 3.0))

    val myLambda3: BinaryDoubleOperator = {a, _ -> 1000 + a}
    println(myLambda3(2.0, 3.0))

    val myLambda4: BinaryDoubleOperator = {_, _ -> 42.0}
    println(myLambda4(2.0, 3.0))
}

fun demoTrailingLambdaParameter() {

    val nums = arrayOf(3, 12, 19, 1, 2, 7, 5, 10)

    println("\nNumbers via a verbose lambda:")
    nums.forEach({e -> println(e)})

    println("\nNumbers using 'it' for the single lambda parameter:")
    nums.forEach({println(it)})

    println("\nNumbers using the trailing lambda syntax:")
    nums.forEach{println(it)}
}

fun demoMethodReferences() {

    val friends = arrayOf("Sleepy", "Dopey", "Happy", "Sneezy", "Doc", "Grumpy", "Bashful")

    val result1 = friends.map{s -> s.length}
    println(result1)

    val result2 = friends.map(String::length)
    println(result2)
}