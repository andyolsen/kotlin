package demo.integration_testing;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTestInJava {

    private static ExpensiveResource resource;

    @BeforeAll
    static void oneoff_setup() {
        System.out.println("Setting up expensive resource********************");
        resource = new ExpensiveResource();
    }

    @AfterAll
    static void oneoff_teardown() {
        System.out.println("Tearing down expensive resource********************");
    }

    @Test
    @Order(1)
    void use_expensive_resource()
    {
        resource.setCount(resource.getCount() + 1);
        assertEquals(resource.getCount(), 1);
    }

    @Test
    @Order(2)
    void use_expensive_resource_again()
    {
        resource.setCount(resource.getCount() + 1);
        assertEquals(resource.getCount(), 2);
    }
}
