package demo.kotest_assertions

class Product(val description: String, val price: Double, vararg ratingsArg: Int) {

    val ratings = ratingsArg.asList().toMutableList()

    fun rate(rating: Int) = ratings.add(rating)

    val taxPayable
        get() = price * 0.2

    override fun toString(): String {
        return "$description, GBP${"%.2f".format(price)}, $ratings"
    }
}