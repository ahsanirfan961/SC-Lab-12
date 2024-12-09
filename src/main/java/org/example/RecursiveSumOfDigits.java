package org.example;

public class RecursiveSumOfDigits {

    /**
     * Computes the sum of the digits of a given integer using recursion.
     * If the number is negative, it is converted to positive.
     *
     * @param number the integer whose digit sum is to be calculated
     * @return the sum of the digits of the absolute value of the number
     */
    public static int sumOfDigits(int number) {
        // Convert negative numbers to positive
        if (number < 0) {
            number = -number;
        }

        // Base case: if the number is 0, return 0
        if (number == 0) {
            return 0;
        }

        // Recursive case: add the last digit to the sum of the rest
        return (number % 10) + sumOfDigits(number / 10);
    }
}

