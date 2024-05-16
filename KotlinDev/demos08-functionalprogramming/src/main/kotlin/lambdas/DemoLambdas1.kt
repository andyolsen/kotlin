package lambdas

fun main() {
    demoSimpleLambdas()
    demoLambaReturnValues()
    demoSpecifyingTypeInfoForLambda()
    demoMultiStatementLambda1()
    demoMultiStatementLambda2()
}

fun demoSimpleLambdas() {
    val myLambda1 = { n: Int -> println(n) }
    myLambda1(42)

    val myLambda2 = { a: Int, b: Int -> println(a * b) }
    myLambda2(5, 10)

    val myLambda3 = { println("Prynhawn da") }
    myLambda3()
}

fun demoLambaReturnValues() {
    val op1 = { a: Int, b: Int -> a * b }
    val res1 = op1(2, 7)
    println(res1)

    val op2 = { a: Int, b: Double -> if (a > b) a else b }
    val res2 = op2(2, 7.5)
    println(res2)
}

typealias BinaryIntOperator = (Int, Int) -> Int

fun demoSpecifyingTypeInfoForLambda() {
    val op1: (Int, Int) -> Int = {a, b -> a * b}
    val res1 = op1(3, 12)
    println(res1)

    val op2: BinaryIntOperator = {a, b -> a * b}
    val res2 = op2(3, 12)
    println(res2)
}

fun demoMultiStatementLambda1() {

    val op = { a: Int, b: Int ->
        if (a > b)
            "$a is bigger"
        else if (a < b)
            "$b is bigger"
        else
            "$a and $b are a dead heat"
    }

    val result = op(19, 1)
    println(result)
}

fun demoMultiStatementLambda2() {

    val op = fun(a: Int, b: Int) : String {
        if (a > b)
            return "$a is bigger"
        else if (a < b)
            return "$b is bigger"
        else
            return "$a and $b are a dead heat"
    }

    val result = op(19, 1)
    println(result)
}
