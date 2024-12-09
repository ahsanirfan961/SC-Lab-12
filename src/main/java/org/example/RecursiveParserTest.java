package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecursiveParserTest {

    @Test
    public void testSimpleExpressions() {
        assertEquals(7.0, RecursiveParser.evaluateExpression("3 + 4"), 1e-9);
        assertEquals(10.0, RecursiveParser.evaluateExpression("5 * 2"), 1e-9);
        assertEquals(2.5, RecursiveParser.evaluateExpression("5 / 2"), 1e-9);
    }

    @Test
    public void testOperatorPrecedence() {
        assertEquals(13.0, RecursiveParser.evaluateExpression("3 + 5 * 2"), 1e-9);
        assertEquals(1.0, RecursiveParser.evaluateExpression("10 / 2 - 4"), 1e-9);
    }

    @Test
    public void testParentheses() {
        assertEquals(8.0, RecursiveParser.evaluateExpression("(3 + 5) * 2 / 2"), 1e-9);
        assertEquals(-4.5, RecursiveParser.evaluateExpression("3 + (5 * (2 - 8) / 4)"), 1e-9);
    }

    @Test
    public void testFloatingPointNumbers() {
        assertEquals(10.75, RecursiveParser.evaluateExpression("10.5 + 0.25"), 1e-9);
        assertEquals(2.5, RecursiveParser.evaluateExpression("5.0 / 2"), 1e-9);
    }

    @Test
    public void testInvalidExpressions() {
        assertThrows(IllegalArgumentException.class, () -> RecursiveParser.evaluateExpression("3 ++ 5"));
        assertThrows(IllegalArgumentException.class, () -> RecursiveParser.evaluateExpression("3 + (5 * 2"));
        assertThrows(ArithmeticException.class, () -> RecursiveParser.evaluateExpression("3 / 0"));
    }
}
