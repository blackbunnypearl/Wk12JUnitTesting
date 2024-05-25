package com.promineotech;

// Import the Random class from the java.util package
import java.util.Random;

// Public class named TestDemo
public class TestDemo {

    // Method that adds two positive integers
    public int addPositive(int a, int b) {
        // Check if both parameters are positive
        if (a > 0 && b > 0) {
            // If both numbers are positive, return their sum
            return a + b;
        }
        // If one or both parameters are not positive, throw an IllegalArgumentException
        throw new IllegalArgumentException("Both parameters must be positive");
    }
    
    // Method that returns the square of a random number
    public int randomNumberSquared() {
        // Get a random integer
        int num = getRandomInt();
        // Return the square of the random integer
        return num * num;
    }

    // Package-private method that generates a random integer between 1 and 10
    int getRandomInt() {
        // Create a new instance of the Random class
        Random random = new Random();
        // Return a random integer between 1 (inclusive) and 11 (exclusive)
        return random.nextInt(10) + 1;
    }
}
