package demo.kotest_assertions

import io.kotest.matchers.should
import io.kotest.matchers.shouldNot
import org.junit.jupiter.api.Test

class ProductTest2 {

    @Test
    fun `valid price should be accepted`() {
        val fixture = Product("TV", 1500.0)
        fixture.price should beValidPrice()
    }

    @Test
    fun `too-low price should be rejected`() {
        val fixture = Product("TV", -0.01)
        fixture.price shouldNot beValidPrice()
    }

    @Test
    fun `too-high price should be rejected`() {
        val fixture = Product("TV", 3000.01)
        fixture.price shouldNot beValidPrice()
    }
}