package miscellaneous

@JvmInline
value class SecurityToken(val value: String)

inline class TemperatureC(val value: Double) {

    val asKelvin: Double
        get() = value + 273.15

    val asFahrenheit: Double
        get() = 32.0 + (value * 9.0) / 5.0
}

inline class ExamMark(val value: Int) {

    val grade: String
        get() = when(value) {
            in 70..100 -> "A"
            in 60..69  -> "B"
            in 50..59  -> "C"
            else       -> "FAIL"
        }
}

fun main() {
    val st = SecurityToken("wibble")
    println(st)

    val t = TemperatureC(100.0)
    println(t)
    println(t.asKelvin)
    println(t.asFahrenheit)

    val m = ExamMark(99)
    println(m.grade)
}