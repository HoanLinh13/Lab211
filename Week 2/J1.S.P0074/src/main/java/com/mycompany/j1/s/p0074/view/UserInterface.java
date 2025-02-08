package com.mycompany.j1.s.p0074.view;

import com.mycompany.j1.s.p0074.controller.Matrix;
import com.mycompany.j1.s.p0074.model.IMatrix;

import java.util.Scanner;

public class UserInterface {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n============== Calculator Program ==============");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 4) {
                System.out.println("Exiting program. Goodbye!");
                break; // Thoát chương trình
            }

            if (choice >= 1 && choice <= 3) {
                try {
                    if (choice == 1)
                        System.out.println("--------- Addition ---------");
                    else if (choice == 2)
                        System.out.println("--------- Subtraction ---------");
                    else if (choice == 3)
                        System.out.println("--------- Multiplication ---------");

                    System.out.print("Enter Row Matrix 1: ");
                    int rows1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Column Matrix 1: ");
                    int cols1 = scanner.nextInt();
                    scanner.nextLine();
                    IMatrix matrix1 = new Matrix(rows1, cols1);
                    matrix1.insertMatrix();

                    System.out.print("Enter Row Matrix 2: ");
                    int rows2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Column Matrix 2: ");
                    int cols2 = scanner.nextInt();
                    scanner.nextLine();
                    IMatrix matrix2 = new Matrix(rows2, cols2);
                    matrix2.insertMatrix();

                    IMatrix result;
                    switch (choice) {
                        case 1:
                            result = matrix1.additionMatrix(matrix2);
                            displayOperation(matrix1, matrix2, result, "+");
                            break;
                        case 2:
                            result = matrix1.subtractionMatrix(matrix2);
                            displayOperation(matrix1, matrix2, result, "-");
                            break;
                        case 3:
                            result = matrix1.multiplicationMatrix(matrix2);
                            displayOperation(matrix1, matrix2, result, "*");
                            break;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private void displayOperation(IMatrix matrix1, IMatrix matrix2, IMatrix result, String operator) {
        System.out.println("Matrix 1:");
        ((Matrix) matrix1).displayMatrix();

        System.out.println(operator);

        System.out.println("Matrix 2:");
        ((Matrix) matrix2).displayMatrix();

        System.out.println("=");
        System.out.println("Result:");
        ((Matrix) result).displayMatrix();
    }
}