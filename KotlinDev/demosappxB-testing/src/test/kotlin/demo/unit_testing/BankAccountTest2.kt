package demo.unit_testing

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

class BankAccountTest2 {

    lateinit var fixture: BankAccount

    @BeforeEach
    fun setup() {
        println("In setup()")
        fixture = BankAccount("David")
    }

    @AfterEach
    fun teardown() {
        println("In teardown()")
    }

    @Test
    fun `account created with zero balance initially`() {
        assertEquals(0, fixture.balance)
    }

    @Nested
    inner class DepositTests {

        @Test
        fun `single deposit, balance should be that amount`() {

            // Act.
            fixture.deposit(100)

            // Assert.
            val expected = 100
            val actual = fixture.balance
            assertEquals(expected, actual)
        }

        @Test
        fun `multiple deposits, balance should be cumulative`() {

            // Act.
            fixture.deposit(100)
            fixture.deposit(200)
            fixture.deposit(300)

            // Assert.
            val expected = 600
            val actual = fixture.balance
            assertEquals(expected, actual)
        }
    }

    @Nested
    inner class WithdrawTests {

        @Test
        fun `withdrawal within limits, balance should be reduced`() {

            // Act.
            fixture.deposit(600)
            fixture.withdraw(100)
            fixture.withdraw(200)

            // Assert.
            val expected = 300
            val actual = fixture.balance
            assertEquals(expected, actual)
        }

        @Test
        fun `withdrawals up to limit, balance should be zero`() {

            // Act.
            fixture.deposit(600)
            fixture.withdraw(100)
            fixture.withdraw(200)
            fixture.withdraw(300)

            // Assert.
            val expected = 0
            val actual = fixture.balance
            assertEquals(expected, actual)
        }

        @Test
        fun `withdrawals exceed limit, exception should occur - v1`() {

            // Act.
            fixture.deposit(600)
            try {
                fixture.withdraw(601)
                fail("Expected exception didn't occur!")
            } catch (ex: IllegalArgumentException) {
                // Assert.
                assertEquals("Insufficient funds", ex.message)
            }
        }

        @Test
        fun `withdrawals exceed limit, exception should occur - v2`() {

            // Act.
            fixture.deposit(600)
            assertThrows(IllegalArgumentException::class.java) {
                fixture.withdraw(601)
            }
        }
    }
}