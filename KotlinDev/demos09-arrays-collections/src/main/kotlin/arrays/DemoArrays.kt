package arrays

fun main() {
    demoCreateEmptyArray()
    demoCreateArrayOfValues()
    demoCreateArrayOfNulls()
    demoCreateArrayViaInitializerFunction()
    demoArrayCapabilities()
    demoPrimitiveArrays()
}

fun demoCreateEmptyArray() {

    println("\ndemoCreateEmptyArray()---------------------------------------------------------")
    // Create an array via the emptyArray() standard function.
    val strArray = emptyArray<String>()

    println("Size of empty array: ${(strArray.size)}")

    try {
        // This will cause an exception!
        strArray[0] = "wibble"
    }
    catch (ex: IndexOutOfBoundsException) {
        println("Ooooops: $ex")
    }
}

fun demoCreateArrayOfValues() {

    println("\ndemoCreateArrayOfValues()----------------------------------------------------")

    // Create an array of literals via the arrayOf() standard function.
    val strArray = arrayOf("Norway", "Sweden", "Denmark", "Finland")

    println("Strings via manual loop:")
    for (s in strArray) {
        println(s)
    }

    println("Strings via forEach():")
    // This syntax passes a lambda into the forEach() function.
    strArray.forEach { s -> println(s) }
}

fun demoCreateArrayOfNulls() {

    println("\ndemoCreateArrayOfNulls()-------------------------------------------------------")

    // Create an array of Nulls via the arrayOfNulls() standard function.
    val strArray = arrayOfNulls<String>(4)

    // You can then populate as-and-when you're ready.
    strArray[0] = "England"
    strArray[1] = "Scotland"
    strArray[2] = "Wales"
    strArray[3] = "N Ireland"

    println("Best country is ${strArray[2]} :-)")
}

fun demoCreateArrayViaInitializerFunction() {

    println("\ndemoCreateArrayViaInitializerFunction()----------------------------------------")

    // Create an array via the (size, initializerFunction) constructor.
    // This syntax passes a lambda into the 2nd parameter.
    val strArray = Array(5) { i -> "Hello from string $i" }

    println("Strings from array initialized via initializer function:")
    strArray.forEach { s -> println(s) }
}

fun demoArrayCapabilities() {

    println("\ndemoArrayCapabilities()--------------------------------------------------------")

    val strArray = arrayOf("Oslo", "Bergen", "Trondheim", "Stavanger", "Grimstad", "Oslo")

    println(strArray.contains("Bergen"))
    println(strArray.contains("Lillehammer"))

    println(strArray.distinct())

    println(strArray.drop(2))
    println(strArray.dropLast(2))

    println(strArray.getOrElse(42, { "Some surrogate for element at $it" }))

    strArray.sort()
    val indexOfStavanger = strArray.binarySearch("Stavanger")
    println(indexOfStavanger)
}

fun demoPrimitiveArrays() {

    println("\ndemoPrimitiveArrays()----------------------------------------------------------")

    val intArray = intArrayOf(0, 42, 247, 180, 2011)

    println("intArray values:")
    intArray.forEach { i ->println(i) }

    val doubleArray = DoubleArray(5) { i -> Math.sqrt(i.toDouble()) }

    println("doubleArray values:")
    doubleArray.forEach { d -> println("%1.4f".format(d)) }
}