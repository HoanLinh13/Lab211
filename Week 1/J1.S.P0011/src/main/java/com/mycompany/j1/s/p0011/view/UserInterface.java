package com.mycompany.j1.s.p0011.view;

import com.mycompany.j1.s.p0011.controller.UnifiedConverter;
import com.mycompany.j1.s.p0011.model.BaseConverter;

import java.util.Scanner;

public class UserInterface {
    private  Scanner scanner = new Scanner(System.in);
    private BaseConverter converter = new UnifiedConverter();

    public void start() {
        System.out.println("Welcome to the Base Conversion Program!");

        while (true) {
            try {
                int inputBase = getBaseChoice("Choose input base system:");
                int outputBase = getBaseChoice("Choose output base system:");

                System.out.println("\nEnter the input value:");
                String inputValue = scanner.next();

                String result = converter.convert(inputBase, outputBase, inputValue);
                System.out.println("Converted value: " + result);

                if (!askToContinue()) {
                    System.out.println("Thank you for using the Base Conversion Program!");
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

    private int getBaseChoice(String message) {
        System.out.println("\n" + message +
                "\n1: Binary (Base 2)" +
                "\n2: Decimal (Base 10)" +
                "\n3: Hexadecimal (Base 16)");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > 3) {
            throw new IllegalArgumentException("Invalid base choice. Please select 1, 2, or 3.");
        }
        return choice;
    }

    private boolean askToContinue() {
        System.out.println("\nDo you want to convert another value? (yes/no):");
        String choice = scanner.next().toLowerCase();
        return choice.equals("yes");
    }
}