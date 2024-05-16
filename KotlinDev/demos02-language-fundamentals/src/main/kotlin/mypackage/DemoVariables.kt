package mypackage.mypackage

fun main() {
    variables()
    constants()
    strings()
}

fun variables() {
    var height = 1.67
    var weight = 59.9
    var isWelsh = true

    println(height)
    println(weight)
    println(isWelsh)
}

fun constants() {
    val errorMessage: String = "Incorrect input, please try again"
    val pi = 3.1415
    val x = 101

    // The following statement would cause a compiler error.
    // pi++

    // You can initialize val's after declaration (once only).
    val favNum: Int
    if (pi > 0) {
        favNum = 42
    }
    else {
        favNum = 43
    }

    // You can't initialize val's twice! The following statement would be an error.
    // favNum = 43
}

fun strings() {
    val name = "John"

    val str1 = "Hello, $name"
    val str2 = "Hello, $name, your name length is ${name.length}"
    println(str1)
    println(str2)

    val firstLetter = name[0]
    val lastLetter = name[name.length - 1]
    println("$firstLetter $lastLetter")

    val str3 = """
hello world, here's some literal text like a \n and a \t
"""
    println(str3)
}
