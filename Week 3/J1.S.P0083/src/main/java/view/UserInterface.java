package view;

import Model.IStack;
import controller.MyStack;

import java.util.Scanner;

public class UserInterface {
    private IStack stack;
    private Scanner scanner;

    public UserInterface() {
        stack = new MyStack();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nStack Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Get Top");
            System.out.println("4. Display Stack");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    Integer topValue = stack.get();
                    if (topValue != null) {
                        System.out.println("Top value: " + topValue);
                    }
                    break;
                case 4:
                    stack.displayStack();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
