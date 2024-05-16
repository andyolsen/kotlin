package lambdas

fun <T, U, R> andThen(f1: (T) -> U, f2: (U) -> R): (T) -> R {
    return { x -> f2(f1(x)) }
}

fun <T, U, R> compose(f1: (U) -> R, f2: (T) -> U): (T) -> R {
    return { x -> f1(f2(x)) }
}

fun main() {

    val sqr = { n:Int -> n * n }
    val inc = { n:Int -> n + 1 }

    val sqrThenInc = andThen(sqr, inc)
    val res1 = sqrThenInc(2)
    println(res1)

    val incThenSqr = compose(sqr, inc)
    val res2 = incThenSqr(2)
    println(res2)
}