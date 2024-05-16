package inheritance.demo10

fun main() {
    println(process(LinearEquation(1, 2)))
    println(process(QuadraticEquation(1, 2, 3)))
    println(process(CubicEquation(1, 2, 3, 4)))
}

// Because Equation is a sealed class, Kotlin knows the exhaustive set of subclasses. So...
//   - If our "when" forgets a subclass, Kotlin will complain.
//   - If our "when" includes all subclasses, Kotlin doesn't expect an "else" branch.
fun process(eq: Equation) = when(eq) {
    is LinearEquation    -> "It's a linear equation, $eq"
    is QuadraticEquation -> "It's a quadratic equation, $eq"
    is CubicEquation     -> "It's a cubic equation, $eq"
}