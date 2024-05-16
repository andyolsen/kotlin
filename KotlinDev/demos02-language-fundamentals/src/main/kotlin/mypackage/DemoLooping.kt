package mypackage.mypackage

fun main() {
    whileLoops()
    doWhileLoops()
    forLoops()
    rangesForLoops()
    unconditionalLoops()
}

fun whileLoops() {
    var i = 0
    while (i < 5) {
        println(i)
        i++
    }
    println("The end")
}

fun doWhileLoops() {
    var i = 0
    do {
        println(i)
        i++
    }
    while (i < 5)
    println("The end")
}

fun forLoops() {
    val myList = listOf(100, 200, 300)
    for (item in myList) {
        println(item)
    }

    val town = "llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch"
    for (c in town) {
        println(c)
    }
}

fun rangesForLoops() {
    for (i in 5 downTo 1 step 2) {
        println(i)
    }
}

fun unconditionalLoops() {
    myOuterLabel@
    for (i in 1..10) {

        for (j in 1..10) {

            println("$i $j")

            if (i == j)
                continue@myOuterLabel

            if (i == 7)
                break@myOuterLabel
        }
    }
}

