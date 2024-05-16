    package demo.kotest_assertions

    import io.kotest.matchers.Matcher
    import io.kotest.matchers.MatcherResult

    fun beValidPrice() = object : Matcher<Double> {

        override fun test(value: Double) =
            MatcherResult(
                value > 0 && value < 3000,
                { "Price $value should be in range" },
                { "Price $value should not be in range" }
            )
    }