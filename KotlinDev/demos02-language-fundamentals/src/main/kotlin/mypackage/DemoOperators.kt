package mypackage.mypackage

fun main() {
    assignment()
    binaryArithmetic()
    compoundAssignment()
    conversion()
    operatorOverloading()
}

fun assignment() {

    var a = 100
    var b = 42
    a = b
    println(a)
    println(b)

    var s1 = StringBuilder("Hello")
    var s2 = StringBuilder("Goodbye")
    s1 = s2
    s2.append(" World")     // Goodbye World
    println(s1)
    println(s2)
}

fun binaryArithmetic() {
    val goalsFor = 3
    val goalsAgainst = 2
    val totalGoalsInGame = goalsFor + goalsAgainst
    val scoreDifference  = goalsFor - goalsAgainst
    println(totalGoalsInGame)
    println(scoreDifference)
}

fun compoundAssignment() {
    var x = 10
    var a = 2
    var b = 3
    x *= a + b
    println(x)
}

fun conversion() {
    val score1 = 9
    val score2 = 8
    val score3 = 8
    val averageScore = (score1 + score2 + score3) / 3.0
    println("$averageScore")
}

fun operatorOverloading() {
    var dosh = Money(10, 50)
    dosh++
    println(dosh)
}

data class Money(val dollars: Int, val cents: Int) {
    operator fun inc(): Money {
        return Money(dollars + 1, cents)
    }
}
