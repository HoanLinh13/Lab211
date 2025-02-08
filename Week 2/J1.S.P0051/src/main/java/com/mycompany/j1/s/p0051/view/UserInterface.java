package com.mycompany.j1.s.p0051.view;

import com.mycompany.j1.s.p0051.controller.BMICalculator;
import com.mycompany.j1.s.p0051.controller.NormalCalculator;

import java.util.Scanner;

public class UserInterface {
        Scanner scanner = new Scanner(System.in);

        public void start() {
            while (true) {
                System.out.println("\n========= NormalCalculator Program =========");
                System.out.println("1. Normal NormalCalculator");
                System.out.println("2. BMI NormalCalculator");
                System.out.println("3. Exit");
                System.out.print("Please choose one option: ");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        doCalculator();
                        break;
                    case 2:
                        doBMICalculator();
                        break;
                    case 3:
                        System.out.println("Exiting the program. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        private void doCalculator() {
            System.out.println("----- Normal Calculator -----");
            NormalCalculator normalCalculator = new NormalCalculator();

            System.out.println("Input number: ");
            double so = Double.parseDouble(scanner.next());
            scanner.nextLine();

            double temp =  so;

            while (true) {
                System.out.println("Input operator: ");
                String operator = scanner.nextLine();

                if (operator.equals("=")) {
                    System.out.println("Final result: " + temp);
                    return;
                }

                System.out.println("Input number: ");
                so = Double.parseDouble(scanner.nextLine());
                temp = normalCalculator.calculator(temp, operator, so);
                System.out.println("Result: " + temp);
            }
        }

        private void doBMICalculator() {
            System.out.println("----- BMI Calculator -----");
            BMICalculator bmiCalculator = new BMICalculator();

            System.out.print("Enter weight (kg): ");
            double weight = scanner.nextDouble();

            System.out.print("Enter height (cm): ");
            double height = scanner.nextDouble();

            String bmiStatus = bmiCalculator.calculateBMI(weight, height);
            System.out.println("BMI Status: " + bmiStatus);
        }
}
