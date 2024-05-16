package mypackage

fun main(args: Array<String>) {

    // Demo calling a function that doesn't take any parameters.
    pauseOneSec()

    // Demo calling a function that takes parameters.
    printName("Donald", "Duck")

    // Demo calling a function that returns a value.
    val sresult = square(10)
    println(sresult)

    // Demo calling a single-expression function.
    val cresult = cube(10)
    println(cresult)

    // Demo positional arguments.
    val presult = pow(10, 2)
    println(presult)

    // Demo named arguments.
    val nresult = pow(n = 10, p = 2)
    println(nresult)

    // Demo calling a function that has default arguments.
    val dresult1 = powWithDefaults(10)              // Equivalent to powWithDefaults(10, 1)
    println(dresult1)

    val dresult2 = powWithDefaults(p = 3)           // Equivalent to powWithDefaults(1, 3)
    println(dresult2)

    val dresult3 = powWithDefaults(p = 3, n = 10)   // Equivalent to powWithDefaults(10, 3)
    println(dresult3)

    val dresult4 = powForNum(n = 10)                // Equivalent to powForNum(1, 10)
    println(dresult4)

    // Demo the interplay between positional and named arguments.
    val formattedName = formatName("Simon", "Peter", bold=true)
    println(formattedName)

    // Demo pass-by-value semantics.
    var n = 100
    var m = Money(10, 50)
    demoKotlinAlwaysUsesPassByValue(n, m)
    println("$n $m")

    // Demo variadic functions.
    printSquares(3, 12, 19, 1, 2, 7, 5, 10)

    // Demo local functions.
    demoLocalFunctions(21)

    // Demo accessing arguments passed into main.
    println("${args.size} arguments passed into main:")
    for (a in args) {
        println(a)
    }

    // Demo reading from the console.
    readFromConsole()
}

fun pauseOneSec() {
    java.lang.Thread.sleep(1000)
}

fun printName(fn: String, ln: String) {
    println("$fn $ln")
}

fun square(n: Int): Int {
    return n * n
}

fun cube(n: Int) = n * n * n

fun pow(n: Int, p: Int): Int {
    var res = 1
    for (i in 1..p) {
        res *= n
    }
    return res
}

fun powWithDefaults(n: Int = 1, p: Int = 1): Int {
    var res = 1
    for (i in 1..p) {
        res *= n
    }
    return res
}

fun powForNum(p: Int = 1, n: Int): Int {
    var res = 1
    for (i in 1..p) {
        res *= n
    }
    return res
}

fun formatName(fn: String,
               sn: String,
               italics: Boolean = false,
               bold: Boolean = false): String {

    var sb = StringBuilder()

    if (italics) {
        sb.append("<i>")
    }

    if (bold) {
        sb.append("<b>")
    }

    sb.append(fn, " ", sn)

    if (bold) {
        sb.append("</b>")
    }

    if (italics) {
        sb.append("</i>")
    }

    return sb.toString()
}

fun demoKotlinAlwaysUsesPassByValue(n: Int, m: Money) {
    // The following statements are not allowed - parameters are "val"
    // n = 42
    // m = Money(10, 20)

    // The following statement is allowed - you can mutate the state of a referenced object.
    m.addDollar()
}

fun printSquares(vararg nums : Int) {

    // Display some useful info about the nums parameter.
    println("The nums parameter is of type ${nums::class.qualifiedName}")
    println("The nums parameter has ${nums.size} items")

    // Print the square of all the nums.
    for (i in nums)
        println(i * i)
}

fun readFromConsole() {

    print("Full name? ")
    val name = readLine()

    // Note the use of backticks around `in`, because it's a Kotlin keyword.
    val scanner = java.util.Scanner(System.`in`)

    print("Age? ")
    val age = scanner.nextInt()

    print("Welsh? ")
    val welsh = scanner.nextBoolean()

    print("$name, age: $age Welsh: $welsh")
}

fun demoLocalFunctions(a: Int) {

    var b = 42;

    fun myCoolLocalFunction(s: String) {
        b++
        println("$s $a $b")
    }

    myCoolLocalFunction("Call #1")
    myCoolLocalFunction("Call #2")
}

data class Money(var dollars: Int, var cents: Int) {
    fun addDollar() {
        this.dollars++
    }
}