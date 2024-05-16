package mypackage

fun main() {

    var result = 1

    for (n in 1..6) {
        result *= n
    }

    println("6 factorial is $result")
}