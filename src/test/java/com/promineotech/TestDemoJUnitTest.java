package com.promineotech;

// Import statements for various static methods used in the tests
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// Test class for TestDemo
class TestDemoJUnitTest {

    private TestDemo testDemo; // Instance of TestDemo to be tested

    // Set up method to initialize testDemo before each test
    @BeforeEach
    void setUp() throws Exception {
        testDemo = new TestDemo();
    }

    // Parameterized test to check if two positive numbers are added correctly
    @ParameterizedTest
    @MethodSource("TestDemoTest#argumentsForAddPositive")
    void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
        // If no exception is expected, assert that the addition result is as expected
        if (!expectException) {
            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
        } else {
            // If an exception is expected, assert that an IllegalArgumentException is thrown
            assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
        }
    }
    
    // Method to provide arguments for the parameterized test above
    static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
                arguments(2, 4, 6, false), // Test case with two positive numbers
                arguments(0, 0, 0, true), // Test case expecting an exception (adding zeros)
                arguments(-1, 1, 0, true), // Test case expecting an exception (adding a negative number)
                arguments(-1, -1, -2, true), // Test case expecting an exception (adding two negative numbers)
                arguments(2, -4, -2, true) // Test case expecting an exception (adding a positive and a negative number)
                );
    }
    
    // Test to check if the randomNumberSquared method works as expected
    @Test
    void assertThatTwoPositiveNumbersAreAddedCorrectly(){
        // Create a spy of testDemo to mock the getRandomInt method
        TestDemo mockDemo = spy(testDemo);
        // Mock the getRandomInt method to always return 5
        doReturn(5).when(mockDemo).getRandomInt();
        // Call the randomNumberSquared method and store the result
        int fiveSquared = mockDemo.randomNumberSquared();
        // Assert that the result is 25 (5 squared)
        assertThat(fiveSquared).isEqualTo(25);
    }
}
