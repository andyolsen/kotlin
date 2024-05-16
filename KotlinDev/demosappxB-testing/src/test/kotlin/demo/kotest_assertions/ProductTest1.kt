package demo.kotest_assertions

import org.junit.jupiter.api.Test

import io.kotest.matchers.shouldBe
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.string.shouldContain

class ProductTest1 {

    private val fixture = Product("TV", 1500.0, 5, 4, 3, 5, 4, 3)

    @Test
    fun `should have correct number of ratings initially`() {
        fixture.ratings.size.shouldBe(6)
    }

    @Test
    fun `should allow ratings to be added`() {
        fixture.ratings.add(4)
        fixture.ratings.size shouldBe 7
    }

    @Test
    fun `tax payable is correct - v1`() {
        fixture.taxPayable shouldBe (300.0 plusOrMinus 0.001)
    }

    @Test
    fun `tax payable is correct - v2`() {
        fixture.taxPayable shouldBe 300.0.plusOrMinus(0.001)
    }

    @Test
    fun `ratings contains rating`() {
        fixture.ratings shouldContain 3
    }

    @Test
    fun `ratings doesn't contain absent rating`() {
        fixture.ratings shouldNotContain 2
    }

    @Test
    fun `product toString correctly formats price`() {
        val str = fixture.toString()
        str shouldContain Regex("GBP1500.00")
    }
}