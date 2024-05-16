package demo.unit_testing

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested

class BankAccountTest1 {

    @Test
    fun accountCreated_zeroBalanceInitially_v1() {
        val fixture = BankAccount("David")
        assertEquals(0, fixture.balance)
    }

    @Test
    @DisplayName("account created with zero balance initially - v2")
    fun accountCreated_zeroBalanceInitially_v2() {
        val fixture = BankAccount("David")
        assertEquals(0, fixture.balance)
    }

    // Use backticks to give function a readable name. No need for @DisplayName now.
    @Test
    fun `account created with zero balance initially - v3`() {
        val fixture = BankAccount("David")
        assertEquals(0, fixture.balance)
    }

    // Use nested class, to group related tests.
    @Nested
    inner class DepositTests {

        @Test
        fun `single deposit, balance should be that amount`() {

            // Arrange.
            val fixture = BankAccount("David")

            // Act.
            fixture.deposit(100)

            // Assert.
            val expected = 100
            val actual = fixture.balance
            assertEquals(expected, actual)
        }

        @Test
        fun `multiple deposits, balance should be cumulative`() {

            // Arrange.
            val fixture = BankAccount("David")

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

            // Arrange.
            val fixture = BankAccount("David")

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

            // Arrange.
            val fixture = BankAccount("David")

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

            // Arrange.
            val fixture = BankAccount("David")

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

            // Arrange.
            val fixture = BankAccount("David")

            // Act.
            fixture.deposit(600)
            assertThrows(IllegalArgumentException::class.java) {
                fixture.withdraw(601)
            }
        }
    }
}