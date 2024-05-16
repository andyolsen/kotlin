package generics

class Measurement<T>(var amount: T, val unitName: String) {
    override fun toString(): String {
        return "${this::class.simpleName} $amount $unitName"
    }
}

fun main() {
    demoExplicitTyping()
    demoImplicitTyping()
    demoGenericFunctions()
    demoTypeInfoAtRuntime()
}

fun demoExplicitTyping() {
    val m1 = Measurement<Double>(10.5, "km")
    m1.amount = 10.7
    val amount1: Double = m1.amount
    println(amount1)
    println(m1)
}

fun demoImplicitTyping() {
    val m2 = Measurement(10_500, "m")
    m2.amount = 10_700
    val amount2: Int = m2.amount
    println(amount2)
    println(m2)
}

fun demoGenericFunctions() {
    displaySeries("Important numbers:", 3, 12, 19, 1, 2, 7, 5, 10)
    displaySeries("Ducklings:", "Huey", "Louis", "Dewey")
}

fun <T>displaySeries(msg: String, vararg items: T) {
    println(msg)
    for (item in items) {
        println(item)
    }
}

fun demoTypeInfoAtRuntime() {
    println(getIfType<Double>(1234))
    println(getIfType<Double>(3.14))
    println(getIfType<Double>("wibble"))
}

inline fun <reified T> getIfType(arg: Any): T? {
    println("\narg is ${arg::class}, T is ${T::class}")
    return if (arg is T) arg else null
}

