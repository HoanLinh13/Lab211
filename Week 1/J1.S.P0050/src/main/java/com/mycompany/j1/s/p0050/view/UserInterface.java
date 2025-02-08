package com.mycompany.j1.s.p0050.view;

import com.mycompany.j1.s.p0050.controller.EquationSolver;

import java.util.Scanner;
import java.util.List;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private EquationSolver solver = new EquationSolver();

    public void start() {
        while (true) {
            System.out.println("========= Equation Program =========");
            System.out.println("1. Calculate Superlative Equation");
            System.out.println("2. Calculate Quadratic Equation");
            System.out.println("3. Exit");
            System.out.print("Please choose one option: ");
            int choice = readInteger();

            switch (choice) {
                case 1:
                    calculateSuperlativeEquation();
                    break;
                case 2:
                    calculateQuadraticEquation();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }

    private void calculateSuperlativeEquation() {
        System.out.println("----- Calculate Superlative Equation -----");
        float a = readFloat("Enter A: ");
        float b = readFloat("Enter B: ");
        List<Float> result = solver.calculateEquation(a, b);

        if (result == null) {
            System.out.println("No solution.");
        } else if (result.isEmpty()) {
            System.out.println("Infinitely many solutions.");
        } else {
            System.out.println("Solution: x = " + result.get(0));
        }

        displayNumberProperties(a, b);
    }

    private void calculateQuadraticEquation() {
        System.out.println("----- Calculate Quadratic Equation -----");
        float a = readFloat("Enter A: ");
        float b = readFloat("Enter B: ");
        float c = readFloat("Enter C: ");
        List<Float> result = solver.calculateQuadraticEquation(a, b, c);

        if (result == null) {
            System.out.println("No solution.");
        } else if (result.isEmpty()) {
            System.out.println("Infinitely many solutions.");
        } else {
            for (int i = 0; i < result.size(); i++) {
                System.out.println("Solution x" + (i + 1) + " = " + result.get(i));
            }
        }

        displayNumberProperties(a, b, c);
    }

    // KT số chẳn, lẻ, số chính phương
    private void displayNumberProperties(float... numbers) {
        for (float number : numbers) {
            System.out.println("Odd Number(s): " + number);
            System.out.println("Number is Even: " + solver.isOdd(number));
            System.out.println("Number is Perfect Square: " + solver.isPerfectSquare(number));
        }
    }

    // KT validate menu
    private int readInteger() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Please input number ");
            }
        }
    }

    // KT validate dữ liệu nhập vào
    private float readFloat(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
