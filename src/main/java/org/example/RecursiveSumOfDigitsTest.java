package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RecursiveSumOfDigitsTest {

    @Test
    void testPositiveNumber() {
        assertEquals(6, RecursiveSumOfDigits.sumOfDigits(123));
        assertEquals(15, RecursiveSumOfDigits.sumOfDigits(69));
    }

    @Test
    void testZero() {
        assertEquals(0, RecursiveSumOfDigits.sumOfDigits(0));
    }

    @Test
    void testNegativeNumber() {
        assertEquals(6, RecursiveSumOfDigits.sumOfDigits(-123));
        assertEquals(15, RecursiveSumOfDigits.sumOfDigits(-69));
    }

    @Test
    void testLargeNumber() {
        assertEquals(45, RecursiveSumOfDigits.sumOfDigits(123456789));
        assertEquals(9, RecursiveSumOfDigits.sumOfDigits(900000000));
    }

    @Test
    void testEdgeCases() {
        assertEquals(1, RecursiveSumOfDigits.sumOfDigits(10));
        assertEquals(7, RecursiveSumOfDigits.sumOfDigits(-7));
    }
}

