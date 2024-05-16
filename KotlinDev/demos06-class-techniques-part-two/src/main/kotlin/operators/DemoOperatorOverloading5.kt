package operators

data class Percentage(val n: Int) : Comparable<Percentage>{
    override fun compareTo(that: Percentage) = this.n - that.n
}

fun main() {

    // Use relational operators.
    val pc1 = Percentage(10)
    val pc2 = Percentage(20)
    println(pc1 >  pc2)
    println(pc1 >= pc2)
    println(pc1 <  pc2)
    println(pc1 <= pc2)

    // Use range operator.
    val percentages = Percentage(10)..Percentage(20)
    val p1 = Percentage(15)
    println(p1 in percentages)
    println(p1 !in percentages)
}
