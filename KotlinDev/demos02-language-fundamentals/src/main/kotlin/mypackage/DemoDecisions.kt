package mypackage.mypackage

import java.util.*

fun main() {
    ifExpressions()
    relationalOperators()
    logicalOperators()
    bitwiseOperatorFunctions()
    multiwayBranching1()
    multiwayBranching2()
    multiwayBranching3()
    multiwayBranching4()
}

fun ifExpressions() {
    val salary: Double = 55_000.0
    val taxRate = if (salary > 40000) 45 else 20
    println("You will pay tax at $taxRate percent")
}

fun relationalOperators() {
    val age: Int = 21
    if (age >= 18) {
        println("Adult")
    } else if (age > 2) {
        println("Child")
    } else {
        println("Infant")
    }
}

fun logicalOperators() {
    val age: Int = 21
    if (age >= 18 && age <= 65)
        println("You are working age")
    if (age < 18 || age > 65)
        println("You are not working age")

    val isWelsh: Boolean = true
    val isRugbyFan: Boolean = false

    if (isWelsh && !isRugbyFan)
        println("How can you NOT like rugby if you're Welsh?!?!")
}

fun bitwiseOperatorFunctions() {
    val bits = 0b10101101
    val mask = 0b00001111
    val result = bits and mask  // Can also write bits.and(mask), result is 0b00001010
    println(result)
}

fun multiwayBranching1() {
    val channelNumber: Int = 102
    val catchUps = listOf(15, 28, 29, 34)

    when (channelNumber) {
        1, 101       -> println("BBC1")     // Channels 1 and 101 are both BBC1.
        2, 102       -> println("BBC2")     // Channels 2 and 102 are both BBC2.
        3, 103       -> println("ITV1")     // Channels 3 and 103 are both ITV1.
        in catchUps  -> println("Catch-up channel")
        in 700..799  -> println("Radio station")
        else         -> {
            println("Some other channel")
            println("It's probably rubbish")
        }
    }
}

fun multiwayBranching2() {
    val channelNumber: Int = 102
    val catchUps = listOf(15, 28, 29, 34)

    when {
        channelNumber == 1 || channelNumber == 101 -> println("BBC1")
        channelNumber == 2 || channelNumber == 102 -> println("BBC2")
        channelNumber == 3 || channelNumber == 103 -> println("ITV1")
        channelNumber in catchUps                  -> println("Catch-up channel")
        channelNumber in 700..799                  -> println("Radio station")
        else                                       -> println("Other")
    }
}

fun multiwayBranching3() {
    val channelNumber: Int = 102
    val catchUps = listOf(15, 28, 29, 34)

    val channelName = when (channelNumber) {
        1, 101       -> "BBC1"
        2, 102       -> "BBC2"
        3, 103       -> "ITV1"
        in catchUps  -> "Catch-up channel"
        in 700..799  -> "Radio station"
        else         -> "Other"
    }
    println("Channel name: $channelName")
}

fun multiwayBranching4() {
    println(demoWhen("super swans"))
    println(demoWhen(42))
    println(demoWhen(Date()))
}

fun demoWhen(arg: Any) = when (arg) {
    is String -> "String arg in uppercase is ${arg.uppercase()}"
    is Int -> "Integer arg squared is ${arg *  arg}"
    else -> "Arg type is ${arg::class.simpleName}"
}
