package demo.mocking

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class BAServiceTest {

    // Create mock object that implements BARepository.
    val repos = mockk<BARepository>()

    // Create mock object we can use instead of a real Logger.
    val logger = mockk<Logger>()

    // Inject mock objects into "object under test".
    val service = BAService(repos, logger)

    @Test
    fun `test deposit`() {

        // Helper variables.
        val id = 1234
        val acc = BA(id, "David")

        // Set expectations on mock object.
        every { repos.getById(id) } returns acc
        every { repos.update(id, acc) } returns Unit
        every { logger.log(any()) } returns Unit

        // Act.
        service.depositIntoAccount(id, 100)

        // Assert.
        assertEquals(acc.balance, 100)

        // Verify interactions upon mock object.
        verify {
            repos.getById(id)
            repos.update(id, acc)
            logger.log("Account $id, deposited GBP100")
        }
        confirmVerified(repos)
    }

    @Test
    fun `test get balance for one account`() {

        // Set expectations on mock object.
        every { repos.getById(any()) } answers {
            BA( firstArg(), "David", 1000)
        }

        // Act.
        val balance = service.getBalanceForAccount(1234)

        // Assert.
        assertEquals(balance, 1000)

        // Verify interactions upon mock object.
        verify {
            repos.getById(any())
        }
        confirmVerified(repos)
    }


    @Test
    fun `test get total balance for multiple accounts`() {

        // Set expectations on mock object.
        every { repos.getById(any()) } answers {
            BA(firstArg(), "David", 1000)
        }

        // Act.
        val balance = service.getBalanceForAccounts(3, 12, 19, 1, 2, 7)

        // Assert.
        assertEquals(balance, 6000)

        // Verify interactions upon mock object.
        verify(exactly = 6) {
            repos.getById(any())
        }
        confirmVerified(repos)
    }
}

