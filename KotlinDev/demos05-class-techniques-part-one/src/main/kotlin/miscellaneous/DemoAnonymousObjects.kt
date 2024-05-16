package miscellaneous

fun main() {

    val myObj = object {
        var x = 10
        var y = 20
        var z = 30
        override fun toString(): String {
            return "$x, $y, $z"
        }
    }

    val myObj2 = object {
        var x = 10
        var y = 20
        var z = 30
        override fun toString(): String {
            return "$x, $y, $z"
        }
    }

    myObj2.x += 100
    myObj2.y = 72
    println("$myObj2 is of type ${myObj2::class}")
}