package com.mycompany.j1.s.p0051.controller;

public class NormalCalculator {
    public double calculator(double a, String operator, double b) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                   throw new ArithmeticException("Cannot divide by zero.");
                }
                return a / b;
            case "^":
                return Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Invalid operator. Please use (+, -, *, /, ^).");
        }
    }
}
