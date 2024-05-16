package mypackage

typealias Predicate<T> = (T) -> Boolean

fun main() {
    doIntTests()
    doStringTests()
}

fun doIntTests() {

    // Predicate to test an Int.
    var anIntPredicate: Predicate<Int>

    anIntPredicate = { it >= 0 }         // Test for non-negative int.
    println(anIntPredicate(-15))
    println(anIntPredicate(0))
    println(anIntPredicate(10))

    anIntPredicate = { it in 0..100 }    // Test for valid exam mark.
    println(anIntPredicate(-15))
    println(anIntPredicate(72))
    println(anIntPredicate(101))

    anIntPredicate = { it % 10 == 0 }    // Test for multiple of 10.
    println(anIntPredicate(-15))
    println(anIntPredicate(0))
    println(anIntPredicate(10))
}

fun doStringTests() {

    // Predicate to test a String.
    var aStringPredicate : Predicate<String>

    aStringPredicate = {it == it.lowercase()}     // Test if string is all lowercase.
    println(aStringPredicate("Matthew"))
    println(aStringPredicate("mark"))
    println(aStringPredicate("LUKE"))
    println(aStringPredicate("john"))

    aStringPredicate = {it == it.trim()}            // Test if string has no leading/trailing whitespace.
    println(aStringPredicate("Emily"))
    println(aStringPredicate("  tom"))
    println(aStringPredicate("ANDREW  "))
}