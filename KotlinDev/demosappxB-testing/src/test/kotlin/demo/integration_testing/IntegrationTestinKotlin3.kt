package demo.integration_testing

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IntegrationTestinKotlin3 {

    // Note we use val now (not var) and we don't need to use lateinit.
    // This is because we initialize the field in a constructor, rather than in @BeforeAll.
    private val resource: ExpensiveResource

    constructor() {
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
