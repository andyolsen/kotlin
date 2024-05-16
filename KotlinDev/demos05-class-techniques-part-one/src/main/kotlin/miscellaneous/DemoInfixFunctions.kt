package miscellaneous

class Message(var value: String) {

    infix fun append(str: String) {
        value += str
    }

    override fun toString() = value
}

fun main() {
    var m = Message("super")
    m.append("califragilist")     // Normal syntax
    m append "icexpialidocious"   // Can omit . and () for infix functions
    println(m)
}