package demo.integration_testing

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Assertions.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IntegrationTestinKotlin2 {

    // Note the declaration of resource:
    //  - it's an instance field (not static), because the test class is just created once (not once per test).
    //  - it's var (not val), because it's modified in @BeforeAll.
    //  - it's lateinit, because it's initialized late (in @BeforeAll, not in ctor or init block).
    private lateinit var resource: ExpensiveResource

    @BeforeAll
    fun oneoff_setup() {
        println("Setting up expensive resource********************")
        resource = ExpensiveResource()
    }

    @AfterAll
    fun oneoff_teardown() {
        println("Tearing down expensive resource********************")
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
