package demo.integration_testing

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class IntegrationTestinKotlin1 {

    companion object {
        @JvmStatic
        private lateinit var resource: ExpensiveResource

        @BeforeAll
        @JvmStatic
        fun oneoff_setup() {
            println("Setting up expensive resource********************")
            resource = ExpensiveResource()
        }

        @AfterAll
        @JvmStatic
        fun oneoff_teardown() {
            println("Tearing down expensive resource********************")
        }
    }

    @Test
    @Order(1)
    fun `use expensive resource`()
    {
        resource.count++
        assertEquals(resource.count, 1)
    }

    @Test
    @Order(2)
    fun `use expensive resource again`()
    {
        resource.count++
        assertEquals(resource.count, 2)
    }
}
