package org.example;

import java.util.Stack;

public class RecursiveParser {

    public static double evaluateExpression(String expression) {
        // Clean and parse the input expression
        expression = expression.replaceAll("\\s+", ""); // Remove whitespace
        if (!isValidExpression(expression)) {
            throw new IllegalArgumentException("Invalid expression: " + expression);
        }
        return parseExpression(expression, 0, expression.length());
    }

    private static double parseExpression(String expression, int start, int end) {
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int i = start;

        while (i < end) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch) || ch == '.') {
                int numEnd = i + 1;
                while (numEnd < end && (Character.isDigit(expression.charAt(numEnd)) || expression.charAt(numEnd) == '.')) {
                    numEnd++;
                }
                double num = Double.parseDouble(expression.substring(i, numEnd));
                values.push(num);
                i = numEnd;
            } else if (ch == '(') {
                int closingBracket = findClosingBracket(expression, i);
                double nestedResult = parseExpression(expression, i + 1, closingBracket);
                values.push(nestedResult);
                i = closingBracket + 1;
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    processTopOperator(values, operators);
                }
                operators.push(ch);
                i++;
            } else {
                throw new IllegalArgumentException("Unexpected character: " + ch);
            }
        }

        while (!operators.isEmpty()) {
            processTopOperator(values, operators);
        }

        return values.pop();
    }


    private static int findClosingBracket(String expression, int openIndex) {
        int balance = 0;
        for (int i = openIndex; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') balance++;
            if (expression.charAt(i) == ')') balance--;
            if (balance == 0) return i;
        }
        throw new IllegalArgumentException("Mismatched parentheses in expression.");
    }

    private static int precedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }

    private static void processTopOperator(Stack<Double> values, Stack<Character> operators) {
        if (values.size() < 2) throw new IllegalArgumentException("Invalid expression.");
        double b = values.pop();
        double a = values.pop();
        char op = operators.pop();
        values.push(applyOperator(a, b, op));
    }

    private static double applyOperator(double a, double b, char op) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) throw new ArithmeticException("Division by zero.");
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Unknown operator: " + op);
        };
    }

    private static boolean isValidExpression(String expression) {
        return expression.matches("[0-9+\\-*/(). ]+");
    }
}

