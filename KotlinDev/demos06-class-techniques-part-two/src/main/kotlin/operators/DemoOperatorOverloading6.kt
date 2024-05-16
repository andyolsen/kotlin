package operators

data class ArithmeticProgression(val term0: Int, val numTerms: Int, val delta: Int = 1) {

    var terms = mutableListOf<Int>()

    init {
        var term = term0
        for (i in 1..numTerms) {
            terms.add(term)
            term += delta
        }
    }

    override fun toString() : String {
        val sb = StringBuilder()
        for (term in terms) {
            sb.append("$term ")
        }
        return sb.toString()
    }
}

operator fun ArithmeticProgression.get(i: Int) = this.terms[i]

operator fun ArithmeticProgression.set(i: Int, value: Int)  {
    this.terms[i] = value
}

operator fun ArithmeticProgression.get(i: Int, j: Int): List<Int> {
    var result = mutableListOf<Int>()
    for (i in i..j) {
        result.add(this.terms[i])
    }
    return result
}

fun main() {

    val ap = ArithmeticProgression(1, 10, 3)
    println(ap)

    println(ap[1])
    println(ap[3, 7])

    ap[0] = 99
    println(ap)
}
