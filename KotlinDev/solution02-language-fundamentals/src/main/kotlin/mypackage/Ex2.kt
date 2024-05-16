package mypackage

fun main() {

    println("Prime numbers between 1 and 1000 inclusive:");
    for (num in 1..1000) {

        var i = 2
        while (i < num) {
            if (num % i == 0) {
                break
            }
            i++
        }

        if (i == num) {
            println("\t$num")
        }
    }
}