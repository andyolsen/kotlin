package typeSafeEnums

import java.lang.IllegalArgumentException
import java.util.*

enum class State {
    OFF, PENDING, ON, SHUTTING_DOWN
}

fun main() {
    demoUsingEnum()
    demoEnumFeatures()
    demoEnumTypeValues()
}

fun demoUsingEnum() {
    println("Using an enum")
    val s1: State = State.ON
    println(s1)
}

fun demoEnumFeatures() {
    println("Enum features")
    val s1: State = State.ON
    println(s1.name)
    println(s1.ordinal)

    val s2: State = State.ON
    println(s1.equals(s2))
    println(s1 == s2)
    println(s1 == State.ON)
}

fun demoEnumTypeValues() {
    println("\nEnum values")
    val enumValues = State.values()
    for (v in enumValues) {
        println(v)
    }
}

fun demoEnumValueOf() {

    val scanner = Scanner(System.`in`)
    print("\nEnter a 'State' mnemonic: ")
    val mnemonic = scanner.next()

    try {
        val valueOfMnemonic = State.valueOf(mnemonic)
        val s1 : State = valueOfMnemonic
        println(s1)
        println(s1.name)
        println(s1.ordinal)
    }
    catch (ex: IllegalArgumentException) {
        println("Invalid mnemonic")
    }
}
