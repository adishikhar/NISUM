package com.nisum;



import org.junit.jupiter.api.*;

public class LifecycleTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All - runs once before all tests");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before Each - runs before every test");
    }

    @Test
    void testOne() {
        System.out.println("Test One - actual test code");
    }

    @Test
    void testTwo() {
        System.out.println("Test Two - actual test code");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After Each - runs after every test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All - runs once after all tests");
    }
}
